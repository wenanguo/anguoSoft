package com.anguo.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.mapper.CommonSysMemberMapper;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonSysMemberService extends BaseService<CommonSysMember> {
	@Autowired
	private CommonSysMemberMapper mapper;
	
	
	
	/**
	 * 根据用户名单条数据
	 * @param obj
	 * @return
	 * @throws Exception 
	 */
	public CommonSysMember login(CommonSysMember commonSysMember) throws Exception
	{
		//根据用户名查询用户
		CommonSysMember geoMember= this.mapper.getDataByUserName(commonSysMember);
		
		if(geoMember==null)
		{
			throw new Exception("用户不存在！");
			
		}else if(!geoMember.getPassword().equals(commonSysMember.getPassword()))
		{
			throw new Exception("密码错误！");
		}
		
		
		return geoMember;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public CommonSysMemberMapper getMapper() {
		return mapper;
	}
}
