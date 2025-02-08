package com.ruoyi.road.service.impl;

import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.road.domain.Dept;
import com.ruoyi.road.mapper.AccidentdataMapper;
import com.ruoyi.road.domain.Accidentdata;
import com.ruoyi.road.service.IAccidentdataService;

/**
 * 事故数据管理Service业务层处理
 * 
 * @author lzx
 * @date 2024-12-30
 */
@Service
public class AccidentdataServiceImpl implements IAccidentdataService 
{
    @Autowired
    private AccidentdataMapper accidentdataMapper;

    /**
     * 查询事故数据管理
     * 
     * @param id 事故数据管理主键
     * @return 事故数据管理
     */
    @Override
    public Accidentdata selectAccidentdataById(Long id)
    {
        return accidentdataMapper.selectAccidentdataById(id);
    }

    /**
     * 查询事故数据管理列表
     * 
     * @param accidentdata 事故数据管理
     * @return 事故数据管理
     */
    @Override
    public List<Accidentdata> selectAccidentdataList(Accidentdata accidentdata)
    {
        return accidentdataMapper.selectAccidentdataList(accidentdata);
    }


    /**
     * 新增事故数据管理
     * 
     * @param accidentdata 事故数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertAccidentdata(Accidentdata accidentdata)
    {
        int rows = accidentdataMapper.insertAccidentdata(accidentdata);
        insertDept(accidentdata);
        return rows;
    }

    /**
     * 修改事故数据管理
     * 
     * @param accidentdata 事故数据管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateAccidentdata(Accidentdata accidentdata)
    {
        accidentdataMapper.deleteDeptByDeptId(accidentdata.getId());
        insertDept(accidentdata);
        return accidentdataMapper.updateAccidentdata(accidentdata);
    }

    /**
     * 批量删除事故数据管理
     * 
     * @param ids 需要删除的事故数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAccidentdataByIds(Long[] ids)
    {
        accidentdataMapper.deleteDeptByDeptIds(ids);
        return accidentdataMapper.deleteAccidentdataByIds(ids);
    }

    /**
     * 删除事故数据管理信息
     * 
     * @param id 事故数据管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAccidentdataById(Long id)
    {
        accidentdataMapper.deleteDeptByDeptId(id);
        return accidentdataMapper.deleteAccidentdataById(id);
    }

    /**
     * 新增高速公路相关部门管理信息
     * 
     * @param accidentdata 事故数据管理对象
     */
    public void insertDept(Accidentdata accidentdata)
    {
        List<Dept> deptList = accidentdata.getDeptList();
        Long id = accidentdata.getId();
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
                accidentdataMapper.batchDept(list);
            }
        }
    }
}
