package com.anguo.oy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.oy.db.domain.OyqyLike;
import com.anguo.oy.service.OyqyLikeService;
import com.anguo.util.AnguoStatusUtil;

/**
 * 点赞控制器
 * @ClassName: OyqyLike
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class OyqyLikeController extends BaseController {
	
	private final static Logger log = Logger.getLogger(OyqyLikeController.class);
	@Autowired
	private OyqyLikeService oyqyLikeService;

	@RequestMapping("/oyqyLike/list.htm")
	@ResponseBody
	public PageResult<List<OyqyLike>> queryOyqyLikeList(OyqyLike oyqyLike) {
	
		PageResult<List<OyqyLike>> result=new PageResult<List<OyqyLike>>();
		
		try {
			result= oyqyLikeService.getPageData(oyqyLike);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/oyqyLike/listAll.htm")
	@ResponseBody
	public List<OyqyLike> queryOyqyLikeAllList(OyqyLike oyqyLike) {
		try {
			return oyqyLikeService.getAllData(oyqyLike);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/oyqyLike/create.htm")
	@ResponseBody
	public PageResult saveOyqyLike(HttpServletRequest request,HttpServletResponse response, OyqyLike oyqyLike) {
		
		PageResult resutl=new PageResult();
		oyqyLike.setOperateDate(new Date());
		oyqyLike.setStatus(AnguoStatusUtil.BASE_NORMAL);
		
		
		
		if(oyqyLikeService.getData(oyqyLike)==null){
			
			try {
				
				
				int i = oyqyLikeService.insertData(oyqyLike);
				
				
				
	
				if (i > 0) {
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

	@RequestMapping("/oyqyLike/update.htm")
	@ResponseBody
	public PageResult updateOyqyLike(HttpServletRequest request,HttpServletResponse response,OyqyLike oyqyLike) {
		
		PageResult resutl=new PageResult();
		try {
			int i = oyqyLikeService.updateData(oyqyLike);
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

	@RequestMapping("/oyqyLike/delete.htm")
	@ResponseBody
	public PageResult deleteOyqyLike(HttpServletRequest request,OyqyLike oyqyLike) {
		PageResult resutl=new PageResult();
		try {
			
			int i =oyqyLikeService.deleteData(oyqyLike);
			
			
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
	
	@RequestMapping("/oyqyLike/load.htm")
	@ResponseBody
	public Object loadOyqyLike(OyqyLike oyqyLike) {
		
		return oyqyLikeService.getData(oyqyLike);
	}
}
