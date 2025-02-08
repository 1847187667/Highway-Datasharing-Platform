package com.ruoyi.road.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.road.domain.Dept;
import com.ruoyi.road.mapper.TrafficcontrolMapper;
import com.ruoyi.road.domain.Trafficcontrol;
import com.ruoyi.road.service.ITrafficcontrolService;

/**
 * 交通管制数据管理Service业务层处理
 * 
 * @author lzx
 * @date 2024-11-15
 */
@Service
public class TrafficcontrolServiceImpl implements ITrafficcontrolService 
{
    @Autowired
    private TrafficcontrolMapper trafficcontrolMapper;

    /**
     * 查询交通管制数据管理
     * 
     * @param id 交通管制数据管理主键
     * @return 交通管制数据管理
     */
    @Override
    public Trafficcontrol selectTrafficcontrolById(Long id)
    {
        return trafficcontrolMapper.selectTrafficcontrolById(id);
    }

    /**
     * 查询交通管制数据管理列表
     * 
     * @param trafficcontrol 交通管制数据管理
     * @return 交通管制数据管理
     */
    @Override
    public List<Trafficcontrol> selectTrafficcontrolList(Trafficcontrol trafficcontrol)
    {
        return trafficcontrolMapper.selectTrafficcontrolList(trafficcontrol);
    }

    /**
     * 新增交通管制数据管理
     * 
     * @param trafficcontrol 交通管制数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTrafficcontrol(Trafficcontrol trafficcontrol)
    {
        int rows = trafficcontrolMapper.insertTrafficcontrol(trafficcontrol);
        insertDept(trafficcontrol);
        return rows;
    }

    /**
     * 修改交通管制数据管理
     * 
     * @param trafficcontrol 交通管制数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTrafficcontrol(Trafficcontrol trafficcontrol)
    {
        trafficcontrolMapper.deleteDeptByDeptId(trafficcontrol.getId());
        insertDept(trafficcontrol);
        return trafficcontrolMapper.updateTrafficcontrol(trafficcontrol);
    }

    /**
     * 批量删除交通管制数据管理
     * 
     * @param ids 需要删除的交通管制数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTrafficcontrolByIds(Long[] ids)
    {
        trafficcontrolMapper.deleteDeptByDeptIds(ids);
        return trafficcontrolMapper.deleteTrafficcontrolByIds(ids);
    }

    /**
     * 删除交通管制数据管理信息
     * 
     * @param id 交通管制数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTrafficcontrolById(Long id)
    {
        trafficcontrolMapper.deleteDeptByDeptId(id);
        return trafficcontrolMapper.deleteTrafficcontrolById(id);
    }

    /**
     * 新增高速公路相关部门管理信息
     * 
     * @param trafficcontrol 交通管制数据管理对象
     */
    public void insertDept(Trafficcontrol trafficcontrol)
    {
        List<Dept> deptList = trafficcontrol.getDeptList();
        Long id = trafficcontrol.getId();
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
                trafficcontrolMapper.batchDept(list);
            }
        }
    }
}
