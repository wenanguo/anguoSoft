package com.anguo.mongo.db.service;

import java.lang.reflect.Field;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.anguo.mongo.db.domain.BaseMongoVo;
import com.anguo.mybatis.db.core.PageResult;

/**
 * mongodb业务逻辑父类
 * @author Andrew.Wen
 *
 * @param <T>
 */
public class BaseMongoService<T extends BaseMongoVo> {
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * 获取分页数据
	 * @param obj
	 * @return
	 */
	public PageResult<List<T>> getPageData(T obj) {
		
		try {
			PageResult<List<T>> page=new PageResult<List<T>>();
			
			Query query=new Query();
			query.with(new Sort(new Sort.Order(Direction.ASC, "id")));
			
			//反射遍历设置查询条件
			Class<?> d1=obj.getClass();
			
			for(Field pp: d1.getDeclaredFields())
			{
				pp.setAccessible(true);
				
				Object value=pp.get(obj);
				if(value!=null)query.addCriteria(Criteria.where(pp.getName()).regex(pp.get(obj).toString()));
				
			}
			
			page=getPageData(obj,query);
			
			return page;
			
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;

			}
	}
	
	
	/**
	 * 自定义查询条件分页方法
	 * @param obj
	 * @param query
	 * @return
	 */
	public PageResult<List<T>> getPageData(T obj,Query query) {
		
		try {
			PageResult<List<T>> page=new PageResult<List<T>>();
			
			//查询总记录数
			List<?> countList=this.getMongoTemplate().find(query,obj.getClass());
			page.setTotal(countList.size());
			
			//设置分页
			query.skip((obj.getRows()-1)*obj.getPage());
			query.limit(obj.getPage());
			
			
			//获取查询数据
			List<T> list=getQueryData(obj,query);
			
			
			//设置结果
			page.setRows(list);
			page.setPage(obj.getPage());
		
			
			return page;
			
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} 
		
	}
	
	/**
	 * 获得所有数据
	 * @param obj
	 * @return
	 */
	public List<T> getAllData(T obj)
	{
		try {
		Query query=new Query();
		
		
		//反射遍历设置查询条件
		Class<?> d1=obj.getClass();
		
		for(Field pp: d1.getDeclaredFields())
		{
			pp.setAccessible(true);
			
			Object value=pp.get(obj);
			if(value!=null)query.addCriteria(Criteria.where(pp.getName()).regex(pp.get(obj).toString()));
			
		}
		//设置根据id排序
		query.with(new Sort(new Sort.Order(Direction.ASC, "id")));
	
		
		
		return getQueryData(obj,query);
		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据查询条件获取数据
	 * @param obj
	 * @return
	 */
	public List<T> getQueryData(T obj,Query query)
	{
		try {
		
		return (List<T>) this.getMongoTemplate().find(query,obj.getClass());
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	
	/**
	 * 获得单条数据
	 * @param obj
	 * @return
	 */
	public T getData(T obj)
	{
		return (T) this.getMongoTemplate().findOne(new Query(Criteria.where("id").is(obj.getId())), obj.getClass());
	}
	
	/**
	 * 获得最大编号，实现自增id
	 * @param obj
	 * @return
	 */
	public int getMaxId(T obj)
	{
		try {
			Query query=new Query();
			
			
			//反射遍历设置查询条件
			Class<?> d1=obj.getClass();
			
		
			//设置根据id排序
			query.with(new Sort(new Sort.Order(Direction.DESC, "id")));
		
			
			T t=(T)this.getMongoTemplate().findOne(query,obj.getClass());
			
			if(t!=null)
			{
				return t.getId()+1;
			}else{
				return 0;
			}
			
			
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		
		
		
	}
	
	/**
	 * 插入数据
	 * @param obj
	 */
	public void insertData(T obj)
	{
		this.getMongoTemplate().insert(obj);
	}
	
	/**
	 * 批量插入队列
	 * @param list
	 */
	public void insertListData(List<T> list)
	{
		this.getMongoTemplate().insertAll(list);
	}

	
	/**
	 * 修改，与传统修改无差别，当记录不存在时插入，而如果记录存在时则忽略
	 * @param obj
	 */
	public void updateData(T obj)
	{
		
		
		try
		{
			Update update=new Update();
			
			//反射设置修改对象
			Class<?> d1=obj.getClass();
			
			for(Field pp: d1.getDeclaredFields())
			{
				pp.setAccessible(true);
				update.set(pp.getName(), pp.get(obj));
				
			}
			
			this.getMongoTemplate().updateFirst(new Query(Criteria.where("id").is(obj.getId())), update, obj.getClass());
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * mongo特有修改，如不存在当前对象则插入，如已存在当前对象则更新，但会消掉没有值的字段
	 */
	public void saveData(T obj)
	{
		this.getMongoTemplate().save(obj);
	}
	
	
	/**
	 * 删除数据
	 * @param obj
	 */
	public void deleteData(T obj)
	{
		 this.getMongoTemplate().remove(obj);
	}
	
	
	/**
	 * 删除所有数据数据
	 * @param obj
	 */
	public void deleteAllData(T obj)
	{
		List<T> list=getAllData(obj);
		for(T t:list)
		{
			deleteData(t);
		}
	}
	
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	
}
