package com.ruoyi.road.service;

import java.util.List;
import com.ruoyi.road.domain.Trafficcontrol;

/**
 * 交通管制数据管理Service接口
 * 
 * @author lzx
 * @date 2024-11-15
 */
public interface ITrafficcontrolService 
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
     * 批量删除交通管制数据管理
     * 
     * @param ids 需要删除的交通管制数据管理主键集合
     * @return 结果
     */
    public int deleteTrafficcontrolByIds(Long[] ids);

    /**
     * 删除交通管制数据管理信息
     * 
     * @param id 交通管制数据管理主键
     * @return 结果
     */
    public int deleteTrafficcontrolById(Long id);
}
