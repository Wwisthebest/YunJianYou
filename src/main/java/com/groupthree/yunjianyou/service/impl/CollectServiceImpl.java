package com.groupthree.yunjianyou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.mapper.CollectMapper;
import com.groupthree.yunjianyou.pojo.Collect;
import com.groupthree.yunjianyou.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LongGe
 * @title CollectServiceImpl
 * @cresion 1.0.0
 * @create 2024/5/21 21:05
 * @description
 */
@Service
@Transactional
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    /**
     * 查询收藏信息
     * @return
     */
    @Override
    public List<Collect> getCollect(Collect collect) {

        return collectMapper.selectAll();
    }
    @Override
    public List<Collect> findAll() {

        return collectMapper.selectAll();
    }


    /**
     * 根据ID查询信息
     * @param fId
     * @return
     */
    @Override
    public Collect getCollectByfId(Integer fId) {

        return collectMapper.selectByPrimaryKey(fId);
    }

    /**
     * 分页查询收藏信息
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Collect> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<Collect>(collectMapper.selectAll());
    }

    /**
     * 删除收藏信息
     *
     * @param fId
     */
    public int delCollect(Integer fId) {

        return collectMapper.deleteByPrimaryKey(fId);
    }

    /**
     * 批量删除
     * @param fId
     */
    @Override
    public void deleteManyCollect(List<Integer> fId) {
        collectMapper.deleteByIds(fId.toString().replaceAll("\\[|]", ""));
    }

    /**
     * 修改
     * @param collect
     * @return
     */
    @Override
    public void updateCollect(Collect collect) {

         collectMapper.updateByPrimaryKeySelective(collect);
    }

    /**
     * 增加收藏
     * @param ssId
     */
    @Override
    public void addCollect( String ssName, Double ssPrice,String ssAddress,Long ssId) {
        Collect collect = new Collect();
        collect.setSsName(ssName);
        collect.setSsPrice(ssPrice);
        collect.setSsAddress(ssAddress);
        collect.setSsId(ssId);
        collectMapper.insertSelective(collect);
    }
}
