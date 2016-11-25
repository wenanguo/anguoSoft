package com.anguo.oy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.oy.db.mapper.OyqyHistoryLikeMapper;
import com.anguo.oy.db.domain.OyqyHistoryLike;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class OyqyHistoryLikeService extends BaseService<OyqyHistoryLike> {
	@Autowired
	private OyqyHistoryLikeMapper mapper;
	public OyqyHistoryLikeMapper getMapper() {
		return mapper;
	}
}
