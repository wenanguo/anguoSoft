
package com.anguo.oy.db.domain;




import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 实体类
 * @ClassName: OyqyLike 
 * @author Andrew.Wen
 */
public class OyqyLike extends BaseVo  {

	/**
	 * 编号.
	 */
		private Integer id;
	/**
	 * 所属旅行记录编号.
	 */
		private Integer travelId;
	/**
	 * openid.
	 */
		private String openid;
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
    
public Integer getTravelId() {
		return travelId;
	}
	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
    
public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
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
