package com.anguo.service.test;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.testng.annotations.Test;

import com.anguo.mybatis.db.core.CodeComments;

@CodeComments("单元测试")
public class LogTest {
	
	private static final Logger log = Logger.getLogger(LogTest.class);//日志文件
	
	
	@Test
	@CodeComments("mongo测试")
	public void test1() throws InterruptedException{
		MDC.put("userName", "文安国");
		
		log.debug("debug============");
		Thread.sleep(1000);
		log.info("info==============");
		Thread.sleep(1000);
		log.warn("warn==============");
		Thread.sleep(1000);
		log.error("warn==============");
		
	}

}
