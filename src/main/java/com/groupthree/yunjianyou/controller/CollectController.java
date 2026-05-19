package com.groupthree.yunjianyou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.Collect;
import com.groupthree.yunjianyou.service.CollectService;
import com.groupthree.yunjianyou.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LongGe
 * @title CollectController
 * @cresion 1.0.0
 * @create 2024/5/21 21:03
 * @description
 */
@Controller
@RequestMapping("/collect")
//@CrossOrigin
public class CollectController {
    @Autowired
    private CollectService collectService;
    private ScenicSpotService scenicSpotService;
    /**
     * 查询收藏里的所有信息
     * @param model
     * @return
     */
    @GetMapping(value = "/list")
    public String collectList(
            @RequestParam(defaultValue = "1") int pno,
            @RequestParam(defaultValue = "10") int pageSize,
            Collect collect, Model model){
//        Integer username = (Integer)session.getAttribute("username");
        PageHelper.startPage(pno, pageSize); //开始分页

        List<Collect> list = collectService.getCollect(collect);
        PageInfo<Collect> page = new PageInfo<Collect>(list);
        model.addAttribute("collect", list);
        model.addAttribute("page", page);
        model.addAttribute("fId",collect.getfId());
        model.addAttribute("pno", pno);
        return "collectHtml/collect";
    }

    /**
     * 转到详情页
     * @param fId
     * @param model
     * @return
     */
    @GetMapping(value = "details/{fId}")
    public String collectByfId(@PathVariable(value = "fId") Integer fId, Model model){
        Collect collectByfId = collectService.getCollectByfId(fId);
        model.addAttribute("collectByfId",collectByfId);
        return "collectHtml/details";
    }

    /**
     * 添加收藏
     * @param collect
     * @return
     */
    @PostMapping("/addCollect")
    public String addCollect(@RequestBody Collect collect) {
        System.out.println(collect);
        System.out.println(collect.getSsId());
        System.out.println(collect.getSsName());
        System.out.println(collect.getSsPrice());
        collectService.addCollect(collect.getSsName(),collect.getSsPrice(),collect.getSsAddress(),collect.getSsId());
        return "redirect:/collect/list";
    }


    /**
     * 删除收藏信息
     * @param fId
     * @return
     */
    @RequestMapping ("/delCollect/{fId}")
    public String delCollect(@PathVariable("fId") Integer fId){
        int num = collectService.delCollect(fId);
        if (num > 0)
            return "redirect:/collect/list";
        else
            return null;
    }

}
