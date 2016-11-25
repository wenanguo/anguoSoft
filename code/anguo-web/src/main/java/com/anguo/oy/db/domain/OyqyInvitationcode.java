
package com.anguo.oy.db.domain;




import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 实体类
 * @ClassName: OyqyInvitationcode 
 * @author Andrew.Wen
 */
public class OyqyInvitationcode extends BaseVo  {

	/**
	 * ç¼–å·.
	 */
		private Integer id;
	/**
	 * openid.
	 */
		private String openid;
	/**
	 * nickname.
	 */
		private String nickname;
	/**
	 * sex.
	 */
		private String sex;
	/**
	 * headimgurl.
	 */
		private String headimgurl;
	/**
	 * invitationcode.
	 */
		private String invitationcode;
	/**
	 * playdate.
	 */
		@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	@JsonSerialize(using = AnguoDateUtils.class)        
		private Date playdate;
	/**
	 * .
	 */
		private Integer status;
	/**
	 * .
	 */
		private Integer operateUserId;
	/**
	 * .
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
    
public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
    
public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
    
public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
    
public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
    
public String getInvitationcode() {
		return invitationcode;
	}
	public void setInvitationcode(String invitationcode) {
		this.invitationcode = invitationcode;
	}
    
public Date getPlaydate() {
		return playdate;
	}
	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
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
