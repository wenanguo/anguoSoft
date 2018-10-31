package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.web.db.mapper.UserMapper;
import com.anguo.web.db.domain.User;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class UserService extends BaseService<User> {

//	@Autowired
//	private UserMapper mapper;
//
//	public UserMapper getMapper() {
//		return mapper;
//	}
}
