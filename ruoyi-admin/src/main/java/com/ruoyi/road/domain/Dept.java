package com.ruoyi.road.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 高速公路相关部门管理对象 dept
 * 
 * @author lzx
 * @date 2024-11-15
 */
public class Dept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键（部门id） */
    private Long deptId;

    /** 上级部门 */
    @Excel(name = "上级部门")
    private Long parentId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 部门领导 */
    @Excel(name = "部门领导")
    private String leader;

    /** 部门电话 */
    @Excel(name = "部门电话")
    private String phone;

    /** 部门邮箱 */
    @Excel(name = "部门邮箱")
    private String email;

    /** 部门状态 */
    @Excel(name = "部门状态")
    private String status;

    /** 部门创建者 */
    @Excel(name = "部门创建者")
    private String createdBy;

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setLeader(String leader) 
    {
        this.leader = leader;
    }

    public String getLeader() 
    {
        return leader;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("deptName", getDeptName())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("createdBy", getCreatedBy())
            .toString();
    }
}
