package com.anguo.app.service;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.mapper.CommonAppLoggedUserMapper;
import com.anguo.app.db.mapper.CommonSysMemberMapper;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonSysMemberService extends BaseService<CommonSysMember> {
	
	@Autowired
	private CommonSysMemberMapper mapper;
	
	@Autowired
	private CommonAppLoggedUserMapper commonAppLoggedUserMapper;
	
	
	
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
	
	
	
	/**
	 * 根据uuid获取当前登录用户
	 * @param obj
	 * @return
	 */
	public CommonSysMember getDataByUUID(String obj)
	{
		return this.mapper.getDataByUUID(obj);
	}
	
	
	
	public CommonSysMemberMapper getMapper() {
		return mapper;
	}
}
