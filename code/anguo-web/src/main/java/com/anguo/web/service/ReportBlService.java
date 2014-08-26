package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.ReportBl;
import com.anguo.web.db.mapper.ReportBlMapper;

@Service
public class ReportBlService extends BaseService<ReportBl> {
	@Autowired
	private ReportBlMapper mapper;

	public ReportBlMapper getMapper() {
		return mapper;
	}

	public void setMapper(ReportBlMapper mapper) {
		this.mapper = mapper;
	}
	
	
}
