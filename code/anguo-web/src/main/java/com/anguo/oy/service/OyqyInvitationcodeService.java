package com.anguo.oy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.oy.db.mapper.OyqyInvitationcodeMapper;
import com.anguo.oy.db.domain.OyqyInvitationcode;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class OyqyInvitationcodeService extends BaseService<OyqyInvitationcode> {
	@Autowired
	private OyqyInvitationcodeMapper mapper;
	public OyqyInvitationcodeMapper getMapper() {
		return mapper;
	}
	
	public OyqyInvitationcode getDatabyOpenid(OyqyInvitationcode obj){
		return this.mapper.getDatabyOpenid(obj);
	}
}
