package com.anguo.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.web.db.mapper.CommonRoleAuthorityMapper;
import com.anguo.web.db.domain.CommonRoleAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonRoleAuthorityService extends BaseService<CommonRoleAuthority> {
	
	
	@Autowired
	private CommonRoleAuthorityMapper mapper;
	
	
	public int deleteDataByRole(CommonSysRole role)
	{
		return this.mapper.deleteDataByRole(role);
	}
	
	public CommonRoleAuthorityMapper getMapper() {
		return mapper;
	}
}
