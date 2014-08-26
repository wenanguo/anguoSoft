
package com.anguo.web.db.domain;

import java.util.Date;
import com.anguo.mybatis.db.core.BaseVo;


/**
 * 实体类
 * @ClassName: WebConfig 
 * @author Andrew.Wen
 */
public class WebConfig extends BaseVo  {

	@Override
	public String toString() {
		return "WebConfig [id=" + id + ", code=" + code + ", title=" + title
				+ ", contentType=" + contentType + ", contentClass="
				+ contentClass + ", content=" + content + ", status=" + status
				+ ", operateUserId=" + operateUserId + ", operateDate="
				+ operateDate + "]";
	}
	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private String code;
	private String title;
	
	/**
	 * .
	 */
	private Integer contentType;
	/**
	 * .
	 */
	private Integer contentClass;
	/**
	 * .
	 */
	private String content;
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
	private Date operateDate;



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
    
public Integer getContentClass() {
		return contentClass;
	}
	public void setContentClass(Integer contentClass) {
		this.contentClass = contentClass;
	}
    
public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
