package com.anguo.app.db.mapper;

import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.mybatis.db.mapper.BaseMapper;

public interface CommonSysMemberMapper extends BaseMapper<CommonSysMember> {

	/**
	 * 根据用户名单条数据
	 * @param obj
	 * @return
	 */
	public CommonSysMember getDataByUserName(CommonSysMember obj);
	
	
	/**
	 * 根据uuid获取当前登录用户
	 * @param obj
	 * @return
	 */
	public CommonSysMember getDataByUUID(String obj);
	
}
