package com.anguo.mybatis.db.core;

import com.anguo.util.AnguoStatusUtil;

/**
 * 页面返回结果类
 * @author Andrew.Wen
 *
 * @param <T>
 */
public class PageResult<T> {
	
	

	@Override
	public String toString() {
		return "PageResult [total=" + total + ", page=" + page + ", rows="
				+ rows + ", code=" + code + ", msg=" + msg + "]";
	}

	private int total;
	
	private int page;
	
	private T rows;
	
	
	/**
	 * 操作代码
	 */
	private int code=AnguoStatusUtil.INTERFACE_SUCCESS;
	/**
	 * 消息描述
	 */
	private String msg;
	
	
	
	public PageResult() {
		super();
		this.msg=AnguoStatusUtil.getUserInfo(this.code);
	}
	
	public PageResult(int code) {
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

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
