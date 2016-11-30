
package com.anguo.job.db.domain;




import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 实体类
 * @ClassName: CommonSysJob 
 * @author Andrew.Wen
 */
public class CommonSysJob extends BaseVo  {

	@Override
	public String toString() {
		return "CommonSysJob [id=" + id + ", jobName=" + jobName
				+ ", jobGroup=" + jobGroup + ", jobClass=" + jobClass
				+ ", cronExpression=" + cronExpression + ", memo=" + memo
				+ ", status=" + status + ", operateUserId=" + operateUserId
				+ ", operateDate=" + operateDate + "]";
	}
	/**
	 * 编号.
	 */
		private Integer id;
	/**
	 * 任务名称.
	 */
		private String jobName;
	/**
	 * 任务分组.
	 */
		private String jobGroup;
	/**
	 * 作业类.
	 */
		private String jobClass;
	/**
	 * 任务运行表达式.
	 */
		private String cronExpression;
	/**
	 * 任务描述.
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
    
public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
    
public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
    
public String getJobClass() {
		return jobClass;
	}
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}
    
public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
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
