
package com.anguo.oy.db.domain;




import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 实体类
 * @ClassName: XyCampaignAction 
 * @author Andrew.Wen
 */
public class XyCampaignAction extends BaseVo  {

	/**
	 * 编号.
	 */
		private Integer id;
	/**
	 * 来源openid.
	 */
		private String openid;
	/**
	 * 动作.
	 */
		private String action;
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
    
public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
    
public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
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
