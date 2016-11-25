
package com.anguo.oy.db.domain;




import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 实体类
 * @ClassName: XyCampaign 
 * @author Andrew.Wen
 */
public class XyCampaign extends BaseVo  {

	/**
	 * 编号.
	 */
		private Integer id;
	/**
	 * 来源openid.
	 */
		private String fromopenid;
	/**
	 * 来源名称.
	 */
		private String fromnickname;
	/**
	 * 来源性别.
	 */
		private Integer fromsex;
	/**
	 * 来源图片.
	 */
		private String fromheadimgurl;
	/**
	 * 目标openid.
	 */
		private String toopenid;
	/**
	 * 目标名称.
	 */
		private String tonickname;
	/**
	 * 目标性别.
	 */
		private Integer tosex;
	/**
	 * 目标图片.
	 */
		private String toheadimgurl;
	/**
	 * 城市.
	 */
		private String city;
	/**
	 * 做什么事.
	 */
		private String dosamething;
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
    
public String getFromopenid() {
		return fromopenid;
	}
	public void setFromopenid(String fromopenid) {
		this.fromopenid = fromopenid;
	}
    
public String getFromnickname() {
		return fromnickname;
	}
	public void setFromnickname(String fromnickname) {
		this.fromnickname = fromnickname;
	}
    
public Integer getFromsex() {
		return fromsex;
	}
	public void setFromsex(Integer fromsex) {
		this.fromsex = fromsex;
	}
    
public String getFromheadimgurl() {
		return fromheadimgurl;
	}
	public void setFromheadimgurl(String fromheadimgurl) {
		this.fromheadimgurl = fromheadimgurl;
	}
    
public String getToopenid() {
		return toopenid;
	}
	public void setToopenid(String toopenid) {
		this.toopenid = toopenid;
	}
    
public String getTonickname() {
		return tonickname;
	}
	public void setTonickname(String tonickname) {
		this.tonickname = tonickname;
	}
    
public Integer getTosex() {
		return tosex;
	}
	public void setTosex(Integer tosex) {
		this.tosex = tosex;
	}
    
public String getToheadimgurl() {
		return toheadimgurl;
	}
	public void setToheadimgurl(String toheadimgurl) {
		this.toheadimgurl = toheadimgurl;
	}
    
public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
    
public String getDosamething() {
		return dosamething;
	}
	public void setDosamething(String dosamething) {
		this.dosamething = dosamething;
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
