package com.anguo.log.db.domain;

import com.anguo.mongo.db.domain.BaseMongoVo;

/**
 * 实体类
 * 
 * @ClassName: CommonOperateLog
 * @author Andrew.Wen
 */
public class CommonOperateLog extends BaseMongoVo {

	@Override
	public String toString() {
		return "CommonOperateLog [runtimeClass=" + runtimeClass
				+ ", runtimeMethod=" + runtimeMethod + ", createtime="
				+ createtime + ", loglevel=" + loglevel + ", logmsg=" + logmsg
				+ ", userId=" + userId + ", userType=" + userType + "]"+super.getId();
	}

	
	/**
	 * .
	 */
	private String runtimeClass;
	/**
	 * .
	 */
	private String runtimeMethod;
	/**
	 * .
	 */
	private String createtime;
	/**
	 * .
	 */
	private String loglevel;
	/**
	 * .
	 */
	private String logmsg;
	/**
	 * .
	 */
	private String userId;
	/**
	 * .
	 */
	private String userType;

	public String getRuntimeClass() {
		return runtimeClass;
	}

	public void setRuntimeClass(String runtimeClass) {
		this.runtimeClass = runtimeClass;
	}

	public String getRuntimeMethod() {
		return runtimeMethod;
	}

	public void setRuntimeMethod(String runtimeMethod) {
		this.runtimeMethod = runtimeMethod;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getLoglevel() {
		return loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	public String getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
