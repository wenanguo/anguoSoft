package com.anguo.app.db.domain;


/**
 * 所有返回结果基类，包括web接口及app
 * @author Andrew.Wen
 *
 */
public class ResultMsg<T> {
	
	/**
	 * 操作代码
	 */
	private int code;
	/**
	 * 消息描述
	 */
	private String msg;
	/**
	 * 消息对象
	 */
	private T obj;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}

}
