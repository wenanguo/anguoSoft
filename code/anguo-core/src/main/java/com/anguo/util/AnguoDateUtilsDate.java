package com.anguo.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;




/**
 * 自定义返回JSON 数据格中日期格式化处理
 *
 * @author Andrew.Wen
 */
public class AnguoDateUtilsDate extends JsonSerializer<Date> {
	
	/**
	 * 绑定spring jackon字符串序列化
	 */
	@Override
	public void serialize(Date value, JsonGenerator jgen,
			org.codehaus.jackson.map.SerializerProvider provider)
			throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat(AnguoDateUtils.C_DATE_PATTON_DEFAULT);
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}

}