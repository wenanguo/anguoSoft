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
import com.anguo.oy.db.domain.OyqyHistory;
import com.anguo.oy.db.domain.OyqyHistoryLike;
import com.anguo.oy.db.mapper.OyqyHistoryLikeMapper;
import com.anguo.oy.service.OyqyHistoryLikeService;
import com.anguo.oy.service.OyqyHistoryService;

/**
 * 制器类
 * @ClassName: OyqyHistoryLike
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class OyqyHistoryLikeController extends BaseController {
	
	private final static Logger log = Logger.getLogger(OyqyHistoryLikeController.class);
	@Autowired
	private OyqyHistoryLikeService oyqyHistoryLikeService;
	
	@Autowired
	private OyqyHistoryService oyqyHistoryService;
	

	@RequestMapping("/oyqyHistoryLike/list.htm")
	@ResponseBody
	public PageResult<List<OyqyHistoryLike>> queryOyqyHistoryLikeList(OyqyHistoryLike oyqyHistoryLike) {
	
		PageResult<List<OyqyHistoryLike>> result=new PageResult<List<OyqyHistoryLike>>();
		
		try {
			result= oyqyHistoryLikeService.getPageData(oyqyHistoryLike);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/oyqyHistoryLike/listAll.htm")
	@ResponseBody
	public List<OyqyHistoryLike> queryOyqyHistoryLikeAllList(OyqyHistoryLike oyqyHistoryLike) {
		try {
			return oyqyHistoryLikeService.getAllData(oyqyHistoryLike);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/oyqyHistoryLike/create.htm")
	@ResponseBody
	public PageResult saveOyqyHistoryLike(HttpServletRequest request,HttpServletResponse response, OyqyHistoryLike oyqyHistoryLike) {
		
		PageResult resutl=new PageResult();
		oyqyHistoryLike.setOperateDate(new Date());
		oyqyHistoryLike.setStatus(AnguoStatusUtil.BASE_NORMAL);
		
		if(oyqyHistoryLikeService.getData(oyqyHistoryLike)==null){
			
			try {
				
				
				int i = oyqyHistoryLikeService.insertData(oyqyHistoryLike);
				
				
				
	
				if (i > 0) {
					
					OyqyHistory oyqyHistory=new OyqyHistory();
					oyqyHistory.setId(oyqyHistoryLike.getTravelId());
					oyqyHistory.setToopenid(oyqyHistoryLike.getOpenid());
					
					resutl.setRows(oyqyHistoryService.getData(oyqyHistory));
					
					resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
				} else {
					resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
				}
			} catch (Exception e) {
				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
				e.printStackTrace();
			}
		
		}else{
			resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
		}
		
		return resutl;
	}

	@RequestMapping("/oyqyHistoryLike/update.htm")
	@ResponseBody
	public PageResult updateOyqyHistoryLike(HttpServletRequest request,HttpServletResponse response,OyqyHistoryLike oyqyHistoryLike) {
		
		PageResult resutl=new PageResult();
		try {
			int i = oyqyHistoryLikeService.updateData(oyqyHistoryLike);
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

	@RequestMapping("/oyqyHistoryLike/delete.htm")
	@ResponseBody
	public PageResult deleteOyqyHistoryLike(HttpServletRequest request,OyqyHistoryLike oyqyHistoryLike) {
		PageResult resutl=new PageResult();
		try {
			
			int i =oyqyHistoryLikeService.deleteData(oyqyHistoryLike);
			
			
			if (i > 0) {
				
				OyqyHistory oyqyHistory=new OyqyHistory();
				oyqyHistory.setId(oyqyHistoryLike.getTravelId());
				oyqyHistory.setToopenid(oyqyHistoryLike.getOpenid());
				
				resutl.setRows(oyqyHistoryService.getData(oyqyHistory));
				
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
	
	@RequestMapping("/oyqyHistoryLike/load.htm")
	@ResponseBody
	public Object loadOyqyHistoryLike(OyqyHistoryLike oyqyHistoryLike) {
		
		return oyqyHistoryLikeService.getData(oyqyHistoryLike);
	}
}
