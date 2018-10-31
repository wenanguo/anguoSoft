
package com.anguo.web.db.domain;


import com.anguo.mybatis.db.core.BaseVo;


/**
 * 实体类
 * @ClassName: User 
 * @author Andrew.Wen
 */
public class User extends BaseVo  {

	/**
	 * .
	 */
		private Integer id;
	/**
	 * .
	 */
		private String name;
	/**
	 * .
	 */
		private String password;
	/**
	 * .
	 */
		private Integer age;




    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
