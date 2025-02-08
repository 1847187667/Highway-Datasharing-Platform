package com.ruoyi.road.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.road.domain.Dept;
import com.ruoyi.road.mapper.MaintenanceinfoMapper;
import com.ruoyi.road.domain.Maintenanceinfo;
import com.ruoyi.road.service.IMaintenanceinfoService;

/**
 * 维护与施工数据管理Service业务层处理
 * 
 * @author lzx
 * @date 2024-11-15
 */
@Service
public class MaintenanceinfoServiceImpl implements IMaintenanceinfoService 
{
    @Autowired
    private MaintenanceinfoMapper maintenanceinfoMapper;

    /**
     * 查询维护与施工数据管理
     * 
     * @param id 维护与施工数据管理主键
     * @return 维护与施工数据管理
     */
    @Override
    public Maintenanceinfo selectMaintenanceinfoById(Long id)
    {
        return maintenanceinfoMapper.selectMaintenanceinfoById(id);
    }

    /**
     * 查询维护与施工数据管理列表
     * 
     * @param maintenanceinfo 维护与施工数据管理
     * @return 维护与施工数据管理
     */
    @Override
    public List<Maintenanceinfo> selectMaintenanceinfoList(Maintenanceinfo maintenanceinfo)
    {
        return maintenanceinfoMapper.selectMaintenanceinfoList(maintenanceinfo);
    }

    /**
     * 新增维护与施工数据管理
     * 
     * @param maintenanceinfo 维护与施工数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMaintenanceinfo(Maintenanceinfo maintenanceinfo)
    {
        int rows = maintenanceinfoMapper.insertMaintenanceinfo(maintenanceinfo);
        insertDept(maintenanceinfo);
        return rows;
    }

    /**
     * 修改维护与施工数据管理
     * 
     * @param maintenanceinfo 维护与施工数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMaintenanceinfo(Maintenanceinfo maintenanceinfo)
    {
        maintenanceinfoMapper.deleteDeptByDeptId(maintenanceinfo.getId());
        insertDept(maintenanceinfo);
        return maintenanceinfoMapper.updateMaintenanceinfo(maintenanceinfo);
    }

    /**
     * 批量删除维护与施工数据管理
     * 
     * @param ids 需要删除的维护与施工数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMaintenanceinfoByIds(Long[] ids)
    {
        maintenanceinfoMapper.deleteDeptByDeptIds(ids);
        return maintenanceinfoMapper.deleteMaintenanceinfoByIds(ids);
    }

    /**
     * 删除维护与施工数据管理信息
     * 
     * @param id 维护与施工数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMaintenanceinfoById(Long id)
    {
        maintenanceinfoMapper.deleteDeptByDeptId(id);
        return maintenanceinfoMapper.deleteMaintenanceinfoById(id);
    }

    /**
     * 新增高速公路相关部门管理信息
     * 
     * @param maintenanceinfo 维护与施工数据管理对象
     */
    public void insertDept(Maintenanceinfo maintenanceinfo)
    {
        List<Dept> deptList = maintenanceinfo.getDeptList();
        Long id = maintenanceinfo.getId();
        if (StringUtils.isNotNull(deptList))
        {
            List<Dept> list = new ArrayList<Dept>();
            for (Dept dept : deptList)
            {
                dept.setDeptId(id);
                list.add(dept);
            }
            if (list.size() > 0)
            {
                maintenanceinfoMapper.batchDept(list);
            }
        }
    }
}
