package com.anguo.mongo.db.domain;

import com.anguo.mybatis.db.core.BaseVo;

/**
 * mongodb基类
 * @author Andrew.Wen
 *
 */
public class BaseMongoVo extends BaseVo {

	/**
	 * 默认主键，支持mongodb
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
