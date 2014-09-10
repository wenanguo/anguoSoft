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
	
	/**
	 * 根据用户名单条数据
	 * @param obj
	 * @return
	 * @throws Exception 
	 */
	public GeoMember login(GeoMember loginGeoMember) throws Exception
	{
		//根据用户名查询用户
		GeoMember geoMember= this.mapper.getDataByUserName(loginGeoMember);
		
		if(geoMember==null)
		{
			throw new Exception("用户不存在！");
			
		}else if(!geoMember.getPassword().equals(loginGeoMember.getPassword()))
		{
			throw new Exception("密码错误！");
		}
		
		
		return geoMember;
	}
	
	
	
	
	
	
	
	
	
	
	
	public GeoMemberMapper getMapper() {
		return mapper;
	}
}
