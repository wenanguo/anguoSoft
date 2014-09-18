package com.anguo.app.test;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.app.controller.CommonAppController;
import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.domain.Sign;
import com.anguo.app.service.CommonAppService;
import com.anguo.app.service.CommonAppSiDefineService;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoAppUtil;
import com.anguo.util.AnguoEncryptUtil;
import com.anguo.util.AnguoJsonUtil;




@ContextConfiguration(locations = {"file:src/test/resources/project-*.xml" })
public class AppServiceTest  extends AbstractTestNGSpringContextTests{

	@Autowired
	CommonAppService paramManageService;
	
	@Autowired
	CommonAppSiDefineService commonAppSiDefineService;
	
	@Autowired
	AnguoEncryptUtil anguoEncryptUtil;
	@Autowired
	CommonAppController commonAppController;
	
	@Test
	public void test1() throws Exception
	{
		String DEFAULT_PUBLIC_KEY=
		        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDveyqk24CbH/mAgEbUD03pVYQ1"+"\r"
				+"pTbhZf+9hnVJMtVfYEHf33i53Myq/qVkPsAI6/6iCHgOXhR1RGRmCXtZnTELoPVn"+"\r"
				+"K3nRQJVFpeVmH3s4i6q6BXaTt6i0RTfWQzeP9SgUtfSPzoAxoGM4DfRw3U5wYvzH"+"\r"
				+"v60/Mvd4IvWafQeYvQIDAQAB"+"\r";
		
				//业务参数
				CommonSysMember member=new CommonSysMember();
				member.setMemberName("wenanguo");
				member.setPassword("123456");
				
				String reqParam=AnguoJsonUtil.toJson(member);
				
				
				//系统参数
				CommonAppLoggedUser commonAppLoggedUser=new CommonAppLoggedUser();
				commonAppLoggedUser.setOsType("iphone");
				commonAppLoggedUser.setOsVersion("8.0");
						
				String appParam=AnguoJsonUtil.toJson(commonAppLoggedUser);
		
		
				//用户签名
				Sign sign=new Sign();
				String timestamp=String.valueOf(System.currentTimeMillis());
		    	String uuid="943f9627-9466-489f-b603-1b38f529e57d";
		    	
		    	sign.setUuid(uuid);
		    	sign.setTimestamp(timestamp);
		    	
		    	sign=AnguoAppUtil.enSign(sign, DEFAULT_PUBLIC_KEY);
				
		    	String userParam=AnguoJsonUtil.toJson(sign);
		
		Object obj=this.commonAppController.doAction("login", AnguoEncryptUtil.encryptBASE64(reqParam.getBytes()),AnguoEncryptUtil.encryptBASE64(appParam.getBytes()),AnguoEncryptUtil.encryptBASE64(userParam.getBytes()),null,null);
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
	
	/**
	 * 单元测试，RSA非对称加密
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception
	{
		  System.out.println("公钥加密——私钥解密");  
	        String inputStr = "abc";  
	        byte[] data = inputStr.getBytes();  
	        
	  
	        byte[] encodedData = AnguoEncryptUtil.encryptByPublicKey(data, anguoEncryptUtil.getPublicKey());  
	  
	        byte[] decodedData = AnguoEncryptUtil.decryptByPrivateKey(encodedData,anguoEncryptUtil.getPrivateKey());  
	  
	        String outputStr = new String(decodedData);  
	        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
	        Assert.assertEquals(inputStr, outputStr);  
	}
	
}
