package com.anguo.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;

/**
 * 安全编码组件
 * 
 * @author Andrew Wen
 * @version 1.0
 * @since 1.0
 */
public class AnguoEncryptUtil  {
	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	private static final String PUBLIC_KEY = "RSAPublicKey";
	private static final String PRIVATE_KEY = "RSAPrivateKey";
	public static final String KEY_SHA = "SHA";  
    public static final String KEY_MD5 = "MD5";  
    /** 
     * MAC算法可选以下多种算法 
     *  
     * <pre> 
     * HmacMD5  
     * HmacSHA1  
     * HmacSHA256  
     * HmacSHA384  
     * HmacSHA512 
     * </pre> 
     */  
    public static final String KEY_MAC = "HmacMD5";  
	
	
	/**
	 * 私钥
	 */
	private RSAPrivateKey privateKey;

	/**
	 * 公钥
	 */
	private RSAPublicKey publicKey;
	
	


	/**
	 * 公钥文件路径
	 */
	private String publicKeyPath;
	/**
	 * 私钥文件路径
	 */
	private String privateKeyPath;
	
	
	
	public String getPublicKeyPath() {
		return publicKeyPath;
	}

	public void setPublicKeyPath(String publicKeyPath) {
		this.publicKeyPath = publicKeyPath;
	}

	public String getPrivateKeyPath() {
		return privateKeyPath;
	}

	public void setPrivateKeyPath(String privateKeyPath) {
		this.privateKeyPath = privateKeyPath;
	}


