
package com.anguo.app.db.domain;




import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;


/**
 * 实体类
 * @ClassName: CommonAppLoggedUser 
 * @author Andrew.Wen
 */
public class CommonAppLoggedUser extends BaseVo  {

	@Override
	public String toString() {
		return "CommonAppLoggedUser [id=" + id + ", uuid=" + uuid
				+ ", memberId=" + memberId + ", phoneBrand=" + phoneBrand
				+ ", channelFlag=" + channelFlag + ", appBetaFlag="
				+ appBetaFlag + ", phoneDeviceId=" + phoneDeviceId
				+ ", innerVersion=" + innerVersion + ", externalVersion="
				+ externalVersion + ", osType=" + osType + ", osVersion="
				+ osVersion + ", phoneModel=" + phoneModel + ", imsi=" + imsi
				+ ", imei=" + imei + ", sign=" + sign + ", appCode=" + appCode
				+ ", status=" + status + ", operateUserId=" + operateUserId
				+ ", operateDate=" + operateDate + "]";
	}
	/**
	 * 编号.
	 */
	private Integer id;
	/**
	 * uuid.
	 */
	private String uuid;
	/**
	 * 会员编号.
	 */
	private Integer memberId;
	/**
	 * 手机品牌.
	 */
	private String phoneBrand;
	/**
	 * 渠道编号.
	 */
	private Integer channelFlag;
	/**
	 * 版本类别.
	 */
	private Integer appBetaFlag;
	/**
	 * 设备编号.
	 */
	private String phoneDeviceId;
	/**
	 * 内部版本号.
	 */
	private String innerVersion;
	/**
	 * 外部版本号.
	 */
	private String externalVersion;
	/**
	 * 操作系统.
	 */
	private String osType;
	/**
	 * 操作系统版本.
	 */
	private String osVersion;
	/**
	 * 手机型号.
	 */
	private String phoneModel;
	/**
	 * imsi.
	 */
	private String imsi;
	/**
	 * imei.
	 */
	private String imei;
	/**
	 * 签名信息.
	 */
	private String sign;
	/**
	 * app_code.
	 */
	private String appCode;
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




    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
    
public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
    
public String getPhoneBrand() {
		return phoneBrand;
	}
	public void setPhoneBrand(String phoneBrand) {
		this.phoneBrand = phoneBrand;
	}
    
public Integer getChannelFlag() {
		return channelFlag;
	}
	public void setChannelFlag(Integer channelFlag) {
		this.channelFlag = channelFlag;
	}
    
public Integer getAppBetaFlag() {
		return appBetaFlag;
	}
	public void setAppBetaFlag(Integer appBetaFlag) {
		this.appBetaFlag = appBetaFlag;
	}
    
public String getPhoneDeviceId() {
		return phoneDeviceId;
	}
	public void setPhoneDeviceId(String phoneDeviceId) {
		this.phoneDeviceId = phoneDeviceId;
	}
    
public String getInnerVersion() {
		return innerVersion;
	}
	public void setInnerVersion(String innerVersion) {
		this.innerVersion = innerVersion;
	}
    
public String getExternalVersion() {
		return externalVersion;
	}
	public void setExternalVersion(String externalVersion) {
		this.externalVersion = externalVersion;
	}
    
public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
    
public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
    
public String getPhoneModel() {
		return phoneModel;
	}
	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}
    
public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
    
public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
    
public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
    
public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
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
