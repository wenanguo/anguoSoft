package com.anguo.app.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.anguo.app.db.domain.CommonSysMember;
import com.anguo.app.db.domain.ResultMsg;
import com.anguo.util.AnguoEncryptUtil;
import com.anguo.util.AnguoJsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;



public class AppTest {
	
	/**
	 * 服务器地址
	 */
	public static final String ServerUrl = "http://127.0.0.1:8091/anguosoft/";
	

	@Test
	public void  test1() throws IOException {

		String url = ServerUrl + "login.app";

		DefaultHttpClient httpClient = new DefaultHttpClient();

		List<BasicNameValuePair> paramMap = new ArrayList<BasicNameValuePair>();

		
		
		CommonSysMember member=new CommonSysMember();
		member.setMemberName("wenanguo");
		member.setPassword("123456");
		
		String param=AnguoJsonUtil.toJson(member);
		
		
		// 参数json格式
		//String param = "{\"cinemaId\":\"4067\",\"date\":\"2014-03-28\"}";

		// 进行BASE64加密
		//param = encryptBASE64(param);

		//业务参数
		paramMap.add(new BasicNameValuePair("reqParam", AnguoEncryptUtil.encryptBASE64(param.getBytes())));
		//系统参数
		paramMap.add(new BasicNameValuePair("appParam", AnguoEncryptUtil.encryptBASE64("{osVision:10}".getBytes())));
		//用户参数
		paramMap.add(new BasicNameValuePair("userParam", AnguoEncryptUtil.encryptBASE64("{sign:abc}".getBytes())));

		HttpPost httppost = new HttpPost(url);

		try {
			HttpEntity re = new UrlEncodedFormEntity(paramMap, HTTP.UTF_8);

			httppost.setEntity(re);

			// 返回对象
			HttpResponse response = httpClient.execute(httppost);

			String result = EntityUtils.toString(response.getEntity());

			System.out.println(result);
			
			ResultMsg<CommonSysMember> messages= AnguoJsonUtil.fromJson(result, new TypeReference<ResultMsg<CommonSysMember>>(){});
			System.out.println(messages.getCode());
			System.out.println(messages.getMsg());
			System.out.println(messages.getObj().getMemberName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

	}
	
}
