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
import com.ruoyi.road.domain.Emergencyevents;
import com.ruoyi.road.service.IEmergencyeventsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 紧急事件数据管理Controller
 * 
 * @author lzx
 * @date 2024-12-30
 */
@RestController
@RequestMapping("/road/emergencyevents")
public class EmergencyeventsController extends BaseController
{
    @Autowired
    private IEmergencyeventsService emergencyeventsService;

    /**
     * 查询紧急事件数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:emergencyevents:list')")
    @GetMapping("/list")
    public TableDataInfo list(Emergencyevents emergencyevents)
    {
        startPage();
        List<Emergencyevents> list = emergencyeventsService.selectEmergencyeventsList(emergencyevents);
        return getDataTable(list);
    }

    /**
     * 导出紧急事件数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:emergencyevents:export')")
    @Log(title = "紧急事件数据管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Emergencyevents emergencyevents)
    {
        List<Emergencyevents> list = emergencyeventsService.selectEmergencyeventsList(emergencyevents);
        ExcelUtil<Emergencyevents> util = new ExcelUtil<Emergencyevents>(Emergencyevents.class);
        util.exportExcel(response, list, "紧急事件数据管理数据");
    }

    /**
     * 获取紧急事件数据管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('road:emergencyevents:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(emergencyeventsService.selectEmergencyeventsById(id));
    }

    /**
     * 新增紧急事件数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:emergencyevents:add')")
    @Log(title = "紧急事件数据管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Emergencyevents emergencyevents)
    {
        return toAjax(emergencyeventsService.insertEmergencyevents(emergencyevents));
    }

    /**
     * 修改紧急事件数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:emergencyevents:edit')")
    @Log(title = "紧急事件数据管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Emergencyevents emergencyevents)
    {
        return toAjax(emergencyeventsService.updateEmergencyevents(emergencyevents));
    }

    /**
     * 删除紧急事件数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:emergencyevents:remove')")
    @Log(title = "紧急事件数据管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(emergencyeventsService.deleteEmergencyeventsByIds(ids));
    }
}
