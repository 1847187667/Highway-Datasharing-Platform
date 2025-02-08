package com.ruoyi.web.controller.system;

import java.util.Map;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TrafficStatusScreen;
import com.ruoyi.system.service.ITrafficStatusScreenService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/traffic")
public class TrafficStatusScreenController extends BaseController {
    
    @Resource
    private ITrafficStatusScreenService trafficStatusScreenService;

    /**
     * 获取数据大屏数据
     */
    @GetMapping("/datascreen")
    public AjaxResult getDataScreenData() {
        Map<String, Object> data = trafficStatusScreenService.getScreenData();
        return AjaxResult.success(data);
    }

    /**
     * 获取最新交通状态
     */
    @GetMapping("/latest")
    public AjaxResult getLatestStatus() {
        TrafficStatusScreen status = trafficStatusScreenService.getLatestTrafficStatus();
        return AjaxResult.success(status);
    }

} 