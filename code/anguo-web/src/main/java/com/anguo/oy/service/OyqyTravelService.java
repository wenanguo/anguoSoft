package com.anguo.oy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.oy.db.mapper.OyqyTravelMapper;
import com.anguo.oy.db.domain.OyqyTravel;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class OyqyTravelService extends BaseService<OyqyTravel> {
	@Autowired
	private OyqyTravelMapper mapper;
	
	public OyqyTravelMapper getMapper() {
		return mapper;
	}
	
	/**
	 * 根据fromopenid获取对象
	 * @param obj
	 * @return
	 */
	public OyqyTravel getDataByToOpenid(OyqyTravel obj){
		
		return this.mapper.getDataByToOpenid(obj);
	}
}
