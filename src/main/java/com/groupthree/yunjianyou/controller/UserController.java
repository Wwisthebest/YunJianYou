package com.groupthree.yunjianyou.controller;

import com.github.pagehelper.PageInfo;
import com.groupthree.yunjianyou.pojo.Result;
import com.groupthree.yunjianyou.pojo.StatusCode;
import com.groupthree.yunjianyou.pojo.User;
import com.groupthree.yunjianyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 根据ID查询User信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result<User> findById(@PathVariable Integer id) {
        //调用UserService实现根据主键查询User
        User user = userService.findById(id);
        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }

    /***
     * 分页查询User全部信息
     * @return
     */
    @GetMapping(value = "/search" )
    public Result<PageInfo> findPage(@RequestParam(value = "pageNo") Integer pageNo,@RequestParam(value = "pageSize") Integer pageSize){
        //调用UserService实现分页查询User
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",userService.findUserPage(pageNo, pageSize));
    }

    /**
     * 新增User信息
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        System.out.println("生成");
        userService.add(user);
        return new Result(true,StatusCode.OK,"新增用户成功");
    }

    /**
     * 更新User信息
     * @param user
     * @return
     */
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        System.out.println("修改");
        userService.updateUser(user);
        return new Result(true,StatusCode.OK,"修改用户成功");
    }

    /**
     * 单个删除User信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteUserById")
    public Result deleteUserById(@PathParam(value = "id") Integer id){
        System.out.println("删除");
        userService.deleteUserById(id);
        return new Result(true,StatusCode.OK,"删除单个用户成功");
    }

    /**
     * 多个删除User信息
     * @param userIds
     * @return
     */
    @PostMapping(value = "/deleteAllSelectUser")
    public Result deleteAllSelectUser(@RequestBody List<Integer> userIds){
        userService.deleteAllSelectUser(userIds);
        return new Result(true,StatusCode.OK,"删除多个用户成功");
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Map<String, Object> register(User user) {
        return userService.register(user);
    }

    /**
     * 更改用户信息
     * @return
     */
    @PostMapping("/user_updateInfo")
    @ResponseBody
    public Result userUpdateInfo(HttpSession session,User user){
        User user1 = (User) session.getAttribute("user");
        if(user1 != null) {
            user1.setuName(user.getuName());
            user1.setuNickName(user.getuNickName());
            user1.setuIdNum(user.getuIdNum());
            user1.setPhone(user.getPhone());
            user1.setSex(user.getSex());
            user1.setEmail(user.getEmail());
            userService.updateUser(user1);
            return new  Result(false,200,"个人信息更新成功!");
        }else {
            return new  Result(false,500,"个人信息更新异常!");
        }
//        return "/userHtml/info";
    }

    /**
     * 修改密码方法
     * @param password
     * @param newPassword
     * @param checkPassword
     * @param session
     * @return
     */
    @PostMapping("/infoTochangePassword")
    @ResponseBody
    public Result infoTochangePassword(String password,String newPassword,String checkPassword,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (StringUtils.isEmpty(newPassword)||StringUtils.isEmpty(checkPassword)){
            return new Result(false,500,"要修改的密码不能为空!");
        }else if(!newPassword.equals(checkPassword)){
            return new Result(false,500,"两次输入的密码不一致");
        }else if(!user.getuPassword().equals(password)){
            return new Result(false,500,"原密码输入错误");
        }else if(password.equals(newPassword)){
            return new Result(false,500,"原密码不能与新密码相同");
        }else {
            user.setuPassword(newPassword);
            boolean b=userService.updateUser(user);//更新数据库
            return new Result(true,200,"密码修改成功");
        }
    }

    /**
     * 登陆账号
     * @param user
     * @return
     */
//    @PostMapping("/login")
//    public Map<String, Object> login(User user, HttpSession session) {
//        String sysCode=(String) session.getAttribute("sysCode");//系统正确的验证码
//
//        return userService.login(user);
//    }
}
