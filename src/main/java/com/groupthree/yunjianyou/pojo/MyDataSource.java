package com.groupthree.yunjianyou.pojo;

import cn.hutool.crypto.symmetric.AES;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MyDataSource extends HikariDataSource {
    private AES aes;
    public MyDataSource(AES aes) {
        this.aes = aes;
    }
    @Override
    public String getPassword(){
        String realPassword=aes.decryptStr(super.getPassword());
        return realPassword;
    }
}
