package com.anguo.web.db.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;


/**
 * 用户实体类，继承UserDetailss实现spring security权限验证
 * 
 * @author Andrew.Wen
 */
public class CommonSysUser extends BaseVo implements UserDetails {

	public CommonSysUser(String userName, String password,
			Set<GrantedAuthority> authorities) {
		super();
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
	}

	public CommonSysUser() {
		super();
	}

	@Override
	public String toString() {
		return "CommonSysUser [id=" + id + ", userName=" + userName
				+ ", password=" + password + ", realName=" + realName
				+ ", birthday=" + birthday + ", email=" + email + ", phone="
				+ phone + ", memo=" + memo + ", status=" + status
				+ ", operateUserId=" + operateUserId + ", operateDate="
				+ operateDate + ", authorities=" + authorities + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2607026848568566102L;

	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private String userName;
	/**
	 * .
	 */
	private String password;
	/**
	 * .
	 */
	private String realName;
	/**
	 * .
	 */
	@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	@JsonSerialize(using = AnguoDateUtils.class)
	private Date birthday;
	/**
	 * .
	 */
	private String email;
	/**
	 * .
	 */
	private String phone;
	/**
	 * .
	 */
	private String memo;
	/**
	 * .
	 */
	private Integer status;
	/**
	 * .
	 */
	private Integer operateUserId;
	/**
	 * .
	 */
	@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	@JsonSerialize(using = AnguoDateUtils.class)
	private Date operateDate;

	// 实现了UserDetails之后的相关变量
	private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(0);

	/**
	 * get set 方法
	 * 
	 */
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOperateUserId() {
		return operateUserId;
	}

	public void setOperateUserId(Integer operateUserId) {
		this.operateUserId = operateUserId;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	/**
	 * spring security 鉴权重载方法
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.authorities;
	}

	@Override
	public String getUsername() {

		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
