package com.anguo.weixin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.weixin.service.WxTokenService;

/**
 * 获取Token
 * @ClassName: WxToken
 * @author Andrew.Wen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class WxTokenController extends BaseController {
	
	private final static Logger log = Logger.getLogger(WxTokenController.class);
	@Autowired
	private WxTokenService wxTokenService;

	
	
	/**
	 * 获取access_token
	 * @param wxToken
	 * @return
	 */
	@RequestMapping("/wxToken/getAccessToken.htm")
	@ResponseBody
	public Object getAccessToken() {
		
		return wxTokenService.getAccessToken();
	}
	
	
	/**
	 * 获取jsapi_token
	 * @param wxToken
	 * @return
	 */
	@RequestMapping("/wxToken/getJsapiToken.htm")
	@ResponseBody
	public Object getJsapiToken() {
		
		return wxTokenService.getJsapiToken();
	}
}
