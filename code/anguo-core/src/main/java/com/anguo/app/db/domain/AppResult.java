package com.anguo.app.db.domain;

import com.anguo.util.AnguoStatusUtil;


/**
 * 所有返回结果基类，包括web接口及app
 * @author Andrew.Wen
 *
 */
public class AppResult<T> {
	
	
	@Override
	public String toString() {
		return "ResultMsg [code=" + code + ", msg=" + msg + ", obj=" + obj
				+ "]";
	}
	/**
	 * 操作代码
	 */
	private int code=ConstantClass.INTERFACE_SUCCESS;
	/**
	 * 消息描述
	 */
	private String msg;
	/**
	 * 消息对象
	 */
	private T obj;
	
	public AppResult() {
		super();
		this.msg=AnguoStatusUtil.getUserInfo(this.code);
	}
	
	public AppResult(int code) {
		super();
		this.code = code;
		this.msg=AnguoStatusUtil.getUserInfo(this.code);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
		this.msg=AnguoStatusUtil.getUserInfo(code);
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
