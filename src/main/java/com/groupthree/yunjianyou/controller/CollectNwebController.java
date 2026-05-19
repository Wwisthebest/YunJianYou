package com.groupthree.yunjianyou.controller;

import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.Collect;
import com.groupthree.yunjianyou.pojo.Result;
import com.groupthree.yunjianyou.pojo.StatusCode;
import com.groupthree.yunjianyou.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author LongGe
 * @title CollectNwebController
 * @cresion 1.0.0
 * @create 2024/6/18 15:44
 * @description
 */
@RestController
@RequestMapping("col")
public class CollectNwebController {
    @Autowired
    private CollectService collectService;

    /**
     * 查询收藏
     * @return
     */
    @GetMapping("/all")
    public Result<List<Collect>> findAll(){
        List<Collect> list = collectService.findAll();
        return new Result<List<Collect>>(true, StatusCode.OK,"查询收藏成功",list);
    }

    /**
     * 修改收藏信息
     * @param collect
     * @return
     */
    @PutMapping(value = "/updateByfId")
    public Result updateCollect(@RequestBody Collect collect){
        //修改数据
        collectService.updateCollect(collect);
        return new Result(true,StatusCode.OK,"修改收藏信息成功");
    }


    /**
     * 删除收藏信息
     * @param fId
     * @return
     */
    @DeleteMapping(value = "/delByfId")
    public Result deleteCollect(@PathParam(value = "fId") Integer fId){
        collectService.delCollect(fId);
        return new Result(true,StatusCode.OK,"删除收藏信息成功");
    }

    /**
     * 批量删除
     * @param fId
     * @return
     */
    @PostMapping(value = "/deleteManyCollect")
    public Result deleteManyCollect(@RequestBody List<Integer> fId){
        collectService.deleteManyCollect(fId);
        return new Result(true,StatusCode.OK,"批量删除收藏信息成功");

    }


    /**
     * 分页查询收藏信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/sea")
    public Result<PageInfo<Collect>> findPage(@PathParam(value = "page")int page, @PathParam(value = "size") int size){
        PageInfo<Collect> pageInfo = collectService.findPage(page,size);
        return new Result<PageInfo<Collect>>(true,StatusCode.OK,"分页查询收藏信息成功",pageInfo);

    }
}
