package com.groupthree.yunjianyou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.ScenicSpot;
import com.groupthree.yunjianyou.service.ScenicSpotService;
import com.groupthree.yunjianyou.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author He
 * @version 1.0.0
 * @title ScenicSpotWebController
 * @create 2024/6/10 12:48
 * @description
 */
@Controller
@RequestMapping(value = "/spotsWeb")
public class ScenicSpotWebController {
    @Autowired
    private ScenicSpotService scenicSpotService;

    /**
     * 分页查看所有景点信息
     * @param pno
     * @param pageSize
     * @param scenicSpot
     * @param model
     * @return
     */
    @GetMapping(value = "/page_list")
    public String findPageList(@RequestParam(defaultValue = "1") int pno, @RequestParam(defaultValue = "4") int pageSize,
                               ScenicSpot scenicSpot, Model model){
        PageHelper.startPage(pno,pageSize);//开始分页
        List<ScenicSpot> scenicSpotList = scenicSpotService.findList(scenicSpot);
        PageInfo<ScenicSpot> pageInfo = new PageInfo<ScenicSpot>(scenicSpotList);
        model.addAttribute("scenicSpotList",scenicSpotList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pno",pno);
        model.addAttribute("spotName",scenicSpot.getSpotName());
        model.addAttribute("spotState",scenicSpot.getSoptState());
        model.addAttribute("spotAddress",scenicSpot.getSpotAddress());
        model.addAttribute("mapInfo",scenicSpot.getMapInfo());

        return "/spot/spots_view";
    }

    /**
     * 欢迎页所有景点信息
     * @param scenicSpot
     * @param model
     * @return
     */
    @GetMapping(value = "/index")
    public String findPage(ScenicSpot scenicSpot, Model model){
        List<ScenicSpot> scenicSpotList = scenicSpotService.findList(scenicSpot);
        model.addAttribute("scenicSpotList",scenicSpotList);
        return "/index";
    }

    /**
     * 分页查看后台景点列表
     * @param pno
     * @param pageSize
     * @param scenicSpot
     * @param model
     * @return
     */
    @GetMapping(value = "/list")
    public String findList(@RequestParam(defaultValue = "1") int pno, @RequestParam(defaultValue = "10") int pageSize,
                           ScenicSpot scenicSpot, Model model){
        PageHelper.startPage(pno,pageSize);//开始分页
        List<ScenicSpot> scenicSpotList = scenicSpotService.findList(scenicSpot);
        PageInfo<ScenicSpot> pageInfo = new PageInfo<ScenicSpot>(scenicSpotList);
        model.addAttribute("scenicSpotList",scenicSpotList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pno",pno);
        model.addAttribute("spotName",scenicSpot.getSpotName());
        model.addAttribute("spotState",scenicSpot.getSoptState());
        model.addAttribute("spotAddress",scenicSpot.getSpotAddress());

        return "/spot/spots_list";
    }

    /**
     * 根据id查询景点信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/detail/{id}")
    public String findSpotsById(@PathVariable(value = "id") Long id, Model model){
        ScenicSpot scenicSpot = scenicSpotService.findById(id);
        model.addAttribute("scenicSpot",scenicSpot);
        return "/spot/spots_detail";
    }

    /**
     * 产生订单：订单号
     * @param request
     * @param model
     * @return
     */
    @PostMapping("/pay")
    public String orderPay(HttpServletRequest request, Model model){
        //获取数量
        String num = request.getParameter("num");
        double v1Num=Double.parseDouble(num);
        //获取单价
        String ticketPrice = request.getParameter("ticketPrice");
        double v2Price=Double.parseDouble(ticketPrice);
        //计算总价
        double totalPrice=v1Num*v2Price;
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        String format = decimalFormat.format(totalPrice);
        //使用雪花算法
        IdWorker idWorker=new IdWorker(1,1);
        long orderId = idWorker.nextId();
        //获取商品的名称
        String name = request.getParameter("spotName");
        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("num",num);
        model.addAttribute("tradeNo",orderId);
        model.addAttribute("spotName",name);
        //获取名称
        return "/spot/spots_order";
    }

}
