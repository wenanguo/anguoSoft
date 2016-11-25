package com.anguo.oy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.oy.db.domain.OyqyTravel;
import com.anguo.oy.service.OyqyTravelService;
import com.anguo.util.AnguoStatusUtil;
import com.anguo.weixin.service.WxTokenService;
import com.anguo.weixin.util.AnguoEmojiFilterUtils;
import com.anguo.weixin.util.AnguoWxUtil;

/**
 * 制器类
 * @ClassName: OyqyTravel
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class OyqyTravelController extends BaseController {
	
	private final static Logger log = Logger.getLogger(OyqyTravelController.class);
	
	
	@Autowired
	private OyqyTravelService oyqyTravelService;
	
	//获取token服务类
	@Autowired
	private WxTokenService wxTokenService;
	
	

	@RequestMapping("/oyqyTravel/list.htm")
	@ResponseBody
	public PageResult<List<OyqyTravel>> queryOyqyTravelList(OyqyTravel oyqyTravel) {
	
		PageResult<List<OyqyTravel>> result=new PageResult<List<OyqyTravel>>();
		
		try {
			result= oyqyTravelService.getPageData(oyqyTravel);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/oyqyTravel/listAll.htm")
	@ResponseBody
	public List<OyqyTravel> queryOyqyTravelAllList(OyqyTravel oyqyTravel) {
		try {
			return oyqyTravelService.getAllData(oyqyTravel);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/oyqyTravel/create.htm")
	@ResponseBody
	public PageResult saveOyqyTravel(HttpServletRequest request,HttpServletResponse response, OyqyTravel oyqyTravel) {
		
		PageResult resutl=new PageResult();
		oyqyTravel.setOperateDate(new Date());
		oyqyTravel.setStatus(AnguoStatusUtil.BASE_NORMAL);
		
		
		oyqyTravel.setFromnickname(AnguoEmojiFilterUtils.filterEmoji(oyqyTravel.getFromnickname()));
		oyqyTravel.setTonickname(AnguoEmojiFilterUtils.filterEmoji(oyqyTravel.getTonickname()));
		
		
		
		try {
		
			if(StringUtils.isEmpty(oyqyTravel.getCity())||StringUtils.isEmpty(oyqyTravel.getDosamething())){
				
				//用户名或手机号不能为空
				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
				resutl.setMsg("请选择城市去玩吧！");
				
				
			}else if(oyqyTravel.getFromopenid().equalsIgnoreCase("15285027249")){
				
				//已经答题的情况
				 resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
				resutl.setMsg("文先生，感谢您的测试，返回成功状态！");
				
			}
			else if(oyqyTravelService.getDataByToOpenid(oyqyTravel)!=null){
				//已经答题的情况
				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
				resutl.setMsg("对不起你已经参与过该活动！");
				
			}else{
				
				
				
				//插入数据
				
				int i=oyqyTravelService.insertData(oyqyTravel);
				
				
				if (i > 0) {
					
					resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
					
				} else {
					resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
				}
				
				
			}
			
			
			
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
			e.printStackTrace();
		}
		
		return resutl;
		
		
	}

	
	/**
	 * 微信访问初始入口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/oyqy/index.htm")
	public void trans(HttpServletRequest request,HttpServletResponse response) {
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqy/weixin.htm?fromnickname=Jay?fromopenid=initopenid?fromsex=1?fromheadimgurl=http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqy/images/share.jpg?v=1";
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_USERINFO+"?url="+shareURL+"&scope=snsapi_userinfo&response_type=code#wechat_redirect";
		
		
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
	@RequestMapping("/oyqy/weixin.htm")
	public ModelAndView weixinSign(HttpServletRequest request,String fromnickname,String fromopenid,String fromsex,String fromheadimgurl) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		Map frommap=new HashMap();
		frommap.put("fromnickname", fromnickname);
		frommap.put("fromopenid", fromopenid);
		frommap.put("fromsex", fromsex);
		frommap.put("fromheadimgurl", fromheadimgurl);
		
		
		
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqy/weixin.htm?fromnickname="+request.getParameter("nickname")+"?fromopenid="+request.getParameter("openid")+"?fromsex="+request.getParameter("sex")+"?fromheadimgurl="+request.getParameter("headimgurl");
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_USERINFO+"?url="+shareURL+"&scope=snsapi_userinfo&response_type=code#wechat_redirect";
		
		ModelAndView mav=new ModelAndView("oyqy/index");
		
		
		Map<String, String> share=new HashMap<String, String>();
		share.put("title", "我想和"+request.getParameter("nickname")+"去");
		share.put("desc", "我去，竟然有这么多人想和"+request.getParameter("nickname")+"约约约！");
		share.put("link", linkurl);
		share.put("imgUrl", request.getParameter("headimgurl"));
		share.put("domain", AnguoWxUtil.DOMAIN);
		
		
		
		
		 String url = "";
		 
		         url = request.getScheme()+"://"+request.getServerName()+request.getContextPath()
		 
		                         + request.getServletPath();
		 
		         if (request.getQueryString() != null){
		 
		             url += "?" + request.getQueryString();
		 
		         }
		 
		          
		 
		         System.out.println("getQueryString:"+url);

		
		
		
		
		
		
		
		
		
//		
//		
//		
//		 String queryString = "";  
//		 try {
//		
//		Map<String, String[]> params = request.getParameterMap();  
//       
//		log.info(params);
//		
//        for (String key : params.keySet()) {  
//            String[] values = params.get(key);  
//            for (int i = 0; i < values.length; i++) {  
//                String value = values[i];  
//                queryString += key + "=" + URLEncoder.encode(value, "UTF-8") + "&";  
//            }  
//        }  
//        // 去掉最后一个空格  
//        if(queryString.length()>0)
//        	{
//        	
//        	queryString = queryString.substring(0, queryString.length() - 1);
//        	queryString ="?"+queryString;
//        	
//        	}
//		//System.out.println(queryString);
//		
//	    
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		
//		log.info(queryString);
//		 
//		// 注意 URL 一定要动态获取，不能 hardcode
//        String url2 = request.getScheme() + "://"+ request.getServerName() + request.getRequestURI()+queryString;
        
        Map<String, String> ret = AnguoWxUtil.sign(getJsapiTicket(), url);
        
      //获取滚动数据
      mav.addObject("map",ret);
      mav.addObject("share", share);    
      mav.addObject("from",frommap);
      return mav;
	}
	
	
	  /**
		* 获取token
		*/
	public String getJsapiTicket(){
				
		return String.valueOf(wxTokenService.getJsapiToken().get("ticket"));
				
	}
	
}
