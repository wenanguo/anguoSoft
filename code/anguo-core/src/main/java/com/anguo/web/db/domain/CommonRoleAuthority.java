
package com.anguo.web.db.domain;




import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.util.AnguoDateUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 实体类
 * @ClassName: CommonRoleAuthority 
 * @author Andrew.Wen
 */
public class CommonRoleAuthority extends BaseVo  {

	/**
	 * .
	 */
		private Integer id;
	/**
	 * .
	 */
		private Integer commonSysRoleId;
	/**
	 * .
	 */
		private Integer commonSysAuthorityId;




    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public Integer getCommonSysRoleId() {
		return commonSysRoleId;
	}
	public void setCommonSysRoleId(Integer commonSysRoleId) {
		this.commonSysRoleId = commonSysRoleId;
	}
    
public Integer getCommonSysAuthorityId() {
		return commonSysAuthorityId;
	}
	public void setCommonSysAuthorityId(Integer commonSysAuthorityId) {
		this.commonSysAuthorityId = commonSysAuthorityId;
	}
	
}
