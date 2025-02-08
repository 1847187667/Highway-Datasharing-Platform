package com.ruoyi.road.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交通管制数据管理对象 trafficcontrol
 * 
 * @author lzx
 * @date 2024-11-15
 */
public class Trafficcontrol extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 管制开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "管制开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date controlStartTime;

    /** 管制结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "管制结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date controlEndTime;

    /** 管制原因 */
    @Excel(name = "管制原因")
    private String controlReason;

    /** 管制路段 */
    @Excel(name = "管制路段")
    private String controlLocation;

    /** 更新时间 */
    @Excel(name = "更新时间")
    private Date updatedAt;

    /** 提供数据部门id */
    @Excel(name = "提供数据部门id")
    private Long deptId;

    /** 高速公路相关部门管理信息 */
    private List<Dept> deptList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setControlStartTime(Date controlStartTime) 
    {
        this.controlStartTime = controlStartTime;
    }

    public Date getControlStartTime() 
    {
        return controlStartTime;
    }
    public void setControlEndTime(Date controlEndTime) 
    {
        this.controlEndTime = controlEndTime;
    }

    public Date getControlEndTime() 
    {
        return controlEndTime;
    }
    public void setControlReason(String controlReason) 
    {
        this.controlReason = controlReason;
    }

    public String getControlReason() 
    {
        return controlReason;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public List<Dept> getDeptList()
    {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList)
    {
        this.deptList = deptList;
    }

    public String getControlLocation() {
        return controlLocation;
    }

    public void setControlLocation(String controlLocation) {
        this.controlLocation = controlLocation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("controlStartTime", getControlStartTime())
            .append("controlEndTime", getControlEndTime())
            .append("controlReason", getControlReason())
            .append("updatedAt", getUpdatedAt())
            .append("deptId", getDeptId())
            .append("deptList", getDeptList())
            .toString();
    }
}
