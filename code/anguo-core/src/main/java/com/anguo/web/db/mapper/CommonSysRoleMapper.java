package com.anguo.web.db.mapper;

import java.util.List;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;

public interface CommonSysRoleMapper extends BaseMapper<CommonSysRole> {
	
	/**
	 * 根据用户查询用户角色
	 * @param obj
	 * @return
	 */
	public List<CommonSysRole> getRoleByUser(CommonSysUser obj);
	
	/**
	 * 根据权限查询用户角色
	 * @param obj
	 * @return
	 */
	public List<CommonSysRole> getRoleByAuthority(CommonSysAuthority obj);
	
	/**
	 * 根据权限查询用户角色树，会取出所有角色节点，有权限则checked为true
	 * @param obj
	 * @return
	 */
	public List<CommonSysRole> getRoleTreeByUser(CommonSysUser obj);
	
	

	
	
}
