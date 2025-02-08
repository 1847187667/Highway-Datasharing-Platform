package com.ruoyi.road.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.road.domain.Trafficstatus;
import com.ruoyi.road.service.ITrafficstatusService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 交通状态数据管理Controller
 * 
 * @author lzx
 * @date 2024-11-15
 */
@RestController
@RequestMapping("/road/trafficstatus")
public class TrafficstatusController extends BaseController
{
    @Autowired
    private ITrafficstatusService trafficstatusService;

    /**
     * 查询交通状态数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:trafficstatus:list')")
    @GetMapping("/list")
    public TableDataInfo list(Trafficstatus trafficstatus)
    {
        startPage();
        List<Trafficstatus> list = trafficstatusService.selectTrafficstatusList(trafficstatus);
        return getDataTable(list);
    }

    /**
     * 导出交通状态数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:trafficstatus:export')")
    @Log(title = "交通状态数据管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Trafficstatus trafficstatus)
    {
        List<Trafficstatus> list = trafficstatusService.selectTrafficstatusList(trafficstatus);
        ExcelUtil<Trafficstatus> util = new ExcelUtil<Trafficstatus>(Trafficstatus.class);
        util.exportExcel(response, list, "交通状态数据管理数据");
    }

    /**
     * 获取交通状态数据管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('road:trafficstatus:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(trafficstatusService.selectTrafficstatusById(id));
    }

    /**
     * 新增交通状态数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:trafficstatus:add')")
    @Log(title = "交通状态数据管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Trafficstatus trafficstatus)
    {
        return toAjax(trafficstatusService.insertTrafficstatus(trafficstatus));
    }

    /**
     * 修改交通状态数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:trafficstatus:edit')")
    @Log(title = "交通状态数据管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Trafficstatus trafficstatus)
    {
        return toAjax(trafficstatusService.updateTrafficstatus(trafficstatus));
    }

    /**
     * 删除交通状态数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:trafficstatus:remove')")
    @Log(title = "交通状态数据管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(trafficstatusService.deleteTrafficstatusByIds(ids));
    }
}
