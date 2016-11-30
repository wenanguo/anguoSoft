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
import com.anguo.web.db.domain.CommonSysParam;
import com.anguo.web.db.mapper.CommonSysParamMapper;
import com.anguo.web.service.CommonSysParamService;

/**
 * 制器类
 * @ClassName: CommonSysParam
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonSysParamController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonSysParamController.class);
	@Autowired
	private CommonSysParamService commonSysParamService;

	@RequestMapping("/commonSysParam/list.htm")
	@ResponseBody
	public PageResult<List<CommonSysParam>> queryCommonSysParamList(CommonSysParam commonSysParam) {
	
		PageResult<List<CommonSysParam>> result=new PageResult<List<CommonSysParam>>();
		
		try {
			result= commonSysParamService.getPageData(commonSysParam);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/commonSysParam/listAll.htm")
	@ResponseBody
	public List<CommonSysParam> queryCommonSysParamAllList(CommonSysParam commonSysParam) {
		try {
			return commonSysParamService.getAllData(commonSysParam);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/commonSysParam/create.htm")
	@ResponseBody
	public PageResult saveCommonSysParam(HttpServletRequest request,HttpServletResponse response, CommonSysParam commonSysParam) {
		
		PageResult resutl=new PageResult();
		
		try {
			int i = commonSysParamService.insertData(commonSysParam);
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

	@RequestMapping("/commonSysParam/update.htm")
	@ResponseBody
	public PageResult updateCommonSysParam(HttpServletRequest request,HttpServletResponse response,CommonSysParam commonSysParam) {
		
		PageResult resutl=new PageResult();
		try {
			int i = commonSysParamService.updateData(commonSysParam);
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

	@RequestMapping("/commonSysParam/delete.htm")
	@ResponseBody
	public PageResult deleteCommonSysParam(HttpServletRequest request,CommonSysParam commonSysParam) {
		PageResult resutl=new PageResult();
		try {
			
			int i =commonSysParamService.deleteData(commonSysParam);
			
			
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
	
	@RequestMapping("/commonSysParam/load.htm")
	@ResponseBody
	public Object loadCommonSysParam(CommonSysParam commonSysParam) {
		
		return commonSysParamService.getData(commonSysParam);
	}
}
