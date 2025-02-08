package com.ruoyi.road.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

import com.ruoyi.road.domain.Meteorologicaldata;
import com.ruoyi.road.domain.Dept;

/**
 * 气象数据管理Mapper接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface MeteorologicaldataMapper {
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
     * 查询排序后的气象数据管理列表
     *
     * @param meteorologicaldata 气象数据管理
     * @return 排序后的气象数据管理
     */
    public List<Meteorologicaldata> selectSortedMeteorologicaldataList(Meteorologicaldata meteorologicaldata);

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
     * 删除气象数据管理
     * 
     * @param id 气象数据管理主键
     * @return 结果
     */
    public int deleteMeteorologicaldataById(Long id);

    /**
     * 批量删除气象数据管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMeteorologicaldataByIds(Long[] ids);

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
     * 通过气象数据管理主键删除高速公路相关部门管理信息
     * 
     * @param id 气象数据管理ID
     * @return 结果
     */
    public int deleteDeptByDeptId(Long id);

}
