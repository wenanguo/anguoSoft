package com.anguo.member.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.member.db.mapper.GeoMemberMapper;
import com.anguo.member.db.domain.GeoMember;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class GeoMemberService extends BaseService<GeoMember> {
	@Autowired
	private GeoMemberMapper mapper;
	public GeoMemberMapper getMapper() {
		return mapper;
	}
}
