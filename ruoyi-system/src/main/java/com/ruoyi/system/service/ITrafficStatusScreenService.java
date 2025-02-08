package com.ruoyi.system.service;

import java.util.Map;
import java.util.List;
import com.ruoyi.system.domain.TrafficStatusScreen;

public interface ITrafficStatusScreenService {
    
    /**
     * 获取数据大屏展示数据
     */
    Map<String, Object> getScreenData();
    
    /**
     * 获取最新的交通状态
     */
    TrafficStatusScreen getLatestTrafficStatus();

} 