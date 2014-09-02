
package com.anguo.web.db.domain;




import java.util.Date;

import com.anguo.mybatis.db.core.BaseVo;


/**
 * 实体类
 * @ClassName: CommonSysClass 
 * @author Andrew.Wen
 */
public class CommonSysClass extends BaseVo  {

	/**
	 * 编号.
	 */
	private Integer id;
	/**
	 * 类型.
	 */
	private Integer type;
	/**
	 * 类别名称.
	 */
	private String name;
	/**
	 * 父节点.
	 */
	private Integer parentId;
	/**
	 * 备注.
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
    
public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
    
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
