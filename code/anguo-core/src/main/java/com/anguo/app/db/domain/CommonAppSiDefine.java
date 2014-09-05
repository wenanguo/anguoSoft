
package com.anguo.app.db.domain;




import java.util.Date;
import com.anguo.mybatis.db.core.BaseVo;


/**
 * 接口定义实体类
 * @ClassName: CommonAppSiDefine 
 * @author Andrew.Wen
 */
public class CommonAppSiDefine extends BaseVo  {

	/**
	 * 编号.
	 */
	private Integer id;
	/**
	 * 接口分类编号.
	 */
	private Integer siType;
	/**
	 * 接口编码.
	 */
	private String siService;
	/**
	 * 接口名称.
	 */
	private String siName;
	/**
	 * 模拟接口.
	 */
	private Integer siDemo;
	/**
	 * 开启日志.
	 */
	private Integer siLogging;
	/**
	 * 授权访问.
	 */
	private Integer siAuthAccess;
	
	/**
	 * 加密方式
	 */
	private Integer siEncryptionWay;
	
	/**
	 * 多行.
	 */
	private Integer siMultiResult;
	/**
	 * bean名称.
	 */
	private String siServiceName;
	/**
	 * bean方法.
	 */
	private String siServiceMethod;
	/**
	 * 备注.
	 */
	private String memo;
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
	private Date operateDate;




    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public Integer getSiType() {
		return siType;
	}
	public void setSiType(Integer siType) {
		this.siType = siType;
	}
	public Integer getSiEncryptionWay() {
		return siEncryptionWay;
	}
	public void setSiEncryptionWay(Integer siEncryptionWay) {
		this.siEncryptionWay = siEncryptionWay;
	}
public String getSiService() {
		return siService;
	}
	public void setSiService(String siService) {
		this.siService = siService;
	}
    
public String getSiName() {
		return siName;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}
    
public Integer getSiDemo() {
		return siDemo;
	}
	public void setSiDemo(Integer siDemo) {
		this.siDemo = siDemo;
	}
    
public Integer getSiLogging() {
		return siLogging;
	}
	public void setSiLogging(Integer siLogging) {
		this.siLogging = siLogging;
	}
    
public Integer getSiAuthAccess() {
		return siAuthAccess;
	}
	public void setSiAuthAccess(Integer siAuthAccess) {
		this.siAuthAccess = siAuthAccess;
	}
    
public Integer getSiMultiResult() {
		return siMultiResult;
	}
	public void setSiMultiResult(Integer siMultiResult) {
		this.siMultiResult = siMultiResult;
	}
    
public String getSiServiceName() {
		return siServiceName;
	}
	public void setSiServiceName(String siServiceName) {
		this.siServiceName = siServiceName;
	}
    
public String getSiServiceMethod() {
		return siServiceMethod;
	}
	public void setSiServiceMethod(String siServiceMethod) {
		this.siServiceMethod = siServiceMethod;
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
	
}
