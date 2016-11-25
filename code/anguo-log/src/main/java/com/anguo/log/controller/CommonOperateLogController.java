package com.anguo.log.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anguo.log.db.domain.CommonOperateLog;
import com.anguo.log.service.CommonOperateLogService;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;


/**
 * 制器类
 * @ClassName: CommonOperateLog
 * @author Andrew.Wen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class CommonOperateLogController extends BaseController {
	
	private final static Logger log = Logger.getLogger(CommonOperateLogController.class);
	@Autowired
	private CommonOperateLogService commonOperateLogService;

//	@RequestMapping("/commonOperateLog/list.json")
//	@ResponseBody
//	public PageResult<CommonOperateLog> queryCommonOperateLogList(CommonOperateLog commonOperateLog) {
//		try {
//
//			return commonOperateLogService.getPageData(commonOperateLog);
//
//		} catch (Exception e) {
//			log.error("发生错误，因为：" + e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}

	@RequestMapping("/commonOperateLog/listAll.json")
	@ResponseBody
	public List<CommonOperateLog> queryCommonOperateLogAllList(CommonOperateLog commonOperateLog) {
		try {
			return commonOperateLogService.getAllData(commonOperateLog);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

//	@RequestMapping("/commonOperateLog/create.json")
//	public void saveCommonOperateLog(HttpServletRequest request,
//			HttpServletResponse response, CommonOperateLog commonOperateLog) {
//		Map messages = new HashMap();
//		try {
//			int i = commonOperateLogService.insertData(commonOperateLog);
//			if (i > 0) {
//				messages.put("success", true);
//				messages.put("msg", "添加成功!");
//			} else {
//				messages.put("success", false);
//				messages.put("msg", "添加失败!");
//			}
//		} catch (Exception e) {
//			messages.put("success", false);
//			messages.put("msg", "添加失败!");
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//	@RequestMapping("/commonOperateLog/update.json")
//	public void updateCommonOperateLog(HttpServletRequest request,
//			HttpServletResponse response,CommonOperateLog commonOperateLog) {
//		Map messages = new HashMap();
//		try {
//			int i = commonOperateLogService.updateData(commonOperateLog);
//			if (i > 0) {
//				messages.put("success", true);
//				messages.put("msg", "修改成功!");
//			} else {
//				messages.put("success", false);
//				messages.put("msg", "修改失败!");
//			}
//		} catch (Exception e) {
//			messages.put("success", false);
//			messages.put("msg", "修改失败!");
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//	@RequestMapping("/commonOperateLog/delete.json")
//	@ResponseBody
//	public Map deleteCommonOperateLog(HttpServletRequest request,CommonOperateLog commonOperateLog) {
//		Map messages = new HashMap();
//		try {
//		
//			String ids=request.getParameter("ids");
//			int i =0;
//			for(String id : ids.split(",")){
//				
//				CommonOperateLog temp=new CommonOperateLog();
//												temp.setId(Integer.parseInt(id));
//																																																																				 i =i+ commonOperateLogService.deleteData(temp);
//			}
//			
//			
//			
//			if (i > 0) {
//				messages.put("success", true);
//				messages.put("msg", "删除成功!");
//			} else {
//				messages.put("success", false);
//				messages.put("msg", "删除失败!");
//			}
//		} catch (Exception e) {
//			messages.put("success", false);
//			messages.put("msg", "删除失败!");
//			e.printStackTrace();
//		}
//		return messages;
//	}
//	
//	@RequestMapping("/commonOperateLog/load.json")
//	@ResponseBody
//	public Object loadCommonOperateLog(CommonOperateLog commonOperateLog) {
//		
//		return commonOperateLogService.getData(commonOperateLog);
//	}
}
