package com.anguo.oy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.weixin.service.WxTokenService;
import com.anguo.weixin.util.AnguoWxUtil;

/**
 * 潜水控制器
 * @ClassName: OyqyLike
 * @author Andrew.Wen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class OyqydivingController extends BaseController {
	
	private final static Logger log = Logger.getLogger(OyqydivingController.class);
	
	
	//获取token服务类
	@Autowired
	private WxTokenService wxTokenService;
	
	/**
	 * 微信访问初始入口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/oyqydiving/index.htm")
	public void trans(HttpServletRequest request,HttpServletResponse response) {
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqydiving/weixin.htm";
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_SNSAPI_BASE+"?url="+shareURL+"&scope=snsapi_base&response_type=code#wechat_redirect";
		
		
		try {
			response.sendRedirect(linkurl);
		} catch (IOException e) {
 
			e.printStackTrace();
		}
				
	}
	
	
	/**
	 * pc访问
	 * @param request
	 * @return
	 */
	@RequestMapping("/oyqydiving/weixin.htm")
	public ModelAndView weixinSign(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqydiving/weixin.htm";
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_SNSAPI_BASE+"?url="+shareURL+"&scope=snsapi_base&response_type=code#wechat_redirect";
		
		ModelAndView mav=new ModelAndView("diving/index");
		
		
		Map<String, String> share=new HashMap<String, String>();
		share.put("title", "偶遇潜水");
		share.put("desc", "小伙伴一起来玩潜水吧~！");
		share.put("link", linkurl);
		share.put("imgUrl", "http://lb.teamyy.cn/encounterr-web/diving/share.png");
		share.put("domain", AnguoWxUtil.DOMAIN);
		share.put("openid", request.getParameter("openid"));
		
		System.out.println("=============");
		System.out.println(request.getParameter("openid"));
				
		System.out.println("=============");
			
		 String url = "";
		 
		         url = request.getScheme()+"://"+request.getServerName()+request.getContextPath()
		 
		                         + request.getServletPath();
		 
		         if (request.getQueryString() != null){
		 
		             url += "?" + request.getQueryString();
		 
		         }
		 
		          
		 
		         System.out.println("getQueryString:"+url);

		
		
		
		
		
		
        Map<String, String> ret = AnguoWxUtil.sign(getJsapiTicket(), url);
        
      //获取滚动数据
      mav.addObject("map",ret);
      mav.addObject("share", share);    
      return mav;
	}
	
	  /**
			* 获取token
			*/
		public String getJsapiTicket(){
					
			return String.valueOf(wxTokenService.getJsapiToken().get("ticket"));
					
		}
	
	
}
