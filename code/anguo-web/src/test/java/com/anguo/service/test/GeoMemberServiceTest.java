package com.anguo.service.test;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.anguo.member.db.domain.GeoMember;
import com.anguo.member.service.GeoMemberService;
import com.anguo.mybatis.db.controller.BaseConstants;



@ContextConfiguration(locations = { "classpath*:cmcc-platform.xml" , "file:src/main/resources/project-*.xml" })
public class GeoMemberServiceTest extends AbstractTestNGSpringContextTests {


	@Autowired
	GeoMemberService geoMemberService;

	/**
	 * 插入数据编号
	 */
	private Integer insertDataId = 11;

	/**
	 * 插入数据
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void insertData() {
		GeoMember geoMember = new GeoMember();
		
		//********设置插入数据***********
	
	     
						geoMember.setMemberName("用户名");
			     
						geoMember.setPassword("密码");
			     
						geoMember.setPhone("电话");
			     
						geoMember.setImei("imei");
			     
						geoMember.setImsi("imsi");
			     
						geoMember.setNickName("昵称");
			     
						geoMember.setPhoto("头像");
			     
						geoMember.setSex(1);
			     
				     
						geoMember.setContact("其他联系方式");
			     
						geoMember.setCredits(1);
			     
						geoMember.setEmail("邮箱");
			     
						geoMember.setMemberClass(1);
			     
						geoMember.setStatus(1);
			     
						geoMember.setOperateUserId(1);
			     
				     
		//*******************************
		
		int result = geoMemberService.insertData(geoMember);

		assert result == 1 : "GeoMember插入数据失败，成功结果为0，但执行结果为：" + result;

		/**
		 * 设置插入数据编号
		 */
		insertDataId = geoMember.getId();

	}

	/**
	 * 获得单条数据
	 */
	@Test(dependsOnMethods = { "insertData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void getData() {
		GeoMember geoMember = new GeoMember();
		// ********设置获取数据***********
		geoMember.setId(insertDataId);
		//*******************************
		GeoMember geoMemberData = (GeoMember) geoMemberService.getData(geoMember);

		assert geoMemberData != null : "获得单条数据失败，执行数据为null";

	}

	/**
	 * 获得全部数据
	 */
	@Test(dependsOnMethods = { "getData" }, groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void getAllData() {
		
		List<GeoMember> list = geoMemberService.getAllData(null);

		assert list.size() >= 1 : "如果获取全部系统列表成功，返回列表至少应该有一条记录, 但返回条数为"
				+ list.size();
	}

	/**
	 * 修改数据
	 */
	@Test(dependsOnMethods = { "getAllData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void updateData() {

		GeoMember geoMember = new GeoMember();

		// ********设置修改数据***********
	
	
					geoMember.setId(insertDataId);
		
     
					geoMember.setMemberName("用户名");
		
     
					geoMember.setPassword("密码");
		
     
					geoMember.setPhone("电话");
		
     
					geoMember.setImei("imei");
		
     
					geoMember.setImsi("imsi");
		
     
					geoMember.setNickName("昵称");
		
     
					geoMember.setPhoto("头像");
		
     
					geoMember.setSex(insertDataId);
		
     
		
     
					geoMember.setContact("其他联系方式");
		
     
					geoMember.setCredits(insertDataId);
		
     
					geoMember.setEmail("邮箱");
		
     
					geoMember.setMemberClass(insertDataId);
		
     
					geoMember.setStatus(insertDataId);
		
     
					geoMember.setOperateUserId(insertDataId);
		
     
		
     		// ******************************

		int result = geoMemberService.updateData(geoMember);

		assert result == 1 : "修改数据失败，执行结果为" + result;
	}

	/**
	 * 删除数据
	 */
	@Test(dependsOnMethods = { "updateData" },groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void deleteData() {

		GeoMember geoMember = new GeoMember();

		// ********设置删除数据***********
		geoMember.setId(insertDataId);
		// ******************************

		int result = geoMemberService.deleteData(geoMember);

		assert result == 1 : "删除数据失败，执行结果为" + result;

	}
	
	
	/**
	 * 删除数据
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void loginTest() {

		GeoMember geoMember = new GeoMember();

		// ********设置数据***********
		geoMember.setMemberName("wenanguo1");
		geoMember.setPassword("123456");
		// ******************************
		GeoMember resultGeoMember = null;
		
		//测试用户名错误
		try {
			 resultGeoMember  = geoMemberService.login(geoMember);
		} catch (Exception e) {
			
			Assert.assertEquals(e.getMessage(), "用户不存在！");
		}

		
		//测试密码错误
		try {
			geoMember.setMemberName("wenanguo");
			geoMember.setPassword("1234561");
			 resultGeoMember  = geoMemberService.login(geoMember);
		} catch (Exception e) {
			
			Assert.assertEquals(e.getMessage(), "密码错误！");
		}
		
		//测试密码错误
		try {
					geoMember.setMemberName("wenanguo");
					geoMember.setPassword("123456");
					resultGeoMember  = geoMemberService.login(geoMember);
					
					Assert.assertNotNull(resultGeoMember);
			} catch (Exception e) {
					
			}

	}

}
