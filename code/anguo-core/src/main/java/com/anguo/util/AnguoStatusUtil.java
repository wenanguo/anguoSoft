package com.anguo.util;

/**
 * 
 * @author Andrew.Wen
 *
 */
public class AnguoStatusUtil {
	
	

	public static String getUserInfo(int code) {

		String statusValue="";
		
		switch (code) {
		
		case 1100:
			statusValue="后台服务异常";
			break;
		case 1101:
			statusValue="接口未定义或者数据未同步";
			break;
		case 1102:
			statusValue="接口未定义";
			break;
		case 1103:
			statusValue="接口已被停用";
			break;
		case 1104:
			statusValue="无权访问";
			break;
		case 1105:
			statusValue="Spring容器中未定义服务";
			break;
		case 1106:
			statusValue="Spring容器中未定义方法";
			break;
		case 1107:
			statusValue="接口访问超时";
			break;
		case 1108:
			statusValue="参数Base64解码错误";
			break;
		case 1109:
			statusValue="接口调试模式已关闭，不能使用get方法请求调用";
			break;
		case 1110:
			statusValue="参数非法，用户签名不一致";
			break;
		case 1111:
			statusValue="登陆已超时";
			break;
		case 1112:
			statusValue="参数非法，用户签名错误";
			break;
		case 1200:
			statusValue="调用服务器成功";
			break;
		case 1300://网络超时
			statusValue="当前网络不稳定，连接服务器超时，请稍后再试！";
			break;
		case 1301:
			statusValue="请求编码异常";
			break;
		case 1302:
			statusValue="客户端调用接口异常";
			break;
		case 1303:
			statusValue="服务器端接口未返回任何数据";
			break;
		case 1304:
			statusValue="解析数据出现异常";
			break;
		case 1305:
			statusValue="requestBean对象不能为空";
			break;
		case 1306:
			statusValue="请求路径不能为空";
			break;
		case 1307://无法连接网络
			statusValue="手机无法连接网络，请检查数据流量及WIFI状态!";
			break;
		case 1308:
			statusValue="文件上传路径未定义";
			break;
		case 1309://上传文件不存在
			statusValue="请确认文件是否存在！";
			break;
		case 1310:
			statusValue="请求参数中包含特定的关键字";
			break;
		case 1400:
			statusValue="登陆账号错误";
			break;
		case 1401:
			statusValue="登陆密码错误";
			break;
		default:
			statusValue="服务器连接异常，请稍后再试~";
			break;
			
		}
		return statusValue;

	}

}
