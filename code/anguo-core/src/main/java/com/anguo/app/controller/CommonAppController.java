package com.anguo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.app.db.domain.CommonAppSiData;
import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.domain.ConstantClass;
import com.anguo.app.db.domain.ResultMsg;
import com.anguo.app.db.domain.Sign;
import com.anguo.app.service.CommonAppService;
import com.anguo.app.service.CommonAppSiDataService;
import com.anguo.app.service.CommonAppSiDefineService;
import com.anguo.app.service.CommonSysMemberService;
import com.anguo.util.AnguoAppUtil;
import com.anguo.util.AnguoEncryptUtil;
import com.anguo.util.AnguoJsonUtil;

/**
 * app接口调用总控制器
 * @author Andrew.Wen
 *
 */
@Controller
public class CommonAppController {
	
	private final static Logger log = Logger.getLogger(CommonAppController.class);
	
	
	//私钥
	private final static String DEFAULT_PRIVATE_KEY=
			"MIICXAIBAAKBgQDveyqk24CbH/mAgEbUD03pVYQ1pTbhZf+9hnVJMtVfYEHf33i5"+"\r"
			+"3Myq/qVkPsAI6/6iCHgOXhR1RGRmCXtZnTELoPVnK3nRQJVFpeVmH3s4i6q6BXaT"+"\r"
			+"t6i0RTfWQzeP9SgUtfSPzoAxoGM4DfRw3U5wYvzHv60/Mvd4IvWafQeYvQIDAQAB"+"\r"
			+"AoGAO5hl+1KYhYIGgADsH1eTpu5eEU+FAcB1TP/J7iZVTP/SRNkC3RXiZOcr1296"+"\r"
			+"MH4yBrae0cx9wNT9Oxs+9AUXL/dmPnJh36+4Rg4P1aHl65Q0hvuq7UUwCqPXG+AT"+"\r"
			+"RjIP57htK/E/0dyvMicXfMr1Ip6+gUFcYgy3nChm9phfz+0CQQD6+79KR82d6Amg"+"\r"
			+"1Rk8yhXMND8eO8t2CzqBeZlDJlmOmBwJhLjOglTcCeDrecAUQgcq+euQUB0Mca4l"+"\r"
			+"Z48u1iOvAkEA9ESQRwgSNWFP8xOqDPBvBFbE/UT4caB9/SqJDHMgDwj/XvV6IXoN"+"\r"
			+"29yprg+z3uJJi2ANZZIalUDpxsFXbg0pUwJBANV6zHqiGIL3mzjyCUVrnp7S0d0l"+"\r"
			+"fyoo4tq+U16KgCKJv09ZVNhSg1umC2o/ZOHWR8KGUZeujQbIqxelvmRYQIECQEC7"+"\r"
			+"yuCIKwsqdt2cYHx9W25y8FGObajvN3RYSWmbOOvDHqozs+IbToDtwan3T1vJ7GOb"+"\r"
			+"WPGJ/rF/OnUJ1/m6UzECQGxVPKOcSUsQI1NKTLHvATgGxAdvQNii1b3DjjqNLFDN"+"\r"
			+"aBtbG4svFr0t7HLkilUQnvex3oJkTsp/VYBxTbSSLVU="+"\r";
	
	//app业务逻辑类
	@Autowired
	CommonAppService appManageService;
	
	@Autowired
	CommonAppSiDefineService commonAppSiDefineService;
	
	@Autowired
	CommonAppSiDataService commonAppSiDataService;
	
	@Autowired
	CommonSysMemberService commonSysMemberService;
	
	
	/**
	 * 接收客户端请求方法
	 * @param serviceCode 业务代码
	 * @param reqParam 请求参数
	 * @param appParam app参数
	 * @param userParam 用户参数
	 * @param session 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	  @RequestMapping(value={"/{serviceCode}.app"}, method={RequestMethod.POST})
	  @ResponseBody
	  public Object doAction(@PathVariable("serviceCode") String serviceCode, String reqParam, String appParam, String userParam, HttpSession session, HttpServletRequest request) throws Exception
	  {
		  
		  String localAppParam=null,localReqParam=null,localUserParam=null;
		  Sign loginSign=null;
		  //登录用户
		  CommonSysMember commonSysMember=null;
		  //系统信息
		  CommonAppLoggedUser commonAppLoggerUser=null;
		  
		  //解密base64编码
		  if(StringUtils.isNotEmpty(reqParam))
		  {
			  localReqParam=new String(AnguoEncryptUtil.decryptBASE64(reqParam));
		  }
		  
		  if(StringUtils.isNotEmpty(appParam))
		  {
			  localAppParam=new String(AnguoEncryptUtil.decryptBASE64(appParam));
			  commonAppLoggerUser=AnguoJsonUtil.fromJson(localAppParam, CommonAppLoggedUser.class);
		  }
		  
		  if(StringUtils.isNotEmpty(userParam))
		  {
			  localUserParam=new String(AnguoEncryptUtil.decryptBASE64(userParam));
			  
			  //获得签名数据
			  loginSign=AnguoJsonUtil.fromJson(localUserParam, Sign.class);
			  
			  //解密
			  loginSign=AnguoAppUtil.deSign(loginSign, DEFAULT_PRIVATE_KEY);
			  
			  commonSysMember =this.commonSysMemberService.getDataByUUID(loginSign.getUuid());
			  
		  }
		  
		  
		  log.debug("====================调用参数====================");
		  log.debug("解密后业务参数:"+localReqParam);
		  log.debug("解密后系统参数:"+localAppParam);
		  log.debug("解密后用户参数:"+localUserParam);
		  log.debug("===============================================");
		  
		  //根据服务编码获取用户bean名称及方法名
		  CommonAppSiDefine commonAppSiDefine=new CommonAppSiDefine();
		  commonAppSiDefine.setSiService(serviceCode);
		  commonAppSiDefine=this.commonAppSiDefineService.getDataBySiService(commonAppSiDefine);
		  
		  
		  
	    if(commonAppSiDefine!=null)
	    {
	    	
	    	//鉴权开关打开，需要鉴权
	    	if(commonAppSiDefine.getSiAuthAccess().equals(2))
	    	{
	    		
	    		if(commonSysMember==null)
	    		{
	    			ResultMsg rs=new ResultMsg();
	    			rs.setCode(ConstantClass.INTERFACE_LOGIN_TIMEOUT);
	    			
	    			return rs;
	    		}
	    	}
	    	
	    	
	    	
	    	if(commonAppSiDefine.getSiDemo().equals(2))
	    	{
	    		
	    		
	    		//真实接口
	    		Object resultObj=this.appManageService.ObjectInvoke(commonAppSiDefine.getSiServiceName(), commonAppSiDefine.getSiServiceMethod(), 
	    				localReqParam,commonAppLoggerUser,commonSysMember,session,request);
	    		
	    		return resultObj;
	    		
	    	}else
	    	{
	    		//模拟接口
	    		Map responseMap=new HashMap();
	    		
	    		CommonAppSiData cas=new CommonAppSiData();
	    		cas.setCommonAppSiDefineId(commonAppSiDefine.getId());
	    		cas.setParamType("2");
	    		
	    		List<CommonAppSiData> list=this.commonAppSiDataService.getAllData(cas);
	    		
	    		for(CommonAppSiData temp : list)
	    		{
	    			responseMap.put(temp.getDataName(), temp.getDataDefaultVal());
	    		}
	    		
	    		return responseMap;
	    	}
	    	
	    }
	    
	    return null;


	    
	  }

	  
	  

	
}
