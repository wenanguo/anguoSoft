package com.anguo.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.web.db.domain.WebNews;
import com.anguo.web.db.domain.WebNewsType;
import com.anguo.web.service.WebConfigService;
import com.anguo.web.service.WebNewsService;
import com.anguo.web.service.WebNewsTypeService;

@ContextConfiguration(locations = { "classpath*:cmcc-platform.xml" , "file:src/main/resources/project-*.xml" })
public class WebNewsServiceTest extends AbstractTestNGSpringContextTests {


	@Autowired
	WebNewsService webNewsService;
	
	@Autowired
	WebNewsTypeService webNewsTypeService;

	@Autowired
	WebConfigService webConfigService;
	
	/**
	 * 插入数据编号
	 */
	private Integer insertDataId = 11;

	
	public void getConfigByCode()
	{
		System.out.println(this.webConfigService.getDataByCode("config.contactUs"));
	}
	
	
	/**
	 * 插入数据
	 */
	
	public void insertData() {
		WebNews webNews = new WebNews();
		
		//********设置插入数据***********
	
	     
		//webNews.setId(1);
						webNews.setMainTitle("");
			     
						webNews.setSubTitle("");
			     
				     
						webNews.setPreviewImg("");
			     
						webNews.setWebNewsTypeId(1);
			     
						webNews.setStatus(1);
			     
						webNews.setOperateUserId(1);
			     
				     
		//*******************************
		
		int result = webNewsService.insertData(webNews);

		assert result == 1 : "WebNews插入数据失败，成功结果为0，但执行结果为：" + result;

		/**
		 * 设置插入数据编号
		 */
		insertDataId = webNews.getId();

	}

//	/**
//	 * 获得单条数据
//	 */
//	@Test(dependsOnMethods = { "insertData" })
//	public void getData() {
//		WebNews webNews = new WebNews();
//		// ********设置获取数据***********
//		//webNews.setId(insertDataId);
//		//*******************************
//		List<WebNews> list = webNewsService.getPageData(webNews);
//
//		for(WebNews wn:list)
//		{
//			System.out.println(wn.getId());
//		}
//		assert list != null : "获得单条数据失败，执行数据为null";
//
//	}
	
	/**
	 * 根据父节点编号数据
	 */
	
	public void getParentData() {
		
		List<WebNewsType> list = new ArrayList<WebNewsType>();
		
		list=webNewsTypeService.getListByParentId(list, 1);

		for(WebNewsType wn:list)
		{
			System.out.println(wn.getId());
		}
		assert list != null : "获得单条数据失败，执行数据为null";

	}

	/**
	 * 获得全部数据
	 */
	
	public void getPageData() {
		
		WebNews page=new  WebNews();
		page.setPage(2);
		
		PageResult<WebNews> page2 = webNewsService.getPageData(page);

		System.out.println(page2);
		
	}

	/**
	 * 修改数据
	 */
	
	public void updateData() {

		WebNews webNews = new WebNews();

		// ********设置修改数据***********
	
	
					webNews.setId(insertDataId);
		
     
					webNews.setMainTitle("");
		
     
					webNews.setSubTitle("");
		
     
		
     
					webNews.setPreviewImg("");
		
     
					webNews.setWebNewsTypeId(insertDataId);
		
     
					webNews.setStatus(insertDataId);
		
     
					webNews.setOperateUserId(insertDataId);
		
     
		
     		// ******************************

		int result = webNewsService.updateData(webNews);

		assert result == 1 : "修改数据失败，执行结果为" + result;
	}

	/**
	 * 删除数据
	 */
	
	public void deleteData() {

		WebNews webNews = new WebNews();

		// ********设置删除数据***********
		webNews.setId(insertDataId);
		// ******************************

		int result = webNewsService.deleteData(webNews);

		assert result == 1 : "删除数据失败，执行结果为" + result;

	}

}
