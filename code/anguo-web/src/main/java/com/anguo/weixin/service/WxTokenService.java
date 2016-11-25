package com.anguo.weixin.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.util.AnguoJsonUtil;
import com.anguo.weixin.db.mapper.WxTokenMapper;
import com.anguo.weixin.db.domain.WxToken;
import com.anguo.weixin.util.AnguoHttpUtil;
import com.anguo.weixin.util.AnguoWxUtil;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class WxTokenService extends BaseService<WxToken> {
	@Autowired
	private WxTokenMapper mapper;
	
	
	public WxTokenMapper getMapper() {
		return mapper;
	}
	
	/**
	 * 获取有效期accessToken
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	public Map getAccessToken(){
		
		//从数据库获取token
		WxToken wxToken=getDataByDb(WxToken.ACCESS_TOKEN);
		
		if(wxToken==null){
			//本地过期，重新获取
			Map map=getAccessTokenByWeixin(AnguoWxUtil.APPID,AnguoWxUtil.APPSECRET);
			WxToken insertObj=new WxToken();
			insertObj.setToken(String.valueOf(map.get("access_token")));
			insertObj.setValidity(Integer.valueOf(String.valueOf(map.get("expires_in"))));
			insertObj.setTokenType(WxToken.ACCESS_TOKEN);
			insertObj.setOperateDate(new Date());
			//重新获取后插入数据库
			this.mapper.insertData(insertObj);
			
			return map;
		}else{
			Map map=new HashMap();
			map.put("access_token", wxToken.getToken());
			map.put("expires_in", wxToken.getValidity());
			return map;
		}
		
	}
	
	
	
	/**
	 * 获取jsapitoken
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	public Map getJsapiToken(){
		
		//从数据库获取token
		WxToken wxToken=getDataByDb(WxToken.JSAPI_TICKET);
		
		if(wxToken==null){
			//本地过期，重新获取
			
			
			
			Map map=this.getJsapiTokenByWeixin(String.valueOf(this.getAccessToken().get("access_token")));
			WxToken insertObj=new WxToken();
			insertObj.setToken(String.valueOf(map.get("ticket")));
			insertObj.setValidity(Integer.valueOf(String.valueOf(map.get("expires_in"))));
			insertObj.setTokenType(WxToken.JSAPI_TICKET);
			insertObj.setOperateDate(new Date());
			//重新获取后插入数据库
			this.mapper.insertData(insertObj);
			
			return map;
		}else{
			Map map=new HashMap();
			map.put("ticket", wxToken.getToken());
			map.put("expires_in", wxToken.getValidity());
			return map;
		}
		
	}
	
	
    
    
   /**
    * 从微信官方网站获取Access_token
    * @param appid 
    * @param appsecret
    * @return
    */
	private Map getAccessTokenByWeixin(String appid,String appsecret){
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret+"";
		String retStr=AnguoHttpUtil.getMethod(url);
		
		Map map=AnguoJsonUtil.fromJson(retStr, HashMap.class);
		
		return map;
	}
	
	
	
	 /**
	    * 从微信官方网站获取jsapi_ticket
	    * @param accessToken 
	    * @return
	    */
		private Map getJsapiTokenByWeixin(String accessToken){
			
			String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
			
			String retStr=AnguoHttpUtil.getMethod(url);
			
			Map map=AnguoJsonUtil.fromJson(retStr, HashMap.class);
			
			return map;
		}
	
	/**
	 * 根据类型从数据库获取有效token
	 * @param tokenType
	 * @return
	 */
	private WxToken getDataByDb(Integer tokenType){
		
		WxToken obj=new WxToken();
		obj.setTokenType(tokenType);
		return this.mapper.getDataByValidity(obj);
	}
}
