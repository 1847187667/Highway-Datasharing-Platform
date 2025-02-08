package com.ruoyi.road.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.road.domain.Dept;
import com.ruoyi.road.mapper.EmergencyeventsMapper;
import com.ruoyi.road.domain.Emergencyevents;
import com.ruoyi.road.service.IEmergencyeventsService;

/**
 * 紧急事件数据管理Service业务层处理
 * 
 * @author lzx
 * @date 2024-12-30
 */
@Service
public class EmergencyeventsServiceImpl implements IEmergencyeventsService 
{
    @Autowired
    private EmergencyeventsMapper emergencyeventsMapper;

    /**
     * 查询紧急事件数据管理
     * 
     * @param id 紧急事件数据管理主键
     * @return 紧急事件数据管理
     */
    @Override
    public Emergencyevents selectEmergencyeventsById(Long id)
    {
        return emergencyeventsMapper.selectEmergencyeventsById(id);
    }

    /**
     * 查询紧急事件数据管理列表
     * 
     * @param emergencyevents 紧急事件数据管理
     * @return 紧急事件数据管理
     */
    @Override
    public List<Emergencyevents> selectEmergencyeventsList(Emergencyevents emergencyevents)
    {
        return emergencyeventsMapper.selectEmergencyeventsList(emergencyevents);
    }

    /**
     * 新增紧急事件数据管理
     * 
     * @param emergencyevents 紧急事件数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertEmergencyevents(Emergencyevents emergencyevents)
    {
        int rows = emergencyeventsMapper.insertEmergencyevents(emergencyevents);
        insertDept(emergencyevents);
        return rows;
    }

    /**
     * 修改紧急事件数据管理
     * 
     * @param emergencyevents 紧急事件数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateEmergencyevents(Emergencyevents emergencyevents)
    {
        emergencyeventsMapper.deleteDeptByDeptId(emergencyevents.getId());
        insertDept(emergencyevents);
        return emergencyeventsMapper.updateEmergencyevents(emergencyevents);
    }

    /**
     * 批量删除紧急事件数据管理
     * 
     * @param ids 需要删除的紧急事件数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEmergencyeventsByIds(Long[] ids)
    {
        emergencyeventsMapper.deleteDeptByDeptIds(ids);
        return emergencyeventsMapper.deleteEmergencyeventsByIds(ids);
    }

    /**
     * 删除紧急事件数据管理信息
     * 
     * @param id 紧急事件数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEmergencyeventsById(Long id)
    {
        emergencyeventsMapper.deleteDeptByDeptId(id);
        return emergencyeventsMapper.deleteEmergencyeventsById(id);
    }

    /**
     * 新增高速公路相关部门管理信息
     * 
     * @param emergencyevents 紧急事件数据管理对象
     */
    public void insertDept(Emergencyevents emergencyevents)
    {
        List<Dept> deptList = emergencyevents.getDeptList();
        Long id = emergencyevents.getId();
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
                emergencyeventsMapper.batchDept(list);
            }
        }
    }
}
