package com.anguo.oy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.oy.db.mapper.XyCampaignActionMapper;
import com.anguo.oy.db.domain.XyCampaignAction;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class XyCampaignActionService extends BaseService<XyCampaignAction> {
	@Autowired
	private XyCampaignActionMapper mapper;
	public XyCampaignActionMapper getMapper() {
		return mapper;
	}
}
