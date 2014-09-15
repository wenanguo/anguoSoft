package com.anguo.util.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.annotations.Test;
import com.anguo.app.db.domain.CommonAppSiData;
import com.anguo.app.db.domain.ResultMsg;
import com.anguo.app.db.domain.ResultMsgList;
import com.anguo.util.AnguoJsonUtil;
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
		t.setOperateDate(new Date());
		
		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		
		
		String jsonStr=AnguoJsonUtil.toJson(t);
		System.out.println(jsonStr);
		
		
		CommonAppSiData t2=AnguoJsonUtil.fromJson(jsonStr, CommonAppSiData.class);
		System.out.println(t2);
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException
	{
		String json="{\"code\":100,\"msg\":null,\"obj\":{\"dataName\":\"wenanguo\",\"operateDate\":\"2014-09-11 17:39:27\"}}";
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
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
		
		
		System.out.println(lst.getCode());
		System.out.println(lst.getObj().toString());
	}
	
	@Test
	public void test4() throws JsonParseException, JsonMappingException, IOException
	{
		List<CommonAppSiData> list=new ArrayList<CommonAppSiData>();
		CommonAppSiData c1=new CommonAppSiData();
		c1.setMemo("备注");
		c1.setOperateDate(new Date());
		list.add(c1);
		
		
		String json=AnguoJsonUtil.toJson(list);
		System.out.println(json);
		//String json="{\"code\":100,\"msg\":null,\"obj\":{\"dataName\":\"wenanguo\"}}";
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, CommonAppSiData.class); 
		List<CommonAppSiData> lst =  mapper.readValue(json, javaType); 		
		
		
		System.out.println(lst.toString());
	}
	
	
	@Test
	public void test5() throws JsonParseException, JsonMappingException, IOException
	{
		List<CommonAppSiData> list=new ArrayList<CommonAppSiData>();
		CommonAppSiData c1=new CommonAppSiData();
		c1.setMemo("备注");
		c1.setOperateDate(new Date());
		list.add(c1);
		
		
		ResultMsgList<CommonAppSiData> rlm=new ResultMsgList<CommonAppSiData>(); 
		//rlm.setList(list);
		
		String json=AnguoJsonUtil.toJson(rlm);
		System.out.println(json);

		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ResultMsgList.class,CommonAppSiData.class); 
		ResultMsgList<CommonAppSiData> lst =  mapper.readValue(json, javaType); 		
		
		
		
		
		System.out.println(lst.toString());
	}
	
	
	@Test
	public void test6() throws JsonParseException, JsonMappingException, IOException
	{
		List<CommonAppSiData> list=new ArrayList<CommonAppSiData>();
		CommonAppSiData c1=new CommonAppSiData();
		c1.setMemo("备注");
		c1.setOperateDate(new Date());
		list.add(c1);
		
		
		ResultMsgList<CommonAppSiData> rlm=new ResultMsgList<CommonAppSiData>(); 
		rlm.setObj(list);
		
		String json=AnguoJsonUtil.toJson(rlm);
		System.out.println(json);

		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		
		
		//ResultMsgList<CommonAppSiData> lst =  mapper.readValue(json, new TypeReference<ResultMsgList<CommonAppSiData>>() { }); 		
		
		//ResultMsgList<CommonAppSiData> lst =  AnguoJsonUtil.fromJson(json, new TypeReference<ResultMsgList<CommonAppSiData>>() { });
		
		
		//System.out.println(lst.getObj().toString());
	}
	
	@Test
	public void test7() throws JsonParseException, JsonMappingException, IOException
	{
		List<CommonAppSiData> list=new ArrayList<CommonAppSiData>();
		CommonAppSiData c1=new CommonAppSiData();
		c1.setMemo("备注");
		c1.setOperateDate(new Date());
		list.add(c1);
		
		
		ResultMsgList<CommonAppSiData> rlm=new ResultMsgList<CommonAppSiData>(); 
		rlm.setObj(list);
		
		String json=AnguoJsonUtil.toJson(rlm);
		System.out.println(json);

		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		
		
		//ResultMsgList<CommonAppSiData> lst =  mapper.readValue(json, new TypeReference<ResultMsgList<CommonAppSiData>>() { }); 		
		
		ResultMsg<List<CommonAppSiData>> lst =  AnguoJsonUtil.fromJson(json, new ResultMsg<List<CommonAppSiData>>().getClass());
		
		
		System.out.println(lst.getObj().toString());
	}
	
	@Test
	public void test8() throws JsonParseException, JsonMappingException, IOException
	{
		List<CommonAppSiData> list=new ArrayList<CommonAppSiData>();
		CommonAppSiData c1=new CommonAppSiData();
		c1.setMemo("备注");
		c1.setOperateDate(new Date());
		list.add(c1);
		
		
		ResultMsgList<CommonAppSiData> rlm=new ResultMsgList<CommonAppSiData>(); 
		rlm.setObj(list);
		
		String json=AnguoJsonUtil.toJson(rlm);
		System.out.println(json);

		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ResultMsg.class,new ArrayList<CommonAppSiData>().getClass());  		
		
		ResultMsg<List<CommonAppSiData>> lst =  mapper.readValue(json, javaType);
		
		
		System.out.println(lst.getObj().toString());
	}
	
	
	
}
