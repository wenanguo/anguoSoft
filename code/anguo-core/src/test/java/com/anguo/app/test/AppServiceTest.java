package com.anguo.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.service.AppManageService;
import com.anguo.app.service.CommonAppSiDefineService;
import com.anguo.mybatis.db.core.PageResult;




@ContextConfiguration(locations = {"file:src/test/resources/project-*.xml" })
public class AppServiceTest  extends AbstractTestNGSpringContextTests{

	@Autowired
	AppManageService paramManageService;
	
	@Autowired
	CommonAppSiDefineService commonAppSiDefineService;
	
	@Test
	public void test1()
	{

		
		Object obj=this.paramManageService.ObjectInvoke("appService", "login", "123");
		System.out.println(obj);
	}
	
	@Test
	public void test2()
	{

		CommonAppSiDefine commonAppSiDefine=new CommonAppSiDefine();
		commonAppSiDefine.setSiService("login");
		  
		  
		commonAppSiDefine =this.commonAppSiDefineService.getDataBySiService(commonAppSiDefine);
		System.out.println(commonAppSiDefine);
	}
	
	@Test
	public void test3()
	{

		CommonAppSiDefine commonAppSiDefine=new CommonAppSiDefine();
		//commonAppSiDefine.setSiService("login");
		  
		  
		PageResult<CommonAppSiDefine> list =this.commonAppSiDefineService.getPageData(commonAppSiDefine);
		System.out.println(list);
	}
}
