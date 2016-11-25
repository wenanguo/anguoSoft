package com.anguo.oy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.oy.db.mapper.OyqyHistoryMapper;
import com.anguo.oy.db.domain.OyqyHistory;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class OyqyHistoryService extends BaseService<OyqyHistory> {
	@Autowired
	private OyqyHistoryMapper mapper;
	public OyqyHistoryMapper getMapper() {
		return mapper;
	}
}