	public RSAPrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(RSAPrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public RSAPublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(RSAPublicKey publicKey) {
		this.publicKey = publicKey;
	}
	
	
	/**
     * 将二进制数据编码为BASE64字符串
     * @param binaryData
     * @return
     */
    public static String encryptBASE64(byte[] binaryData) {
        try {
            return new String(Base64.encodeBase64(binaryData), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
     
    /**
     * 将BASE64字符串恢复为二进制数据
     * @param base64String
     * @return
     */
    public static byte[] decryptBASE64(String base64String) {
        try {
            return Base64.decodeBase64(base64String.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
  
    /** 
     * MD5加密 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptMD5(byte[] data) throws Exception {  
  
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);  
        md5.update(data);  
  
        return md5.digest();  
  
    }  
  
    /** 
     * SHA加密 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptSHA(byte[] data) throws Exception {  
  
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);  
        sha.update(data);  
  
        return sha.digest();  
  
    }  
  
    /** 
     * 初始化HMAC密钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public static String initMacKey() throws Exception {  
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);  
  
        SecretKey secretKey = keyGenerator.generateKey();  
        return encryptBASE64(secretKey.getEncoded());  
    }  
  
    /** 
     * HMAC加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {  
  
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);  
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());  
        mac.init(secretKey);  
  
        return mac.doFinal(data);  
  
    }
	
	
	/**
	 * 用私钥对信息生成数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param privateKey
	 *            私钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		// 解密由base64编码的私钥
		byte[] keyBytes = decryptBASE64(privateKey);

		// 构造PKCS8EncodedKeySpec对象
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 取私钥匙对象
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// 用私钥对信息生成数字签名
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		signature.update(data);

		return encryptBASE64(signature.sign());
	}
	
	/**
	 * 用私钥对信息生成数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param privateKey
	 *            私钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, RSAPrivateKey privateKey) throws Exception {
		
		// KEY_ALGORITHM 指定的加密算法
		//KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 取私钥匙对象

		// 用私钥对信息生成数字签名
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateKey);
		signature.update(data);

		return encryptBASE64(signature.sign());
	}

	/**
	 * 校验数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param publicKey
	 *            公钥
	 * @param sign
	 *            数字签名
	 * 
	 * @return 校验成功返回true 失败返回false
	 * @throws Exception
	 * 
	 */
	public static boolean verify(byte[] data, String publicKey, String sign)
			throws Exception {

		// 解密由base64编码的公钥
		byte[] keyBytes = decryptBASE64(publicKey);

		// 构造X509EncodedKeySpec对象
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 取公钥匙对象
		PublicKey pubKey = keyFactory.generatePublic(keySpec);

		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);

		// 验证签名是否正常
		return signature.verify(decryptBASE64(sign));
	}
	
	/**
	 * 校验数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param publicKey
	 *            公钥
	 * @param sign
	 *            数字签名
	 * 
	 * @return 校验成功返回true 失败返回false
	 * @throws Exception
	 * 
	 */
	public static boolean verify(byte[] data, RSAPublicKey publicKey, String sign)
			throws Exception {


		// KEY_ALGORITHM 指定的加密算法
		//KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);


		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicKey);
		signature.update(data);

		// 验证签名是否正常
		return signature.verify(decryptBASE64(sign));
	}

	/**
	 * 解密<br>
	 * 用私钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, String key)
			throws Exception {
		// 对密钥解密
		byte[] keyBytes = decryptBASE64(key);

		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}
	
	/**
	 * 解密<br>
	 * 用私钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, RSAPrivateKey privateKey)
			throws Exception {

		// 取得私钥
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}

	/**
	 * 解密<br>
	 * 用公钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, String key)
			throws Exception {
		// 对密钥解密
		byte[] keyBytes = decryptBASE64(key);

		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}
	
	/**
	 * 解密<br>
	 * 用公钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, RSAPublicKey publicKey)
			throws Exception {
		
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}

	/**
	 * 加密<br>
	 * 用公钥加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String publicKeyStr)
			throws Exception {
		byte[] buffer= decryptBASE64(publicKeyStr);
		KeyFactory keyFactory= KeyFactory.getInstance("RSA");
		X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);
		RSAPublicKey key=(RSAPublicKey) keyFactory.generatePublic(keySpec);
		
		return  encryptByPublicKey(data,key);
	}
	
	/**
	 * 加密<br>
	 * 用公钥加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, RSAPublicKey publicKey)
			throws Exception {
		// 取得公钥
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}

	/**
	 * RSA加密<br>
	 * 用字符串秘钥加密
	 * @param data 加密数据
	 * @param privateKeyStr 字符串秘钥
	 * @return
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String privateKeyStr)
			throws Exception {
		
		byte[] buffer= decryptBASE64(privateKeyStr);
		
		RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(buffer));  
		RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());  
		KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
		
		RSAPrivateKey privateKey=(RSAPrivateKey) keyFactory.generatePrivate(rsaPrivKeySpec);  
		
		return encryptByPrivateKey(data,privateKey);
		
		
	}
	
	/**
	 * 使用私钥进行RSA加密
	 * @param data 加密数据
	 * @param privateKey 私钥对象
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, RSAPrivateKey privateKey)
			throws Exception {
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}

	/**
	 * 取得私钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);

		return encryptBASE64(key.getEncoded());
	}

	
	
	/**
	 * 根据文件路径载入公钥文件
	 * @param publicKeyPath
	 * @return
	 * @throws Exception
	 */
	public void loadPublicKey(String publicKeyPath) throws Exception
	{
		String publicKeyStr="";
		
		try {
			
			publicKeyStr=readKeyContent(publicKeyPath);
			
			byte[] buffer= decryptBASE64(publicKeyStr);
			KeyFactory keyFactory= KeyFactory.getInstance("RSA");
			X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);
			this.publicKey= (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("公钥非法");
		} catch (IOException e) {
			throw new Exception("公钥数据内容读取错误");
		} catch (NullPointerException e) {
			throw new Exception("公钥数据为空");
		}
	}
	
	/**
	 * 根据字符串生成公钥对象
	 * @param publicKeyStr
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 */
	public RSAPublicKey initPublicKey(String publicKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		byte[] buffer= decryptBASE64(publicKeyStr);
		KeyFactory keyFactory= KeyFactory.getInstance("RSA");
		X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);
		return (RSAPublicKey) keyFactory.generatePublic(keySpec);
	}
	
	/**
	 * 根据字符串生成私钥对象
	 * @param privateKeyStr
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public RSAPrivateKey initPrivateKey(String privateKeyStr) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException 
	{
		byte[] buffer= decryptBASE64(privateKeyStr);
		
		RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(buffer));  
		RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());  
		KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
		
		return (RSAPrivateKey) keyFactory.generatePrivate(rsaPrivKeySpec);  
	}
	
	
	/**
	 * 载入秘钥，使用经过PKCS#8编码的私钥文件
	 * @param privateKeyPath
	 * @return
	 * @throws Exception
	 */
	public void loadPrivateKeyByUtf8(String privateKeyPath) throws Exception{
		
		String privateKeyStr="";
		
		try {
			privateKeyStr=readKeyContent(privateKeyPath);
			
			
			//BASE64Decoder base64Decoder= new BASE64Decoder();
			byte[] buffer= decryptBASE64(privateKeyStr);
			PKCS8EncodedKeySpec keySpec= new PKCS8EncodedKeySpec(buffer);
			KeyFactory keyFactory= KeyFactory.getInstance("RSA");
			this.privateKey= (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
			
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("私钥非法");
		} catch (IOException e) {
			throw new Exception("私钥数据内容读取错误");
		} catch (NullPointerException e) {
			throw new Exception("私钥数据为空");
		}
	}
	
	/**
	 * 载入秘钥，使用未经过PKCS#8编码的私钥文件
	 * @param privateKeyPath
	 * @throws Exception
	 */
	public void loadPrivateKey(String privateKeyPath) throws Exception{
		
		String privateKeyStr="";
		
		try {
			privateKeyStr=readKeyContent(privateKeyPath);
			
			
			//BASE64Decoder base64Decoder= new BASE64Decoder();
			byte[] buffer= decryptBASE64(privateKeyStr);
			
			RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(buffer));  
			RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());  
			KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
			
			this.privateKey=(RSAPrivateKey) keyFactory.generatePrivate(rsaPrivKeySpec);  
			
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("私钥非法");
		} catch (IOException e) {
			throw new Exception("私钥数据内容读取错误");
		} catch (NullPointerException e) {
			throw new Exception("私钥数据为空");
		}
	}
	
	/**
	 * 从文件中读取秘钥内容
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private static String readKeyContent(String path) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String readLine= null;
		StringBuilder sb= new StringBuilder();
		while((readLine= br.readLine())!=null){
			if(readLine.charAt(0)=='-'){
				continue;
			}else{
				sb.append(readLine);
				sb.append('\r');
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 初始化
	 */
	public void init()
	{
		
		    //加载公钥
			try {
					loadPublicKey(this.publicKeyPath);
					System.out.println("加载公钥成功");
				} catch (Exception e) {
					System.err.println(e.getMessage());
					System.err.println("加载公钥失败");
				}

				//加载私钥
				try {
					loadPrivateKey(this.privateKeyPath);
					System.out.println("加载私钥成功");
				} catch (Exception e) {
					System.err.println(e.getMessage());
					System.err.println("加载私钥失败");
				}
	}

//	/**
//	 * 生成初始化密钥
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public static Map<String, Object> initKey() throws Exception {
//		KeyPairGenerator keyPairGen = KeyPairGenerator
//				.getInstance(KEY_ALGORITHM);
//		keyPairGen.initialize(1024);
//
//		KeyPair keyPair = keyPairGen.generateKeyPair();
//
//		// 公钥
//		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//
//		// 私钥
//		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//
//		Map<String, Object> keyMap = new HashMap<String, Object>(2);
//
//		keyMap.put(PUBLIC_KEY, publicKey);
//		keyMap.put(PRIVATE_KEY, privateKey);
//		return keyMap;
//	}
}
