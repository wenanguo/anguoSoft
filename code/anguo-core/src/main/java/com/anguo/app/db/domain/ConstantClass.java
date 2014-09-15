package com.anguo.app.db.domain;

/**
 * 常量类
 * @author Administrator
 *
 */
public class ConstantClass {
	
	/***************基础类**********************/
	/**
	 * 正常
	 */
	public static final int BASE_NORMAL=100;    
	/**
	 * 删除
	 */
	public static final int BASE_DELETE=101;
	/**
	 * 作废
	 */
	public static final int BASE_INVALID=102;	
	/**
	 * 审核中
	 */
	public static final int BASE_AUDITING=103;	
	/**
	 * 停用
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
	public static final int BASE_UNKNOWN=110;	
	
	
	
	/****************接口类******************/
	/**
	 * 无权限
	 */
	public static final int INTERFACE_NOPERMISSION=	601; 
	/**
	 * 业务错误
	 */
	public static final int INTERFACE_SERVICEERROR=	602; 



}
