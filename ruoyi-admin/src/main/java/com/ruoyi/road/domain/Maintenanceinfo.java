package com.ruoyi.road.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维护与施工数据管理对象 maintenanceinfo
 * 
 * @author lzx
 * @date 2024-11-15
 */
public class Maintenanceinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintenanceStartTime;

    /** （预计）结束时间 */
    @Excel(name = "", readConverterExp = "预=计")
    private Date maintenanceEndTime;

    /** 维护/施工地点 */
    @Excel(name = "维护/施工地点")
    private String maintenanceLocation;

    /** 维护/施工性质 */
    @Excel(name = "维护/施工性质")
    private String maintenanceType;

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
    public void setMaintenanceStartTime(Date maintenanceStartTime) 
    {
        this.maintenanceStartTime = maintenanceStartTime;
    }

    public Date getMaintenanceStartTime() 
    {
        return maintenanceStartTime;
    }
    public void setMaintenanceEndTime(Date maintenanceEndTime) 
    {
        this.maintenanceEndTime = maintenanceEndTime;
    }

    public Date getMaintenanceEndTime() 
    {
        return maintenanceEndTime;
    }
    public void setMaintenanceLocation(String maintenanceLocation) 
    {
        this.maintenanceLocation = maintenanceLocation;
    }

    public String getMaintenanceLocation() 
    {
        return maintenanceLocation;
    }
    public void setMaintenanceType(String maintenanceType) 
    {
        this.maintenanceType = maintenanceType;
    }

    public String getMaintenanceType() 
    {
        return maintenanceType;
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
            .append("maintenanceStartTime", getMaintenanceStartTime())
            .append("maintenanceEndTime", getMaintenanceEndTime())
            .append("maintenanceLocation", getMaintenanceLocation())
            .append("maintenanceType", getMaintenanceType())
            .append("updatedAt", getUpdatedAt())
            .append("deptId", getDeptId())
            .append("deptList", getDeptList())
            .toString();
    }
}
