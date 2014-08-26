package com.anguo.web.controller;

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

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.web.db.domain.ReportBl;
import com.anguo.web.service.ReportBlService;

/**
 * 制器类
 * @ClassName: ReportBl
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class ReportBlController extends BaseController {
	
	private final static Logger log = Logger.getLogger(ReportBlController.class);
	@Autowired
	private ReportBlService reportBlService;

	@RequestMapping("/reportBl/list.htm")
	@ResponseBody
	public Object queryReportBlList(ReportBl reportBl) {
		try {
			
			PageResult<ReportBl> page=reportBlService.getPageData(reportBl);
			
			for(ReportBl rb:page.getRows())
			{
				Integer[] data=new Integer[12];
				
				data[0]=rb.getM1();
				data[1]=rb.getM2();
				data[2]=rb.getM3();
				data[3]=rb.getM4();
				data[4]=rb.getM5();
				data[5]=rb.getM6();
				data[6]=rb.getM7();
				data[7]=rb.getM8();
				data[8]=rb.getM9();
				data[9]=rb.getM10();
				data[10]=rb.getM11();
				data[11]=rb.getM12();
				
				rb.setData(data);
			}
			
			return page;
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/reportBl/listAll.htm")
	@ResponseBody
	public List<ReportBl> queryReportBlAllList(ReportBl reportBl) {
		try {
			return reportBlService.getAllData(reportBl);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/reportBl/create.htm")
	@ResponseBody
	public Object saveReportBl(HttpServletRequest request,
			HttpServletResponse response, ReportBl reportBl) {
		Map messages = new HashMap();
		try {
			int i = reportBlService.insertData(reportBl);
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

	@RequestMapping("/reportBl/update.htm")
	@ResponseBody
	public Object updateReportBl(HttpServletRequest request,
			HttpServletResponse response,ReportBl reportBl) {
		Map messages = new HashMap();
		try {
			int i = reportBlService.updateData(reportBl);
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

	@RequestMapping("/reportBl/delete.htm")
	@ResponseBody
	public Map deleteReportBl(HttpServletRequest request,ReportBl reportBl) {
		Map messages = new HashMap();
		try {
		
			int i =this.reportBlService.deleteData(reportBl);
			
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
	
	@RequestMapping("/reportBl/load.htm")
	@ResponseBody
	public Object loadReportBl(ReportBl reportBl) {
		
		return reportBlService.getData(reportBl);
	}
}
