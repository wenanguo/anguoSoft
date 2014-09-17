package com.anguo.app.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.app.db.mapper.CommonAppLoggedUserMapper;
import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonAppLoggedUserService extends BaseService<CommonAppLoggedUser> {
	
	@Autowired
	private CommonAppLoggedUserMapper mapper;
	
	
	
	/**
	 * 根据uuid获取当前登录用户
	 * @param obj
	 * @return
	 */
	public CommonAppLoggedUser getDataByUUID(CommonAppLoggedUser obj)
	{
		return this.mapper.getDataByUUID(obj);
	}
	
	
	/**
	 * 删除已登录用户
	 * @param obj
	 * @return
	 */
	public int deleteDataByMember(CommonAppLoggedUser obj)
	{
		return this.mapper.deleteDataByMember(obj);
	}
	
	
	
	public CommonAppLoggedUserMapper getMapper() {
		return mapper;
	}
}
