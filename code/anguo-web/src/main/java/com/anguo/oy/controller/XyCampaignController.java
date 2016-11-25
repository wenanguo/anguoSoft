package com.anguo.oy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anguo.mybatis.db.controller.BaseController;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoStatusUtil;
import com.anguo.weixin.service.WxTokenService;
import com.anguo.weixin.util.AnguoWxUtil;
import com.anguo.oy.db.domain.XyCampaign;
import com.anguo.oy.db.mapper.XyCampaignMapper;
import com.anguo.oy.service.XyCampaignService;

/**
 * 制器类
 * @ClassName: XyCampaign
 * @author Andrew.Wen
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class XyCampaignController extends BaseController {
	
	private final static Logger log = Logger.getLogger(XyCampaignController.class);
	@Autowired
	private XyCampaignService xyCampaignService;
	
	//获取token服务类
		@Autowired
		private WxTokenService wxTokenService;

	@RequestMapping("/xyCampaign/list.htm")
	@ResponseBody
	public PageResult<List<XyCampaign>> queryXyCampaignList(XyCampaign xyCampaign) {
	
		PageResult<List<XyCampaign>> result=new PageResult<List<XyCampaign>>();
		
		try {
			result= xyCampaignService.getPageData(xyCampaign);
		} catch (Exception e) {
		
			log.error("发生错误，因为：" + e.getMessage());
			e.printStackTrace();
			result.setCode(AnguoStatusUtil.INTERFACE_SERVICE_ERROR);
			result.setMsg(result.getMsg()+":"+e.getMessage());
			
		}
		return result;
	}

	@RequestMapping("/xyCampaign/listAll.htm")
	@ResponseBody
	public List<XyCampaign> queryXyCampaignAllList(XyCampaign xyCampaign) {
		try {
			return xyCampaignService.getAllData(xyCampaign);
		} catch (Exception e) {
			log.error("查询列表发生错误，因为：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/xyCampaign/create.htm")
	@ResponseBody
	public PageResult saveXyCampaign(HttpServletRequest request,HttpServletResponse response, XyCampaign xyCampaign) {
		
		PageResult resutl=new PageResult();
		xyCampaign.setOperateDate(new Date());
		
		
		try {
			int i = xyCampaignService.insertData(xyCampaign);
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

	@RequestMapping("/xyCampaign/update.htm")
	@ResponseBody
	public PageResult updateXyCampaign(HttpServletRequest request,HttpServletResponse response,XyCampaign xyCampaign) {
		
		PageResult resutl=new PageResult();
		try {
			int i = xyCampaignService.updateData(xyCampaign);
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

	@RequestMapping("/xyCampaign/delete.htm")
	@ResponseBody
	public PageResult deleteXyCampaign(HttpServletRequest request,XyCampaign xyCampaign) {
		PageResult resutl=new PageResult();
		try {
			
			int i =xyCampaignService.deleteData(xyCampaign);
			
			
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
	
	@RequestMapping("/xyCampaign/load.htm")
	@ResponseBody
	public Object loadXyCampaign(XyCampaign xyCampaign) {
		
		return xyCampaignService.getData(xyCampaign);
	}
	
	
	
	
	/**
	 * 微信访问初始入口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/xyCampaign/index.htm")
	public void trans(HttpServletRequest request,HttpServletResponse response) {
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/xyCampaign/weixin.htm?fromopenid=initopenid";
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_SNSAPI_BASE+"?url="+shareURL+"&scope=snsapi_base&response_type=code#wechat_redirect";
		
		
		try {
			response.sendRedirect(linkurl);
		} catch (IOException e) {
 
			e.printStackTrace();
		}
				
	}
	
	

	/**
	 * 微信访问初始入口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/xyCampaign/loading.htm")
	public void load(HttpServletRequest request,HttpServletResponse response) {
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/xyCampaign/weixin.htm";
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
	@RequestMapping("/xyCampaign/weixin2.htm")
	public ModelAndView weixin2Sign(HttpServletRequest request,String openid,String fromopenid) {
		
		
		System.out.println("openid:"+openid);
		System.out.println("fromopenid:"+fromopenid);
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
//		Map frommap=new HashMap();
//		frommap.put("fromnickname", fromnickname);
//		frommap.put("fromopenid", fromopenid);
//		frommap.put("fromsex", fromsex);
//		frommap.put("fromheadimgurl", fromheadimgurl);
		
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/xyCampaign/weixin.htm"+"?fromopenid="+openid;
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_SNSAPI_BASE+"?url="+shareURL+"&scope=snsapi_base&response_type=code#wechat_redirect";
		
		ModelAndView mav=new ModelAndView("160810/index");
		
		
		Map<String, String> share=new HashMap<String, String>();
		share.put("title", "试试解开你身上的封印");
		share.put("desc", "想和运动健儿一样上赛场拼搏吗？So easy ~");
		share.put("link", linkurl);
		share.put("imgUrl", "http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/160810/images/share.png");
		share.put("domain", AnguoWxUtil.DOMAIN);
		
		share.put("openid", openid);
		share.put("fromopenid", fromopenid);
		
		
//		//////////////////////////
//		XyCampaign xyCampaign = new XyCampaign();
//		xyCampaign.setFromopenid(fromopenid);
//		xyCampaign=this.xyCampaignService.getDataByfromopenid(xyCampaign);
//		if(xyCampaign!=null){
//			share.put("fromheadimgurl", xyCampaign.getFromheadimgurl());
//		}
//		
		
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
      //mav.addObject("from",frommap);
      return mav;
	}
	
	
	/**
	 * pc访问
	 * @param request
	 * @return
	 */
	@RequestMapping("/xyCampaign/weixin.htm")
	public ModelAndView weixinSign(HttpServletRequest request,String openid,String fromopenid) {
		
		
		System.out.println("openid:"+openid);
		System.out.println("fromopenid:"+fromopenid);
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
//		Map frommap=new HashMap();
//		frommap.put("fromnickname", fromnickname);
//		frommap.put("fromopenid", fromopenid);
//		frommap.put("fromsex", fromsex);
//		frommap.put("fromheadimgurl", fromheadimgurl);
		
		
		String shareURL="http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/xyCampaign/weixin.htm"+"?fromopenid="+openid;
		String linkurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AnguoWxUtil.APPID+"&redirect_uri="+AnguoWxUtil.REDIRECT_URI_SNSAPI_BASE+"?url="+shareURL+"&scope=snsapi_base&response_type=code#wechat_redirect";
		
		ModelAndView mav=new ModelAndView("160810/index");
		
		
		Map<String, String> share=new HashMap<String, String>();
		share.put("title", "试试解开你身上的封印");
		share.put("desc", "想和运动健儿一样上赛场拼搏吗？So easy ~");
		share.put("link", linkurl);
		share.put("imgUrl", "http://"+AnguoWxUtil.DOMAIN+"/encounterr-web/160810/images/share.png");
		share.put("domain", AnguoWxUtil.DOMAIN);
		
		share.put("openid", openid);
		share.put("fromopenid", fromopenid);
		
		
		//////////////////////////
		XyCampaign xyCampaign = new XyCampaign();
		xyCampaign.setFromopenid(fromopenid);
		xyCampaign=this.xyCampaignService.getDataByfromopenid(xyCampaign);
		if(xyCampaign!=null){
			share.put("fromheadimgurl", xyCampaign.getFromheadimgurl());
		}
		
		
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
      //mav.addObject("from",frommap);
      return mav;
	}
	
	
	  /**
		* 获取token
		*/
	public String getJsapiTicket(){
				
		return String.valueOf(wxTokenService.getJsapiToken().get("ticket"));
				
	}
	
}
