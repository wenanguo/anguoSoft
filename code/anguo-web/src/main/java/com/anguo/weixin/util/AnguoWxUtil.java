package com.anguo.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * 微信工具
 * @author Andrew.Wen
 *
 */
public class AnguoWxUtil {
	
	 public final static String APPID="wxc61929518b03a74d";
	 
	 public final static String APPSECRET="7db827c02e7bd085164ffe4bcdebd81f";
	//域名
	 public final static String DOMAIN="lb.teamyy.cn";
	 
	 //userinfo类型获取地址
	 public final static String REDIRECT_URI_USERINFO="http://"+DOMAIN+"/encounterr-web/weixin/authorize_snsapi_userinfo.htm";
	 //SNSAPI_BASE类型获取地址
	 public final static String REDIRECT_URI_SNSAPI_BASE="http://"+DOMAIN+"/encounterr-web/weixin/authorize_snsapi_base.htm";
	 
	 
	 
		private final static Logger log = Logger.getLogger(AnguoWxUtil.class);
	 
	 
   /**
	* token,与微信配置一致
	*/
	 private static final String token="oyqy";
	
	
	
//
//	 public static void main(String[] args) {
//	        String jsapi_ticket = "sM4AOVdWfPE4DxkXGEs8VH02Z8eyXfwBbtj-9XS3ygs_gnuGuXqFkTpIcg5LwHqwVcRNAxtuQyFiZ-_ik4V_Qg";
//
//	        // 注意 URL 一定要动态获取，不能 hardcode
//	        String url = "http://anguo.tunnel.mobi/kaosheng/weixin/jssdk.jsp";
//	        Map<String, String> ret = sign(jsapi_ticket, url);
//	        for (Map.Entry entry : ret.entrySet()) {
//	            System.out.println(entry.getKey() + ", " + entry.getValue());
//	        }
//	    };
	
	
	    
	 /**
	  * jsapi_ticket签名
	  * @param jsapi_ticket
	  * @param url
	  * @return
	 * @throws UnsupportedEncodingException 
	  */
	 public static Map<String, String> sign(String jsapi_ticket, String url)  {
		 
		    
	        Map<String, String> ret = new HashMap<String, String>();
	        String nonce_str = create_nonce_str();
	        String timestamp = create_timestamp();
	        String string1;
	        String signature = "";

	        //注意这里参数名必须全部小写，且必须有序
	        string1 = "jsapi_ticket=" + jsapi_ticket +
	                  "&noncestr=" + nonce_str +
	                  "&timestamp=" + timestamp +
	                  "&url=" + url;

	        try
	        {
	            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	            crypt.reset();
	            crypt.update(string1.getBytes("UTF-8"));
	            signature = byteToHex(crypt.digest());
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
	        catch (UnsupportedEncodingException e)
	        {
	            e.printStackTrace();
	        }

	        ret.put("url", url);
	        ret.put("jsapi_ticket", jsapi_ticket);
	        ret.put("nonceStr", nonce_str);
	        ret.put("timestamp", timestamp);
	        ret.put("signature", signature);
	        
	        ret.put("appid", AnguoWxUtil.APPID);

	        //log.info(ret);
	        return ret;
	    }

	 
	    /**
	     * 转换8进制
	     * @param hash
	     * @return
	     */
	    private static String byteToHex(final byte[] hash) {
	        Formatter formatter = new Formatter();
	        for (byte b : hash)
	        {
	            formatter.format("%02x", b);
	        }
	        String result = formatter.toString();
	        formatter.close();
	        return result;
	    }

	    private static String create_nonce_str() {
	        return UUID.randomUUID().toString();
	    }

	    private static String create_timestamp() {
	        return Long.toString(System.currentTimeMillis() / 1000);
	    }
	    
	    /**
	     * inputStream转换成字符串
	     * @param in
	     * @return
	     * @throws UnsupportedEncodingException
	     * @throws IOException
	     */
	    public static final String inputStream2String(InputStream in) throws UnsupportedEncodingException, IOException{
	        if(in == null)
	            return "";
	        
	        StringBuffer out = new StringBuffer();
	        byte[] b = new byte[4096];
	        for (int n; (n = in.read(b)) != -1;) {
	            out.append(new String(b, 0, n, "UTF-8"));
	        }
	        return out.toString();
	    }
	    
	    
	    
	    /**
		 * 微信验证检查签名
		 * @param signature
		 * @param timestamp
		 * @param nonce
		 * @return
		 */
		public static String checkSign(String timestamp,String nonce){
			
			String[] arr=new String[]{token,timestamp,nonce};
			//排序
			Arrays.sort(arr);
			
			//生成字符串
			StringBuffer content=new StringBuffer();
			for(int i=0;i<arr.length;i++)
			{
				content.append(arr[i]);
			}
			
			//sha1加密
			String temp=SHA1(content.toString());
			return temp;
		}

		
		
		/**
		 * sha1加密
		 * @param decript
		 * @return
		 */
		public static String SHA1(String decript) {
	        try {
	            MessageDigest digest = java.security.MessageDigest
	                    .getInstance("SHA-1");
	            digest.update(decript.getBytes());
	            byte messageDigest[] = digest.digest();
	            // Create Hex String
	            StringBuffer hexString = new StringBuffer();
	            // 字节数组转换为 十六进制 数
	            for (int i = 0; i < messageDigest.length; i++) {
	                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
	                if (shaHex.length() < 2) {
	                    hexString.append(0);
	                }
	                hexString.append(shaHex);
	            }
	            return hexString.toString();
	 
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
		
		
	    
	   
	    
}
