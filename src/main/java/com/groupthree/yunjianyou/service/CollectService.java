package com.groupthree.yunjianyou.service;

import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.Collect;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LongGe
 * @title CollectService
 * @cresion 1.0.0
 * @create 2024/5/21 21:05
 * @description
 */

@Service
public interface CollectService {
    public List<Collect> getCollect(Collect collect);
    List<Collect> findAll();//查询收藏信息
    public Collect getCollectByfId(Integer fId);
    public PageInfo<Collect> findPage(int page,int size);//分页查询收藏信息
    public int delCollect(Integer fId);//删除收藏信息
    public void deleteManyCollect(List<Integer> fId);//批量删除
    public void updateCollect(Collect collect);//修改
    public void addCollect(String ssName,Double ssPrice,String ssAddress,Long ssId);//添加收藏
}
