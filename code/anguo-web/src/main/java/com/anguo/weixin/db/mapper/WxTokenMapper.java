package com.anguo.weixin.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.weixin.db.domain.WxToken;

public interface WxTokenMapper extends BaseMapper<WxToken> {

	/**
	 * 根据类型获取有效期内的token
	 * @param obj
	 * @return
	 */
	public WxToken getDataByValidity(WxToken obj);
	
}
