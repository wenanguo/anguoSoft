package com.anguo.app.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.service.CommonAppLoggedUserService;
import com.anguo.mybatis.db.controller.BaseConstants;

@ContextConfiguration(locations = { "classpath*:cmcc-platform.xml" , "file:src/test/resources/project-*.xml" })
public class CommonAppLoggedUserServiceTest extends AbstractTestNGSpringContextTests {


	@Autowired
	CommonAppLoggedUserService commonAppLoggedUserService;

	/**
	 * 插入数据编号
	 */
	private Integer insertDataId = 11;

	/**
	 * 插入数据
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void insertData() {
		CommonAppLoggedUser commonAppLoggedUser = new CommonAppLoggedUser();
		
		//********设置插入数据***********
	
	     
						commonAppLoggedUser.setUuid("uuid");
			     
						commonAppLoggedUser.setMemberId(1);
			     
						commonAppLoggedUser.setInnerVersion("内部版本号");
			     
						commonAppLoggedUser.setExternalVersion("外部版本号");
			     
						commonAppLoggedUser.setOsType("操作系统");
			     
						commonAppLoggedUser.setOsVersion("操作系统版本");
			     
						commonAppLoggedUser.setPhoneModel("手机型号");
			     
						commonAppLoggedUser.setImsi("imsi");
			     
						commonAppLoggedUser.setImei("imei");
			     
						commonAppLoggedUser.setSign("签名信息");
			     
						commonAppLoggedUser.setAppCode("app_code");
			     
						commonAppLoggedUser.setStatus(1);
			     
						commonAppLoggedUser.setOperateUserId(1);
			     
				     
		//*******************************
		
		int result = commonAppLoggedUserService.insertData(commonAppLoggedUser);

		assert result == 1 : "CommonAppLoggedUser插入数据失败，成功结果为0，但执行结果为：" + result;

		/**
		 * 设置插入数据编号
		 */
		insertDataId = commonAppLoggedUser.getId();

	}

	/**
	 * 获得单条数据
	 */
	@Test(dependsOnMethods = { "insertData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void getData() {
		CommonAppLoggedUser commonAppLoggedUser = new CommonAppLoggedUser();
		// ********设置获取数据***********
		commonAppLoggedUser.setId(insertDataId);
		//*******************************
		CommonAppLoggedUser commonAppLoggedUserData = (CommonAppLoggedUser) commonAppLoggedUserService.getData(commonAppLoggedUser);

		assert commonAppLoggedUserData != null : "获得单条数据失败，执行数据为null";

	}
	
	

	/**
	 * 获得全部数据
	 */
	@Test(dependsOnMethods = { "getData" }, groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void getAllData() {
		
		List<CommonAppLoggedUser> list = commonAppLoggedUserService.getAllData(null);

		assert list.size() >= 1 : "如果获取全部系统列表成功，返回列表至少应该有一条记录, 但返回条数为"
				+ list.size();
	}

	/**
	 * 修改数据
	 */
	@Test(dependsOnMethods = { "getAllData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void updateData() {

		CommonAppLoggedUser commonAppLoggedUser = new CommonAppLoggedUser();

		// ********设置修改数据***********
	
	
					commonAppLoggedUser.setId(insertDataId);
		
     
					commonAppLoggedUser.setUuid("uuid");
		
     
					commonAppLoggedUser.setMemberId(insertDataId);
		
     
					commonAppLoggedUser.setInnerVersion("内部版本号");
		
     
					commonAppLoggedUser.setExternalVersion("外部版本号");
		
     
					commonAppLoggedUser.setOsType("操作系统");
		
     
					commonAppLoggedUser.setOsVersion("操作系统版本");
		
     
					commonAppLoggedUser.setPhoneModel("手机型号");
		
     
					commonAppLoggedUser.setImsi("imsi");
		
     
					commonAppLoggedUser.setImei("imei");
		
     
					commonAppLoggedUser.setSign("签名信息");
		
     
					commonAppLoggedUser.setAppCode("app_code");
		
     
					commonAppLoggedUser.setStatus(insertDataId);
		
     
					commonAppLoggedUser.setOperateUserId(insertDataId);
		
     
		
     		// ******************************

		int result = commonAppLoggedUserService.updateData(commonAppLoggedUser);

		assert result == 1 : "修改数据失败，执行结果为" + result;
	}

	/**
	 * 删除数据
	 */
	@Test(dependsOnMethods = { "updateData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void deleteData() {

		CommonAppLoggedUser commonAppLoggedUser = new CommonAppLoggedUser();

		// ********设置删除数据***********
		commonAppLoggedUser.setId(insertDataId);
		// ******************************

		int result = commonAppLoggedUserService.deleteData(commonAppLoggedUser);

		assert result == 1 : "删除数据失败，执行结果为" + result;

	}

}
