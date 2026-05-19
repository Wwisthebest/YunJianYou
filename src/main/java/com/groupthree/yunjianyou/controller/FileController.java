package com.groupthree.yunjianyou.controller;

import com.groupthree.yunjianyou.opera.FastDFSClient;
import com.groupthree.yunjianyou.pojo.Result;
import com.groupthree.yunjianyou.pojo.StatusCode;
import com.groupthree.yunjianyou.utils.FastDFSFile;
import com.groupthree.yunjianyou.utils.KindEditorResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author He
 * @version 1.0.0
 * @title FileController
 * @create 2024/6/8 13:31
 * @description
 */

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {
    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception{
        FastDFSFile fastDFSFile=new FastDFSFile(file.getOriginalFilename(),file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename()));

        String[] upload = FastDFSClient.upload(fastDFSFile);
        String url="http://192.168.10.10:8080/"+upload[0]+"/"+upload[1]+"";
        return new Result(true, StatusCode.OK,"文件上传成功",url);
    }

    /**
     * KindEditor文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/kindEditorUpload")
    public KindEditorResult uploadImgKindeditor(@RequestParam("file") MultipartFile file) throws Exception{

        if (!StringUtils.isEmpty(file) && file.getSize()>0) {
            FastDFSFile fastDFSFile=new FastDFSFile(file.getOriginalFilename(),file.getBytes(),
                    StringUtils.getFilenameExtension(file.getOriginalFilename()));
            String[] upload = FastDFSClient.upload(fastDFSFile);
            String url="http://192.168.10.10:8080/"+upload[0]+"/"+upload[1]+"";
            return new KindEditorResult(0,"文件上传成功！",url);
        }else {
            return new KindEditorResult(1,"文件上传异常！",null);
        }

    }
}
