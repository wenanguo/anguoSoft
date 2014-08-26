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
import com.anguo.web.db.domain.ReportPie;
import com.anguo.web.db.mapper.ReportPieMapper;
import com.anguo.web.service.ReportPieService;

/**
 * 制器类
 * @ClassName: ReportPie
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class ReportPieController extends BaseController {
	
	private final static Logger log = Logger.getLogger(ReportPieController.class);
	@Autowired
	private ReportPieService reportPieService;

	@RequestMapping("/reportPie/list.htm")
	@ResponseBody
	public Object queryReportPieList(ReportPie reportPie) {
		try {
			return reportPieService.getPageData(reportPie);
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/reportPie/listAll.htm")
	@ResponseBody
	public List<ReportPie> queryReportPieAllList(ReportPie reportPie) {
		try {
			return reportPieService.getAllData(reportPie);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/reportPie/create.htm")
	@ResponseBody
	public Object saveReportPie(HttpServletRequest request,
			HttpServletResponse response, ReportPie reportPie) {
		Map messages = new HashMap();
		try {
			int i = reportPieService.insertData(reportPie);
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

	@RequestMapping("/reportPie/update.htm")
	@ResponseBody
	public Object updateReportPie(HttpServletRequest request,
			HttpServletResponse response,ReportPie reportPie) {
		Map messages = new HashMap();
		try {
			int i = reportPieService.updateData(reportPie);
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

	@RequestMapping("/reportPie/delete.htm")
	@ResponseBody
	public Map deleteReportPie(HttpServletRequest request,ReportPie reportPie) {
		Map messages = new HashMap();
		try {
		
			int i =this.reportPieService.deleteData(reportPie);
			
			
			
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
	
	@RequestMapping("/reportPie/load.htm")
	@ResponseBody
	public Object loadReportPie(ReportPie reportPie) {
		
		return reportPieService.getData(reportPie);
	}
}
