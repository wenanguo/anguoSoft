
package com.anguo.web.db.domain;


import com.anguo.mybatis.db.core.BaseVo;


/**
 * 实体类
 * @ClassName: CommonUserRole 
 * @author Andrew.Wen
 */
public class CommonUserRole extends BaseVo  {

	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private Integer commonSysUserId;
	/**
	 * .
	 */
	private Integer commonSysRoleId;




    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public Integer getCommonSysUserId() {
		return commonSysUserId;
	}
	public void setCommonSysUserId(Integer commonSysUserId) {
		this.commonSysUserId = commonSysUserId;
	}
    
public Integer getCommonSysRoleId() {
		return commonSysRoleId;
	}
	public void setCommonSysRoleId(Integer commonSysRoleId) {
		this.commonSysRoleId = commonSysRoleId;
	}
	
}
