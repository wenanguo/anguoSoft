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
					for(int i=0 ;i<1;i++){
					//加密
					byte[] cipher = this.anguoRSAEncryptUtil.encrypt(encryptStr);
					
					//byte[] cipher =encryptStr.getBytes();
					//System.out.println("密文长度:"+ cipher.length);
					System.out.println("1："+AnguoRSAEncryptUtil.byteArrayToString(cipher));
					String temp =new String(cipher);
					System.out.println(temp);
					System.out.println("2："+AnguoRSAEncryptUtil.byteArrayToString(temp.getBytes()));
					
					//解密
					byte[] plainText = this.anguoRSAEncryptUtil.decrypt(temp.getBytes());
					
					//System.out.println("明文长度:"+ plainText.length);
					//System.out.println("明文："+AnguoRSAEncryptUtil.byteArrayToString(plainText));
					System.out.println("解密字符串:"+new String(plainText));
					
					}
					
					System.out.println(System.currentTimeMillis()-start);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
		
		
		
		
		
		
		
		
		
		
//		
//		
//		
//		
//		
//		
//		
//		
//		//测试字符串
//				String encryptStr= "wenanguo##123456";
//
//				try {
//					long start=System.currentTimeMillis();
//					for(int i=0 ;i<10;i++){
//					//加密
//					byte[] cipher = this.anguoRSAEncryptUtil.encrypt(encryptStr.getBytes());
//					
//					System.out.println("加密文："+this.anguoRSAEncryptUtil.byteArrayToString(cipher));
//					//解密
//					byte[] plainText = this.anguoRSAEncryptUtil.decrypt(cipher);
//					
//					System.out.println("明文："+this.anguoRSAEncryptUtil.byteArrayToString(plainText));
//					
//					}
//					
//					System.out.println(System.currentTimeMillis()-start);
//				} catch (Exception e) {
//					System.err.println(e.getMessage());
//				}
				
	}
}
