package com.ruoyi.road.domain;

import java.util.Base64;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 事故数据管理对象 accidentdata
 * 
 * @author lzx
 * @date 2024-12-30
 */
public class Accidentdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date accidentTime;

    /**  */
    @Excel(name = "")
    private String accidentLocation;

    /**  */
    @Excel(name = "")
    private String accidentType;

    /**  */
    @Excel(name = "")
    private String involvedVehicles;

    /**  */
    @Excel(name = "")
    private String image;

    /**  */
    @Excel(name = "")
    private Long casualties;

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
    public void setAccidentTime(Date accidentTime) 
    {
        this.accidentTime = accidentTime;
    }

    public Date getAccidentTime() 
    {
        return accidentTime;
    }
    public void setAccidentLocation(String accidentLocation) 
    {
        this.accidentLocation = accidentLocation;
    }

    public String getAccidentLocation() 
    {
        return accidentLocation;
    }
    public void setAccidentType(String accidentType) 
    {
        this.accidentType = accidentType;
    }

    public String getAccidentType() 
    {
        return accidentType;
    }
    public void setInvolvedVehicles(String involvedVehicles) 
    {
        this.involvedVehicles = involvedVehicles;
    }

    public String getInvolvedVehicles() 
    {
        return involvedVehicles;
    }
    public void setImage(String image)
    {
        this.image= image;
    }

    public String getImage()
    {
        return image;
    }
    public void setCasualties(Long casualties) 
    {
        this.casualties = casualties;
    }

    public Long getCasualties() 
    {
        return casualties;
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
            .append("accidentTime", getAccidentTime())
            .append("accidentLocation", getAccidentLocation())
            .append("accidentType", getAccidentType())
            .append("involvedVehicles", getInvolvedVehicles())
            .append("image", getImage())
            .append("casualties", getCasualties())
            .append("updatedAt", getUpdatedAt())
            .append("deptId", getDeptId())
            .append("deptList", getDeptList())
            .toString();
    }
}
