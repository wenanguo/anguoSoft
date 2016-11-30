package com.anguo.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.app.db.domain.CommonAppSiData;
import com.anguo.app.db.mapper.CommonAppSiDataMapper;
import com.anguo.mybatis.db.service.BaseService;

@Service
public class CommonAppSiDataService extends BaseService<CommonAppSiData> {
	
	
	@Autowired
	private CommonAppSiDataMapper mapper;
	public CommonAppSiDataMapper getMapper() {
		return mapper;
	}
}
