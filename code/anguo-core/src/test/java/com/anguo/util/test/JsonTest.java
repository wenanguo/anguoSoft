package com.anguo.util.test;

import org.testng.annotations.Test;

import com.anguo.util.AnguoJsonUtil;
import com.anguo.util.AnguoRSAEncryptUtil;
import com.anguo.web.db.domain.TreeNode;

public class JsonTest {

	
	@Test
	public void test1()
	{
		TreeNode t=new TreeNode();
		
		t.setChecked(false);
		t.setId(1);
		t.setText("test");
		t.setTitle("title");
		t.setUrl("url");
		
		
		String jsonStr=AnguoJsonUtil.toJson(t);
		System.out.println(jsonStr);
		
		
		TreeNode t2=(TreeNode) AnguoJsonUtil.fromJson(jsonStr, TreeNode.class);
		System.out.println(t2);
	}
	
	
	@Test
	public void test2()
	{
		String yuan="wenanguo870623文安国";
		
		byte[] cipher =yuan.getBytes();
		
		System.out.println("1："+AnguoRSAEncryptUtil.byteArrayToString(cipher));
		
		
		
		
		
		System.out.println(new String(yuan.getBytes()));
	}
}
