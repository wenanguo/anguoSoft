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
	 * 后台服务异常
	 */
	public static final int INTERFACE_SERVICE_ERROR= 1100;
	/**
	 * 接口未定义或者数据未同步
	 */
	public static final int INTERFACE_NOT_SYNC= 1101;

	/**
	 * 接口未定义
	 */
	public static final int INTERFACE_NOT_DEFINE= 1102;

	/**
	 * 接口已被停用
	 */
	public static final int INTERFACE_DISABLE =1103;

	/**
	 * 无权访问
	 */
	public static final int INTERFACE_NO_PERMISSION= 1104;
	/**
	 * Spring容器中未定义服务
	 */
	public static final int INTERFACE_NOT_CLASS= 1105;

	/**
	 * Spring容器中未定义方法
	 */
	public static final int INTERFACE_NOT_METHOD= 1106;
	
	/**
	 * 接口访问超时
	 */
	public static final int INTERFACE_TIMEOUT= 1107;
	/**
	 * 参数Base64解码错误
	 */
	public static final int INTERFACE_BASE64_ERROR=  1108;
	/**
	 * 接口调试模式已关闭，不能使用get方法请求调用
	 */
	public static final int INTERFACE_NOT_GET= 1109;
	/**
	 * 参数非法，用户签名不一致
	 */
	public static final int INTERFACE_SIGN_INCONFORMITY= 1110;
	/**
	 * 登陆已超时
	 */
	public static final int INTERFACE_LOGIN_TIMEOUT=  1111;
	/**
	 * 参数非法，用户签名错误
	 */
	public static final int INTERFACE_SIGN_ERROR=  1112;
	/**
	 * 调用服务器成功
	 */
	public static final int INTERFACE_SUCCESS= 1200;
	/**
	 * 当前网络不稳定，连接服务器超时，请稍后再试！
	 */
	public static final int INTERFACE_NETWORK_INSTABILITY= 1300;//网络超时
	/**
	 * 请求编码异常";
	 */
	public static final int INTERFACE_SERVICECODE_ERROR= 1301;
	/**
	 * 客户端调用接口异常";
	 */
	public static final int INTERFACE_APPCALL_ERROR= 1302;
	/**
	 * 服务器端接口未返回任何数据";
	 */
	public static final int INTERFACE_NO_DATA= 1303;
	/**
	 * 解析数据出现异常";
	 */
	public static final int INTERFACE_DATA_ERROR= 1304;
	/**
	 * requestBean对象不能为空";
	 */
	public static final int INTERFACE_REQUEST_NULL= 1305;
	/**
	 * 请求路径不能为空";
	 */
//	public static final int INTERFACE_REQUESTURL_NULL= 1306;
	/**
	 * 手机无法连接网络，请检查数据流量及WIFI状态!";
	 */
	public static final int INTERFACE_NOT_NETWORK= 1307;//无法连接网络
	/**
	 * 文件上传路径未定义";
	 */
	public static final int INTERFACE_NOT_UPLOADURL= 1308;
	/**
	 * 请确认文件是否存在！";
	 */
	public static final int INTERFACE_NO_FILE= 1309;//上传文件不存在
	/**
	 * 请求参数中包含特定的关键字";
	 */
	public static final int INTERFACE_REQUEST_ERROR= 1310;
	/**
	 * 登陆账号错误";
	 */
	public static final int INTERFACE_USERNAME_ERROR= 1400;
	/**
	 * 登陆密码错误";
	 */
	public static final int INTERFACE_PASSWORD_ERROR= 1401;




}
