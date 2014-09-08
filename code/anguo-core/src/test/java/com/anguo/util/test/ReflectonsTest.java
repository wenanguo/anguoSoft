package com.anguo.util.test;

import org.testng.annotations.Test;

import com.anguo.util.AnguoReflections;

public class ReflectonsTest {

	
	@Test
	public void getCodeTest()
	{
		Class<?> demo1=null;
       
        try{
            //一般尽量采用这种形式
            demo1=Class.forName("com.anguo.mybatis.db.controller.BaseController");
            
            System.out.println(AnguoReflections.getClassAnnotation(demo1));
            
            System.out.println(AnguoReflections.getMethodAnnotation(demo1,"getSecuritySessionUser"));
            
        }catch(Exception e){
            e.printStackTrace();
        }
		
		System.out.println("wewe");
	}
}
