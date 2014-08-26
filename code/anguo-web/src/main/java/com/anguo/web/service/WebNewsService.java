package com.anguo.web.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.controller.WebNewsController;
import com.anguo.web.db.domain.WebNews;
import com.anguo.web.db.domain.WebNewsType;
import com.anguo.web.db.mapper.WebNewsMapper;

@Service
public class WebNewsService extends BaseService<WebNews> implements ApplicationContextAware {
	
	@Autowired
	private WebNewsMapper mapper;
	
	private ApplicationContext act;
	
	private final static Logger log = Logger.getLogger(WebNewsService.class);

	@Override
	public void setApplicationContext(ApplicationContext act)
			throws BeansException {

		this.act=act;
		
		
		
	}
	
	
	public void test()
	{
		log.info("WebNewsService");
		System.out.println("============WebNewsService 容器"+this.act.getDisplayName()+"=========");
		for(String beanName:this.act.getBeanDefinitionNames()){
			System.out.println(beanName);
		}
		System.out.println("======================================");
	}
	
	@Autowired
	WebNewsTypeService webNewsTypeService;
	
	public WebNewsMapper getMapper() {
		return mapper;
	}
	
	/**
	 * 获得导航栏轮换图片
	 * @return
	 */
	public List<WebNews> getIndexImgList()
	{
		//获得导航栏切换大图
		WebNews indexImg=new WebNews();
		indexImg.setWebNewsTypeId(101);
		List<WebNews> indexImgList=this.getAllData(indexImg);
				
		return indexImgList;
	}

	public Object getOrderNoticeList() {
		//获得在线公告
				WebNews orderNotice=new WebNews();
				orderNotice.setWebNewsTypeId(8);
				List<WebNews> orderNoticeList=this.getAllData(orderNotice);
						
				return orderNoticeList;
	}
	
	
	/**
	 * 根据父节点递归获取当前内容列表，包括孙子节点
	 * @param parentId
	 * @return
	 */
	public List<WebNews> getNewsListByParentId(int parentId) {
		
		//获取所有节点类别
		List<WebNewsType> list=new ArrayList<WebNewsType>();
		this.webNewsTypeService.getListByParentId(list, parentId);
		
		
		List<WebNews> newsList=new ArrayList<WebNews>();
		for(WebNewsType wnt:list)
		{
			WebNews wn=new WebNews();
			wn.setWebNewsTypeId(wnt.getId());
			
			newsList.addAll(this.mapper.getAllData(wn));
		}
		
	
						
		return newsList;
	}
}
