package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.CommonSysClass;
import com.anguo.web.db.mapper.CommonSysClassMapper;

@Service
public class CommonSysClassService extends BaseService<CommonSysClass> {
	@Autowired
	private CommonSysClassMapper mapper;
	
	
	public CommonSysClassMapper getMapper() {
		return mapper;
	}
}
