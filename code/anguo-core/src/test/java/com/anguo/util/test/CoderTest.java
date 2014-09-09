package com.anguo.util.test;

import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.anguo.util.AnguoEncryptUtil;


/**
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class CoderTest {

    
    private AnguoEncryptUtil rSACoder;
  
    @BeforeTest  
    public void setUp() throws Exception {  
//        Map<String, Object> keyMap = RSACoder.initKey();  
//  
//        publicKey = RSACoder.getPublicKey(keyMap);  
//        privateKey = RSACoder.getPrivateKey(keyMap);  
//        System.err.println("公钥: \n\r" + publicKey);  
//        System.err.println("私钥： \n\r" + privateKey);  
    	
    	rSACoder=new AnguoEncryptUtil();
    	System.out.println("载入密钥对");
        
        rSACoder.loadPublicKey("D:/ssh/rsa_public_key.pem");
        
        rSACoder.loadPrivateKey("D:/ssh/rsa_private_key.pem");
    }  
  
    @Test  
    public void test() throws Exception {  
    	
    	
        System.err.println("公钥加密——私钥解密");  
        String inputStr = "abc";  
        byte[] data = inputStr.getBytes();  
        
  
        byte[] encodedData = AnguoEncryptUtil.encryptByPublicKey(data, rSACoder.getPublicKey());  
  
        byte[] decodedData = AnguoEncryptUtil.decryptByPrivateKey(encodedData,rSACoder.getPrivateKey());  
  
        String outputStr = new String(decodedData);  
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
        Assert.assertEquals(inputStr, outputStr);  
  
    }  
  
    @Test  
    public void testSign() throws Exception {  
        System.err.println("私钥加密——公钥解密");  
        String inputStr = "sign";  
        byte[] data = inputStr.getBytes();  
  
        byte[] encodedData = AnguoEncryptUtil.encryptByPrivateKey(data, rSACoder.getPrivateKey());  
  
        byte[] decodedData = AnguoEncryptUtil.decryptByPublicKey(encodedData, rSACoder.getPublicKey());  
  
        String outputStr = new String(decodedData);  
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
        Assert.assertEquals(inputStr, outputStr);  
  
        System.err.println("私钥签名——公钥验证签名");  
        // 产生签名  
        String sign = AnguoEncryptUtil.sign(decodedData, rSACoder.getPrivateKey());  
        
        System.err.println("签名:\r" + sign);  
  
        // 验证签名  
        boolean status = AnguoEncryptUtil.verify(decodedData, rSACoder.getPublicKey(), sign);  
        System.err.println("状态:\r" + status);  
        Assert.assertEquals(true, status);  
  
    }  
}
