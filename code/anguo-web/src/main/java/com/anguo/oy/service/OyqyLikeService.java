package com.anguo.oy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.oy.db.mapper.OyqyLikeMapper;
import com.anguo.oy.db.domain.OyqyLike;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class OyqyLikeService extends BaseService<OyqyLike> {
	@Autowired
	private OyqyLikeMapper mapper;
	public OyqyLikeMapper getMapper() {
		return mapper;
	}
}
