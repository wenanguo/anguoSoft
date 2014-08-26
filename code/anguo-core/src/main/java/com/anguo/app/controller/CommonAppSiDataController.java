package com.anguo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.app.db.domain.CommonAppSiData;
import com.anguo.app.db.mapper.CommonAppSiDataMapper;
import com.anguo.app.service.CommonAppSiDataService;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;

/**
 * 制器类
 * @ClassName: CommonAppSiData
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonAppSiDataController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonAppSiDataController.class);
	@Autowired
	private CommonAppSiDataService commonAppSiDataService;

	@RequestMapping("/commonAppSiData/list.json")
	@ResponseBody
	public PageResult<CommonAppSiData> queryCommonAppSiDataList(CommonAppSiData commonAppSiData) {
		try {
			
			return commonAppSiDataService.getPageData(commonAppSiData);
			
			
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonAppSiData/listAll.json")
	@ResponseBody
	public List<CommonAppSiData> queryCommonAppSiDataAllList(CommonAppSiData commonAppSiData) {
		try {
			return commonAppSiDataService.getAllData(commonAppSiData);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonAppSiData/create.json")
	@ResponseBody
	public Map saveCommonAppSiData(HttpServletRequest request,
			HttpServletResponse response, CommonAppSiData commonAppSiData) {
		Map messages = new HashMap();
		try {
			int i = commonAppSiDataService.insertData(commonAppSiData);
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

	@RequestMapping("/commonAppSiData/update.json")
	@ResponseBody
	public Map updateCommonAppSiData(HttpServletRequest request,
			HttpServletResponse response,CommonAppSiData commonAppSiData) {
		Map messages = new HashMap();
		try {
			int i = commonAppSiDataService.updateData(commonAppSiData);
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

	@RequestMapping("/commonAppSiData/delete.json")
	@ResponseBody
	public Map deleteCommonAppSiData(HttpServletRequest request,CommonAppSiData commonAppSiData) {
		Map messages = new HashMap();
		try {
		
			
			int i=this.commonAppSiDataService.deleteData(commonAppSiData);
			
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
	
	@RequestMapping("/commonAppSiData/load.json")
	@ResponseBody
	public Object loadCommonAppSiData(CommonAppSiData commonAppSiData) {
		
		return commonAppSiDataService.getData(commonAppSiData);
	}
}
