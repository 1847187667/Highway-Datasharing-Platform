package com.ruoyi.road.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 交通状态数据管理对象 trafficstatus
 * 
 * @author lzx
 * @date 2024-11-15
 */
public class Trafficstatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 交通流量 */
    @Excel(name = "交通流量")
    private Long trafficVolume;

    /** 平均车速 */
    @Excel(name = "平均车速")
    private Long averageSpeed;

    /** 拥堵状况 */
    @Excel(name = "拥堵状况")
    private String congestionDescription;

    /** 车辆类型分布 */
    @Excel(name = "车辆类型分布")
    private String vehicleTypeDistribution;

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
    public void setTrafficVolume(Long trafficVolume) 
    {
        this.trafficVolume = trafficVolume;
    }

    public Long getTrafficVolume() 
    {
        return trafficVolume;
    }
    public void setAverageSpeed(Long averageSpeed) 
    {
        this.averageSpeed = averageSpeed;
    }

    public Long getAverageSpeed() 
    {
        return averageSpeed;
    }
    public void setCongestionDescription(String congestionDescription) 
    {
        this.congestionDescription = congestionDescription;
    }

    public String getCongestionDescription() 
    {
        return congestionDescription;
    }
    public void setVehicleTypeDistribution(String vehicleTypeDistribution) 
    {
        this.vehicleTypeDistribution = vehicleTypeDistribution;
    }

    public String getVehicleTypeDistribution() 
    {
        return vehicleTypeDistribution;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("trafficVolume", getTrafficVolume())
            .append("averageSpeed", getAverageSpeed())
            .append("congestionDescription", getCongestionDescription())
            .append("vehicleTypeDistribution", getVehicleTypeDistribution())
            .append("updatedAt", getUpdatedAt())
            .append("deptId", getDeptId())
            .append("deptList", getDeptList())
            .toString();
    }
}
