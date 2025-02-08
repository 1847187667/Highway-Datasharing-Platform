package com.ruoyi.road.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.road.domain.Meteorologicaldata;
import com.ruoyi.road.service.IMeteorologicaldataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 气象数据管理Controller
 * 
 * @author lzx
 * @date 2024-11-15
 */
@RestController
@RequestMapping("/road/meteorologicaldata")
public class MeteorologicaldataController extends BaseController
{
    @Autowired
    private IMeteorologicaldataService meteorologicaldataService;

    /**
     * 查询气象数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:meteorologicaldata:list')")
    @GetMapping("/list") //这是一个Spring MVC的注解，表示当前方法是处理HTTP GET请求的。URL路径为/list。当用户访问/road/meteorologicaldata/list这个URL时，Spring会将这个请求映射到当前方法。
    public TableDataInfo list(Meteorologicaldata meteorologicaldata)//Spring MVC 将自动将前端发送的URL和查询参数解析为 Meteorologicaldata 类型的对象 meteorologicaldata。
    {
        startPage();
        List<Meteorologicaldata> list = meteorologicaldataService.selectMeteorologicaldataList(meteorologicaldata);
        return getDataTable(list);
    }

    /**
     * 导出气象数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:meteorologicaldata:export')")
    @Log(title = "气象数据管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Meteorologicaldata meteorologicaldata)
    {
        List<Meteorologicaldata> list = meteorologicaldataService.selectMeteorologicaldataList(meteorologicaldata);
        ExcelUtil<Meteorologicaldata> util = new ExcelUtil<Meteorologicaldata>(Meteorologicaldata.class);
        util.exportExcel(response, list, "气象数据管理数据");
    }

    /**
     * 获取气象数据管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('road:meteorologicaldata:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(meteorologicaldataService.selectMeteorologicaldataById(id));
    }

    /**
     * 新增气象数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:meteorologicaldata:add')")
    @Log(title = "气象数据管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Meteorologicaldata meteorologicaldata)
    {
        return toAjax(meteorologicaldataService.insertMeteorologicaldata(meteorologicaldata));
    }

    /**
     * 修改气象数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:meteorologicaldata:edit')")
    @Log(title = "气象数据管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Meteorologicaldata meteorologicaldata)
    {
        return toAjax(meteorologicaldataService.updateMeteorologicaldata(meteorologicaldata));
    }

    /**
     * 删除气象数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:meteorologicaldata:remove')")
    @Log(title = "气象数据管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(meteorologicaldataService.deleteMeteorologicaldataByIds(ids));
    }
}
