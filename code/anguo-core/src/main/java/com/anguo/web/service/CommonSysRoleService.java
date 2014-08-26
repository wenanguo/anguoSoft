package com.anguo.web.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.mapper.CommonSysRoleMapper;

@Service
public class CommonSysRoleService extends BaseService<CommonSysRole> {
	@Autowired
	private CommonSysRoleMapper mapper;
	
	public CommonSysRoleMapper getMapper() {
		return mapper;
	}
	
	/**
	 * 根据用户查询用户角色
	 * @param obj
	 * @return
	 */
	public List<CommonSysRole> getRoleByUser(CommonSysUser obj)
	{
		return this.mapper.getRoleByUser(obj);
	}
	
	
	/**
	 * 根据权限查询用户角色树，会取出所有角色节点，有权限则checked为true
	 * @param obj
	 * @return
	 */
	public List<CommonSysRole> getRoleTreeByUser(CommonSysUser obj)
	{
		return this.mapper.getRoleTreeByUser(obj);
	}
	
	/**
	 * 根据权限查询用户角色
	 * @param obj
	 * @return
	 */
	public List<CommonSysRole> getRoleByAuthority(CommonSysAuthority obj)
	{
		return this.mapper.getRoleByAuthority(obj);
	}
	
	
	public int insertData(CommonSysRole obj)
	{
		obj.setEName("ROLE_"+System.currentTimeMillis());
		return this.getMapper().insertData(obj);
	}

	

	

	
}
