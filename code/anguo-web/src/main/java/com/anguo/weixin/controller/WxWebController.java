package com.anguo.weixin.controller;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.util.AnguoJsonUtil;
import com.anguo.weixin.util.AnguoHttpUtil;
import com.anguo.weixin.util.AnguoWxUtil;

/**
 * 微信类--网页服务
 * @author Andrew.Wen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class WxWebController extends BaseController {
	
	private final static Logger log = Logger.getLogger(WxWebController.class);
	
	
	/**
	 * 网页授权获取用户基本信息snsapi_base方式
	 * @param code
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/weixin/authorize_snsapi_base.htm",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView authorizeSnsapiBase(String code,String state,String url) {
	
		/*
		 * 页面请求地址
		 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx620486606c2af0f2&redirect_uri=http://anguo.ngrok.gzjyhny.com/whisper/weixin/authorize_snsapi_base.htm?url=http://anguo.ngrok.gzjyhny.com/whisper/weixin/index.jsp&scope=snsapi_base&response_type=code#wechat_redirect
		 */
		String[] urlArr=url.split("[?]");
		ModelAndView mav=new ModelAndView("redirect:"+urlArr[0]);
		
		

		
		
		
		log.info("==================oauth2Authorize:====================");
		log.info("code:"+code);
		log.info("state:"+state);
		log.info("url:"+url);
		log.info("==================oauth2Authorize:====================");
		
		//请求获取token
		String GET_ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AnguoWxUtil.APPID+"&secret="+AnguoWxUtil.APPSECRET+"&code="+code+"&grant_type=authorization_code"; 
		
		String retStr=AnguoHttpUtil.getMethod(GET_ACCESS_TOKEN_URL);
		
		Map map=AnguoJsonUtil.fromJson(retStr, HashMap.class);
		
		
		//加入参数
		mav.addObject("access_token", map.get("access_token"));
		mav.addObject("expires_in", map.get("expires_in"));
		mav.addObject("refresh_token", map.get("refresh_token"));
		mav.addObject("openid", map.get("openid"));
		mav.addObject("scope", map.get("scope"));
		
		
		for(int i=1;i<urlArr.length;i++){
			mav.addObject(urlArr[i].split("[=]")[0], urlArr[i].split("[=]")[1]);
		}
		
		
		return mav;
	}
	
	
	
	/**
	 * 网页授权获取用户基本信息snsapi_userinfo方式
	 * @param code
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/weixin/authorize_snsapi_userinfo.htm",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView authorize_snsapi_userinfo(String code,String state,String url) {
	
		/*
		 * 页面请求地址
		 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx620486606c2af0f2&redirect_uri=http://anguo.ngrok.gzjyhny.com/whisper/weixin/authorize_snsapi_userinfo.htm?url=http://anguo.ngrok.gzjyhny.com/whisper/weixin/userinfo.jsp&scope=snsapi_base&response_type=code#wechat_redirect
		 */
		
		log.info("==================oauth2Authorize:====================");
		log.info("code:"+code);
		log.info("state:"+state);
		log.info("url:"+url);
		log.info("==================oauth2Authorize:====================");
		
		
		String[] urlArr=url.split("[?]");
		ModelAndView mav=new ModelAndView("redirect:"+urlArr[0]);
		
	
		
		//请求获取token
		String GET_ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AnguoWxUtil.APPID+"&secret="+AnguoWxUtil.APPSECRET+"&code="+code+"&grant_type=authorization_code"; 
		
		String retStr=AnguoHttpUtil.getMethod(GET_ACCESS_TOKEN_URL);
		
		Map map_access=AnguoJsonUtil.fromJson(retStr, HashMap.class);
		
		
		String GET_USERINFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token="+map_access.get("access_token")+"&openid="+map_access.get("openid")+"&lang=zh_CN";
		
		String retStrUser=AnguoHttpUtil.getMethod(GET_USERINFO_URL);
		
		Map map_user=AnguoJsonUtil.fromJson(retStrUser, HashMap.class);
		
		
		log.debug(map_user);
		//加入参数
		mav.addObject("openid", map_user.get("openid"));
		mav.addObject("nickname", map_user.get("nickname"));
		mav.addObject("sex", map_user.get("sex"));
		mav.addObject("province", map_user.get("province"));
		mav.addObject("city", map_user.get("city"));
		mav.addObject("country", map_user.get("country"));
		mav.addObject("headimgurl", map_user.get("headimgurl"));
		mav.addObject("privilege", map_user.get("privilege"));
		if(map_user.get("unionid")!=null)mav.addObject("unionid", map_user.get("unionid"));
		
		

		for(int i=1;i<urlArr.length;i++){
			mav.addObject(urlArr[i].split("[=]")[0], urlArr[i].split("[=]")[1]);
		}
		
		return mav;
	}
	
	
	
	
}
