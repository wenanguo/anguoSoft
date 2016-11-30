package com.anguo.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.app.db.domain.CommonAppSiDefine;
import com.anguo.app.db.mapper.CommonAppSiDefineMapper;
import com.anguo.mybatis.db.service.BaseService;

@Service
public class CommonAppSiDefineService extends BaseService<CommonAppSiDefine> {
	@Autowired
	private CommonAppSiDefineMapper mapper;
	
	
	/**
	 * 根据业务编码获得单条数据
	 * @param obj
	 * @return
	 */
	public CommonAppSiDefine getDataBySiService(CommonAppSiDefine obj)
	{
		return this.mapper.getDataBySiService(obj);
	}
	
	
	public CommonAppSiDefineMapper getMapper() {
		return mapper;
	}
}
