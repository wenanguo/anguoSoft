package com.anguo.web.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.mapper.CommonSysAuthorityMapper;

@Service
public class CommonSysAuthorityService extends BaseService<CommonSysAuthority> {
	@Autowired
	private CommonSysAuthorityMapper mapper;
	
	
	public CommonSysAuthorityMapper getMapper() {
		return mapper;
	}
	
	
	/**
	 * 根据用户编号获取当前用户权限
	 * @param obj
	 * @return
	 */
	public List<CommonSysAuthority> getAuthorityByUserId(CommonSysUser obj)
	{
		return this.mapper.getAuthorityByUserId(obj);
	}
	
	
}
