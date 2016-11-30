package com.anguo.web.controller;

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
import com.anguo.web.db.domain.CommonRoleAuthority;
import com.anguo.web.db.mapper.CommonRoleAuthorityMapper;
import com.anguo.web.service.CommonRoleAuthorityService;

/**
 * 制器类
 * @ClassName: CommonRoleAuthority
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonRoleAuthorityController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonRoleAuthorityController.class);
	@Autowired
	private CommonRoleAuthorityService commonRoleAuthorityService;

	@RequestMapping("/commonRoleAuthority/list.htm")
	@ResponseBody
	public PageResult<List<CommonRoleAuthority>> queryCommonRoleAuthorityList(CommonRoleAuthority commonRoleAuthority) {
	
		PageResult<List<CommonRoleAuthority>> result=new PageResult<List<CommonRoleAuthority>>();
		
		try {
			result= commonRoleAuthorityService.getPageData(commonRoleAuthority);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/commonRoleAuthority/listAll.htm")
	@ResponseBody
	public List<CommonRoleAuthority> queryCommonRoleAuthorityAllList(CommonRoleAuthority commonRoleAuthority) {
		try {
			return commonRoleAuthorityService.getAllData(commonRoleAuthority);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonRoleAuthority/create.htm")
	@ResponseBody
	public PageResult saveCommonRoleAuthority(HttpServletRequest request,HttpServletResponse response, CommonRoleAuthority commonRoleAuthority) {
		
		PageResult resutl=new PageResult();
		
		try {
			int i = commonRoleAuthorityService.insertData(commonRoleAuthority);
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

	@RequestMapping("/commonRoleAuthority/update.htm")
	@ResponseBody
	public PageResult updateCommonRoleAuthority(HttpServletRequest request,HttpServletResponse response,CommonRoleAuthority commonRoleAuthority) {
		
		PageResult resutl=new PageResult();
		try {
			int i = commonRoleAuthorityService.updateData(commonRoleAuthority);
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

	@RequestMapping("/commonRoleAuthority/delete.htm")
	@ResponseBody
	public PageResult deleteCommonRoleAuthority(HttpServletRequest request,CommonRoleAuthority commonRoleAuthority) {
		PageResult resutl=new PageResult();
		try {
			
			int i =commonRoleAuthorityService.deleteData(commonRoleAuthority);
			
			
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
	
	@RequestMapping("/commonRoleAuthority/load.htm")
	@ResponseBody
	public Object loadCommonRoleAuthority(CommonRoleAuthority commonRoleAuthority) {
		
		return commonRoleAuthorityService.getData(commonRoleAuthority);
	}
}
