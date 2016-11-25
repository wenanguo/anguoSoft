package com.anguo.oy.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.oy.db.domain.XyCampaign;

public interface XyCampaignMapper extends BaseMapper<XyCampaign> {

	
	public XyCampaign getDataByfromopenid(XyCampaign obj);
	
	
	public XyCampaign getDataByopenid(XyCampaign obj);
}
