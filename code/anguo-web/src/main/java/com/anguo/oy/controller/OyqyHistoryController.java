package com.anguo.oy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.oy.db.domain.OyqyHistory;
import com.anguo.oy.service.OyqyHistoryService;
import com.anguo.util.AnguoStatusUtil;
import com.anguo.weixin.service.WxTokenService;
import com.anguo.weixin.util.AnguoWxUtil;

/**
 * 黑历史控制器类
 * @ClassName: OyqyHistory
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class OyqyHistoryController extends BaseController {
	
	private final static Logger log = Logger.getLogger(OyqyHistoryController.class);
	@Autowired
	private OyqyHistoryService oyqyHistoryService;
	
	
	//获取token服务类
	@Autowired
	private WxTokenService wxTokenService;
	

	@RequestMapping("/oyqyhistory/list.htm")
	@ResponseBody
	public PageResult<List<OyqyHistory>> queryOyqyHistoryList(OyqyHistory oyqyHistory) {
	
		PageResult<List<OyqyHistory>> result=new PageResult<List<OyqyHistory>>();
		
		try {
			result= oyqyHistoryService.getPageData(oyqyHistory);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/oyqyhistory/listAll.htm")
	@ResponseBody
	public List<OyqyHistory> queryOyqyHistoryAllList(OyqyHistory oyqyHistory) {
		try {
			return oyqyHistoryService.getAllData(oyqyHistory);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/oyqyhistory/create.htm")
	@ResponseBody
	public PageResult saveOyqyHistory(HttpServletRequest request,HttpServletResponse response, OyqyHistory oyqyHistory) {
		
		PageResult resutl=new PageResult();
		oyqyHistory.setOperateDate(new Date());
		oyqyHistory.setStatus(AnguoStatusUtil.BASE_NORMAL);
		
		try {
			int i = oyqyHistoryService.insertData(oyqyHistory);
			
			
			
			if (i > 0) {
				
				
				resutl.setCode(AnguoStatusUtil.OPT_ADD_SUCCESS);
			} else {
				resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
			}
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_ADD_ERROR);
			e.printStackTrace();
		}
		
		return resutl;
	}

	@RequestMapping("/oyqyhistory/update.htm")
	@ResponseBody
	public PageResult updateOyqyHistory(HttpServletRequest request,HttpServletResponse response,OyqyHistory oyqyHistory) {
		
		PageResult resutl=new PageResult();
		try {
			int i = oyqyHistoryService.updateData(oyqyHistory);
			if (i > 0) {
				resutl.setCode(AnguoStatusUtil.OPT_UPDATE_SUCCESS);
			} else {
				resutl.setCode(AnguoStatusUtil.OPT_UPDATE_ERROR);
			}
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_UPDATE_ERROR);
			e.printStackTrace();
		}
		return resutl;
		
	}

	@RequestMapping("/oyqyhistory/delete.htm")
	@ResponseBody
	public PageResult deleteOyqyHistory(HttpServletRequest request,OyqyHistory oyqyHistory) {
		PageResult resutl=new PageResult();
		try {
			
			int i =oyqyHistoryService.deleteData(oyqyHistory);
			
			
			if (i > 0) {
				resutl.setCode(AnguoStatusUtil.OPT_DELETE_SUCCESS);
			} else {
				resutl.setCode(AnguoStatusUtil.OPT_DELETE_ERROR);
			}
		} catch (Exception e) {
			resutl.setCode(AnguoStatusUtil.OPT_DELETE_ERROR);
			e.printStackTrace();
		}
		return resutl;
	}
	
	@RequestMapping("/oyqyhistory/load.htm")
	@ResponseBody
	public Object loadOyqyHistory(OyqyHistory oyqyHistory) {
		
		return oyqyHistoryService.getData(oyqyHistory);
	}
	
	/**
	 * 微信访问初始入口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/oyqyhistory/index.htm")
	public void trans(HttpServletRequest request,HttpServletResponse response) {
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqyhistory/weixin.htm?fromnickname=Jay?fromopenid=initopenid?fromsex=1?fromheadimgurl=http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqy/images/share.jpg?v=1";
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
	@RequestMapping("/oyqyhistory/weixin.htm")
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
		
		
		
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/oyqyhistory/weixin.htm?fromnickname="+request.getParameter("nickname")+"?fromopenid="+request.getParameter("openid")+"?fromsex="+request.getParameter("sex")+"?fromheadimgurl="+request.getParameter("headimgurl");
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_USERINFO+"?url="+shareURL+"&scope=snsapi_userinfo&response_type=code#wechat_redirect";
		
		ModelAndView mav=new ModelAndView("160707/index");
		
		
		Map<String, String> share=new HashMap<String, String>();
		share.put("title", "来匿名聊聊和我的黑历史吧");
		share.put("desc", "说吧！打不死你！");
		share.put("link", linkurl);
		share.put("imgUrl", request.getParameter("headimgurl"));
		share.put("domain", AnguoWxUtil.DOMAIN);
		
		
		
		
		 String url = "";
		 
		         url = request.getScheme()+"://"+request.getServerName()+request.getContextPath()
		 
		                         + request.getServletPath();
		 
		         if (request.getQueryString() != null){
		 
		             url += "?" + request.getQueryString();
		 
		         }
		 
		          
		 

		
		
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
