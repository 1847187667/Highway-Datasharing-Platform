package com.ruoyi.road.mapper;

import java.util.List;
import com.ruoyi.road.domain.Emergencyevents;
import com.ruoyi.road.domain.Dept;

/**
 * 紧急事件数据管理Mapper接口
 * 
 * @author lzx
 * @date 2024-12-30
 */
public interface EmergencyeventsMapper 
{
    /**
     * 查询紧急事件数据管理
     * 
     * @param id 紧急事件数据管理主键
     * @return 紧急事件数据管理
     */
    public Emergencyevents selectEmergencyeventsById(Long id);

    /**
     * 查询紧急事件数据管理列表
     * 
     * @param emergencyevents 紧急事件数据管理
     * @return 紧急事件数据管理集合
     */
    public List<Emergencyevents> selectEmergencyeventsList(Emergencyevents emergencyevents);

    /**
     * 新增紧急事件数据管理
     * 
     * @param emergencyevents 紧急事件数据管理
     * @return 结果
     */
    public int insertEmergencyevents(Emergencyevents emergencyevents);

    /**
     * 修改紧急事件数据管理
     * 
     * @param emergencyevents 紧急事件数据管理
     * @return 结果
     */
    public int updateEmergencyevents(Emergencyevents emergencyevents);

    /**
     * 删除紧急事件数据管理
     * 
     * @param id 紧急事件数据管理主键
     * @return 结果
     */
    public int deleteEmergencyeventsById(Long id);

    /**
     * 批量删除紧急事件数据管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmergencyeventsByIds(Long[] ids);

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
     * 通过紧急事件数据管理主键删除高速公路相关部门管理信息
     * 
     * @param id 紧急事件数据管理ID
     * @return 结果
     */
    public int deleteDeptByDeptId(Long id);
}
