package com.ruoyi.road.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 紧急事件数据管理对象 emergencyevents
 * 
 * @author lzx
 * @date 2024-12-30
 */
public class Emergencyevents extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eventTime;

    /**  */
    @Excel(name = "")
    private String eventType;

    /**  */
    @Excel(name = "")
    private String eventLocation;

    /**  */
    @Excel(name = "")
    private String eventDescription;

    /**  */
    @Excel(name = "")
    private String image;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /**  */
    @Excel(name = "")
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
    public void setEventTime(Date eventTime) 
    {
        this.eventTime = eventTime;
    }

    public Date getEventTime() 
    {
        return eventTime;
    }
    public void setEventType(String eventType) 
    {
        this.eventType = eventType;
    }

    public String getEventType() 
    {
        return eventType;
    }
    public void setEventLocation(String eventLocation) 
    {
        this.eventLocation = eventLocation;
    }

    public String getEventLocation() 
    {
        return eventLocation;
    }
    public void setEventDescription(String eventDescription) 
    {
        this.eventDescription = eventDescription;
    }

    public String getEventDescription() 
    {
        return eventDescription;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
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
            .append("eventTime", getEventTime())
            .append("eventType", getEventType())
            .append("eventLocation", getEventLocation())
            .append("eventDescription", getEventDescription())
            .append("image", getImage())
            .append("updatedAt", getUpdatedAt())
            .append("deptId", getDeptId())
            .append("deptList", getDeptList())
            .toString();
    }
}
