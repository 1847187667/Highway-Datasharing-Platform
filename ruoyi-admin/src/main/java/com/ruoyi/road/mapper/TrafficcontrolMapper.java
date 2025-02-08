package com.ruoyi.road.mapper;

import java.util.List;
import com.ruoyi.road.domain.Trafficcontrol;
import com.ruoyi.road.domain.Dept;

/**
 * 交通管制数据管理Mapper接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface TrafficcontrolMapper 
{
    /**
     * 查询交通管制数据管理
     * 
     * @param id 交通管制数据管理主键
     * @return 交通管制数据管理
     */
    public Trafficcontrol selectTrafficcontrolById(Long id);

    /**
     * 查询交通管制数据管理列表
     * 
     * @param trafficcontrol 交通管制数据管理
     * @return 交通管制数据管理集合
     */
    public List<Trafficcontrol> selectTrafficcontrolList(Trafficcontrol trafficcontrol);

    /**
     * 新增交通管制数据管理
     * 
     * @param trafficcontrol 交通管制数据管理
     * @return 结果
     */
    public int insertTrafficcontrol(Trafficcontrol trafficcontrol);

    /**
     * 修改交通管制数据管理
     * 
     * @param trafficcontrol 交通管制数据管理
     * @return 结果
     */
    public int updateTrafficcontrol(Trafficcontrol trafficcontrol);

    /**
     * 删除交通管制数据管理
     * 
     * @param id 交通管制数据管理主键
     * @return 结果
     */
    public int deleteTrafficcontrolById(Long id);

    /**
     * 批量删除交通管制数据管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficcontrolByIds(Long[] ids);

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
     * 通过交通管制数据管理主键删除高速公路相关部门管理信息
     * 
     * @param id 交通管制数据管理ID
     * @return 结果
     */
    public int deleteDeptByDeptId(Long id);
}
