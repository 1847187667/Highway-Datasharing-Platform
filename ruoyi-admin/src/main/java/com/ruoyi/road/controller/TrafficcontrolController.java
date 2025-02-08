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
import com.ruoyi.road.domain.Trafficcontrol;
import com.ruoyi.road.service.ITrafficcontrolService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 交通管制数据管理Controller
 * 
 * @author lzx
 * @date 2024-11-15
 */
@RestController
@RequestMapping("/road/trafficcontrol")
public class TrafficcontrolController extends BaseController
{
    @Autowired
    private ITrafficcontrolService trafficcontrolService;

    /**
     * 查询交通管制数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:trafficcontrol:list')")
    @GetMapping("/list")
    public TableDataInfo list(Trafficcontrol trafficcontrol)
    {
        startPage();
        List<Trafficcontrol> list = trafficcontrolService.selectTrafficcontrolList(trafficcontrol);
        return getDataTable(list);
    }

    /**
     * 导出交通管制数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:trafficcontrol:export')")
    @Log(title = "交通管制数据管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Trafficcontrol trafficcontrol)
    {
        List<Trafficcontrol> list = trafficcontrolService.selectTrafficcontrolList(trafficcontrol);
        ExcelUtil<Trafficcontrol> util = new ExcelUtil<Trafficcontrol>(Trafficcontrol.class);
        util.exportExcel(response, list, "交通管制数据管理数据");
    }

    /**
     * 获取交通管制数据管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('road:trafficcontrol:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(trafficcontrolService.selectTrafficcontrolById(id));
    }

    /**
     * 新增交通管制数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:trafficcontrol:add')")
    @Log(title = "交通管制数据管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Trafficcontrol trafficcontrol)
    {
        return toAjax(trafficcontrolService.insertTrafficcontrol(trafficcontrol));
    }

    /**
     * 修改交通管制数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:trafficcontrol:edit')")
    @Log(title = "交通管制数据管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Trafficcontrol trafficcontrol)
    {
        return toAjax(trafficcontrolService.updateTrafficcontrol(trafficcontrol));
    }

    /**
     * 删除交通管制数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:trafficcontrol:remove')")
    @Log(title = "交通管制数据管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(trafficcontrolService.deleteTrafficcontrolByIds(ids));
    }
}
