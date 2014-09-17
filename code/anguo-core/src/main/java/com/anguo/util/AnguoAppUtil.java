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
	 * @param uuid
	 * @param timestamp
	 * @param DEFAULT_PUBLIC_KEY
	 * @return
	 * @throws Exception
	 */
	public static String enSign(String uuid,String timestamp, String DEFAULT_PUBLIC_KEY) throws Exception
	{
    	
    	String sign=uuid+"||"+timestamp;
    	
    	//公钥加密
    	byte[] encodedData = AnguoEncryptUtil.encryptByPublicKey(sign.getBytes(), DEFAULT_PUBLIC_KEY);  
        
    	String signStr1=AnguoEncryptUtil.encryptBASE64(encodedData);
    	
    	
    	return signStr1;
    	
    	
	}
	
	/**
	 * 签名
	 * @param sign
	 * @param timestamp
	 * @param DEFAULT_PRIVATE_KEY
	 * @return
	 * @throws Exception
	 */
	public static Sign deSign(String sign,String timestamp, String DEFAULT_PRIVATE_KEY) throws Exception
	{
		
		byte[] signStr2=AnguoEncryptUtil.decryptBASE64(sign);
    	
    	
    	String signStr=new String(AnguoEncryptUtil.decryptByPrivateKey(signStr2, DEFAULT_PRIVATE_KEY));
		
		
    	
    	String[] arr=signStr.split("||"); 
    	Sign signBean=new Sign();
    	
    	signBean.setUuid(arr[0]);
    	signBean.setTimestamp(arr[1]);
        
    	
    	//判断时间戳是否相等
    	if(!signBean.getTimestamp().equals(timestamp))
    	{
    		throw new Exception("签名错误");
    	}
    	
    	
    	return signBean;
    	
    	
	}
}
