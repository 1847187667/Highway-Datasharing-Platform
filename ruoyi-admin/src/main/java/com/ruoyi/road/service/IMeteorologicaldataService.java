package com.ruoyi.road.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.road.domain.Meteorologicaldata;

/**
 * 气象数据管理Service接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface IMeteorologicaldataService 
{
    /**
     * 查询气象数据管理
     * 
     * @param id 气象数据管理主键
     * @return 气象数据管理
     */
    public Meteorologicaldata selectMeteorologicaldataById(Long id);

    /**
     * 查询气象数据管理列表
     * 
     * @param meteorologicaldata 气象数据管理
     * @return 气象数据管理集合
     */
    public List<Meteorologicaldata> selectMeteorologicaldataList(Meteorologicaldata meteorologicaldata);

    /**
     * 新增气象数据管理
     * 
     * @param meteorologicaldata 气象数据管理
     * @return 结果
     */
    public int insertMeteorologicaldata(Meteorologicaldata meteorologicaldata);

    /**
     * 修改气象数据管理
     * 
     * @param meteorologicaldata 气象数据管理
     * @return 结果
     */
    public int updateMeteorologicaldata(Meteorologicaldata meteorologicaldata);

    /**
     * 批量删除气象数据管理
     * 
     * @param ids 需要删除的气象数据管理主键集合
     * @return 结果
     */
    public int deleteMeteorologicaldataByIds(Long[] ids);

    /**
     * 删除气象数据管理信息
     * 
     * @param id 气象数据管理主键
     * @return 结果
     */
    public int deleteMeteorologicaldataById(Long id);
    
}
