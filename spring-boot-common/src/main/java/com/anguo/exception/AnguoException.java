package com.anguo.exception;


/**
 * App异常类
 * @author Andrew.Wen
 *
 */
public class AnguoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1173368695463538257L;
	
	
	public AnguoException()
	{
		super();
	}
	
	public AnguoException(int code)
	{
		
		super();
		this.code=code;
	}
	
	public AnguoException(String message)
	{
		super(message);
	}
	
	
	/**
	 * 异常代码
	 */
	private int code;
	
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	

}
