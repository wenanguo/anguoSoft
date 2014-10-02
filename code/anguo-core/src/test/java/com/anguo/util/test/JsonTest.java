package com.anguo.util.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.anguo.app.db.domain.CommonAppSiData;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.mybatis.db.core.PageResultList;
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
		
		
		CommonAppSiData t2=AnguoJsonUtil.fromJson(jsonStr, new TypeReference<CommonAppSiData>(){});
		Assert.assertEquals(t2.getMemo(), "wenanguo");
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException
	{
		String json="{\"code\":100,\"msg\":null,\"rows\":{\"dataName\":\"wenanguo\",\"operateDate\":\"2014-09-11 17:39:27\"}}";
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		//String json = "{\"error\":0, \"results\":{\"AppId\": \"werewrfasdf\", \"AppKey\":\"wqrfdsafdzsjkfhjadh\"}}";
		
		PageResult<CommonAppSiData> call = mapper.readValue(json, new TypeReference<PageResult<CommonAppSiData>>() {});
		
		System.out.println(call.toString());
		System.out.println(call.getRows().toString());
	}
	
	
	@Test
	public void test3() throws JsonParseException, JsonMappingException, IOException
	{
		String json="{\"code\":100,\"msg\":null,\"rows\":{\"dataName\":\"wenanguo\"}}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(PageResult.class, CommonAppSiData.class); 
		PageResult<CommonAppSiData> lst =  mapper.readValue(json, javaType); 		
		
		
		System.out.println(lst.getCode());
		System.out.println(lst.getRows().toString());
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
		
		
		PageResultList<CommonAppSiData> rlm=new PageResultList<CommonAppSiData>(); 
		//rlm.setList(list);
		
		String json=AnguoJsonUtil.toJson(rlm);
		System.out.println(json);

		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(PageResultList.class,CommonAppSiData.class); 
		PageResultList<CommonAppSiData> lst =  mapper.readValue(json, javaType); 		
		
		
		
		
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
		
		
		PageResultList<CommonAppSiData> rlm=new PageResultList<CommonAppSiData>(); 
		rlm.setRows(list);
		
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
		
		
		PageResultList<CommonAppSiData> rlm=new PageResultList<CommonAppSiData>(); 
		rlm.setRows(list);
		
		String json=AnguoJsonUtil.toJson(rlm);
		System.out.println(json);

		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		
		
		//ResultMsg<List<CommonAppSiData>> lst =  mapper.readValue(json, new TypeReference<ResultMsg<List<CommonAppSiData>>>() { }); 		
		
		//ResultMsgList<CommonAppSiData> lst2 =  AnguoJsonUtil.fromJson(json, new ResultMsgList<CommonAppSiData>().getClass());
		
		//ResultMsg<List<CommonAppSiData>> lst=AnguoJsonUtil.fromJson(json, new TypeReference<ResultMsg<List<CommonAppSiData>>>() { });
		
//		for(CommonAppSiData cas : lst.getObj()){
//				
//				Assert.assertEquals(cas.getMemo(),"备注");
//			}
	}
	
	@Test
	public void test8() throws JsonParseException, JsonMappingException, IOException
	{
		List<CommonAppSiData> list=new ArrayList<CommonAppSiData>();
		CommonAppSiData c1=new CommonAppSiData();
		c1.setMemo("备注");
		c1.setOperateDate(new Date());
		list.add(c1);
		
		
		PageResultList<CommonAppSiData> rlm=new PageResultList<CommonAppSiData>(); 
		rlm.setRows(list);
		
		String json=AnguoJsonUtil.toJson(rlm);
		System.out.println(json);

		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(PageResult.class,new ArrayList<CommonAppSiData>().getClass());  		
		
		PageResult<List<CommonAppSiData>> lst =  mapper.readValue(json, javaType);
		
		//for(CommonAppSiData cas : lst.getObj()){
			
		System.out.println(lst);
		
	}
	
	
	@Test
	public void test9() throws JsonGenerationException, JsonMappingException, IOException
	{
		Map map=new HashMap();
		
		map.put("memo", "wenanguo");
		
		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		String jsonStr=AnguoJsonUtil.toJson(map);
		System.out.println(jsonStr);
		
		
		CommonAppSiData t2=AnguoJsonUtil.fromJson(jsonStr, new TypeReference<CommonAppSiData>(){});
		Assert.assertEquals(t2.getMemo(), "wenanguo");
	}
	
	
	
}
