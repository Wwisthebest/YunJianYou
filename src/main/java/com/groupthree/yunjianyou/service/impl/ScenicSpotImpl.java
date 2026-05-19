package com.groupthree.yunjianyou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.mapper.ScenicSpotMapper;
import com.groupthree.yunjianyou.pojo.ScenicSpot;
import com.groupthree.yunjianyou.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author He
 * @version 1.0.0
 * @title ScenicSpotImpl
 * @create 2024/5/27 20:47
 * @description
 */
@Service
@Transactional
public class ScenicSpotImpl implements ScenicSpotService {
    @Autowired
    private ScenicSpotMapper scenicSpotMapper;

    /**
     * 查询所有景点信息
     * @return
     */
    @Override
    public List<ScenicSpot> findAll(){
        return scenicSpotMapper.selectAll();
    }

    /**
     * 根据ID查询景点信息
     * @param id
     * @return
     */
    @Override
    public ScenicSpot findById(Long id){
        return scenicSpotMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增景点
     * @param scenicSpot
     * @return
     */
    @Override
    public void addScenicSpot(ScenicSpot scenicSpot){
        scenicSpotMapper.insertSelective(scenicSpot);
    }

    /**
     * 修改景点(根据ID)
     * @param scenicSpot
     */
    @Override
    public void updateScenicSpot(ScenicSpot scenicSpot){
        scenicSpotMapper.updateByPrimaryKeySelective(scenicSpot);
    }

    /**
     * 删除景点(根据ID)
     * @param id
     */
    @Override
    public void deleteScenicSpot(Long id){
        scenicSpotMapper.deleteByPrimaryKey(id);
    }
    /**
     * 批量删除景点(根据ID列表)
     * @param scenicSpotIds
     */
    @Override
    public void deleteManyScenicSpot(List<Long> scenicSpotIds){

        scenicSpotMapper.deleteByIds(scenicSpotIds.toString().replaceAll("\\[|]", ""));
    }

    /**
     * 分页查询景点信息
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ScenicSpot> findPage(int page,int size){
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<ScenicSpot>(scenicSpotMapper.selectAll());
    }

    /**
     * 多条件查询景点信息
     * @param scenicSpot
     * @return
     */
    @Override
    public List<ScenicSpot> findList(ScenicSpot scenicSpot){
        //构建查询的条件
        Example example = createExample(scenicSpot);
        //多条件查询品牌的信息
        return scenicSpotMapper.selectByExample(example);
    }
    /**
     * 构建条件对象
     */
    public Example createExample(ScenicSpot scenicSpot){
        Example example = new Example(ScenicSpot.class);
        Example.Criteria criteria = example.createCriteria();
        if (scenicSpot!=null){
            //景点名称
            if(!StringUtils.isEmpty(scenicSpot.getSpotName())){
                //第一个参数：指定要比较的条件，属性的名称【不是数据库表中字段的名称】
                //第二个参数：指定要比较的值
                criteria.andLike("spotName","%"+scenicSpot.getSpotName()+"%");
            }
            //景点地址
            if(!StringUtils.isEmpty(scenicSpot.getSpotAddress())){
                //第一个参数：指定要比较的条件，属性的名称【不是数据库表中字段的名称】
                //第二个参数：指定要比较的值
                criteria.andLike("spotAddress","%"+scenicSpot.getSpotAddress()+"%");
            }
        }
        return example;
    }

}
