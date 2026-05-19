package com.groupthree.yunjianyou.mapper;

import com.groupthree.yunjianyou.pojo.ScenicSpot;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

/**
 * @author He
 * @version 1.0.0
 * @title ScenicSpotMapper
 * @create 2024/5/27 20:47
 * @description
 */
public interface ScenicSpotMapper extends Mapper<ScenicSpot>,DeleteByIdsMapper<ScenicSpot> {
}
