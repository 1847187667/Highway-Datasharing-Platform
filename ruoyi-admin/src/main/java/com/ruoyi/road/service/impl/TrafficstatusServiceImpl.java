package com.ruoyi.road.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.road.domain.Dept;
import com.ruoyi.road.mapper.TrafficstatusMapper;
import com.ruoyi.road.domain.Trafficstatus;
import com.ruoyi.road.service.ITrafficstatusService;

/**
 * 交通状态数据管理Service业务层处理
 * 
 * @author lzx
 * @date 2024-11-15
 */
@Service
public class TrafficstatusServiceImpl implements ITrafficstatusService 
{
    @Autowired
    private TrafficstatusMapper trafficstatusMapper;

    /**
     * 查询交通状态数据管理
     * 
     * @param id 交通状态数据管理主键
     * @return 交通状态数据管理
     */
    @Override
    public Trafficstatus selectTrafficstatusById(Long id)
    {
        return trafficstatusMapper.selectTrafficstatusById(id);
    }

    /**
     * 查询交通状态数据管理列表
     * 
     * @param trafficstatus 交通状态数据管理
     * @return 交通状态数据管理
     */
    @Override
    public List<Trafficstatus> selectTrafficstatusList(Trafficstatus trafficstatus)
    {
        return trafficstatusMapper.selectTrafficstatusList(trafficstatus);
    }

    /**
     * 新增交通状态数据管理
     * 
     * @param trafficstatus 交通状态数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTrafficstatus(Trafficstatus trafficstatus)
    {
        int rows = trafficstatusMapper.insertTrafficstatus(trafficstatus);
        insertDept(trafficstatus);
        return rows;
    }

    /**
     * 修改交通状态数据管理
     * 
     * @param trafficstatus 交通状态数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTrafficstatus(Trafficstatus trafficstatus)
    {
        trafficstatusMapper.deleteDeptByDeptId(trafficstatus.getId());
        insertDept(trafficstatus);
        return trafficstatusMapper.updateTrafficstatus(trafficstatus);
    }

    /**
     * 批量删除交通状态数据管理
     * 
     * @param ids 需要删除的交通状态数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTrafficstatusByIds(Long[] ids)
    {
        trafficstatusMapper.deleteDeptByDeptIds(ids);
        return trafficstatusMapper.deleteTrafficstatusByIds(ids);
    }

    /**
     * 删除交通状态数据管理信息
     * 
     * @param id 交通状态数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTrafficstatusById(Long id)
    {
        trafficstatusMapper.deleteDeptByDeptId(id);
        return trafficstatusMapper.deleteTrafficstatusById(id);
    }

    /**
     * 新增高速公路相关部门管理信息
     * 
     * @param trafficstatus 交通状态数据管理对象
     */
    public void insertDept(Trafficstatus trafficstatus)
    {
        List<Dept> deptList = trafficstatus.getDeptList();
        Long id = trafficstatus.getId();
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
                trafficstatusMapper.batchDept(list);
            }
        }
    }
}
