package com.anguo.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.web.db.domain.WebConfig;
import com.anguo.web.service.WebConfigService;

/**
 * 制器类
 * @ClassName: WebConfig
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class WebConfigController extends BaseController {
	
	private final static Logger log = Logger.getLogger(WebConfigController.class);
	@Autowired
	private WebConfigService webConfigService;

	@RequestMapping("/webConfig/list.htm")
	@ResponseBody
	public Object queryWebConfigList(WebConfig webConfig) {
		try {
			return webConfigService.getPageData(webConfig);
			
		} catch (Exception e) {
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	

	@RequestMapping("/webConfig/create.htm")
	@ResponseBody
	public Map saveWebConfig(HttpServletRequest request,
			HttpServletResponse response, WebConfig webConfig) {
		Map messages = new HashMap();
		try {
			
			webConfig=processVo(webConfig);
			int i = webConfigService.insertData(webConfig);
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
	
	
	/**
	 * 
	 * @param webConfig
	 * @return
	 */
	private WebConfig processVo(WebConfig webConfig)
	{
		String content =webConfig.getContent();
		if(StringUtils.hasLength(content))
		{
			if(content.substring(0, 3).equals("<p>"))content=content.substring(3);
			
			if(content.substring(content.length()-4, content.length()).equals("</p>"))content=content.substring(0,content.length()-4);
		}
		
		webConfig.setContent(content);
		
		return webConfig;
	}

	@RequestMapping("/webConfig/update.htm")
	@ResponseBody
	public Map updateWebConfig(HttpServletRequest request,
			HttpServletResponse response,WebConfig webConfig) {
		Map messages = new HashMap();
		try {
			webConfig=processVo(webConfig);
			int i = webConfigService.updateData(webConfig);
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

	@RequestMapping("/webConfig/delete.htm")
	@ResponseBody
	public Map deleteWebConfig(WebConfig webConfig) {
		Map messages = new HashMap();
		try {
		
			int i =this.webConfigService.deleteData(webConfig);
			
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
	
	@RequestMapping("/webConfig/load.htm")
	@ResponseBody
	public Object loadWebConfig(WebConfig webConfig) {
		
		return webConfigService.getData(webConfig);
	}
}
