package com.ruoyi.road.service;

import java.util.List;
import com.ruoyi.road.domain.Trafficstatus;

/**
 * 交通状态数据管理Service接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface ITrafficstatusService 
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
     * 批量删除交通状态数据管理
     * 
     * @param ids 需要删除的交通状态数据管理主键集合
     * @return 结果
     */
    public int deleteTrafficstatusByIds(Long[] ids);

    /**
     * 删除交通状态数据管理信息
     * 
     * @param id 交通状态数据管理主键
     * @return 结果
     */
    public int deleteTrafficstatusById(Long id);
}
