package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.ruoyi.system.domain.TrafficStatusScreen;


@Mapper
public interface TrafficStatusScreenMapper {
    
    
    /**
     * 获取24小时交通流量数据
     */
    List<Map<String, Object>> getHourlyTraffic();
    
    /**
     * 获取车型分布数据
     */
    Map<String, Object> getVehicleTypeDistribution();
    
    /**
     * 获取平均速度趋势
     */
    List<Map<String, Object>> getSpeedTrend();
    
    /**
     * 获取最新的交通状态
     */
    TrafficStatusScreen getLatestTrafficStatus();

    /**
     * 获取最新的10条交通数据
     */
    List<TrafficStatusScreen> getLatestTrafficData();
    
    /**
     * 获取事故类型统计数据
     */
    List<Map<String, Object>> getAccidentTypeStats();
    
    /**
     * 获取交通管制原因统计
     */
    List<Map<String, Object>> getControlReasonStats();
    
    /**
     * 获取维护类型统计
     */
    List<Map<String, Object>> getMaintenanceTypeStats();
    
    /**
     * 获取事件类型统计
     */
    List<Map<String, Object>> getEventTypeStats();
} 