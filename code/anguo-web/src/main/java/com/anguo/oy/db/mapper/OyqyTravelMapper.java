package com.anguo.oy.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.oy.db.domain.OyqyTravel;

public interface OyqyTravelMapper extends BaseMapper<OyqyTravel> {

	
	public OyqyTravel getDataByToOpenid(OyqyTravel obj);
}
