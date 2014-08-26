
package com.anguo.web.db.domain;




import java.util.Date;

import com.anguo.mybatis.db.core.BaseVo;


/**
 * 实体类
 * @ClassName: WebNews 
 * @author Andrew.Wen
 */
public class WebNews extends BaseVo {

	



	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private String mainTitle;
	/**
	 * .
	 */
	private String subTitle;
	/**
	 * .
	 */
	private Integer parentId;
	/**
	 * .
	 */
	private String content;
	/**
	 * .
	 */
	private Integer isDisplayPreviewImg;
	/**
	 * .
	 */
	private String previewImg;
	/**
	 * .
	 */
	private Integer webNewsTypeId;
	/**
	 * .
	 */
	private Integer isRed;
	/**
	 * .
	 */
	private Integer hits;
	/**
	 * .
	 */
	private Integer contentType;
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


	public WebNews(int i) {
		this();
		this.id=i;
	}
	
	public WebNews() {
		super();
	}


	/**
	 * 递增阅读量
	 */
	public void hitNews()
	{
		if(this.getHits()==null)this.setHits(0);
		this.setHits(this.getHits()+1);
		
	}

    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
    
public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
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
    
public Integer getIsDisplayPreviewImg() {
		return isDisplayPreviewImg;
	}
	public void setIsDisplayPreviewImg(Integer isDisplayPreviewImg) {
		this.isDisplayPreviewImg = isDisplayPreviewImg;
	}
    
public String getPreviewImg() {
		return previewImg;
	}
	public void setPreviewImg(String previewImg) {
		this.previewImg = previewImg;
	}
    
public Integer getWebNewsTypeId() {
		return webNewsTypeId;
	}
	public void setWebNewsTypeId(Integer webNewsTypeId) {
		this.webNewsTypeId = webNewsTypeId;
	}
    
public Integer getIsRed() {
		return isRed;
	}
	public void setIsRed(Integer isRed) {
		this.isRed = isRed;
	}
    
public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
    
public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
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
