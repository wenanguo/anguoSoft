package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anguo.mybatis.db.service.BaseService;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.db.domain.CommonUserRole;
import com.anguo.web.db.mapper.CommonSysUserMapper;
import com.anguo.web.db.mapper.CommonUserRoleMapper;


@Service
public class CommonSysUserService extends BaseService<CommonSysUser> {
	
	@Autowired
	private CommonSysUserMapper mapper;
	
	@Autowired
	private CommonUserRoleMapper commonUserRoleMapper;

	
	public int insertData(CommonSysUser obj,String roleIds)
	{
		int i=0;
		i=this.insertData(obj);
		
		updateUserRole(obj, roleIds);
		
		return i; 
	}

	
	public int insertData(CommonSysUser obj)
	{
		obj.setPassword("123456");
		return this.mapper.insertData(obj); 
	}
	
	public int deleteData(CommonSysUser obj)
	{
		/**
		 * 删除权限对应
		 */
		updateUserRole(obj, "");
		return this.getMapper().deleteData(obj);
	}
	
	/**
	 * 更新权限
	 * @param obj
	 * @param roleIds
	 */
	private void updateUserRole(CommonSysUser obj, String roleIds) {
		//删除权限
		this.commonUserRoleMapper.deleteDataByUser(obj);
		
		if(!(roleIds==null||roleIds.length()<1))
		{
			String[] arrRole=roleIds.split(",");
			for(int j=0;j<arrRole.length;j++)
			{
				
				CommonUserRole temp=new CommonUserRole();
				temp.setCommonSysRoleId(Integer.valueOf(arrRole[j]));
				temp.setCommonSysUserId(obj.getId());
				
				this.commonUserRoleMapper.insertData(temp);
				
			}
		}
		
	}

	
	public int updateData(CommonSysUser obj,String roleIds)
	{
		int i=0;
		i=this.updateData(obj);
		
		updateUserRole(obj, roleIds);
		
		return i;
	}
	
	
	public CommonSysUserMapper getMapper() {
		return mapper;
	}


	public void setMapper(CommonSysUserMapper mapper) {
		this.mapper = mapper;
	}


	
}
