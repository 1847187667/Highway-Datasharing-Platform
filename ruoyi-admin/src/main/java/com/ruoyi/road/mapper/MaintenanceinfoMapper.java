package com.ruoyi.road.mapper;

import java.util.List;
import com.ruoyi.road.domain.Maintenanceinfo;
import com.ruoyi.road.domain.Dept;

/**
 * 维护与施工数据管理Mapper接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface MaintenanceinfoMapper 
{
    /**
     * 查询维护与施工数据管理
     * 
     * @param id 维护与施工数据管理主键
     * @return 维护与施工数据管理
     */
    public Maintenanceinfo selectMaintenanceinfoById(Long id);

    /**
     * 查询维护与施工数据管理列表
     * 
     * @param maintenanceinfo 维护与施工数据管理
     * @return 维护与施工数据管理集合
     */
    public List<Maintenanceinfo> selectMaintenanceinfoList(Maintenanceinfo maintenanceinfo);

    /**
     * 新增维护与施工数据管理
     * 
     * @param maintenanceinfo 维护与施工数据管理
     * @return 结果
     */
    public int insertMaintenanceinfo(Maintenanceinfo maintenanceinfo);

    /**
     * 修改维护与施工数据管理
     * 
     * @param maintenanceinfo 维护与施工数据管理
     * @return 结果
     */
    public int updateMaintenanceinfo(Maintenanceinfo maintenanceinfo);

    /**
     * 删除维护与施工数据管理
     * 
     * @param id 维护与施工数据管理主键
     * @return 结果
     */
    public int deleteMaintenanceinfoById(Long id);

    /**
     * 批量删除维护与施工数据管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMaintenanceinfoByIds(Long[] ids);

    /**
     * 批量删除高速公路相关部门管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeptByDeptIds(Long[] ids);
    
    /**
     * 批量新增高速公路相关部门管理
     * 
     * @param deptList 高速公路相关部门管理列表
     * @return 结果
     */
    public int batchDept(List<Dept> deptList);
    

    /**
     * 通过维护与施工数据管理主键删除高速公路相关部门管理信息
     * 
     * @param id 维护与施工数据管理ID
     * @return 结果
     */
    public int deleteDeptByDeptId(Long id);
}
