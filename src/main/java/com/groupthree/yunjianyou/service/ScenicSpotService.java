package com.groupthree.yunjianyou.service;

import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.ScenicSpot;

import java.util.List;

/**
 * @author He
 * @version 1.0.0
 * @title ScenicSpotService
 * @create 2024/5/27 20:47
 * @description
 */
public interface ScenicSpotService {
    /**
     * 查询所有景点信息
     * @return
     */
    public List<ScenicSpot> findAll();

    /**
     * 根据ID查询景点信息
     * @param id
     * @return
     */
    public ScenicSpot findById(Long id);

    /**
     * 新增景点(根据ID)
     * @param scenicSpot
     * @return
     */
    public void addScenicSpot(ScenicSpot scenicSpot);

    /**
     * 修改景点(根据ID)
     * @param scenicSpot
     */
    public void updateScenicSpot(ScenicSpot scenicSpot);

    /**
     * 删除单个景点(根据ID)
     * @param id
     */
    public void deleteScenicSpot(Long id);

    /**
     * 批量删除景点(根据ID列表)
     * @param scenicSpotIds
     */
    public void deleteManyScenicSpot(List<Long> scenicSpotIds);


    /**
     * 分页查询景点信息
     * @param page
     * @param size
     * @return
     */
    public PageInfo<ScenicSpot> findPage(int page,int size);


    /**
     * 多条件查询景点信息
     * @param scenicSpot
     * @return
     */
    public List<ScenicSpot> findList(ScenicSpot scenicSpot);


}
