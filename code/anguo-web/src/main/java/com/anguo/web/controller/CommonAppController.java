package com.anguo.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

/**
 * app接口调用总控制器
 * @author Andrew.Wen
 *
 */
@Controller
public class CommonAppController {
	
	

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
	 */
	  @RequestMapping(value={"/{serviceCode}.app"}, method={RequestMethod.POST})
	  @ResponseBody
	  public Object doAction(@PathVariable("serviceCode") String serviceCode, String reqParam, String appParam, String userParam, HttpSession session, HttpServletRequest request)
	  {
		  
		  System.out.println("系统参数："+appParam);
		  System.out.println("业务参数："+reqParam);
		  System.out.println("用户参数："+userParam);
		  
		  String localAppParam,localReqParam,localUserParam;
		  
		  
		  //根据服务编码获取用户bean名称及方法名
		  CommonAppSiDefine commonAppSiDefine=new CommonAppSiDefine();
		  commonAppSiDefine.setSiService(serviceCode);
		  commonAppSiDefine=this.commonAppSiDefineService.getDataBySiService(commonAppSiDefine);
		  
		  
	    //反射调用sprin bean 方法
//	    Map result = new HashMap();
//	    
//	    result.put("code", "100");
//	    result.put("resule", "secuss");
	    
	    
	    if(commonAppSiDefine!=null)
	    {
	    	
	    	//根据加密方式进行解密
	    	if(commonAppSiDefine.getSiEncryptionWay().equals(1))
	    	{
	    		//base64
	    		
	    	}else
	    	{
	    		
	    	}
	    	
	    	
	    	
	    	if(commonAppSiDefine.getSiDemo().equals(2))
	    	{
	    		//真实接口
	    		Object resultObj=this.appManageService.ObjectInvoke(commonAppSiDefine.getSiServiceName(), commonAppSiDefine.getSiServiceMethod(), reqParam);
	    		//result.put("responseData", resultObj);
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
	    		
	    		//result.put("responseData", responseMap);
	    		return responseMap;
	    	}
	    	
	    }
	    
	    return null;


	    
	  }

	  
	  

	
}
