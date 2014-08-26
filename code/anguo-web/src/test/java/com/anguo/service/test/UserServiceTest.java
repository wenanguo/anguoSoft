package com.anguo.service.test;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.mybatis.db.controller.BaseConstants;
import com.anguo.util.AnguoTreeUtils;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.mapper.CommonSysAuthorityMapper;
import com.anguo.web.db.mapper.CommonSysRoleMapper;
import com.anguo.web.db.mapper.CommonSysUserMapper;



@ContextConfiguration(locations = {"file:src/main/resources/project-*.xml" })
public class UserServiceTest extends AbstractTestNGSpringContextTests {


	
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	CommonSysUserMapper commonSysUserMapper;
	
	@Autowired
	CommonSysAuthorityMapper commonSysAuthorityMapper;
	
	@Autowired
	CommonSysRoleMapper commonSysRoleMapper;
	
	
	
//	@Test(dependsOnMethods = { "getAuthority" }, groups = {BaseConstants.TEST_DATABASE_NO_AFFECT})
//	public void testpage()
//	{
//		CommonSysUser u=new CommonSysUser();
//		//u.setUsername("文");
//	
//		u.setCurrentPage(2);
//		u.setPageSize(2);
//		
//		List<CommonSysUser> list=this.commonSysUserMapper.getPageData(u);
//		
//		for(CommonSysUser t:list)
//		{
//			System.out.println(t);
//		}
//		
//		System.out.println(list.size());
//        System.out.println(u.getTotalPages());
//        System.out.println(u.getTotalRows());
//	}
	
	/**
	 * 获得用户权限单元测试
	 * @throws Exception 
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_NO_AFFECT})
	public void getAuthority() throws Exception
	{
		
		CommonSysUser role=new CommonSysUser();
		
		role.setId(2);
		
		List<CommonSysAuthority> list=this.commonSysAuthorityMapper.getAuthorityByUserId(role);
		
		for(CommonSysAuthority temp:list)
		{
			System.out.println(temp);
		}
		
		AnguoTreeUtils.buildTree(AnguoTreeUtils.coverTreeNode(list));
		
		
	}
	
	/**
	 * 获得用户角色测试
	 */
	@Test(groups = {BaseConstants.TEST_DATABASE_NO_AFFECT})
	public void getRole()
	{
		CommonSysRole u=new CommonSysRole();
		//u.setId(1);
		
		//List<CommonSysRole> list=this.commonSysRoleMapper.getRoleByUser(u);
		List<CommonSysRole> list=this.commonSysRoleMapper.getAllData(u);
		
		for(CommonSysRole temp:list)
		{
			System.out.println(temp);
		}
		
	}
	
	@Test(groups = {BaseConstants.TEST_DATABASE_AFFECT})
	public void insertTest()
	{
		CommonSysUser u=new CommonSysUser();
		u.setUserName("文安国");
		
		System.out.println(this.commonSysUserMapper.insertData(u));
		
	}
	
	@Test(groups = {BaseConstants.TEST_SERVICE_AFFECT})
	public void testActivite1()
	{
		Deployment deployment = repositoryService.createDeployment()
				  .addClasspathResource("FinancialReportProcess.bpmn20.xml")
				  .deploy();
	}
	
	
	
	@Test(groups = {BaseConstants.TEST_SERVICE_AFFECT})
	public void testGetUserListPage()
	{
		CommonSysUser u=new CommonSysUser();
		
		List<CommonSysUser> list=this.commonSysUserMapper.getPageData(u);
		
		for(CommonSysUser usr:list)
		{
			System.out.println(usr);
		}
	}


}
