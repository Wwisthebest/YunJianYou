package com.groupthree.yunjianyou.controller;

import com.groupthree.yunjianyou.pojo.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author He
 * @version 1.0.0
 * @title HtmlController
 * @create 2024/5/27 22:22
 * @description
 */
@Controller
public class HtmlController {

    /**
     * 欢迎页跳转
     * @return
     */
    @GetMapping("index")
    public String scenicSpotsIndex(){
        return "index";
    }

    /**
     * 用户登陆页跳转
     * @return
     */
    @GetMapping("login")
    public String toLogin() {
        return "/userHtml/login";
    }

    /**
     * 管理员登录页跳转
     * @return
     */
    @GetMapping("adminUserLogin")
    public String adminUserLogin(AdminUser adminUser) {
        return "adminUserHtml/b_login";
    }

    /**
     * 用户列表页
     * @return
     */
    @GetMapping("findUserPage")
    public String findUserPage(){
        return "/userHtml/list";
    }

    /**
     * 景点列表页跳转
     * @return
     */
    @GetMapping("pageSpots")
    public String ToSpotsList(){
        return "/spot/spots_list";
    }

    /**
     * 景点列表页新增景点信息页面
     * @return
     */
    @GetMapping(value = "/spotAddPage")
    public String spotAddPage(){
        return "/spot/spots_add";
    }

    /**
     * 景点列表页修改景点信息页面
     * @return
     */
    @GetMapping(value = "/spotEditPage")
    public String spotEditPage(){
        return "/spot/spots_edit";
    }

    /**
     * 景点列表页修改景点信息页面
     * @return
     */
    @GetMapping(value = "/spotDetailPage")
    public String spotDetailPage(){
        return "/spot/spots_bg_detail";
    }

    /**
     * 关于云间游
     * @return
     */
    @GetMapping(value = "/about")
    public String about(){
        return "/about";
    }

    @GetMapping("pageCollect")
    public String ToCollectList(){ return "/collectHtml/collect_list";}
}
