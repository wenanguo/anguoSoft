package com.anguo.log.appender;


import java.net.UnknownHostException;
import java.util.Date;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.MDC;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import com.anguo.util.AnguoReflections;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;


/**
 * mongodb日志记录适配器
 * @author Andrew.Wen
 *
 */
public class MongodbAppender extends AppenderSkeleton implements Appender {

	/**
	 * 连接地址
	 */
	private String hostname="127.0.0.1";
	
	/**
	 * 端口
	 */
	private int port=27017;
	/**
	 * 数据库名称
	 */
	private String databaseName="udpmongo";
	/**
	 * 表名称
	 */
	private String collectionName="commonOperateLog";
	
	private String projectName="项目名称";

	//mongodb相关参数
	private Mongo mongo =null;

	private DB db =null;

	private DBCollection logs = null;

	/**
	 * 自定义内容显示，按照log4j格式
	 */
	protected String collectionPattern = "%c";
	
	
	
	public void connectToMongo() throws UnknownHostException {
		this.mongo = new Mongo(hostname,port);
		this.db = mongo.getDB(databaseName);
		this.logs = this.db.getCollection(collectionName);
	}
	
	
	public String getCollectionPattern() {
		return collectionPattern;
	}

	public void setCollectionPattern(String collectionPattern) {
		this.collectionPattern = collectionPattern;
		this.collectionLayout = new PatternLayout(collectionPattern);
	}

	protected PatternLayout collectionLayout = new PatternLayout(collectionPattern);
	 
	
	public MongodbAppender()
	{
		super();
		
		System.out.println("===========初始化方法==============");
	}

	@Override
	public void close() {
		
		
		   if (mongo != null)
			   mongo.close();
	        db = null;
	        logs = null;
	        System.gc();
	        
		System.out.println("===========关闭方法==============");
	}

	@Override
	public boolean requiresLayout() {
		return true;
	}

	@Override
	protected void append(LoggingEvent event) {
		
		if (null == db) {
		      try {
		        connectToMongo();
		      } catch (UnknownHostException e) {
		        throw new RuntimeException(e.getMessage(), e);
		      }
		    }
	        
	        //获得最大编号
	        int maxId=0;
  
	        DBCursor cursor =  logs.find().sort(new BasicDBObject("_id",-1)).limit(1);
	        while(cursor.hasNext()){  
	        	 DBObject temp=cursor.next();
	             
	             if(temp.get("_id")!=null){
	            	 maxId=Integer.valueOf(temp.get("_id").toString())+1;
	             }
	         }  
	        
	        
	        //获取类及方法注解
	        Class<?> demo1=null;
	        try {
				demo1=Class.forName(event.getLoggerName());
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("ClassNotFoundException:"+event.getLoggerName());
			}

	        
	        String sequence=String.valueOf(System.currentTimeMillis());
	        if(MDC.get("sequence")!=null)
	        {
	        	sequence=MDC.get("sequence").toString();
	        }
	        
	        
	      
	        //======================
	        DBObject log = new BasicDBObject();
	        
	        
	        log.put("_id",maxId);
	        log.put("sequence",sequence);
	        log.put("timeStamp",event.getTimeStamp());
	        log.put("runtimeClass",event.getLoggerName());
	        log.put("runtimeMethod", event.getLocationInformation().getMethodName());
	        log.put("runtimeLineNumber", event.getLocationInformation().getLineNumber());
	        log.put("runtimeThread", event.getThreadName());
	        log.put("projectName",this.getProjectName());
	        log.put("classAnnotation",AnguoReflections.getClassAnnotation(demo1));
	        log.put("methodAnnotation",AnguoReflections.getMethodAnnotation(demo1,event.getLocationInformation().getMethodName()));
	        log.put("createtime", new Date());
	        log.put("loglevel", event.getLevel().toInt());
	        log.put("logmsg", collectionLayout.format(event));
	        log.put("userName", MDC.get("userName"));

	        
	       if( logs.save(log).getN()!=1)
	       {
	    	   System.out.println(collectionLayout.format(event));
	       }
	        
	        
	     
	        
		
	}
	
	
	protected String getLogStatement(LoggingEvent event) {
	    return getLayout().format(event);
	  }

	

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	

	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
