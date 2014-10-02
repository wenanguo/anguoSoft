package com.anguo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.service.CommonAppSiDefineService;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;

/**
 * 制器类
 * @ClassName: CommonAppSiDefine
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonAppSiDefineController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonAppSiDefineController.class);
	@Autowired
	private CommonAppSiDefineService commonAppSiDefineService;

	@RequestMapping("/commonAppSiDefine/list.htm")
	@ResponseBody
	public PageResult<List<CommonAppSiDefine>> queryCommonAppSiDefineList(CommonAppSiDefine commonAppSiDefine) {
		try {
			return commonAppSiDefineService.getPageData(commonAppSiDefine);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonAppSiDefine/listAll.htm")
	@ResponseBody
	public List<CommonAppSiDefine> queryCommonAppSiDefineAllList(CommonAppSiDefine commonAppSiDefine) {
		try {
			return commonAppSiDefineService.getAllData(commonAppSiDefine);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonAppSiDefine/create.htm")
	@ResponseBody
	public Map saveCommonAppSiDefine(HttpServletRequest request,
			HttpServletResponse response, CommonAppSiDefine commonAppSiDefine) {
		Map messages = new HashMap();
		try {
			int i = commonAppSiDefineService.insertData(commonAppSiDefine);
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

	@RequestMapping("/commonAppSiDefine/update.htm")
	@ResponseBody
	public Map updateCommonAppSiDefine(HttpServletRequest request,
			HttpServletResponse response,CommonAppSiDefine commonAppSiDefine) {
		Map messages = new HashMap();
		try {
			int i = commonAppSiDefineService.updateData(commonAppSiDefine);
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

	@RequestMapping("/commonAppSiDefine/delete.htm")
	@ResponseBody
	public Map deleteCommonAppSiDefine(HttpServletRequest request,CommonAppSiDefine commonAppSiDefine) {
		Map messages = new HashMap();
		try {
		
			int i =this.commonAppSiDefineService.deleteData(commonAppSiDefine);
			
			
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
	
	@RequestMapping("/commonAppSiDefine/load.htm")
	@ResponseBody
	public Object loadCommonAppSiDefine(CommonAppSiDefine commonAppSiDefine) {
		
		return commonAppSiDefineService.getData(commonAppSiDefine);
	}
}
