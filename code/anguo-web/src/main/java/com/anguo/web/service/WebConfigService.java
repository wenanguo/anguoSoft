package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.WebConfig;
import com.anguo.web.db.mapper.WebConfigMapper;

@Service
public class WebConfigService extends BaseService<WebConfig> {
	
	
	@Autowired
	private WebConfigMapper mapper;
	
	
	public WebConfig getDataByCode(String code)
	{
		return this.mapper.getDataByCode(code);
	}

	public WebConfigMapper getMapper() {
		return mapper;
	}

	public void setMapper(WebConfigMapper mapper) {
		this.mapper = mapper;
	}
	
}
