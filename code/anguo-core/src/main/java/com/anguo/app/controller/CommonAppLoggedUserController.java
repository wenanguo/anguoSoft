package com.anguo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.app.db.mapper.CommonAppLoggedUserMapper;
import com.anguo.app.service.CommonAppLoggedUserService;

/**
 * 制器类
 * @ClassName: CommonAppLoggedUser
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonAppLoggedUserController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonAppLoggedUserController.class);
	@Autowired
	private CommonAppLoggedUserService commonAppLoggedUserService;

	@RequestMapping("/commonAppLoggedUser/list.htm")
	@ResponseBody
	public PageResult<CommonAppLoggedUser> queryCommonAppLoggedUserList(CommonAppLoggedUser commonAppLoggedUser) {
		try {
			return commonAppLoggedUserService.getPageData(commonAppLoggedUser);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonAppLoggedUser/listAll.htm")
	@ResponseBody
	public List<CommonAppLoggedUser> queryCommonAppLoggedUserAllList(CommonAppLoggedUser commonAppLoggedUser) {
		try {
			return commonAppLoggedUserService.getAllData(commonAppLoggedUser);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonAppLoggedUser/create.htm")
	@ResponseBody
	public Map saveCommonAppLoggedUser(HttpServletRequest request,
			HttpServletResponse response, CommonAppLoggedUser commonAppLoggedUser) {
		Map messages = new HashMap();
		try {
			int i = commonAppLoggedUserService.insertData(commonAppLoggedUser);
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

	@RequestMapping("/commonAppLoggedUser/update.htm")
	@ResponseBody
	public Map updateCommonAppLoggedUser(HttpServletRequest request,
			HttpServletResponse response,CommonAppLoggedUser commonAppLoggedUser) {
		Map messages = new HashMap();
		try {
			int i = commonAppLoggedUserService.updateData(commonAppLoggedUser);
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

	@RequestMapping("/commonAppLoggedUser/delete.htm")
	@ResponseBody
	public Map deleteCommonAppLoggedUser(HttpServletRequest request,CommonAppLoggedUser commonAppLoggedUser) {
		Map messages = new HashMap();
		try {
		
			
			int i =commonAppLoggedUserService.deleteData(commonAppLoggedUser);
			
			
			
			
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
	
	@RequestMapping("/commonAppLoggedUser/load.htm")
	@ResponseBody
	public Object loadCommonAppLoggedUser(CommonAppLoggedUser commonAppLoggedUser) {
		
		return commonAppLoggedUserService.getData(commonAppLoggedUser);
	}
}
