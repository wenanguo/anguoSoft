package com.anguo.app.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anguo.app.db.domain.CommonAppLoggedUser;
import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.domain.ConstantClass;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.util.AnguoJsonUtil;
import com.anguo.util.AnguoStatusUtil;


/**
 * 接受操作服务器类
 * @author Administrator
 *
 */
@Service
public class CommonAppService implements ApplicationContextAware {

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
	 * @param serviceClass bean类名称
	 * @param serviceMethod bean方法名称
	 * @param reqParam 请求业务参数字符串
	 * @param appParam 请求系统参数字符串
	 * @param userParam 请求用户参数字符串
	 * @param session 
	 * @param request
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public Object ObjectInvoke(String serviceClass,String serviceMethod,String reqParam,CommonAppLoggedUser commonAppLoggerUser, CommonSysMember commonSysMember, HttpSession session, HttpServletRequest request) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Object returnOjb=null;
		
		Object serviceObj=this.applicationContext.getBean(serviceClass);
		
		PageResult ar=new PageResult();
		
		if(serviceObj==null)
		{
			//找不到当前bean
			ar.setCode(AnguoStatusUtil.INTERFACE_NOT_CLASS);
			return ar;
		}
		
		Method method = BeanUtils.findMethodWithMinimalParameters(serviceObj.getClass(), serviceMethod);
		
		if(method==null)
		{
			//找不到当前bean
			ar.setCode(AnguoStatusUtil.INTERFACE_NOT_METHOD);
			return ar;
		}
		
		//处理参数
		Class[] methodParamTypes = method.getParameterTypes();

        int paramCount = methodParamTypes.length;
        
        //参数队列
        Object[] paramArrays =  new Object[paramCount];
        
       
        
        if (paramCount>=1)
        {
          Class methodParamType = methodParamTypes[0];

          	//初始化业务参数
            if (!StringUtils.isEmpty(reqParam))
            {
            	paramArrays[0] = AnguoJsonUtil.fromJson(reqParam, methodParamType);
            }
            else {
            	paramArrays[0] = methodParamType.newInstance();
            }
        }
        
        
        //循环注入
        for(int i=1;i<paramCount;i++)
        {
        	//查找系统参数
        	if(methodParamTypes[i].isAssignableFrom(CommonAppLoggedUser.class))
        	{
        		 //初始化系统参数
        		if(commonAppLoggerUser!=null){
        			
        			paramArrays[i] =commonAppLoggerUser;
        		}else{
        			paramArrays[i] =CommonAppLoggedUser.class.newInstance();
        		}
                
        	}
        	
        	//查找用户参数
        	if(methodParamTypes[i].isAssignableFrom(CommonSysMember.class))
        	{
        		 //初始化用户参数
        		 if(commonSysMember!=null)
        		 {
        			 paramArrays[i] = commonSysMember;
        		 }else{
        			 paramArrays[i] = CommonSysMember.class.newInstance();
        		 }
               
        	}
        }
        
        
		
        //调用方法
		returnOjb= method.invoke(serviceObj, paramArrays);
			
			
		
		return returnOjb;
	}

	
	
}
