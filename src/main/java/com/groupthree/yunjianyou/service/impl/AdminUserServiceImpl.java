package com.groupthree.yunjianyou.service.impl;

import com.groupthree.yunjianyou.mapper.AdminUserMapper;
import com.groupthree.yunjianyou.pojo.AdminUser;
import com.groupthree.yunjianyou.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserMapper adminUserMapper;
    @Override
    public AdminUser aLogin(AdminUser adminUser) {
        return adminUserMapper.selectOne(adminUser);
    }
}
