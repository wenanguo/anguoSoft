package com.anguo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoFileUtils;
import com.anguo.web.db.domain.WebNews;
import com.anguo.web.db.domain.WebNewsType;
import com.anguo.web.service.WebConfigService;
import com.anguo.web.service.WebNewsService;
import com.anguo.web.service.WebNewsTypeService;


@Controller
public class WebController extends BaseController {
	
	/**
	 * 新闻获取业务操作
	 */
	@Autowired
	WebNewsService webNewsService;
	
	/**
	 * 新闻类型获取业务操作
	 */
	@Autowired
	WebNewsTypeService webNewsTypeService;
	
	
	/**
	 * 网站配置获取业务操作
	 */
	@Autowired
	WebConfigService webConfigService;
	
	
	
	@RequestMapping("/web/index.htm")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView("index");
		
		//增加网站配置
		mav.addObject("webConfigList",this.webConfigService.getAllData(null));
		
		//获得导航栏
		mav.addObject("indexMenu", this.webNewsTypeService.getIndexMenu());
		
		//获得导航栏
		mav.addObject("indexImgList", this.webNewsService.getIndexImgList());
		
		
		//获得导航栏
		mav.addObject("orderNoticeList", this.webNewsService.getOrderNoticeList());
		
		WebNews companyProfile=this.webNewsService.getData(new WebNews(38));
		companyProfile.setContent(AnguoFileUtils.getText(companyProfile.getContent()));
		//获得公司简介
		mav.addObject("companyProfile", companyProfile);
		
		
		//获取滚动数据
		mav.addObject("rollNewsList",this.webNewsService.getNewsListByParentId(4));
		
		return mav;
	}
	
	
	
	/**
	 * 获得新闻列表
	 * @return
	 */
	@RequestMapping("/web/newslist.htm")
	public ModelAndView newsList(HttpServletRequest request,WebNews webNews) {
		
		ModelAndView mav=new ModelAndView("newslist");
		
		
		
		//增加网站配置
		mav.addObject("webConfigList",this.webConfigService.getAllData(null));
				
		
		PageResult<WebNews> newsList=this.webNewsService.getPageData(webNews);
		//获得新闻
		//List<WebNews> newsList=;
		mav.addObject("newsList", newsList);
		
		//获得导航栏
		mav.addObject("indexMenu", this.webNewsTypeService.getIndexMenu());
				
		//获得导航栏
		mav.addObject("indexImgList", this.webNewsService.getIndexImgList());
		
		//获得侧边菜单栏
		List<WebNewsType> webNewsTypeList = new ArrayList<WebNewsType>();
		webNewsTypeList =this.webNewsTypeService.getListByParentId(webNewsTypeList,webNews.getWebNewsTypeId());
		mav.addObject("webNewsTypeList", webNewsTypeList);
		
		
		//获得当前页面信息
		WebNewsType webNewsType=new WebNewsType();
		webNewsType.setId(webNews.getWebNewsTypeId());
		WebNewsType currWebNewsType=this.webNewsTypeService.getData(webNewsType);
		mav.addObject("currWebNewsType", currWebNewsType);
		
		
		//获得分页URL
		String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI();
		mav.addObject("url", url);
		
		return mav;
	}
	
	@RequestMapping("/web/newsdetail.htm")
	public ModelAndView newsListDetail(WebNews webNews) {
		ModelAndView mav=new ModelAndView("newsdetail");
		
		//增加网站配置
		mav.addObject("webConfigList",this.webConfigService.getAllData(null));
				
		
		//获得导航栏
		mav.addObject("indexImgList", this.webNewsService.getIndexImgList());
		
		//获得当前新闻
		WebNews currWebNews=this.webNewsService.getData(webNews);
		
		mav.addObject("currWebNews", currWebNews);
		
		currWebNews.hitNews();
		this.webNewsService.updateData(currWebNews);
		
		//获得导航栏
		mav.addObject("indexMenu", this.webNewsTypeService.getIndexMenu());
		
		//获得侧边菜单栏
		List<WebNewsType> webNewsTypeList = new ArrayList<WebNewsType>();
		webNewsTypeList =this.webNewsTypeService.getListByParentId(webNewsTypeList,currWebNews.getWebNewsTypeId());
		mav.addObject("webNewsTypeList", webNewsTypeList);
		
		
		return mav;
	}
	
//	@RequestMapping("/web/productlist.htm")
//	public ModelAndView productlist(WebNews webNews) {
//		
//		ModelAndView mav=new ModelAndView("productlist");
//		
//		List<WebNews> newsList=this.webNewsService.getAllData(webNews);
//		mav.addObject("newsList", newsList);
//		
//		//获得导航栏
//		mav.addObject("indexImgList", this.webNewsService.getIndexImgList());
//		
//		//获得导航栏
//		mav.addObject("indexMenu", this.webNewsTypeService.getIndexMenu());
//				
//		//获得侧边菜单栏
//		List<WebNewsType> webNewsTypeList = new ArrayList<WebNewsType>();
//		webNewsTypeList =this.webNewsTypeService.getListByParentId(webNewsTypeList,webNews.getWebNewsTypeId());
//		mav.addObject("webNewsTypeList", webNewsTypeList);
//		
//		
//		
//		return mav;
//	}
//	
//	@RequestMapping("/web/productdetail.htm")
//	public String productdetail() {
//		
//		return "productdetail";
//	}
	

}
