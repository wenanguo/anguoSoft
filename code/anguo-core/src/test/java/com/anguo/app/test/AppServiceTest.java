package com.anguo.app.test;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.service.AppManageService;
import com.anguo.app.service.CommonAppSiDefineService;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoEncryptUtil;




@ContextConfiguration(locations = {"file:src/test/resources/project-*.xml" })
public class AppServiceTest  extends AbstractTestNGSpringContextTests{

	@Autowired
	AppManageService paramManageService;
	
	@Autowired
	CommonAppSiDefineService commonAppSiDefineService;
	
	@Autowired
	AnguoEncryptUtil anguoEncryptUtil;
	
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
	public void test4() throws Exception
	{
		  System.err.println("公钥加密——私钥解密");  
	        String inputStr = "abc";  
	        byte[] data = inputStr.getBytes();  
	        
	  
	        byte[] encodedData = AnguoEncryptUtil.encryptByPublicKey(data, anguoEncryptUtil.getPublicKey());  
	  
	        byte[] decodedData = AnguoEncryptUtil.decryptByPrivateKey(encodedData,anguoEncryptUtil.getPrivateKey());  
	  
	        String outputStr = new String(decodedData);  
	        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
	        Assert.assertEquals(inputStr, outputStr);  
	}
	
}
