package com.anguo.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.security.service.SysUserDetailsService;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.service.CommonSysUserService;

/**
 * 制器类
 * @ClassName: CommonSysUser
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysUserController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysUserController.class);
	@Autowired
	private CommonSysUserService commonSysUserService;
	@Autowired
	private SysUserDetailsService sysUserDetailsService;

	public SysUserDetailsService getSysUserDetailsService() {
		return sysUserDetailsService;
	}

	public void setSysUserDetailsService(SysUserDetailsService sysUserDetailsService) {
		this.sysUserDetailsService = sysUserDetailsService;
	}

	@RequestMapping("/commonSysUser/list.htm")
	@ResponseBody
	public Object queryCommonSysUserList(CommonSysUser commonSysUser) {
		try {
			return commonSysUserService.getPageData(new CommonSysUser());
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysUser/listAll.htm")
	@ResponseBody
	public List<CommonSysUser> queryCommonSysUserAllList(CommonSysUser commonSysUser) {
		try {
			return commonSysUserService.getAllData(new CommonSysUser());
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysUser/create.htm")
	@ResponseBody
	public Object saveCommonSysUser(String roleIds,String userName,String password,String realName,@RequestParam(value ="birthday") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date birthday ,String email,String phone,String memo,Integer status) {
		Map messages = new HashMap();
		try {
			//组装bean实体
			CommonSysUser commonSysUser=new CommonSysUser();
			commonSysUser.setUserName(userName);
			if(password==null){
				commonSysUser.setPassword("123456");
			}else{
				
				commonSysUser.setPassword(password);
			}
			commonSysUser.setRealName(realName);
			commonSysUser.setBirthday(birthday);
			commonSysUser.setEmail(email);
			commonSysUser.setPhone(phone);
			commonSysUser.setMemo(memo);
			commonSysUser.setStatus(status);
			
			
			
			int i = commonSysUserService.insertData(commonSysUser,roleIds);
			
			sysUserDetailsService.loadResourceDefine();
			
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "添加成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "添加失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "添加失败!");
			e.printStackTrace();
		}
		
		return messages;
	}

	@RequestMapping("/commonSysUser/update.htm")
	@ResponseBody
	public Object updateCommonSysUser(String roleIds,String userName,String password,String realName,@RequestParam(value ="birthday") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date birthday ,String email,String phone,String memo) {
		Map messages = new HashMap();
		try {
			
			//组装bean实体
			CommonSysUser commonSysUser=new CommonSysUser();
			commonSysUser.setUserName(userName);
			commonSysUser.setPassword(password);
			commonSysUser.setRealName(realName);
			commonSysUser.setBirthday(birthday);
			commonSysUser.setEmail(email);
			commonSysUser.setPhone(phone);
			commonSysUser.setMemo(memo);
			
			int i = commonSysUserService.updateData(commonSysUser,roleIds);
			
			sysUserDetailsService.loadResourceDefine();
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "修改成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "修改失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "修改失败!");
			e.printStackTrace();
		}
		
		return messages;
		
	}
	
	/**
	 * 修改密码
	 * @param password
	 * @param commonSysUser
	 * @return
	 */
	@RequestMapping("/commonSysUser/updatePassword.htm")
	@ResponseBody
	public Object updateCommonSysUserPassword(String password,CommonSysUser commonSysUser) {
		Map messages = new HashMap();
		try {
			
			//组装bean实体
			commonSysUser.setPassword(password);
			
			int i = commonSysUserService.updateData(commonSysUser);
			
			sysUserDetailsService.loadResourceDefine();
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "修改成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "修改失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "修改失败!");
			e.printStackTrace();
		}
		
		return messages;
		
	}

	@RequestMapping("/commonSysUser/delete.htm")
	@ResponseBody
	public Map deleteCommonSysUser(HttpServletRequest request,Integer id) {
		Map messages = new HashMap();
		try {
			
			//组装bean实体
			CommonSysUser commonSysUser=new CommonSysUser();
			commonSysUser.setId(id);
		
			int i =this.commonSysUserService.deleteData(commonSysUser);
			
			sysUserDetailsService.loadResourceDefine();
			
			if (i > 0) {
				messages.put("success", true);
				messages.put("msg", "删除成功!");
			} else {
				messages.put("success", false);
				messages.put("msg", "删除失败!");
			}
		} catch (Exception e) {
			messages.put("success", false);
			messages.put("msg", "删除失败!");
			e.printStackTrace();
		}
		return messages;
	}
	
	@RequestMapping("/commonSysUser/load.htm")
	@ResponseBody
	public Object loadCommonSysUser(Integer id) {
		
		//组装bean实体
		CommonSysUser commonSysUser=new CommonSysUser();
		commonSysUser.setId(id);
		
		return commonSysUserService.getData(commonSysUser);
	}
	
	@RequestMapping("/commonSysUser/getLoginUser.htm")
	@ResponseBody
	public Object getLoginCommonSysUser() {
		
		return this.getSecuritySessionUser();
	}
}
