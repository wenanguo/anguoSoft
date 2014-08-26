package com.anguo.web.db.domain;

import java.util.Date;

import com.anguo.mybatis.db.core.BaseVo;


/**
 * 实体类
 * @ClassName: WebNewsType 
 * @author Andrew.Wen
 */
public class WebNewsType extends BaseVo  {

	@Override
	public String toString() {
		return "WebNewsType [id=" + id + ", title=" + title + ", isPreviewImg="
				+ isPreviewImg + ", parentId=" + parentId + ", memo=" + memo
				+ ", status=" + status + ", operateUserId=" + operateUserId
				+ ", operateDate=" + operateDate + "]";
	}
	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private String title;
	/**
	 * .
	 */
	private Integer isPreviewImg;
	/**
	 * .
	 */
	private Integer parentId;
	
	private String content;
	
	/**
	 * .
	 */
	private String memo;
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




    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    
public Integer getIsPreviewImg() {
		return isPreviewImg;
	}
	public void setIsPreviewImg(Integer isPreviewImg) {
		this.isPreviewImg = isPreviewImg;
	}
    
public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
