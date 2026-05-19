package com.groupthree.yunjianyou.controller;

import com.baidu.aip.face.AipFace;
import com.groupthree.yunjianyou.pojo.User;
import com.groupthree.yunjianyou.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.HashMap;


@Controller
public class FaceController {
    //从百度申请到的三中参数，用于连接其人脸识别api
    private static final String APP_ID = "83927578";
    private static final String API_KEY = "cbPbHWyoMrtArPKSkYHQYMuw";
    private static final String SECRET_KEY = "5k5YtKDfojDqkjJn1nWgcIUlYlOU1oH8";

    @Autowired
    private UserService userService;

    //将收集到的用户名和相片发送给百度进行注册，其中相片是Base64格式
    //同时相片上传到服务器的photo 文件夫存储，用户数据也保存一份到数据库
    @PostMapping(value="faceRegister")
    @ResponseBody
    public String register (String uName,String faceBase) throws IOException {
        if(!StringUtils.isEmpty(uName) && !StringUtils.isEmpty(faceBase)) {
            //文件上传的地址
            String upPath = ResourceUtils.getURL("classpath:").getPath() + "static\\images\\face-photo";
            //给上传图片命名，格式：用户名_当前时间的毫秒数.jpg
            String fileName = uName + "_" + System.currentTimeMillis() + ".jpg";
            String path = upPath + "\\" + fileName;//上传文件的最终路径
            File file = new File(path);
            //初始化自度云的AipFace
            AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
            //向数据库里插入条用户
            User user = new User();
            user.setuName(uName);
            user.setFacePhoto(path);
            userService.add(user);//添加到数据库
            //图片上传到服务器中
            //将客户端传递过来的相片转换为字节
            byte[] bytes = Base64.getDecoder().decode(faceBase);
            //创建输出流
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);//上传图片
            //创建调用接口所需参数
            //传入可选参数调用接口
            HashMap<String, String> options = new HashMap<String,String>();
            options.put("quality_control", "LOW");
            options.put("liveness_control", "LOW");
            String imageType = "BASE64";//相片格式
            String groupId = "1001";//用户组ID
            //调用接口进行人脸注册，向百度云人脸库插入一张人脸
            JSONObject res = client.addUser(faceBase, imageType, groupId, uName, options);
//            System.out.println(res.toString(2));//控制台观察注册反馈结果
        }
        return "1";
    }

    //用户卷录
    @PostMapping(value = "faceLogin")
    @ResponseBody
    public String login(String faceBase,HttpServletRequest request) {
        String faceData = faceBase;
        //进行人像数据对比
        AipFace client = new AipFace(APP_ID,API_KEY,SECRET_KEY);
        JSONObject user = verifyUser(faceData,client);//进行人像对比获取结果
        Double score = (Double) user.get("score");//获得准确率百分数

        if(score>95) { //准确率超过 95%认为成功
            return "{\"num\":\"1\",\"username\":\""+user.getString("user_id")+"\"}";
        }else {
            return "{\"num\":\"2\"}";
        }
    }

    //人脸对比
    public JSONObject verifyUser(String imgBash64, AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "LOW");
        options.put("liveness_control", "LOW");
        JSONObject res = client.search(imgBash64, "BASE64", "1001", options);
//        System.out.println(res.toString(2));//观察比较结果
//        System.out.println(res.getJSONObject("result"));
//        System.out.println(res.getJSONObject("result").getJSONArray("user_list"));
        JSONObject user = (JSONObject) res.getJSONObject("result").getJSONArray("user_list").get(0);
//        System.out.println("百度返回的user对象："+user.toString());//观察返回的识别到的用户数据
//        System.out.println("uName:"+user.getString("user_id"));
        return user; //识别到的用户信息
    }

}
