
package com.anguo.web.db.domain;


import com.anguo.mybatis.db.core.BaseVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 实体类
 *
 * @author Andrew.Wen
 * @ClassName: CommonRoleInfo
 */
public class CommonRoleInfo extends BaseVo {

    /**
     * .
     */
    private Integer id;
    /**
     * .
     */
    private String roleCode;
    /**
     * .
     */
    private String roleName;
    /**
     * .
     */
    private Integer roleOrder;
    /**
     * .
     */
    private String roleRemark;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleOrder() {
        return roleOrder;
    }

    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
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

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

}
