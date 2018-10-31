package com.anguo.mybatis.db.controller;

import org.springframework.stereotype.Controller;
import com.anguo.mybatis.db.core.CodeComments;



/**
 * 所有controller都继承自该父类
 * @author AndrewWen
 *
 */
@Controller
@CodeComments("基础框架")
public class BaseController {
	
//	/**
//	 * 从security中获取当前登录用户信息
//	 * @return
//	 */
//	@CodeComments("获得当前用户")
//	public CommonSysUser getSecuritySessionUser()
//	{
//		CommonSysUser currUser=null;
//
//		//获得当前用户
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof CommonSysUser) {
//			currUser=(CommonSysUser)principal;
//
//		}
//
//		return currUser;
//	}
	
	 

}

