package com.anguo.web.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.web.db.domain.WebConfig;

public interface WebConfigMapper extends BaseMapper<WebConfig> {
	
	public WebConfig getDataByCode(String code);
	

}
