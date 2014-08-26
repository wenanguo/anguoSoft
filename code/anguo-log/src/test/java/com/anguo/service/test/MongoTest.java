package com.anguo.service.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.domain.User;
import com.anguo.log.db.domain.CommonOperateLog;
import com.anguo.log.service.CommonOperateLogService;
import com.anguo.mongo.service.UserService;
import com.anguo.mybatis.db.controller.BaseConstants;
import com.anguo.mybatis.db.core.PageResult;



@ContextConfiguration(locations = { "classpath*:project-*.xml" , "file:src/main/resources/project-mongo.xml" })
public class MongoTest extends AbstractTestNGSpringContextTests {

	private static final Logger log = Logger.getLogger(MongoTest.class);//日志文件

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	CommonOperateLogService commonOperateLogService;
	
	public CommonOperateLogService getCommonOperateLogService() {
		return commonOperateLogService;
	}

	public void setCommonOperateLogService(
			CommonOperateLogService commonOperateLogService) {
		this.commonOperateLogService = commonOperateLogService;
	}




	@Autowired
	UserService userService;
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * 插入数据
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void insertDataTest() {
		
		//********设置插入数据***********
	
		for(int i=0;i<0;i++)
		{
			User user=new User();
			user.setId(i);
			user.setPassword("password"+i);
			user.setUsername("username"+i);
			
			//getMongoTemplate().insert(user);
			this.userService.insertData(user);
			
			System.out.println(user);
		}
		
		
		
		
	     
		
	}
	
	
	/**
	 * 插入数据
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void deleteDataTest() {
		
		//********设置插入数据***********

		
		User user=new User();
		user.setId(1);
		user.setUsername("username");
		
		//getMongoTemplate().remove(user);
		this.userService.deleteData(user);
	     
		
	}
	
	
	/**
	 * 插入数据
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void deleteAllDataTest() {
		
		//********设置插入数据***********
		this.userService.deleteAllData(new User());
	     
		
	}
	
	/**
	 * 修改数据
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void updateDataTest() throws IllegalArgumentException, IllegalAccessException {
		
		User user=new User();
		user.setId(3);
		user.setUsername("username223");
		
		this.userService.updateData(user);
	     
		
	}
	
	
	@Test
	public void findAllTest()
	{
		List<User> list=userService.getAllData(new User());
		
		System.out.println(list);
	}
	
	
	@Test
	public void findPageTest()
	{
		
		User user=new User();
		user.setPage(20);
		user.setRows(1);
		user.setUsername("1");
		PageResult<User> list=userService.getPageData(user);
		
		
		
		System.out.println(list);
	}

	
	

	@Test
	public void findCommonOperateLogTest()
	{
		
		
		List<CommonOperateLog> list=this.commonOperateLogService.getAllData(new CommonOperateLog());
		
		System.out.println(list);
	}
	
	
	@Test
	public void insertCommonOperateLogTest()
	{
		for(int i=0;i<100;i++){
		CommonOperateLog cc=new CommonOperateLog();
		
		int maxId=this.commonOperateLogService.getMaxId(cc);
		cc.setId(maxId);
		cc.setCreatetime("编号："+maxId);
		cc.setLoglevel("1");
		this.commonOperateLogService.insertData(cc);
		
		}
		
	}

}
