package com.anguo.app.db.domain;

/**
 * 验证对象
 * @author Andrew
 *
 */
public class Sign {
	
	public Sign(String uuid) {
		super();
		this.uuid = uuid;
		this.timestamp=String.valueOf(System.currentTimeMillis());
	}
	public Sign() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Sign [sign=" + sign + ", timestamp=" + timestamp + ", uuid="
				+ uuid + "]";
	}
	/**
	 * 加密后的签名字符串
	 */
	private String sign;
	
	/**
	 * 时间戳
	 */
	private String timestamp;
	
	/**
	 * uuid
	 */
	private String uuid;
	
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
