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

import com.anguo.util.AnguoJsonUtil;
import com.anguo.web.db.domain.TreeNode;

public class AppTest {
	
	/**
	 * 服务器地址
	 */
	public static final String ServerUrl = "http://127.0.0.1:8080/anguosoft/";
	

	@Test
	public void  test1() throws IOException {

		String url = ServerUrl + "login.app";

		DefaultHttpClient httpClient = new DefaultHttpClient();

		List<BasicNameValuePair> paramMap = new ArrayList<BasicNameValuePair>();

		
		
		TreeNode t=new TreeNode();
		
		t.setChecked(false);
		t.setId(147258369);
		t.setText("test1");
		t.setTitle("title2");
		t.setUrl("url3");
		
		
		String param=AnguoJsonUtil.toJson(t);
		
		
		// 参数json格式
		//String param = "{\"cinemaId\":\"4067\",\"date\":\"2014-03-28\"}";

		// 进行BASE64加密
		//param = encryptBASE64(param);

		paramMap.add(new BasicNameValuePair("reqParam", param));

		HttpPost httppost = new HttpPost(url);

		try {
			HttpEntity re = new UrlEncodedFormEntity(paramMap, HTTP.UTF_8);

			httppost.setEntity(re);

			// 返回对象
			HttpResponse response = httpClient.execute(httppost);

			String result = EntityUtils.toString(response.getEntity());

			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

	}
	
}
