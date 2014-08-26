package com.anguo.security.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.db.domain.CommonSysUser;
import com.anguo.web.service.CommonSysRoleService;
import com.anguo.web.service.CommonSysUserService;



public class SysUserDetailsService implements UserDetailsService {

	public static Map<String, CommonSysUser> userMap = null;
	
	/**
	 * 用户业务逻辑操作
	 */
	@Autowired
	CommonSysUserService commonSysUserService;
	
	/**
	 * 角色业务逻辑操作
	 */
	@Autowired
	CommonSysRoleService commonSysRoleService;
	

	
	public SysUserDetailsService()
	{
		
	        
	        
//	        Set<GrantedAuthority> authorities2 = new HashSet<GrantedAuthority>(0);  
//	        //authorities2.add(new GrantedAuthorityImpl("ROLE_USER"));
//	        authorities2.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
//	        
//	        SysUser = new CommonSysUser("wenanguo", "wenanguo",authorities2);
//	        //SysUser.setEmail("admin@family168.com");
//	        userMap.put("wenanguo", SysUser);
	}
	
	/**
	 * 初始化资源
	 */
	public void loadResourceDefine()
	{
		 userMap = new HashMap<String, CommonSysUser>();

		 //CommonSysUser SysUser = null;
		 System.out.println("============刷新用户资源==============");
		 /**
		  * 获得用户列表
		  */
		 List<CommonSysUser> listUser=this.commonSysUserService.getAllData(null);
	        
		 for(CommonSysUser user:listUser)
		 {
			 Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(0);  
		        
			 List<CommonSysRole> listRole=this.commonSysRoleService.getRoleByUser(user);
			 
			 for(CommonSysRole tempRole:listRole)
			 {
				 authorities.add(new GrantedAuthorityImpl(tempRole.getEName()));
			 }
		       
			 user.setAuthorities(authorities);
		     //SysUser = new CommonSysUser(user.getUserName(), user.getPassword(),authorities);
		        
		     userMap.put(user.getUserName(), user);
			 
		 }
		 
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		UserDetails temp=userMap.get(username);
		System.out.println(temp.getAuthorities());
		
		
		return temp;
	}

}
