package com.groupthree.yunjianyou.controller;

import com.groupthree.yunjianyou.pojo.AdminUser;
import com.groupthree.yunjianyou.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    /**
     * 管理员登录
     *
     * @param adminUser
     * @return
     */
    @PostMapping("/adminUser_login")
    public String aLogin(AdminUser adminUser, String aUserCode, HttpSession session, Model model) {
        String sysCode=(String) session.getAttribute("sysCode");//系统正确的验证码
        if(sysCode.equalsIgnoreCase(aUserCode)){
            AdminUser adminUser1 = adminUserService.aLogin(adminUser);
            if (adminUser1 != null) { //登录成功-将用户信息保存到session并且去后台首页
                if (adminUser1.getAState() == 1) {
                    System.out.println("登录成功！" + adminUser1);
                    session.setAttribute("adminUser", adminUser1);
                    return "adminUserHtml/b_index";
                } else {
                    model.addAttribute("message", "该账户被禁用！");
                    System.out.println("该账户被禁用！" + adminUser1);
                    return "adminUserHtml/b_login";
                }

            } else { //登录失败-去登录页面-重新登录
                System.out.println("管理员用户名或密码不正确!！");
                model.addAttribute("message", "管理员用户名或密码不正确!");
                return "adminUserHtml/b_login";
            }
        }else {
            System.out.println("验证码错误!！");
            model.addAttribute("message", "验证码错误!");
            return "adminUserHtml/b_login";
        }

    }

    /**
     * 管理员退出功能
     *
     * @param session
     * @return
     */
    @GetMapping("/adminUser_logout")
    public String adminUserLogout(HttpSession session) {
        session.removeAttribute("adminUser");
        session.invalidate();
        return "adminUserHtml/b_login";
    }

    @GetMapping("/b_body")
    public String bBody() {
        return "adminUserHtml/b_body";
    }
    @GetMapping("/b_font")
    public String bFont() {
        return "adminUserHtml/b_font";
    }

}
