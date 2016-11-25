package com.anguo.weixin.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.weixin.util.AnguoWxUtil;

/**
 * 微信类
 * @author Andrew.Wen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class WxController extends BaseController {
	
	private final static Logger log = Logger.getLogger(WxController.class);
	
	
	/**
	 * 微信加密签名
	 */
	private String signature;
	/**
	 * 时间戳
	 */
	private String timestamp;
	/**
	 * 随机数
	 */
	private String nonce;
	/**
	 * 随机字符串
	 */
	private String echostr;
	

	
	

	/**
	 * 微信验证请求
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@RequestMapping(value = "/weixin/checkSignature.htm",method = RequestMethod.GET)
	@ResponseBody
	public String checkSignature(String signature,String timestamp,String nonce,String echostr) {
	
		log.info("==================checkSignature:====================");
		log.info("signature:"+signature);
		log.info("timestamp:"+timestamp);
		log.info("nonce:"+nonce);
		log.info("echostr:"+echostr);
		log.info("==================checkSignature:====================");
		
		
		String temp =AnguoWxUtil.checkSign(timestamp, nonce);
		if(temp.equals(signature))
		{
			
			return echostr;
		}else{
			return "";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getNonce() {
		return nonce;
	}


	public void setNonce(String nonce) {
		this.nonce = nonce;
	}


	public String getEchostr() {
		return echostr;
	}


	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
}
