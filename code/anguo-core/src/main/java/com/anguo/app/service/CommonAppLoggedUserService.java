package com.anguo.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.app.db.mapper.CommonAppLoggedUserMapper;
import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonAppLoggedUserService extends BaseService<CommonAppLoggedUser> {
	@Autowired
	private CommonAppLoggedUserMapper mapper;
	public CommonAppLoggedUserMapper getMapper() {
		return mapper;
	}
}
