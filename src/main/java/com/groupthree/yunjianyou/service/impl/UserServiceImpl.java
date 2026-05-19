package com.groupthree.yunjianyou.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.mapper.UserMapper;
import com.groupthree.yunjianyou.pojo.User;
import com.groupthree.yunjianyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id){
        return  userMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询User
     * @return
     */
    @Override
    public PageInfo<User> findUserPage(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo<User>(userMapper.selectAll());
    }

    /**
     * User构建查询对象
     * @param user
     * @return
     */
    public Example createExample(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
            // 用户id
            if(!StringUtils.isEmpty(user.getId())){
                criteria.andEqualTo("id",user.getId());
            }
            // 用户真实姓名
            if(!StringUtils.isEmpty(user.getuName())){
                criteria.andEqualTo("uName",user.getuName());
            }
            if(!StringUtils.isEmpty(user.getuNickName())){
                criteria.andEqualTo("uNickName",user.getuNickName());
            }
            // User名称
            if(!StringUtils.isEmpty(user.getuIdNum())){
                criteria.andLike("uIdNum",user.getuIdNum());
            }
            // 价格（分）
            if(!StringUtils.isEmpty(user.getPhone())){
                criteria.andEqualTo("phone",user.getPhone());
            }
            // 库存数量
            if(!StringUtils.isEmpty(user.getEmail())){
                criteria.andEqualTo("email",user.getEmail());
            }
            // 库存预警数量
            if(!StringUtils.isEmpty(user.getIsState())){
                criteria.andEqualTo("isState",user.getIsState());
            }
            // 商品图片
            if(!StringUtils.isEmpty(user.getSex())){
                criteria.andEqualTo("sex",user.getSex());
            }
            // 商品图片列表
            if(!StringUtils.isEmpty(user.getuPassword())){
                criteria.andEqualTo("uPassword",user.getuPassword());
            }
            // 创建时间
            if(!StringUtils.isEmpty(user.getUserAddress())){
                criteria.andEqualTo("userAddress",user.getUserAddress());
            }
            // 更新时间
            if(!StringUtils.isEmpty(user.getUserUrl())){
                criteria.andEqualTo("userUrl",user.getUserUrl());
            }
        }
        return example;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Transactional()
    public Map<String,Object> register(User user) {
        //雪花算法生成确认码
        String confirmCode = IdUtil.getSnowflake(1, 1).nextIdStr();
        //盐
        String salt = RandomUtil.randomString(6);
        //加密密码:原始密码+盐
        String md5Pwd = SecureUtil.md5(user.getuName() + salt);
        //激活失效时间：24小时
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        //初始化账号信息
        user.setSalt(salt);
        user.setuPassword(md5Pwd);
        user.setConfirmCode(confirmCode);
        user.setIsState("0");
        //新增账号
        int result = userMapper.insertSelective(user);
        Map<String, Object> resultMap = new HashMap<>();
        if (result > 0) {
            //TODO 发送邮件
            resultMap.put("code", 200);
            resultMap.put("message", "注册成功，请重新登录");
        } else {
            resultMap.put("code", "400");
            resultMap.put("message", "注册失败");
        }
        return resultMap;

    }
    /**
     * User登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {return userMapper.selectOne(user);}

    /**
     * 用户登陆
     *
     * @param user
     * @return
     */
//    public Map<String,Object> login(User user){
//        Map<String,Object> resultMap = new HashMap<>();
//        //查询用户
//        List<User> userList = userMapper.selectByPhone(user.getPhone());
//        //查询不到结果，返回：该账户不存在
//        if(userList==null||userList.isEmpty()){
//            resultMap.put("code", 400);
//            resultMap.put("message","该账户不存在");
//            return resultMap;
//        }
//        //查询到多个用户，返回：账号异常，请重新登录
//        if(userList.size()>1){
//            resultMap.put("code", 400);
//            resultMap.put("message","账号异常，请重新登录");
//            return resultMap;
//        }
//        //查询到一个用户，进行密码比对
//        User u=userList.get(0);
//        //用户输入的密码和盐进行加密
//        String md5Pwd = SecureUtil.md5(user.getuPassword()+u.getSalt());
//        //密码不一致，返回：用户名或密码错误
//        if(!u.getuPassword().equals(md5Pwd)){
//            resultMap.put("code", 400);
//            resultMap.put("message","用户名或密码错误");
//            return resultMap;
//        }
//        resultMap.put("code", 200);
//        resultMap.put("message","登陆成功");
//        return resultMap;
//    }
    /**
     * 新增User
     * @param user
     * @return
     */
    @Override
    public void add(User user) {
        userMapper.insertSelective(user);
    }

    /**
     * 更新User信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return false;
    }

    /**
     * 删除单个User
     * @param id
     * @return
     */
    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除多个User信息
     * @param userIds
     */
    @Override
    public void deleteAllSelectUser(List<Integer> userIds){
        String userIds2=userIds.toString();
        userIds2= userIds2.replaceAll("\\[|]", "");
        userMapper.deleteByIds(userIds2);
    }

}
