package com.ruoyi.road.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 气象数据管理对象 meteorologicaldata
 * 
 * @author lzx
 * @date 2024-11-15
 */
public class Meteorologicaldata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 温度（℃） */
    @Excel(name = "温度", readConverterExp = "℃=")
    private BigDecimal temperature;

    /** 湿度（%） */
    @Excel(name = "湿度", readConverterExp = "%=")
    private Long humidity;

    /** 风速（km/h） */
    @Excel(name = "风速", readConverterExp = "k=m/h")
    private Long windSpeed;

    /** 雨量（mm） */
    @Excel(name = "雨量", readConverterExp = "m=m")
    private Long rainfall;

    /** 雪量（mm） */
    @Excel(name = "雪量", readConverterExp = "m=m")
    private Long snowfall;

    /** 极端天气预警 */
    @Excel(name = "极端天气预警")
    private String extremeWeatherWarning;

    /** 更新时间 */
    @Excel(name = "更新时间")
    private Date updatedAt;

    /** 提供数据部门id */
    @Excel(name = "数据来源")
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
    public void setTemperature(BigDecimal temperature) 
    {
        this.temperature = temperature;
    }

    public BigDecimal getTemperature() 
    {
        return temperature;
    }
    public void setHumidity(Long humidity) 
    {
        this.humidity = humidity;
    }

    public Long getHumidity() 
    {
        return humidity;
    }
    public void setWindSpeed(Long windSpeed) 
    {
        this.windSpeed = windSpeed;
    }

    public Long getWindSpeed() 
    {
        return windSpeed;
    }
    public void setRainfall(Long rainfall) 
    {
        this.rainfall = rainfall;
    }

    public Long getRainfall() 
    {
        return rainfall;
    }
    public void setSnowfall(Long snowfall) 
    {
        this.snowfall = snowfall;
    }

    public Long getSnowfall() 
    {
        return snowfall;
    }
    public void setExtremeWeatherWarning(String extremeWeatherWarning) 
    {
        this.extremeWeatherWarning = extremeWeatherWarning;
    }

    public String getExtremeWeatherWarning() 
    {
        return extremeWeatherWarning;
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
            .append("temperature", getTemperature())
            .append("humidity", getHumidity())
            .append("windSpeed", getWindSpeed())
            .append("rainfall", getRainfall())
            .append("snowfall", getSnowfall())
            .append("extremeWeatherWarning", getExtremeWeatherWarning())
            .append("updatedAt", getUpdatedAt())
            .append("deptId", getDeptId())
            .append("deptList", getDeptList())
            .toString();
    }
}
