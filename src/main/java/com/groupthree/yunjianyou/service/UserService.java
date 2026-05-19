package com.groupthree.yunjianyou.service;

import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserService {

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 分页查询所有User
     * @return
     */
    PageInfo<User> findUserPage(Integer pageNo,Integer pageSize);

    /**
     * User登录
     * @param user
     * @return
     */
    User login(User user);

//    Map<String,Object> login(User user);

    Map<String,Object> register(User user);

    /**
     * 新增User
     * @param user
     * @return
     */
    public void add(User user);

    /**
     * 修改User信息
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 单个删除User信息
     * @param id
     * @return
     */
    void deleteUserById(Integer id);

    /**
     * 多个删除User信息
     * @param userIds
     */
    void deleteAllSelectUser(List<Integer> userIds);

}
