package com.groupthree.yunjianyou.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.groupthree.yunjianyou.pojo.User;
import com.groupthree.yunjianyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserHtmlController {

    @Autowired
    private UserService userService;

    /**
     * User登录
     *
     * @param user
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/user_login")
    public String login(User user, String userCode, HttpSession session, Model model) {
        String sysCode=(String) session.getAttribute("sysCode");//系统正确的验证码
        System.out.println("aa");
        System.out.println(user);
        if(sysCode.equalsIgnoreCase(userCode)){
           

            User user1 = userService.login(user);
            System.out.println(user);
            if (user1 != null) { //登录成功-将用户信息保存到session并且去后台首页
                System.out.println("登录成功！" + user1);
                session.setAttribute("user", user1);
                session.setAttribute("uName", user1.getuName());
                //跳转个人详细页面取值
                model.addAttribute("user", user1);
                return "index";
            } else { //登录失败-去登录页面-重新登录
                System.out.println("用户手机号或密码不正确!！");
                model.addAttribute("message", "用户手机号或密码不正确!");
                return "/userHtml/login";
            }
        }else {
            System.out.println("验证码错误!！");
            model.addAttribute("message", "验证码错误!");
            return "/userHtml/login";
        }

    }

    /**
     * 注册
     * @param user
     * @param response
     */
//    @PostMapping("/user_register")
//    public void register(User user, HttpServletResponse response) {
//        response.setContentType("text/html;charset=utf-8");
//        try {
//            user.setDeleteStatus(0);
//            userService.add(user);
//            //注册成功
//            response.getWriter().write("<script>alert('注册成功，请登录!');location.href='/login';</script>");
//        } catch (Exception e) {
//            try {
//                response.getWriter().write("<script>alert('注册失败，请重新注册!');location.href='/login';</script>");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }finally {
//            }
//        }
//    }

    /**
     * 退出功能
     *
     * @param session
     * @return
     */
    @GetMapping("logout")
    public String userLogout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "/index";
    }

    /**
     * 用户列表页-新增用户
     * @return
     */
    @GetMapping("/userAddPage")
    public String userAddPage(){
        return "/userHtml/add";
    }
    /**
     * 用户列表页-更新用户
     * @return
     */
    @GetMapping("/userEditPage")
    public String userEditPage(){
        return "/userHtml/edit";
    }

    /**
     * 个人中心
     * @return
     */
    @GetMapping("/user_info")
    public String userInfo(){
        return "/userHtml/info";
    }



    /**
     * 修改密码页面
     * @return
     */
    @GetMapping("/to_changePassword")
    public String toChangePassword(){
        return "/userHtml/info_changePassword";
    }

    /**
     * 人脸识别登陆
     * @return
     */
    @GetMapping("/to_faceLogin")
    public String toFaceLogin(){
        return "/userHtml/face/login";
    }

    /**
     * 人脸识别注册
     * @return
     */
    @GetMapping("/to_faceRegister")
    public String toFaceRegister(){
        return "/userHtml/face/register";
    }

    @GetMapping("/to_faceIndex")
    public String toFaceIndex(){
        return "/userHtml/face/index";
    }
}
