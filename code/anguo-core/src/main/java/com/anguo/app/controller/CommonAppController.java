package com.anguo.app.controller;

import java.lang.reflect.InvocationTargetException;
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

import com.anguo.app.db.domain.CommonAppSiData;
import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.service.AppManageService;
import com.anguo.app.service.CommonAppSiDataService;
import com.anguo.app.service.CommonAppSiDefineService;
import com.anguo.util.AnguoEncryptUtil;

/**
 * app接口调用总控制器
 * @author Andrew.Wen
 *
 */
@Controller
public class CommonAppController {
	
	private final static Logger log = Logger.getLogger(CommonAppController.class);
	
	//app业务逻辑类
	@Autowired
	AppManageService appManageService;
	
	@Autowired
	CommonAppSiDefineService commonAppSiDefineService;
	
	@Autowired
	CommonAppSiDataService commonAppSiDataService;
	
	
	/**
	 * 接收客户端请求方法
	 * @param serviceCode 业务代码
	 * @param reqParam 请求参数
	 * @param appParam app参数
	 * @param userParam 用户参数
	 * @param session 
	 * @param request
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	  @RequestMapping(value={"/{serviceCode}.app"}, method={RequestMethod.POST})
	  @ResponseBody
	  public Object doAction(@PathVariable("serviceCode") String serviceCode, String reqParam, String appParam, String userParam, HttpSession session, HttpServletRequest request) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	  {
		  
		  String localAppParam=null,localReqParam=null,localUserParam=null;
		  
		  //解密base64编码
		  if(StringUtils.isNotEmpty(reqParam))
		  {
			  localReqParam=new String(AnguoEncryptUtil.decryptBASE64(reqParam));
		  }
		  
		  if(StringUtils.isNotEmpty(appParam))
		  {
			  localAppParam=new String(AnguoEncryptUtil.decryptBASE64(appParam));
		  }
		  
		  if(StringUtils.isNotEmpty(userParam))
		  {
			  localUserParam=new String(AnguoEncryptUtil.decryptBASE64(userParam));
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
	    	
	    	if(commonAppSiDefine.getSiDemo().equals(2))
	    	{
	    		//真实接口
	    		Object resultObj=this.appManageService.ObjectInvoke(commonAppSiDefine.getSiServiceName(), commonAppSiDefine.getSiServiceMethod(), 
	    				localReqParam,localAppParam,localUserParam,session,request,commonAppSiDefine);
	    		
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
