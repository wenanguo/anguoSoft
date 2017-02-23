

package com.anguo.security.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * ClassName:interceptorT
 *
 * @author   AndrewWen
 * @version  1.0
 * @since    v1.0
 * @Date	 2013-7-14 下午12:09:30 
 */
public class interceptorT extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		//System.out.println("afterCompletion");
		

		super.afterCompletion(request, response, handler, ex);
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//System.out.println("postHandle");
		

		super.postHandle(request, response, handler, modelAndView);
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String sequence=String.valueOf(System.currentTimeMillis());
    	MDC.put("sequence", "拦截器："+sequence);
		
		return super.preHandle(request, response, handler);
		
	}
	
	

}

