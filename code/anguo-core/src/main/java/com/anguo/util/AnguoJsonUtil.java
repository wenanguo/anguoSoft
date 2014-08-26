package com.anguo.util;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * json转换工具类
 * 
 * @ClassName: PojoMapper
 * @author Andrew.Wen
 */
public class AnguoJsonUtil {

	private static ObjectMapper m = null;
	private static JsonFactory jf = null;

	static {

		m = new ObjectMapper();

		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		m.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

		m.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

		m.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		jf = new JsonFactory();
	}

	/**
	 * json转换为对象
	 * 
	 * @Title: fromJson
	 * @param jsonAsString
	 * @param pojoClass
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws IOException
	 */
	public static <T> Object fromJson(String jsonAsString, Class<T> pojoClass) {

		Object object = null;

		try {
			object = m.readValue(jsonAsString, pojoClass);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return object;
	}

	/**
	 * 对象序列化为json
	 * 
	 * @Title: toJson
	 * @param pojo
	 *            序列化对象
	 * @return
	 */
	public static String toJson(Object pojo) {
		return toJson(pojo, false);
	}

	/**
	 * 对象序列化为json
	 * 
	 * @Title: toJson
	 * @param pojo
	 *            序列化对象
	 * @param prettyPrint
	 *            是否使用正确格式输出
	 * @return
	 */
	public static String toJson(Object pojo, boolean prettyPrint) {

		StringWriter sw = new StringWriter();

		JsonGenerator jg = null;
		try {
			jg = jf.createJsonGenerator(sw);
			if (prettyPrint) {
				jg.useDefaultPrettyPrinter();
			}
			m.writeValue(jg, pojo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sw.toString();
	}

	/**
	 * 把数据源HashMap转换成json
	 * 
	 * @param map
	 */
	public static String hashMapToJson(HashMap map) {
		String string = "{";
		for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
			Entry e = (Entry) it.next();
			string += "'" + e.getKey() + "':";
			string += "'" + e.getValue() + "',";
		}
		string = string.substring(0, string.lastIndexOf(","));
		string += "}";
		return string;
	}

}