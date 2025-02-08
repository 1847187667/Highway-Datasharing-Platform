package com.ruoyi.road.service;

import java.util.List;
import com.ruoyi.road.domain.Emergencyevents;

/**
 * 紧急事件数据管理Service接口
 * 
 * @author lzx
 * @date 2024-12-30
 */
public interface IEmergencyeventsService 
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
     * 批量删除紧急事件数据管理
     * 
     * @param ids 需要删除的紧急事件数据管理主键集合
     * @return 结果
     */
    public int deleteEmergencyeventsByIds(Long[] ids);

    /**
     * 删除紧急事件数据管理信息
     * 
     * @param id 紧急事件数据管理主键
     * @return 结果
     */
    public int deleteEmergencyeventsById(Long id);
}
