package com.anguo.oy.controller;

import java.util.Date;
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
import com.anguo.util.AnguoStatusUtil;
import com.anguo.oy.db.domain.XyCampaignAction;
import com.anguo.oy.db.mapper.XyCampaignActionMapper;
import com.anguo.oy.service.XyCampaignActionService;

/**
 * 制器类
 * @ClassName: XyCampaignAction
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class XyCampaignActionController extends BaseController {
	
	private final static Logger log = Logger.getLogger(XyCampaignActionController.class);
	@Autowired
	private XyCampaignActionService xyCampaignActionService;

	@RequestMapping("/xyCampaignAction/list.htm")
	@ResponseBody
	public PageResult<List<XyCampaignAction>> queryXyCampaignActionList(XyCampaignAction xyCampaignAction) {
	
		PageResult<List<XyCampaignAction>> result=new PageResult<List<XyCampaignAction>>();
		
		try {
			result= xyCampaignActionService.getPageData(xyCampaignAction);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/xyCampaignAction/listAll.htm")
	@ResponseBody
	public List<XyCampaignAction> queryXyCampaignActionAllList(XyCampaignAction xyCampaignAction) {
		try {
			return xyCampaignActionService.getAllData(xyCampaignAction);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/xyCampaignAction/create.htm")
	@ResponseBody
	public PageResult saveXyCampaignAction(HttpServletRequest request,HttpServletResponse response, XyCampaignAction xyCampaignAction) {
		
		PageResult resutl=new PageResult();
		xyCampaignAction.setOperateDate(new Date());
		
		
		try {
			int i = xyCampaignActionService.insertData(xyCampaignAction);
			if (i > 0) {
				resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
			} else {
				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
			}
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
			e.printStackTrace();
		}
		
		return resutl;
	}

	@RequestMapping("/xyCampaignAction/update.htm")
	@ResponseBody
	public PageResult updateXyCampaignAction(HttpServletRequest request,HttpServletResponse response,XyCampaignAction xyCampaignAction) {
		
		PageResult resutl=new PageResult();
		try {
			int i = xyCampaignActionService.updateData(xyCampaignAction);
			if (i > 0) {
				resutl.setCode(AnguoStatusUtil.OPT_UPDATE_SUCCESS);
			} else {
				resutl.setCode(AnguoStatusUtil.OPT_UPDATE_ERROR);
			}
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_UPDATE_ERROR);
			e.printStackTrace();
		}
		return resutl;
		
	}

	@RequestMapping("/xyCampaignAction/delete.htm")
	@ResponseBody
	public PageResult deleteXyCampaignAction(HttpServletRequest request,XyCampaignAction xyCampaignAction) {
		PageResult resutl=new PageResult();
		try {
			
			int i =xyCampaignActionService.deleteData(xyCampaignAction);
			
			
			if (i > 0) {
				resutl.setCode(AnguoStatusUtil.OPT_DELETE_SUCCESS);
			} else {
				resutl.setCode(AnguoStatusUtil.OPT_DELETE_ERROR);
			}
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_DELETE_ERROR);
			e.printStackTrace();
		}
		return resutl;
	}
	
	@RequestMapping("/xyCampaignAction/load.htm")
	@ResponseBody
	public Object loadXyCampaignAction(XyCampaignAction xyCampaignAction) {
		
		return xyCampaignActionService.getData(xyCampaignAction);
	}
}
