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
import com.anguo.oy.db.domain.OyqyInvitationcode;
import com.anguo.oy.db.mapper.OyqyInvitationcodeMapper;
import com.anguo.oy.service.OyqyInvitationcodeService;

/**
 * 制器类
 * @ClassName: OyqyInvitationcode
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class OyqyInvitationcodeController extends BaseController {
	
	private final static Logger log = Logger.getLogger(OyqyInvitationcodeController.class);
	@Autowired
	private OyqyInvitationcodeService oyqyInvitationcodeService;

	@RequestMapping("/oyqyInvitationcode/list.htm")
	@ResponseBody
	public PageResult<List<OyqyInvitationcode>> queryOyqyInvitationcodeList(OyqyInvitationcode oyqyInvitationcode) {
	
		PageResult<List<OyqyInvitationcode>> result=new PageResult<List<OyqyInvitationcode>>();
		
		try {
			result= oyqyInvitationcodeService.getPageData(oyqyInvitationcode);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/oyqyInvitationcode/listAll.htm")
	@ResponseBody
	public List<OyqyInvitationcode> queryOyqyInvitationcodeAllList(OyqyInvitationcode oyqyInvitationcode) {
		try {
			return oyqyInvitationcodeService.getAllData(oyqyInvitationcode);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/oyqyInvitationcode/create.htm")
	@ResponseBody
	public PageResult saveOyqyInvitationcode(HttpServletRequest request,HttpServletResponse response, OyqyInvitationcode oyqyInvitationcode) {
		
		PageResult resutl=new PageResult();
		
		oyqyInvitationcode.setPlaydate(new Date());
		
		try {
			int i = oyqyInvitationcodeService.insertData(oyqyInvitationcode);
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

	@RequestMapping("/oyqyInvitationcode/update.htm")
	@ResponseBody
	public PageResult updateOyqyInvitationcode(HttpServletRequest request,HttpServletResponse response,OyqyInvitationcode oyqyInvitationcode) {
		
		PageResult resutl=new PageResult();
		try {
			int i = oyqyInvitationcodeService.updateData(oyqyInvitationcode);
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

	@RequestMapping("/oyqyInvitationcode/delete.htm")
	@ResponseBody
	public PageResult deleteOyqyInvitationcode(HttpServletRequest request,OyqyInvitationcode oyqyInvitationcode) {
		PageResult resutl=new PageResult();
		try {
			
			int i =oyqyInvitationcodeService.deleteData(oyqyInvitationcode);
			
			
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
	
	@RequestMapping("/oyqyInvitationcode/load.htm")
	@ResponseBody
	public Object loadOyqyInvitationcode(OyqyInvitationcode oyqyInvitationcode) {
		PageResult resutl=new PageResult();
		try {
			
			OyqyInvitationcode obj =oyqyInvitationcodeService.getDatabyOpenid(oyqyInvitationcode);
			
			
			if (obj!=null) {
				resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
				resutl.setMsg(obj.getInvitationcode());
			} else {
				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
			}
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
			e.printStackTrace();
		}
		return resutl;
		
		
		
	}
}
