package com.anguo.util;

import com.anguo.app.db.domain.Sign;



/**
 * app工具类
 * @author Administrator
 *
 */
public class AnguoAppUtil {

	/**
	 * 签名
	 * @param signBean 签名对象
	 * @param DEFAULT_PUBLIC_KEY
	 * @return
	 * @throws Exception
	 */
	public static Sign enSign(Sign signBean, String DEFAULT_PUBLIC_KEY) throws Exception
	{
    	String sign=signBean.getUuid()+"&&"+signBean.getTimestamp();
    	
    	//公钥加密
    	//byte[] encodedData = AnguoEncryptUtil.encryptByPublicKey(sign.getBytes(), DEFAULT_PUBLIC_KEY);  
        
    	String signStr1=AnguoEncryptUtil.encryptBASE64(sign.getBytes());
    	
    	
    	//返回处理后的对象
    	Sign sign2=new Sign();
    	sign2.setSign(signStr1);
    	sign2.setTimestamp(signBean.getTimestamp());
    	
    	
    	return sign2;
    	
    	
	}
	
	
	/**
	 * 验证签名
	 * @param sign
	 * @param timestamp
	 * @param DEFAULT_PRIVATE_KEY
	 * @return
	 * @throws Exception
	 */
	public static Sign deSign(Sign signBean, String DEFAULT_PRIVATE_KEY) throws Exception
	{
		
		byte[] signStrByte=AnguoEncryptUtil.decryptBASE64(signBean.getSign());
    	
    	
    	//String signStr=new String(AnguoEncryptUtil.decryptByPrivateKey(signStrByte, DEFAULT_PRIVATE_KEY));
		
		
    	
    	String[] arr=new String(signStrByte).split("&&"); 
    	Sign signBean2=new Sign();
    	
    	signBean2.setUuid(arr[0]);
    	signBean2.setTimestamp(arr[1]);
        
    	
    	//判断时间戳是否相等
    	if(!signBean2.getTimestamp().equals(signBean.getTimestamp()))
    	{
    		throw new Exception("签名错误");
    	}
    	
    	
    	return signBean2;
    	
    	
	}
}
