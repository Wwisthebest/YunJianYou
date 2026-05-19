package com.groupthree.yunjianyou.mapper;

import com.groupthree.yunjianyou.pojo.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

public interface UserMapper extends Mapper<User>, DeleteByIdsMapper<User> {

}
