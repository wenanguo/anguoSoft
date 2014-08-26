package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.CommonUserRole;
import com.anguo.web.db.mapper.CommonUserRoleMapper;

@Service
public class CommonUserRoleService extends BaseService<CommonUserRole> {
	
	@Autowired
	private CommonUserRoleMapper mapper;

	

	public void setMapper(CommonUserRoleMapper mapper) {
		this.mapper = mapper;
	}

	
}
