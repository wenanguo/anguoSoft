package com.anguo.app.db.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 接口参数实体类
 * 
 * @ClassName: CommonAppSiData
 * @author Andrew.Wen
 */
public class CommonAppSiData extends BaseVo {

	@Override
	public String toString() {
		return "CommonAppSiData [id=" + id + ", commonAppSiDefineId="
				+ commonAppSiDefineId + ", dataName=" + dataName
				+ ", dataTitle=" + dataTitle + ", dataType=" + dataType
				+ ", paramType=" + paramType + ", dataPattern=" + dataPattern
				+ ", memo=" + memo + ", dataDefaultVal=" + dataDefaultVal
				+ ", parentId=" + parentId + ", status=" + status
				+ ", operateUserId=" + operateUserId + ", operateDate="
				+ operateDate + "]";
	}

	/**
	 * 编号.
	 */
	private Integer id;
	/**
	 * 所属接口.
	 */
	private Integer commonAppSiDefineId;
	/**
	 * 参数名.
	 */
	private String dataName;
	/**
	 * 标题.
	 */
	private String dataTitle;
	/**
	 * 数据类型.
	 */
	private String dataType;
	/**
	 * 参数类型.1入参，2出参
	 */
	private String paramType;

	/**
	 * 表达式.
	 */
	private String dataPattern;
	/**
	 * 备注.
	 */
	private String memo;
	/**
	 * 默认值.
	 */
	private String dataDefaultVal;
	/**
	 * 父节点.
	 */
	private Integer parentId;
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

	public Integer getCommonAppSiDefineId() {
		return commonAppSiDefineId;
	}

	public void setCommonAppSiDefineId(Integer commonAppSiDefineId) {
		this.commonAppSiDefineId = commonAppSiDefineId;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataTitle() {
		return dataTitle;
	}

	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataPattern() {
		return dataPattern;
	}

	public void setDataPattern(String dataPattern) {
		this.dataPattern = dataPattern;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDataDefaultVal() {
		return dataDefaultVal;
	}

	public void setDataDefaultVal(String dataDefaultVal) {
		this.dataDefaultVal = dataDefaultVal;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	@JsonSerialize(using = AnguoDateUtils.class)
	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

}
