package com.anguo.web.db.domain;

import com.anguo.mybatis.db.core.BaseVo;


/**
 * 角色实体类
 * @ClassName: CommonSysRole 
 * @author Andrew.Wen
 */
public class CommonSysRole extends BaseVo  {

	@Override
	public String toString() {
		return "CommonSysRole [id=" + id + ", name=" + name + ", eName="
				+ eName + ", memo=" + memo + ", status=" + status + "]";
	}
	
	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private String name;
	/**
	 * .
	 */
	private String eName;
	/**
	 * .
	 */
	private String memo;
	/**
	 * .
	 */
	private Integer status;
	
	/**
	 * 是否选中，用于树节点
	 */
    private Boolean checked;




    
public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
public String getEName() {
		return eName;
	}
	public void setEName(String eName) {
		this.eName = eName;
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
	
}
