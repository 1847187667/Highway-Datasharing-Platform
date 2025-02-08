package com.ruoyi.road.service;

import java.util.List;
import com.ruoyi.road.domain.Maintenanceinfo;

/**
 * 维护与施工数据管理Service接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface IMaintenanceinfoService 
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
     * 批量删除维护与施工数据管理
     * 
     * @param ids 需要删除的维护与施工数据管理主键集合
     * @return 结果
     */
    public int deleteMaintenanceinfoByIds(Long[] ids);

    /**
     * 删除维护与施工数据管理信息
     * 
     * @param id 维护与施工数据管理主键
     * @return 结果
     */
    public int deleteMaintenanceinfoById(Long id);
}
