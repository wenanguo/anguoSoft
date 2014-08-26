package com.anguo.domain;

import com.anguo.mongo.db.domain.BaseMongoVo;

public class User extends BaseMongoVo {
	



	@Override
	public String toString() {
		return "User [username=" +super.getId()+ username + ", password=" + password + "]";
	}

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
