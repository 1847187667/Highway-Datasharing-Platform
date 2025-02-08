package com.ruoyi.road.mapper;

import java.util.List;
import com.ruoyi.road.domain.Trafficstatus;
import com.ruoyi.road.domain.Dept;

/**
 * 交通状态数据管理Mapper接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface TrafficstatusMapper 
{
    /**
     * 查询交通状态数据管理
     * 
     * @param id 交通状态数据管理主键
     * @return 交通状态数据管理
     */
    public Trafficstatus selectTrafficstatusById(Long id);

    /**
     * 查询交通状态数据管理列表
     * 
     * @param trafficstatus 交通状态数据管理
     * @return 交通状态数据管理集合
     */
    public List<Trafficstatus> selectTrafficstatusList(Trafficstatus trafficstatus);

    /**
     * 新增交通状态数据管理
     * 
     * @param trafficstatus 交通状态数据管理
     * @return 结果
     */
    public int insertTrafficstatus(Trafficstatus trafficstatus);

    /**
     * 修改交通状态数据管理
     * 
     * @param trafficstatus 交通状态数据管理
     * @return 结果
     */
    public int updateTrafficstatus(Trafficstatus trafficstatus);

    /**
     * 删除交通状态数据管理
     * 
     * @param id 交通状态数据管理主键
     * @return 结果
     */
    public int deleteTrafficstatusById(Long id);

    /**
     * 批量删除交通状态数据管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficstatusByIds(Long[] ids);

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
     * 通过交通状态数据管理主键删除高速公路相关部门管理信息
     * 
     * @param id 交通状态数据管理ID
     * @return 结果
     */
    public int deleteDeptByDeptId(Long id);
}
