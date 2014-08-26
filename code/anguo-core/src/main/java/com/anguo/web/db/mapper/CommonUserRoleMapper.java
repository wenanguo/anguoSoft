package com.anguo.web.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.domain.CommonUserRole;

public interface CommonUserRoleMapper extends BaseMapper<CommonUserRole> {

	
	/**
	 * 根据用户删除所属角色数据
	 * @param obj
	 * @return
	 */
	public int deleteDataByUser(CommonSysUser obj);
}
