package com.anguo.web.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.service.AppManageService;
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
		  
		//根据服务编码获取用户bean名称及方法名
		  CommonAppSiDefine commonAppSiDefine=new CommonAppSiDefine();
		  commonAppSiDefine.setSiService(serviceCode);
		  commonAppSiDefine=this.commonAppSiDefineService.getDataBySiService(commonAppSiDefine);
		  
		  
	    //反射调用sprin bean 方法
	    Map result = null; 
	    
	    if(commonAppSiDefine!=null)
	    {
	    	result=this.appManageService.ObjectInvoke(commonAppSiDefine.getSiServiceName(), commonAppSiDefine.getSiServiceMethod(), reqParam);
	    }


	    return result;
	  }


	
}
