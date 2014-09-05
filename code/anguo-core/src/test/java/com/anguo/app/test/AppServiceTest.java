package com.anguo.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.service.AppManageService;
import com.anguo.app.service.CommonAppSiDefineService;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoRSAEncryptUtil;




@ContextConfiguration(locations = {"file:src/test/resources/project-*.xml" })
public class AppServiceTest  extends AbstractTestNGSpringContextTests{

	@Autowired
	AppManageService paramManageService;
	
	@Autowired
	CommonAppSiDefineService commonAppSiDefineService;
	
	@Autowired
	AnguoRSAEncryptUtil anguoRSAEncryptUtil;
	
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
	@Test
	public void test4()
	{
		
		//测试字符串
				String encryptStr= "wenanguo##123456";

				try {
					long start=System.currentTimeMillis();
					for(int i=0 ;i<10;i++){
					//加密
					String cipher = this.anguoRSAEncryptUtil.encrypt(encryptStr);
					
					System.out.println("加密文："+cipher);
					//解密
					String plainText = this.anguoRSAEncryptUtil.decrypt(cipher);
					
					System.out.println("明文："+plainText);
					
					}
					
					System.out.println(System.currentTimeMillis()-start);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
	}
}
