package com.anguo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 日志切面
 * @author Andrew.Wen
 *
 */
public class LogAspect {

	
	private final static Logger log = Logger.getLogger(LogAspect.class);
	
	
	 public synchronized void doAfter(JoinPoint jp) {  
	    }  
	  
	    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
	    	
	    	//test
	        Object retVal = pjp.proceed();


			//阿斯顿发
	        
	        return retVal;  
	    }  
	  
	    public synchronized void doBefore(JoinPoint jp) {  
	    	
	    	
	        
	        
	    }  
	  
	    public synchronized void doThrowing(JoinPoint jp, Throwable ex) {  
	        
	    }  
	    
}
