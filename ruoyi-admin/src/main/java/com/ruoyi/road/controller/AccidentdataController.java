package com.ruoyi.road.controller;

import java.util.Base64;
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
import com.ruoyi.road.domain.Accidentdata;
import com.ruoyi.road.service.IAccidentdataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 事故数据管理Controller
 * 
 * @author lzx
 * @date 2024-12-30
 */
@RestController
@RequestMapping("/road/accidentdata")
public class AccidentdataController extends BaseController
{
    @Autowired
    private IAccidentdataService accidentdataService;

    /**
     * 查询事故数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:accidentdata:list')")
    @GetMapping("/list")
    public TableDataInfo list(Accidentdata accidentdata) //accidentdata是前端传递的查询参数query，后端将其作为条件查询数据库
    {
        startPage();
        List<Accidentdata> list = accidentdataService.selectAccidentdataList(accidentdata);
        return getDataTable(list);// 返回json格式数据
    }

    /**
     * 导出事故数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('road:accidentdata:export')")
    @Log(title = "事故数据管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Accidentdata accidentdata)
    {
        List<Accidentdata> list = accidentdataService.selectAccidentdataList(accidentdata);
        ExcelUtil<Accidentdata> util = new ExcelUtil<Accidentdata>(Accidentdata.class);
        util.exportExcel(response, list, "事故数据管理数据");
    }

    /**
     * 获取事故数据管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('road:accidentdata:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(accidentdataService.selectAccidentdataById(id));
    }

    /**
     * 新增事故数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:accidentdata:add')")
    @Log(title = "事故数据管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Accidentdata accidentdata)
    {
        return toAjax(accidentdataService.insertAccidentdata(accidentdata));
    }

    /**
     * 修改事故数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:accidentdata:edit')")
    @Log(title = "事故数据管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Accidentdata accidentdata)
    {
        return toAjax(accidentdataService.updateAccidentdata(accidentdata));
    }

    /**
     * 删除事故数据管理
     */
    @PreAuthorize("@ss.hasPermi('road:accidentdata:remove')")
    @Log(title = "事故数据管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(accidentdataService.deleteAccidentdataByIds(ids));
    }
}
