package com.anguo.app.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.service.CommonSysMemberService;
import com.anguo.mybatis.db.controller.BaseConstants;

@ContextConfiguration(locations = { "classpath*:cmcc-platform.xml" , "file:src/test/resources/project-*.xml" })
public class CommonSysMemberServiceTest extends AbstractTestNGSpringContextTests {


	@Autowired
	CommonSysMemberService commonSysMemberService;

	/**
	 * 插入数据编号
	 */
	private Integer insertDataId = 11;

	/**
	 * 插入数据
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void insertData() {
		CommonSysMember commonSysMember = new CommonSysMember();
		
		//********设置插入数据***********
	
	     
						commonSysMember.setCampusId(1);
			     
						commonSysMember.setMemberName("用户名");
			     
						commonSysMember.setPassword("密码");
			     
						commonSysMember.setPhone("电话");
			     
						commonSysMember.setImei("imei");
			     
						commonSysMember.setImsi("imsi");
			     
						commonSysMember.setNickName("昵称");
			     
						commonSysMember.setPhoto("头像");
			     
						commonSysMember.setSex(1);
			     
				     
						commonSysMember.setContact("其他联系方式");
			     
						commonSysMember.setCredits(1);
			     
						commonSysMember.setEmail("邮箱");
			     
						commonSysMember.setMemberClass(1);
			     
						commonSysMember.setStatus(1);
			     
						commonSysMember.setOperateUserId(1);
			     
				     
		//*******************************
		
		int result = commonSysMemberService.insertData(commonSysMember);

		assert result == 1 : "CommonSysMember插入数据失败，成功结果为0，但执行结果为：" + result;

		/**
		 * 设置插入数据编号
		 */
		insertDataId = commonSysMember.getId();

	}

	/**
	 * 获得单条数据
	 */
	@Test(dependsOnMethods = { "insertData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void getData() {
		CommonSysMember commonSysMember = new CommonSysMember();
		// ********设置获取数据***********
		commonSysMember.setId(insertDataId);
		//*******************************
		CommonSysMember commonSysMemberData = (CommonSysMember) commonSysMemberService.getData(commonSysMember);

		assert commonSysMemberData != null : "获得单条数据失败，执行数据为null";

	}
	
	/**
	 * 获得单条数据uuid
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void getDataByUUid() {
		
		//*******************************
		CommonSysMember commonAppLoggedUserData =  this.commonSysMemberService.getDataByUUID("dc13c18d-2e5a-4024-af4d-c60e6addd3d4");

		System.out.println(commonAppLoggedUserData);
		assert commonAppLoggedUserData != null : "获得单条数据失败，执行数据为null";

	}

	/**
	 * 获得全部数据
	 */
	@Test(dependsOnMethods = { "getData" }, groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void getAllData() {
		
		List<CommonSysMember> list = commonSysMemberService.getAllData(null);

		assert list.size() >= 1 : "如果获取全部系统列表成功，返回列表至少应该有一条记录, 但返回条数为"
				+ list.size();
	}

	/**
	 * 修改数据
	 */
	@Test(dependsOnMethods = { "getAllData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void updateData() {

		CommonSysMember commonSysMember = new CommonSysMember();

		// ********设置修改数据***********
	
	
					commonSysMember.setId(insertDataId);
		
     
					commonSysMember.setCampusId(insertDataId);
		
     
					commonSysMember.setMemberName("用户名");
		
     
					commonSysMember.setPassword("密码");
		
     
					commonSysMember.setPhone("电话");
		
     
					commonSysMember.setImei("imei");
		
     
					commonSysMember.setImsi("imsi");
		
     
					commonSysMember.setNickName("昵称");
		
     
					commonSysMember.setPhoto("头像");
		
     
					commonSysMember.setSex(insertDataId);
		
     
		
     
					commonSysMember.setContact("其他联系方式");
		
     
					commonSysMember.setCredits(insertDataId);
		
     
					commonSysMember.setEmail("邮箱");
		
     
					commonSysMember.setMemberClass(insertDataId);
		
     
					commonSysMember.setStatus(insertDataId);
		
     
					commonSysMember.setOperateUserId(insertDataId);
		
     
		
     		// ******************************

		int result = commonSysMemberService.updateData(commonSysMember);

		assert result == 1 : "修改数据失败，执行结果为" + result;
	}

	/**
	 * 删除数据
	 */
	@Test(dependsOnMethods = { "updateData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void deleteData() {

		CommonSysMember commonSysMember = new CommonSysMember();

		// ********设置删除数据***********
		commonSysMember.setId(insertDataId);
		// ******************************

		int result = commonSysMemberService.deleteData(commonSysMember);

		assert result == 1 : "删除数据失败，执行结果为" + result;

	}

}
