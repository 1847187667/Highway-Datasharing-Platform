package com.ruoyi.road.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.road.domain.Dept;
import com.ruoyi.road.mapper.MeteorologicaldataMapper;
import com.ruoyi.road.domain.Meteorologicaldata;
import com.ruoyi.road.service.IMeteorologicaldataService;

/**
 * 气象数据管理Service业务层处理
 * 
 * @author lzx
 * @date 2024-11-15
 */
@Service
public class MeteorologicaldataServiceImpl implements IMeteorologicaldataService 
{
    @Autowired
    private MeteorologicaldataMapper meteorologicaldataMapper;

    /**
     * 查询气象数据管理
     * 
     * @param id 气象数据管理主键
     * @return 气象数据管理
     */
    @Override
    public Meteorologicaldata selectMeteorologicaldataById(Long id)
    {
        return meteorologicaldataMapper.selectMeteorologicaldataById(id);
    }

    /**
     * 查询气象数据管理列表
     * 
     * @param meteorologicaldata 气象数据管理
     * @return 气象数据管理
     */
    @Override
    public List<Meteorologicaldata> selectMeteorologicaldataList(Meteorologicaldata meteorologicaldata)
    {
        return meteorologicaldataMapper.selectMeteorologicaldataList(meteorologicaldata);
    }

    /**
     * 新增气象数据管理
     * 
     * @param meteorologicaldata 气象数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMeteorologicaldata(Meteorologicaldata meteorologicaldata)
    {
        int rows = meteorologicaldataMapper.insertMeteorologicaldata(meteorologicaldata);
        insertDept(meteorologicaldata);
        return rows;
    }

    /**
     * 修改气象数据管理
     * 
     * @param meteorologicaldata 气象数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMeteorologicaldata(Meteorologicaldata meteorologicaldata)
    {
        meteorologicaldataMapper.deleteDeptByDeptId(meteorologicaldata.getId());
        insertDept(meteorologicaldata);
        return meteorologicaldataMapper.updateMeteorologicaldata(meteorologicaldata);
    }

    /**
     * 批量删除气象数据管理
     * 
     * @param ids 需要删除的气象数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMeteorologicaldataByIds(Long[] ids)
    {
        meteorologicaldataMapper.deleteDeptByDeptIds(ids);
        return meteorologicaldataMapper.deleteMeteorologicaldataByIds(ids);
    }

    /**
     * 删除气象数据管理信息
     * 
     * @param id 气象数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMeteorologicaldataById(Long id)
    {
        meteorologicaldataMapper.deleteDeptByDeptId(id);
        return meteorologicaldataMapper.deleteMeteorologicaldataById(id);
    }

    /**
     * 新增高速公路相关部门管理信息
     * 
     * @param meteorologicaldata 气象数据管理对象
     */
    public void insertDept(Meteorologicaldata meteorologicaldata)
    {
        List<Dept> deptList = meteorologicaldata.getDeptList();
        Long id = meteorologicaldata.getId();
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
                meteorologicaldataMapper.batchDept(list);
            }
        }
    }

}
