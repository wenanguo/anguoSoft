package com.anguo.web.db.mapper;

import java.util.List;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;


public interface CommonSysAuthorityMapper extends BaseMapper<CommonSysAuthority> {
	

	/**
	 * 根据用户编号角色查询用户权限
	 * @param obj
	 * @return
	 */
	public List<CommonSysAuthority> getAuthorityByUserId(CommonSysUser obj);
	
}
