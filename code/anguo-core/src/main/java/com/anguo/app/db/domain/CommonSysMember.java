
package com.anguo.app.db.domain;


import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;


/**
 * 实体类
 * @ClassName: CommonSysMember 
 * @author Andrew.Wen
 */
public class CommonSysMember extends BaseVo  {

	
	/**
	 * 编号.
	 */
	private Integer id;
	/**
	 * uuid.
	 */
	private String uuid;
	
	/**
	 * 所属校区.
	 */
	private Integer campusId;
	/**
	 * 用户名.
	 */
	private String memberName;
	
	/**
	 * 密码.
	 */
	private String password;
	/**
	 * 电话.
	 */
	private String phone;
	/**
	 * imei.
	 */
	private String imei;
	/**
	 * imsi.
	 */
	private String imsi;
	/**
	 * 昵称.
	 */
	private String nickName;
	/**
	 * 头像.
	 */
	private String photo;
	/**
	 * 性别.
	 */
	private Integer sex;
	/**
	 * 出生日期.
	 */
	@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	@JsonSerialize(using = AnguoDateUtils.class)
	private Date birthday;
	/**
	 * 其他联系方式.
	 */
	private String contact;
	/**
	 * 积分.
	 */
	private Integer credits;
	/**
	 * 邮箱.
	 */
	private String email;
	/**
	 * 用户类别.是否招生人员，注册学员
	 */
	private Integer memberClass;
	/**
	 * 状态.
	 */
	private Integer status;
	/**
	 * 操作人.
	 */
	private Integer operateUserId;
	/**
	 * 操作时间.
	 */
	@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	@JsonSerialize(using = AnguoDateUtils.class)
	private Date operateDate;



	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public Integer getCampusId() {
		return campusId;
	}
	public void setCampusId(Integer campusId) {
		this.campusId = campusId;
	}
    
public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
    
public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
    
public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
    
public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
    
public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
    
public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    
public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
    
public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
    
public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
public Integer getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(Integer memberClass) {
		this.memberClass = memberClass;
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
}
