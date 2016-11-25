package com.anguo.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http工具类
 * 
 * @author Andrew.Wen
 *
 */
public class AnguoHttpUtil {

	public static String getMethod(String url) {
		
		String retStr="";
		
		
		try {
			// HttpClient主要负责执行请求
			HttpClient httpclient = new DefaultHttpClient();
			// 利用HTTP GET向服务器发起请求
			HttpGet get = new HttpGet(url);// new
																// HttpGet("http://localhost:8080/cms");
			// 获得服务器响应的的所有信息
			HttpResponse response = httpclient.execute(get);
			// 获得服务器响应回来的消息体（不包括HTTP HEAD）
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 获得响应的字符集编码信息
				// 即获取HTTP HEAD的： ContentType:text/html;charset=UTF-8中的字符集信息
				String charset = EntityUtils.getContentCharSet(entity);
				//System.out.println("响应的字符集是： " + charset);
				InputStream is = entity.getContent();
				// 使用响应中的编码来解释响应的内容
				if(charset==null){
					charset="utf-8";
				}
				
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, charset));
				String line = null;
				while ((line = br.readLine()) != null) {
					//System.out.println(line);
					retStr+=line;
				}
				is.close();
			}
			// 释放所有的链接资源，一般在所有的请求处理完成之后，才需要释放
			httpclient.getConnectionManager().shutdown();
			
			//返回请求结果
			return retStr;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public static String postMethod(String url,Map<String,String> params) {
		
		String retStr="";
		
		
		try {
			
			// HttpClient主要负责执行请求
			HttpClient httpclient = new DefaultHttpClient();
			
			HttpPost post = new HttpPost(url);
			
			if(params!=null){
				
				//添加POST参数
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				
				for (String key : params.keySet()) {
					   nvps.add(new BasicNameValuePair(key,params.get(key)));
				}
				
				post.setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
			}
					
					
					
			// 获得服务器响应的的所有信息
			HttpResponse response = httpclient.execute(post);
			// 获得服务器响应回来的消息体（不包括HTTP HEAD）
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 获得响应的字符集编码信息
				// 即获取HTTP HEAD的： ContentType:text/html;charset=UTF-8中的字符集信息
				String charset = EntityUtils.getContentCharSet(entity);
				//System.out.println("响应的字符集是： " + charset);
				InputStream is = entity.getContent();
				// 使用响应中的编码来解释响应的内容
				if(charset==null){
					charset="utf-8";
				}
				
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, charset));
				String line = null;
				while ((line = br.readLine()) != null) {
					//System.out.println(line);
					retStr+=line;
				}
				is.close();
			}
			// 释放所有的链接资源，一般在所有的请求处理完成之后，才需要释放
			httpclient.getConnectionManager().shutdown();
			
			//返回请求结果
			return retStr;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
