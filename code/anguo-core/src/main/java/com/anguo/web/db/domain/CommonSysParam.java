package com.anguo.web.db.domain;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;

/**
 * 系统参数实体类
 * 
 * @ClassName: CommonSysParam
 * @author Andrew.Wen
 */
public class CommonSysParam extends BaseVo {

	/**
	 * 编号.
	 */
	private Integer id;
	/**
	 * 所属类别.
	 */
	private Integer commonSysClassId;
	/**
	 * 参数名称.
	 */
	private String name;
	/**
	 * 参数值.
	 */
	private String value;
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
	@DateTimeFormat(pattern = AnguoDateUtils.C_TIME_PATTON_DEFAULT)
	@JsonSerialize(using = AnguoDateUtils.class)
	private Date operateDate;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommonSysClassId() {
		return commonSysClassId;
	}

	public void setCommonSysClassId(Integer commonSysClassId) {
		this.commonSysClassId = commonSysClassId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
