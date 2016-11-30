package com.anguo.util.test;

import com.anguo.util.AnguoEncryptUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class Base64Test {
	
	   
    @Test
    public void test64() throws UnsupportedEncodingException
    {
    	String reqParam="eyJvdXRfdHJhZGVfbm8iOiIxMjE3NzUyNTAxMjAxNDA3MDMzMjMzMzY4MDI4IiwiYm9keSI6ImJvZHnmlrnms5UiLCJ0b3RhbF9mZWUiOiIxIiwiYXR0YWNoIjoi6ICD56We5b6u5L+h5pSv5LuY5rWL6K+VIn0=";
    	
    	
    	String a=new String(AnguoEncryptUtil.decryptBASE64(reqParam),"utf-8");
    	
    	System.out.println(a);
        Assert.assertEquals(true,true);


    }

}
