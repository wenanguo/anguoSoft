package com.anguo.web.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import com.anguo.web.db.domain.CommonSysUser;



	/**
	 * 当前系统用户参数Resolver
	 * @author Andrew.Wen
	 */
	public class CurrentUserArgumentResolver implements WebArgumentResolver {

		public Object resolveArgument(MethodParameter methodParameter,
				NativeWebRequest webRequest) throws Exception {
			
			//检查参数类型中是否有CurrentSysUser类型的参数
			if(methodParameter.getParameterType().equals(CommonSysUser.class)) {
				
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				CommonSysUser currUser=null;
				
				 if (principal instanceof CommonSysUser) {
					 currUser=(CommonSysUser)principal;
				 } 

				return currUser;
				
			}
			return UNRESOLVED;
		}
	
}

