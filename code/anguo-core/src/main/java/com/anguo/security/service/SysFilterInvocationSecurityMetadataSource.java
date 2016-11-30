package com.anguo.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.anguo.web.db.domain.CommonSysAuthority;
import com.anguo.web.db.domain.CommonSysRole;
import com.anguo.web.service.CommonSysAuthorityService;
import com.anguo.web.service.CommonSysRoleService;


public class SysFilterInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	
	private final static Logger log = Logger.getLogger(SysFilterInvocationSecurityMetadataSource.class);
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	/**
	 * 角色业务逻辑处理
	 */
	@Autowired
	CommonSysRoleService commonSysRoleService=null;
	
	/**
	 * 权限业务逻辑
	 */
	@Autowired
	CommonSysAuthorityService commonSysAuthorityService=null;

	
	/**
	 * 构造方法
	 * <p>Title: </p> 
	 * <p>Description: </p>
	 */
	public SysFilterInvocationSecurityMetadataSource() {
		
	}

	/**
	 * 载入资源定义
	 */
	private void loadResourceDefine() {
		
		
		/*
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
		 * sparta
		 */
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
		
		Collection<ConfigAttribute> atts=null;
		
		//遍历角色表
		List<CommonSysAuthority> listAuth= this.commonSysAuthorityService.getAllData(null);
		
		for(CommonSysAuthority tempAuth:listAuth)
		{
			atts = new ArrayList<ConfigAttribute>();
			//根据权限遍历角色
			List<CommonSysRole> listRole= this.commonSysRoleService.getRoleByAuthority(tempAuth);
			for(CommonSysRole tempRole:listRole)
			{
				
				atts.add(new SecurityConfig(tempRole.getEName()));
			}
			resourceMap.put(tempAuth.getUrl(), atts);
		}
		
		
		
		
//		//atts.add(new SecurityConfig("ROLE_ADMIN"));
//		resourceMap.put("/index.jsp", atts);
//		resourceMap.put("/controller/index", atts);
//		
//		
//		
//		atts = new ArrayList<ConfigAttribute>();
//		atts.add(new SecurityConfig("ROLE_USER"));
//		resourceMap.put("/**", atts);
		
		//System.out.println(resourceMap);
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		
		// object 是一个URL，被用户请求的url。
				String url = ((FilterInvocation) object).getRequestUrl();
				
		        int firstQuestionMarkIndex = url.indexOf("?");

		        if (firstQuestionMarkIndex != -1) {
		            url = url.substring(0, firstQuestionMarkIndex);
		        }

				Iterator<String> ite = resourceMap.keySet().iterator();

				while (ite.hasNext()) {
					String resURL = ite.next();
					
					if (resURL.equals(url)) {

						return resourceMap.get(resURL);
					}
				}
		
		
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
	
	
	public CommonSysRoleService getCommonSysRoleService() {
		return commonSysRoleService;
	}


	public void setCommonSysRoleService(CommonSysRoleService commonSysRoleService) {
		this.commonSysRoleService = commonSysRoleService;
	}

}
