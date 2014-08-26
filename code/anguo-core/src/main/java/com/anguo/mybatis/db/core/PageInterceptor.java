package com.anguo.mybatis.db.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import com.anguo.mybatis.db.core.dialect.Dialect;
import com.anguo.util.AnguoReflections;

/**
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 老规矩，签名里要拦截的类型只能是接口。
 * 
 * @author 湖畔微风
 * 
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PageInterceptor implements Interceptor {
	
	
    private static final Log logger = LogFactory.getLog(PageInterceptor.class);
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    private static String defaultDialect = "mysql"; // 数据库类型(默认为mysql)
    private static String defaultPageSqlId = ".*Page*"; // 需要拦截的ID(正则匹配)
    //private static String dialect = ""; // 数据库类型(默认为mysql)
    private static String pageSqlId = ""; // 需要拦截的ID(正则匹配)
    private Dialect DIALECT; //数据库方言

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
                DEFAULT_OBJECT_WRAPPER_FACTORY);
        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
        
//        
//        dialect = configuration.getVariables().getProperty("dialect");
//        if (null == dialect || "".equals(dialect)) {
//            logger.warn("Property dialect is not setted,use default 'mysql' ");
//            dialect = defaultDialect;
//        }
//        pageSqlId = configuration.getVariables().getProperty("pageSqlId");
//        if (null == pageSqlId || "".equals(pageSqlId)) {
//            logger.warn("Property pageSqlId is not setted,use default '.*Page$' ");
//            pageSqlId = defaultPageSqlId;
//        }
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        // 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的MappedStatement的sql
        if (mappedStatement.getId().matches(pageSqlId)) {
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            Object parameterObject = boundSql.getParameterObject();
            if (parameterObject == null) {
                throw new NullPointerException("parameterObject is null!");
            } else {
//                PageParameter page = (PageParameter) metaStatementHandler
//                        .getValue("delegate.boundSql.parameterObject.page");
                
                BaseVo page = (BaseVo) parameterObject;
                
                String sql = boundSql.getSql();
                
               
                // 重写sql
                String pageSql = generatePageSql(sql, page);
                
                logger.debug(pageSql);
                
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
                metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
                metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
                Connection connection = (Connection) invocation.getArgs()[0];
                // 重设分页参数里的总页数等
                setPageParameter(sql, connection, mappedStatement, boundSql, page);
            }
        }
        // 将执行权交给下一个拦截器
        return invocation.proceed();
    }

    /**
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用者就可用通过 分页参数
     * <code>PageParameter</code>获得相关信息。
     * 
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
            BoundSql boundSql, BaseVo page) {
        // 记录总记录数
        String countSql = "select count(0) from (" + sql + ") as total";
        
        logger.debug(countSql);
        
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            page.setTotalCount(totalCount);
            int totalPage = totalCount / page.getRows() + ((totalCount % page.getRows() == 0) ? 0 : 1);
            page.setTotalPage(totalPage);

        } catch (SQLException e) {
            logger.error("Ignore this exception", e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
            try {
                countStmt.close();
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
        }

    }

    /**
     * 对SQL参数(?)设值
     * 
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
            Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }

//    /**
//     * 根据数据库类型，生成特定的分页sql
//     * 
//     * @param sql
//     * @param page
//     * @return
//     */
//    private String buildPageSql(String sql, PageParameter page) {
//        if (page != null) {
//            StringBuilder pageSql = new StringBuilder();
//            if ("mysql".equals(dialect)) {
//                pageSql = buildPageSqlForMysql(sql, page);
//            } else if ("oracle".equals(dialect)) {
//                pageSql = buildPageSqlForOracle(sql, page);
//            } else {
//                return sql;
//            }
//            return pageSql.toString();
//        } else {
//            return sql;
//        }
//    }

//    /**
//     * mysql的分页语句
//     * 
//     * @param sql
//     * @param page
//     * @return String
//     */
//    public StringBuilder buildPageSqlForMysql(String sql, PageParameter page) {
//        StringBuilder pageSql = new StringBuilder(100);
//        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
//        pageSql.append(sql);
//        pageSql.append(" limit " + beginrow + "," + page.getPageSize());
//        return pageSql;
//    }
//
//    /**
//     * 参考hibernate的实现完成oracle的分页
//     * 
//     * @param sql
//     * @param page
//     * @return String
//     */
//    public StringBuilder buildPageSqlForOracle(String sql, PageParameter page) {
//        StringBuilder pageSql = new StringBuilder(100);
//        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
//        String endrow = String.valueOf(page.getCurrentPage() * page.getPageSize());
//
//        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
//        pageSql.append(sql);
//        pageSql.append(" ) temp where rownum <= ").append(endrow);
//        pageSql.append(") where row_id > ").append(beginrow);
//        return pageSql;
//    }

    @Override
    public Object plugin(Object target) {
        // 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    
    /**
     * 设置属性，支持自定义方言类和制定数据库的方式
     * <p>
     * <code>dialectClass</code>,自定义方言类。可以不配置这项
     * <ode>dbms</ode> 数据库类型，插件支持的数据库
     * <code>sqlPattern</code> 需要拦截的SQL ID
     * </p>
     * 如果同时配置了<code>dialectClass</code>和<code>dbms</code>,则以<code>dbms</code>为主
     *
     * @param p 属性
     */
    @Override
    public void setProperties(Properties properties) {
    	
            String dialectClass = properties.getProperty("dialectClass");
            if (StringUtils.isEmpty(dialectClass)) {
                try {
                    throw new PropertyException("数据库分页方言无法找到!");
                } catch (PropertyException e) {
                    e.printStackTrace();
                }
            } else {
                Dialect dialect1 = (Dialect) AnguoReflections.instance(dialectClass);
                if (dialect1 == null) {
                    throw new NullPointerException("方言实例错误");
                }
                DIALECT = dialect1;
            }

            pageSqlId = properties.getProperty("sqlPattern");
            if (StringUtils.isEmpty(pageSqlId)) {
                try {
                    throw new PropertyException("sqlPattern property is not found!");
                } catch (PropertyException e) {
                    e.printStackTrace();
                }
            }
        
    	
    }
    
    
    /**
     * 根据数据库方言，生成特定的分页sql
     *
     * @param sql     Mapper中的Sql语句
     * @param page    分页对象
     * @param dialect 方言类型
     * @return 分页SQL
     */
    public String generatePageSql(String sql, BaseVo  page) {
        if (DIALECT.supportsLimit()) {
            int pageSize = page.getRows();
            int index = (page.getPage() - 1) * pageSize;
            int start = index < 0 ? 0 : index;
            return DIALECT.getLimitString(sql, start, pageSize);
        } else {
            return sql;
        }
    }

}
