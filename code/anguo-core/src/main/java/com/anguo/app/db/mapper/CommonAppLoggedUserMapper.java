package com.anguo.app.db.mapper;

import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.mybatis.db.mapper.BaseMapper;

public interface CommonAppLoggedUserMapper extends BaseMapper<CommonAppLoggedUser> {

	
	
	
	/**
	 * 删除已登录用户
	 * @param obj
	 * @return
	 */
	public int deleteDataByMember(CommonAppLoggedUser obj);
	
}
