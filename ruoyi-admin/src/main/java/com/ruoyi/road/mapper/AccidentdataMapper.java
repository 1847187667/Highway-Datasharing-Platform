package com.ruoyi.road.mapper;

import java.util.List;
import com.ruoyi.road.domain.Accidentdata;
import com.ruoyi.road.domain.Dept;

/**
 * 事故数据管理Mapper接口
 * 
 * @author lzx
 * @date 2024-12-30
 */
public interface AccidentdataMapper 
{
    /**
     * 查询事故数据管理
     * 
     * @param id 事故数据管理主键
     * @return 事故数据管理
     */
    public Accidentdata selectAccidentdataById(Long id);

    /**
     * 查询事故数据管理列表
     * 
     * @param accidentdata 事故数据管理
     * @return 事故数据管理集合
     */
    public List<Accidentdata> selectAccidentdataList(Accidentdata accidentdata);

    /**
     * 新增事故数据管理
     * 
     * @param accidentdata 事故数据管理
     * @return 结果
     */
    public int insertAccidentdata(Accidentdata accidentdata);

    /**
     * 修改事故数据管理
     * 
     * @param accidentdata 事故数据管理
     * @return 结果
     */
    public int updateAccidentdata(Accidentdata accidentdata);

    /**
     * 删除事故数据管理
     * 
     * @param id 事故数据管理主键
     * @return 结果
     */
    public int deleteAccidentdataById(Long id);

    /**
     * 批量删除事故数据管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAccidentdataByIds(Long[] ids);

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
     * 通过事故数据管理主键删除高速公路相关部门管理信息
     * 
     * @param id 事故数据管理ID
     * @return 结果
     */
    public int deleteDeptByDeptId(Long id);
}
