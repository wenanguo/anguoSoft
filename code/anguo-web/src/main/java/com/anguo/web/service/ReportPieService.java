package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.ReportPie;
import com.anguo.web.db.mapper.ReportPieMapper;

@Service
public class ReportPieService extends BaseService<ReportPie> {
	
	@Autowired
	private ReportPieMapper mapper;

	public ReportPieMapper getMapper() {
		return mapper;
	}

	public void setMapper(ReportPieMapper mapper) {
		this.mapper = mapper;
	}
	
}
