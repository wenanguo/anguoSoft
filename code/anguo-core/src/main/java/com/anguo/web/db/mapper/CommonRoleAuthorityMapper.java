package com.anguo.web.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.web.db.domain.CommonRoleAuthority;
import com.anguo.web.db.domain.CommonSysRole;

public interface CommonRoleAuthorityMapper extends BaseMapper<CommonRoleAuthority> {

	
	public int deleteDataByRole(CommonSysRole role);
	
}
