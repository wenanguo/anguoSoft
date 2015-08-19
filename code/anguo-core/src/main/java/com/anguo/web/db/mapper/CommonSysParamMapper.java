package com.anguo.web.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.web.db.domain.CommonSysParam;

public interface CommonSysParamMapper extends BaseMapper<CommonSysParam> {

	/**
	 * 根据名称获取参数值
	 * @param obj
	 * @return
	 */
	public CommonSysParam getDataByName(CommonSysParam obj);
	
}
