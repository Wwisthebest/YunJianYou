package com.groupthree.yunjianyou.controller;

import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.Result;
import com.groupthree.yunjianyou.pojo.ScenicSpot;
import com.groupthree.yunjianyou.pojo.StatusCode;
import com.groupthree.yunjianyou.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author He
 * @version 1.0.0
 * @title ScenicSpotController
 * @create 2024/5/27 20:58
 * @description
 */
@RestController
@RequestMapping("/spots")
@CrossOrigin//跨域
public class ScenicSpotController {
    @Autowired
    private ScenicSpotService scenicSpotService;

    /**
     * 查询所有景点信息
     * @return
     */
    @GetMapping("/all")
    public Result<List<ScenicSpot>> findAll(){
        List<ScenicSpot> list = scenicSpotService.findAll();
        return new Result<List<ScenicSpot>>(true, StatusCode.OK,"查询所有景点信息成功",list);
    }

    /**
     * 根据ID查询景点信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<ScenicSpot> findById(@PathVariable(value = "id") Long id){
        ScenicSpot scenicSpot = scenicSpotService.findById(id);
        return new Result<ScenicSpot>(true,StatusCode.OK,"查询景点信息成功",scenicSpot);
    }

    /**
     * 增加景点信息
     */
    @PostMapping
    public Result addScenicSpot(@RequestBody ScenicSpot scenicSpot){
        scenicSpotService.addScenicSpot(scenicSpot);
        return new Result(true,StatusCode.OK,"景点信息增加成功");
    }

    /**
     * 修改景点的信息(根据ID)
     */
    @PutMapping(value = "updateById")
    public Result updateScenicSpot(@RequestBody ScenicSpot scenicSpot){
        //修改数据
        scenicSpotService.updateScenicSpot(scenicSpot);
        return new Result(true,StatusCode.OK,"修改景点信息成功");
    }

    /**
     * 删除景点的信息(根据ID)
     */
    @DeleteMapping(value = "/delById")
    public Result deleteScenicSpot(@PathParam(value = "id") Long id){
        scenicSpotService.deleteScenicSpot(id);
        return new Result(true,StatusCode.OK,"删除景点信息成功");
    }

    /**
     * 批量删除景点(根据ID列表)
     * @param scenicSpotIds
     * @return
     */
    @PostMapping(value = "/deleteManyScenicSpot")
    public Result deleteManyScenicSpot(@RequestBody List<Long> scenicSpotIds){
        scenicSpotService.deleteManyScenicSpot(scenicSpotIds);
        return new Result(true,StatusCode.OK,"批量删除景点信息成功");
    }

    /**
     * 分页查询景点信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search")
    public Result<PageInfo<ScenicSpot>> findPage(@PathParam(value = "page") int page, @PathParam(value = "size") int size){
        PageInfo<ScenicSpot> pageInfo = scenicSpotService.findPage(page,size);
        return new Result<PageInfo<ScenicSpot>>(true,StatusCode.OK,"分页查询景点信息成功",pageInfo);
    }

    /**
     * 多条件查询景点信息
     * @param scenicSpot
     * @return
     */
    @PostMapping("/search")
    public Result<List<ScenicSpot>> findList(@RequestBody ScenicSpot scenicSpot){
        List<ScenicSpot> List = scenicSpotService.findList(scenicSpot);
        return new Result<List<ScenicSpot>>(true,StatusCode.OK,"多条件查询景点信息成功",List);
    }

}
