package com.anguo.app.test;

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
public class AppMemberServiceTest  extends AbstractTestNGSpringContextTests{

	@Autowired
	CommonAppService paramManageService;
	
	@Autowired
	CommonAppSiDefineService commonAppSiDefineService;
	
	@Autowired
	AnguoEncryptUtil anguoEncryptUtil;
	@Autowired
	CommonAppController commonAppController;
	
	@Test
	public void loginTest() throws Exception
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
	public void logoutTest() throws Exception
	{
		String DEFAULT_PUBLIC_KEY=
		        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDveyqk24CbH/mAgEbUD03pVYQ1"+"\r"
				+"pTbhZf+9hnVJMtVfYEHf33i53Myq/qVkPsAI6/6iCHgOXhR1RGRmCXtZnTELoPVn"+"\r"
				+"K3nRQJVFpeVmH3s4i6q6BXaTt6i0RTfWQzeP9SgUtfSPzoAxoGM4DfRw3U5wYvzH"+"\r"
				+"v60/Mvd4IvWafQeYvQIDAQAB"+"\r";
		
				//业务参数
//				CommonSysMember member=new CommonSysMember();
//				member.setMemberName("wenanguo");
//				member.setPassword("123456");
				
				String reqParam="";
				
				
				//系统参数
				CommonAppLoggedUser commonAppLoggedUser=new CommonAppLoggedUser();
				commonAppLoggedUser.setOsType("iphone");
				commonAppLoggedUser.setOsVersion("8.0");
						
				String appParam=AnguoJsonUtil.toJson(commonAppLoggedUser);
		
		
				//用户签名
				Sign sign=new Sign();
				String timestamp=String.valueOf(System.currentTimeMillis());
		    	String uuid="c2cfeda9-1722-472c-869e-7b22d945c1e9";
		    	
		    	sign.setUuid(uuid);
		    	sign.setTimestamp(timestamp);
		    	
		    	sign=AnguoAppUtil.enSign(sign, DEFAULT_PUBLIC_KEY);
				
		    	String userParam=AnguoJsonUtil.toJson(sign);
		
		Object obj=this.commonAppController.doAction("logout", AnguoEncryptUtil.encryptBASE64(reqParam.getBytes()),AnguoEncryptUtil.encryptBASE64(appParam.getBytes()),AnguoEncryptUtil.encryptBASE64(userParam.getBytes()),null,null);
		System.out.println(obj);
	}
	
	@Test
	public void newMemberTest() throws Exception
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
		    	//String uuid="c2cfeda9-1722-472c-869e-7b22d945c1e9";
		    	
		    	//sign.setUuid(uuid);
		    	sign.setTimestamp(timestamp);
		    	
		    	sign=AnguoAppUtil.enSign(sign, DEFAULT_PUBLIC_KEY);
				
		    	String userParam=AnguoJsonUtil.toJson(sign);
		
		Object obj=this.commonAppController.doAction("newMember", AnguoEncryptUtil.encryptBASE64(reqParam.getBytes()),AnguoEncryptUtil.encryptBASE64(appParam.getBytes()),AnguoEncryptUtil.encryptBASE64(userParam.getBytes()),null,null);
		System.out.println(obj);
	}
	
	@Test
	public void updateMemberTest() throws Exception
	{
		String DEFAULT_PUBLIC_KEY=
		        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDveyqk24CbH/mAgEbUD03pVYQ1"+"\r"
				+"pTbhZf+9hnVJMtVfYEHf33i53Myq/qVkPsAI6/6iCHgOXhR1RGRmCXtZnTELoPVn"+"\r"
				+"K3nRQJVFpeVmH3s4i6q6BXaTt6i0RTfWQzeP9SgUtfSPzoAxoGM4DfRw3U5wYvzH"+"\r"
				+"v60/Mvd4IvWafQeYvQIDAQAB"+"\r";
		
				//业务参数
				CommonSysMember member=new CommonSysMember();
				member.setId(2);
				member.setMemberName("wenanguowww");
				member.setPassword("123456344www");
				
				String reqParam=AnguoJsonUtil.toJson(member);
				
				
				//系统参数
				CommonAppLoggedUser commonAppLoggedUser=new CommonAppLoggedUser();
				commonAppLoggedUser.setOsType("iphone");
				commonAppLoggedUser.setOsVersion("8.0");
						
				String appParam=AnguoJsonUtil.toJson(commonAppLoggedUser);
		
		
				//用户签名
				Sign sign=new Sign();
				String timestamp=String.valueOf(System.currentTimeMillis());
		    	//String uuid="c2cfeda9-1722-472c-869e-7b22d945c1e9";
		    	
		    	//sign.setUuid(uuid);
		    	sign.setTimestamp(timestamp);
		    	
		    	sign=AnguoAppUtil.enSign(sign, DEFAULT_PUBLIC_KEY);
				
		    	String userParam=AnguoJsonUtil.toJson(sign);
		
		Object obj=this.commonAppController.doAction("updateMember", AnguoEncryptUtil.encryptBASE64(reqParam.getBytes()),AnguoEncryptUtil.encryptBASE64(appParam.getBytes()),AnguoEncryptUtil.encryptBASE64(userParam.getBytes()),null,null);
		System.out.println(obj);
	}
	
}
