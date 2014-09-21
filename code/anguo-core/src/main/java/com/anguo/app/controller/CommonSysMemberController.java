package com.anguo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.domain.ConstantClass;
import com.anguo.app.db.domain.ResultMsg;
import com.anguo.app.service.CommonAppLoggedUserService;
import com.anguo.app.service.CommonSysMemberService;
import com.anguo.exception.AnguoException;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;

/**
 * 制器类
 * @ClassName: CommonSysMember
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysMemberController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysMemberController.class);
	
	@Autowired
	private CommonSysMemberService commonSysMemberService;
	
	@Autowired
	private CommonAppLoggedUserService commonAppLoggedUserService;

	@RequestMapping("/commonSysMember/list.htm")
	@ResponseBody
	public PageResult<CommonSysMember> queryCommonSysMemberList(CommonSysMember commonSysMember) {
		try {
			return commonSysMemberService.getPageData(commonSysMember);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysMember/listAll.htm")
	@ResponseBody
	public List<CommonSysMember> queryCommonSysMemberAllList(CommonSysMember commonSysMember) {
		try {
			return commonSysMemberService.getAllData(commonSysMember);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysMember/create.htm")
	@ResponseBody
	public Map saveCommonSysMember(HttpServletRequest request,
			HttpServletResponse response, CommonSysMember commonSysMember) {
		Map messages = new HashMap();
		try {
			int i = commonSysMemberService.insertData(commonSysMember);
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

	@RequestMapping("/commonSysMember/update.htm")
	@ResponseBody
	public Map updateCommonSysMember(HttpServletRequest request,
			HttpServletResponse response,CommonSysMember commonSysMember) {
		Map messages = new HashMap();
		try {
			int i = commonSysMemberService.updateData(commonSysMember);
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

	@RequestMapping("/commonSysMember/delete.htm")
	@ResponseBody
	public Map deleteCommonSysMember(HttpServletRequest request,CommonSysMember commonSysMember) {
		Map messages = new HashMap();
		try {
		
			
			int i =commonSysMemberService.deleteData(commonSysMember);
			
			
			
			
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
	
	@RequestMapping("/commonSysMember/load.htm")
	@ResponseBody
	public Object loadCommonSysMember(CommonSysMember commonSysMember) {
		
		return commonSysMemberService.getData(commonSysMember);
	}
	
	
	/**
	 * 登录
	 * @param geoMember
	 * @param commonSysMember
	 * @param commonAppLoggedUser
	 * @return
	 */
	public ResultMsg<CommonSysMember> login(CommonSysMember geoMember,CommonSysMember commonSysMember,CommonAppLoggedUser commonAppLoggedUser) {
		
		log.debug("业务参数："+geoMember.toString());
		log.debug("用户参数："+commonSysMember.toString());
		log.debug("系统参数："+commonAppLoggedUser.toString());
		
		ResultMsg<CommonSysMember> messages = new ResultMsg<CommonSysMember>();
		
		CommonSysMember resultGeoMember=null;
		
		try {
				resultGeoMember  = this.commonSysMemberService.login(geoMember);
				
				String uuid=UUID.randomUUID().toString();
				
				resultGeoMember.setUuid(uuid);
				commonAppLoggedUser.setUuid(uuid);
				commonAppLoggedUser.setMemberId(resultGeoMember.getId());
				
				//插入日志记录表
				this.commonAppLoggedUserService.deleteDataByMember(commonAppLoggedUser);
				this.commonAppLoggedUserService.insertData(commonAppLoggedUser);
				
				messages.setObj(resultGeoMember);
			} catch (AnguoException e) {
				messages.setCode(e.getCode());
			}
		
		
		return messages;
	}
	
	
	/**
	 * 注销
	 * @param geoMember
	 * @param commonSysMember
	 * @param commonAppLoggedUser
	 * @return
	 */
	public ResultMsg<CommonSysMember> logout(CommonSysMember geoMember,CommonSysMember commonSysMember,CommonAppLoggedUser commonAppLoggedUser) {
		
		log.debug("业务参数："+geoMember.toString());
		log.debug("用户参数："+commonSysMember.toString());
		log.debug("系统参数："+commonAppLoggedUser.toString());
		
		ResultMsg<CommonSysMember> messages = new ResultMsg<CommonSysMember>();
		
		commonAppLoggedUser.setMemberId(commonSysMember.getId());
				
		//插入日志记录表
	    this.commonAppLoggedUserService.deleteDataByMember(commonAppLoggedUser);
	    messages.setCode(ConstantClass.INTERFACE_SUCCESS);
				
		return messages;
	}
	
	
	/**
	 * 接口新增用户
	 * @param commonSysMember
	 * @return
	 */
	public ResultMsg newAppCommonSysMember(CommonSysMember commonSysMember) {
		ResultMsg messages = new ResultMsg();
		
			int i = commonSysMemberService.insertData(commonSysMember);
			
			if(i<=0)
			{
				messages.setCode(ConstantClass.INTERFACE_SERVICE_ERROR);
			}else
			{
				messages.setCode(ConstantClass.INTERFACE_SUCCESS);
			}
			
		
		return messages;
	}
	
	/**
	 * 接口修改会员
	 * @param commonSysMember
	 * @return
	 */
	public ResultMsg updateAppCommonSysMember(CommonSysMember commonSysMember) {
		ResultMsg messages = new ResultMsg();
		
		int i = commonSysMemberService.updateData(commonSysMember);
		
		if(i<=0)
		{
			messages.setCode(ConstantClass.INTERFACE_SERVICE_ERROR);
		}else
		{
			messages.setCode(ConstantClass.INTERFACE_SUCCESS);
		}
		
	
	    return messages;
		
	}
}
