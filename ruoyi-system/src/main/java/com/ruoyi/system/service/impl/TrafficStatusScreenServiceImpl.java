package com.ruoyi.system.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ruoyi.system.mapper.TrafficStatusScreenMapper;
import com.ruoyi.system.service.ITrafficStatusScreenService;
import com.ruoyi.system.domain.TrafficStatusScreen;

@Service
public class TrafficStatusScreenServiceImpl implements ITrafficStatusScreenService {

    @Resource
    private TrafficStatusScreenMapper trafficStatusScreenMapper;

    private Map<String, Integer> parseVehicleDistribution(String distribution) {
        Map<String, Integer> result = new HashMap<>();
        if (distribution != null && !distribution.isEmpty()) {
            try {
                String[] pairs = distribution.split(",");
                for (String pair : pairs) {
                    String[] keyValue = pair.split(":");
                    if (keyValue.length == 2) {
                        String type = keyValue[0].trim();
                        int value = Integer.parseInt(keyValue[1].trim());
                        result.put(type, value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> getScreenData() {
        Map<String, Object> data = new HashMap<>();
        
        List<TrafficStatusScreen> latestData = trafficStatusScreenMapper.getLatestTrafficData();
        
        List<Map<String, Object>> chartData = latestData.stream()
            .sorted((a, b) -> a.getUpdatedAt().compareTo(b.getUpdatedAt()))
            .map(item -> {
                Map<String, Object> map = new HashMap<>();
                map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(item.getUpdatedAt()));
                map.put("volume", item.getTrafficVolume() != null ? item.getTrafficVolume() : 0);
                map.put("speed", item.getAverageSpeed() != null ? item.getAverageSpeed() : 0);
                map.put("status", item.getCongestionDescription());
                
                // 解析车型分布数据
                Map<String, Integer> vehicleDistribution = parseVehicleDistribution(item.getVehicleTypeDistribution());
                map.put("小型车", vehicleDistribution.getOrDefault("小型车", 0));
                map.put("中型车", vehicleDistribution.getOrDefault("中型车", 0));
                map.put("大型车", vehicleDistribution.getOrDefault("大型车", 0));
                map.put("特大型车", vehicleDistribution.getOrDefault("特大型车", 0));
                
                return map;
            })
            .collect(Collectors.toList());
        
        data.put("latestData", chartData);

        // 添加事故类型统计数据
        List<Map<String, Object>> accidentStats = trafficStatusScreenMapper.getAccidentTypeStats();
        data.put("accidentStats", accidentStats);
        
        // 添加各类统计数据
        List<Map<String, Object>> controlStats = trafficStatusScreenMapper.getControlReasonStats();
        List<Map<String, Object>> maintenanceStats = trafficStatusScreenMapper.getMaintenanceTypeStats();
        List<Map<String, Object>> eventStats = trafficStatusScreenMapper.getEventTypeStats();
        
        data.put("controlStats", controlStats);
        data.put("maintenanceStats", maintenanceStats);
        data.put("emergencyStats", eventStats);
        
        return data;
    }

    @Override
    public TrafficStatusScreen getLatestTrafficStatus() {
        return trafficStatusScreenMapper.getLatestTrafficStatus();
    }

} 