package com.anguo.wx;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;


@Controller
public class WeChartController extends BaseController {
	
	@RequestMapping("/weChartController/list.json")
	@ResponseBody
	public String queryApiInfoList(HttpServletRequest request) {
		
		
		Enumeration e=request.getParameterNames();
		
		while (e.hasMoreElements()) {
		    Object o= e.nextElement();
		    System.out.print(o+"=");
		    System.out.println(request.getParameter(o.toString()));
		}
		
		String echostr=request.getParameter("echostr");
		
		return echostr;
	}

}
