package com.anguo.weixin.db.domain;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 实体类
 * @ClassName: WxToken 
 * @author Andrew.Wen
 */
public class WxToken extends BaseVo  {

	
	public static final Integer ACCESS_TOKEN=1;
	public static final Integer JSAPI_TICKET=2;
	
	
	
	/**
	 * 编号.
	 */
		private Integer id;
	/**
	 * token.
	 */
		private String token;
	/**
	 * 类型.
	 */
		private Integer tokenType;
	/**
	 * 有效期.
	 */
		private Integer validity;
	/**
	 * 状态.
	 */
		private Integer status;
	/**
	 * 操作人.
	 */
		private Integer operateUserId;
	/**
	 * 操作时间.
	 */
		@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	  @JsonSerialize(using = AnguoDateUtils.class)        
		private Date operateDate;
		
		
		
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getTokenType() {
		return tokenType;
	}
	public void setTokenType(Integer tokenType) {
		this.tokenType = tokenType;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOperateUserId() {
		return operateUserId;
	}
	public void setOperateUserId(Integer operateUserId) {
		this.operateUserId = operateUserId;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}




}
