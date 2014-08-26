package com.anguo.app.db.mapper;

import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.mybatis.db.mapper.BaseMapper;

public interface CommonAppSiDefineMapper extends BaseMapper<CommonAppSiDefine> {

	
	/**
	 * 根据业务编码获得单条数据
	 * @param obj
	 * @return
	 */
	public CommonAppSiDefine getDataBySiService(CommonAppSiDefine obj);
	
}
