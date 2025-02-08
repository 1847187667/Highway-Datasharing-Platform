package com.ruoyi.road.service;

import java.util.List;
import com.ruoyi.road.domain.Accidentdata;

/**
 * 事故数据管理Service接口
 * 
 * @author lzx
 * @date 2024-12-30
 */
public interface IAccidentdataService 
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
     * 批量删除事故数据管理
     * 
     * @param ids 需要删除的事故数据管理主键集合
     * @return 结果
     */
    public int deleteAccidentdataByIds(Long[] ids);

    /**
     * 删除事故数据管理信息
     * 
     * @param id 事故数据管理主键
     * @return 结果
     */
    public int deleteAccidentdataById(Long id);
}
