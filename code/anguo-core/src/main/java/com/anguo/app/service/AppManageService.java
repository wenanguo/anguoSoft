package com.anguo.app.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anguo.util.AnguoJsonUtil;


/**
 * 接受操作服务器类
 * @author Administrator
 *
 */
@Service
public class AppManageService implements ApplicationContextAware {

	/**
	 * spring容器
	 */
	ApplicationContext applicationContext=null;
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		this.applicationContext=applicationContext;
	}
	
	
	
	
	/**
	 * 调用业务逻辑类方法
	 * @param Service_code
	 * @param reqParam
	 */
	public Object ObjectInvoke(String serviceClass,String serviceMethod,String reqParam)
	{
		Object returnOjb=null;
		
		try {
			
		Object serviceObj=this.applicationContext.getBean(serviceClass);
		
		Method method = BeanUtils.findMethodWithMinimalParameters(serviceObj.getClass(), serviceMethod);
		
		//处理参数
		Class[] methodParamTypes = method.getParameterTypes();

        int paramCount = methodParamTypes.length;
        
        Object param = null;
        
        if (paramCount > 0)
        {
          Class methodParamType = methodParamTypes[0];

         
            if (!StringUtils.isEmpty(reqParam))
            {
              param = AnguoJsonUtil.fromJson(reqParam, methodParamType);
            }
            else {
              param = methodParamType.newInstance();
            }

          
        }
			
		returnOjb= method.invoke(serviceObj, new Object[] { param });
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnOjb;
	}

	
	
}
