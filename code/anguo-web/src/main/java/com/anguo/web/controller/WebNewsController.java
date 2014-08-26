package com.anguo.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.CodeComments;
import com.anguo.web.db.domain.WebNews;
import com.anguo.web.service.WebNewsService;

/**
 * 制器类
 * @ClassName: WebNews
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@CodeComments("网站新闻管理")
public class WebNewsController extends BaseController implements ApplicationContextAware {
	
	private final static Logger log = Logger.getLogger(WebNewsController.class);
	
	@Autowired
	private WebNewsService webNewsService;
	
	private ApplicationContext act;

	@RequestMapping("/webNews/list.htm")
	@ResponseBody
	@CodeComments("查询新闻内容")
	public Object queryWebNewsList(WebNews webNews) {
		try {
			
			
			log.info("查询新闻内容："+webNews);
			System.out.println("============controller mvc 容器"+this.act.getDisplayName()+"=========");
			for(String beanName:this.act.getBeanDefinitionNames()){
				System.out.println(beanName);
			}
			System.out.println("======================================");
			
			webNewsService.test();
			
			return webNewsService.getPageData(webNews);
		} catch (Exception e) {
			
			log.error("发生错误，因为：" + e.getMessage());
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/webNews/create.htm")
	@ResponseBody
	@CodeComments("创建新闻内容")
	public Map saveWebNews(HttpServletRequest request,
			HttpServletResponse response, WebNews webNews) {
		Map messages = new HashMap();
		try {
			
			prcessVo(webNews);
			
			int i = webNewsService.insertData(webNews);
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
	
	//对象入库前处理方法
	private WebNews prcessVo(WebNews webNews)
	{
		if(webNews.getIsDisplayPreviewImg().equals(4))
		{
			webNews.setPreviewImg("");
		}
		
		webNews.setOperateDate(new Date());
		
		return webNews;
	}

	@RequestMapping("/webNews/update.htm")
	@ResponseBody
	@CodeComments("修改新闻内容")
	public Map updateWebNews(HttpServletRequest request,
			HttpServletResponse response,WebNews webNews) {
		Map messages = new HashMap();
		try {
			
			//
			prcessVo(webNews);
			
			int i = webNewsService.updateData(webNews);
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

	@RequestMapping("/webNews/delete.htm")
	@ResponseBody
	@CodeComments("删除新闻内容")
	public Map deleteWebNews(HttpServletRequest request,WebNews webNews) {
		Map messages = new HashMap();
		try {
		
			String ids=request.getParameter("ids");
			int i =0;
			for(String id : ids.split(",")){
				
				WebNews temp=new WebNews();
				temp.setId(Integer.parseInt(id));
																																																																																																																				 i =i+ webNewsService.deleteData(temp);
			}
			
			
			
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
	
	@RequestMapping("/webNews/load.htm")
	@ResponseBody
	public Object loadWebNews(WebNews webNews) {
		
		return webNewsService.getData(webNews);
	}


	@Override
	public void setApplicationContext(ApplicationContext act)
			throws BeansException {

		this.act=act;
	}

	
}
