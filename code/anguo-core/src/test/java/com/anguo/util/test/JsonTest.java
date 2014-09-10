package com.anguo.util.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.anguo.app.db.domain.CommonAppSiData;
import com.anguo.app.db.domain.ResultMsg;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	
	@Test
	public void test1() throws JsonGenerationException, JsonMappingException, IOException
	{
		CommonAppSiData t=new CommonAppSiData();
		
		t.setMemo("wenanguo");
		
		
		ObjectMapper mapper = new ObjectMapper();
		//mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		
		String jsonStr=mapper.writeValueAsString(t);
		System.out.println(jsonStr);
		
		
		CommonAppSiData t2=mapper.readValue(jsonStr, CommonAppSiData.class);
		System.out.println(t2);
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException
	{
		String json="{\"code\":100,\"msg\":null,\"obj\":{\"dataName\":\"wenanguo\"}}";
		
		ObjectMapper mapper = new ObjectMapper();
		//String json = "{\"error\":0, \"results\":{\"AppId\": \"werewrfasdf\", \"AppKey\":\"wqrfdsafdzsjkfhjadh\"}}";
		
		ResultMsg<CommonAppSiData> call = mapper.readValue(json, new TypeReference<ResultMsg<CommonAppSiData>>() {});
		
		System.out.println(call.toString());
		System.out.println(call.getObj().toString());
	}
	
	@Test
	public void test3() throws JsonParseException, JsonMappingException, IOException
	{
		String json="{\"code\":100,\"msg\":null,\"obj\":{\"dataName\":\"wenanguo\"}}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ResultMsg.class, CommonAppSiData.class); 
		ResultMsg<CommonAppSiData> lst =  mapper.readValue(json, javaType); 		
		
		
		System.out.println(lst.toString());
		System.out.println(lst.getObj().toString());
	}
	
	
	
}
