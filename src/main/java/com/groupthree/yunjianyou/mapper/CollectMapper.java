package com.groupthree.yunjianyou.mapper;

import com.groupthree.yunjianyou.pojo.Collect;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

/**
 * @author LongGe
 * @title CollertMapper
 * @cresion 1.0.0
 * @create 2024/5/21 21:04
 * @description
 */
public interface CollectMapper extends Mapper<Collect>, DeleteByIdsMapper<Collect> {
}
