package com.anguo.member.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.member.db.domain.GeoMember;

public interface GeoMemberMapper extends BaseMapper<GeoMember> {
	
	
	
	/**
	 * 根据用户名单条数据
	 * @param obj
	 * @return
	 */
	public GeoMember getDataByUserName(GeoMember obj);

}
