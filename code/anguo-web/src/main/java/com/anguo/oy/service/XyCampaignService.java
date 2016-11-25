package com.anguo.oy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.oy.db.mapper.XyCampaignMapper;
import com.anguo.oy.db.domain.XyCampaign;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class XyCampaignService extends BaseService<XyCampaign> {
	
	
	public XyCampaign getDataByfromopenid(XyCampaign obj){
		return this.mapper.getDataByfromopenid(obj);
	}
	
	
	public XyCampaign getDataByopenid(XyCampaign obj){
		return this.mapper.getDataByopenid(obj);
	}
	
	
	@Autowired
	private XyCampaignMapper mapper;
	public XyCampaignMapper getMapper() {
		return mapper;
	}
}
