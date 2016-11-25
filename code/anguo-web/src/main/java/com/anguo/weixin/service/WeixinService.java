package com.anguo.weixin.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.anguo.util.AnguoJsonUtil;
import com.anguo.weixin.util.AnguoHttpUtil;

/**
 * 微信业务逻辑
 * @author Andrew.Wen
 *
 */
@Service
public class WeixinService {

	
	 
    /**微信公共方法**/
	
	
	
	
	
	/**
	 * 获取微信服务器IP地址
	 * @param accessToken
	 * @return
	 */
	public static Map getCallbackip(String accessToken){
		
		String url="https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token="+accessToken;
		String retStr=AnguoHttpUtil.getMethod(url);
		Map map=AnguoJsonUtil.fromJson(retStr, HashMap.class);
		
		return map;
	}
}
