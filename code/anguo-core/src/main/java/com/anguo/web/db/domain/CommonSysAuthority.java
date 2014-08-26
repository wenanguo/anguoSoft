
package com.anguo.web.db.domain;


/**
 * 权限实体类
 * @author Andrew.Wen
 */
public class CommonSysAuthority  {

	@Override
	public String toString() {
		return "CommonSysAuthority [id=" + id + ", code=" + code + ", name="
				+ name + ", url=" + url + ", icon=" + icon + ", type=" + type
				+ ", sort=" + sort + ", parentId=" + parentId + ", status="
				+ status + "]";
	}
	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private String code;
	/**
	 * .
	 */
	private String name;
	/**
	 * .
	 */
	private String url;
	/**
	 * .
	 */
	private String icon;
	/**
	 * .
	 */
	private Integer type;
	/**
	 * .
	 */
	private Integer sort;
	/**
	 * .
	 */
	private Integer parentId;
	/**
	 * .
	 */
	private Integer status;




    
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
    
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
    
public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
    
public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
    
public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
    
public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
