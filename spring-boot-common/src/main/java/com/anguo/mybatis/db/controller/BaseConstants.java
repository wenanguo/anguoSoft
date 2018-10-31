package com.anguo.mybatis.db.controller;


/**
 * 常量定义类 
 * 
 * @author AndrewWen

 */
public class BaseConstants {
	
	/**
	 * 是
	 */
	public static final int BASE_YES = 2;
	
	/**
	 * 否
	 */
	public static final int BASE_NO = 1;
	

	/**
	 * 正常
	 */
	public static final int BASE_NORMAL = 100;

	/**
	 * 删除
	 */
	public static final int BASE_DELETE = 101;

	/**
	 * 作废
	 */
	public static final int BASE_INVALID = 102;

	/**
	 * 审核中
	 */
	public static final int BASE_AUDITING = 103;
	
	/**
	 * 停止
	 */
	public static final int BASE_STOP=104;
	
	/**
	 * 过期
	 */
	public static final int BASE_EXPIRED=105;
	
	/**
	 * 锁定
	 */
	public static final int BASE_LOCKED=106;


	/**
	 * 未知
	 */
	public static final int BASE_UNKNOWN = 110;

	
	//===定义testng级别
	/**
	 * 数据库操作，不进行测试
	 */
	/**
	 * 数据库测试，影响原始数据
	 */
	public static final String TEST_DATABASE_AFFECT="test_database_affect";
	/**
	 * 数据库测试，不影响原始数据
	 */
	public static final String TEST_DATABASE_NO_AFFECT="test_database_no_affect";
	/**
	 * WEB测试，影响原始数据
	 */
	public static final String TEST_WEB_AFFECT="test_web_affect";
	/**
	 * WEB测试，不影响原始数据
	 */
	public static final String TEST_WEB_NO_AFFECT="test_web_no_affect";
	/**
	 * 工具测试，影响原始数据
	 */
	public static final String TEST_UTIL_AFFECT="test_util_affect";
	/**
	 * 工具测试，不影响原始数据
	 */
	public static final String TEST_UTIL_NO_AFFECT="test_util_no_affect";
	/**
	 * 服务测试，影响原始数据
	 */
	public static final String TEST_SERVICE_AFFECT="test_service_affect";
	/**
	 * 服务测试，不影响原始数据
	 */
	public static final String TEST_SERVICE_NO_AFFECT="test_service_no_affect";
	/**
	 * 接口测试，影响原始数据
	 */
	public static final String TEST_INTERFACE_AFFECT="test_interface_affect";
	/**
	 * 接口测试，不影响原始数据
	 */
	public static final String TEST_INTERFACE_NO_AFFECT="test_interface_no_affect";

	
	
	
	
}
