package com.anguo.app.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.app.db.domain.CommonAppLoggedUser;

public interface CommonAppLoggedUserMapper extends BaseMapper<CommonAppLoggedUser> {

	
	/**
	 * 根据uuid获取当前登录用户
	 * @param obj
	 * @return
	 */
	public CommonAppLoggedUser getDataByUUID(CommonAppLoggedUser obj);
	
	/**
	 * 删除已登录用户
	 * @param obj
	 * @return
	 */
	public int deleteDataByMember(CommonAppLoggedUser obj);
	
}
