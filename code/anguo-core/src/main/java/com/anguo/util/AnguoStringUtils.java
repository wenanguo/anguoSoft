package com.anguo.util;


/**
 * 字符串工具类
 * @author Andrew.Wen
 *
 */
public class AnguoStringUtils {
	
	
	/**
	 * 根据属性名获得get方法名称
	 * @param field 属性名
	 * @return
	 * @throws Exception
	 */
	public static String getGetMethodName(String field) throws Exception
	{
		if(field!=null&&field.length()>0)
		{
			return "get"+field.substring(0,1).toUpperCase()+field.substring(1);
		}else
		{
			throw new Exception("属性值不能为空，请检查参数");
		}
	}
	
	/**
	 * 根据属性名获得Set方法名称
	 * @param field 属性名
	 * @return
	 * @throws Exception
	 */
	public static String getSetMethodName(String field) throws Exception
	{
		if(field!=null&&field.length()>0)
		{
			return "set"+field.substring(0,1).toUpperCase()+field.substring(1);
		}else
		{
			throw new Exception("属性值不能为空，请检查参数");
		}
	}

}
