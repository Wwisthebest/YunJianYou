package com.groupthree.yunjianyou.opera;


import com.groupthree.yunjianyou.utils.FastDFSFile;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author He
 * @version 1.0.0
 * @title FastDFSClient
 * @create 2024/6/8 13:27
 * @description
 */
public class FastDFSClient {
    /**
     * 静态代码块：只执行一次
     * 构造代码块：每次创建对象都会被执行一次
     */
    static {
        try{
            //获取到tracker的配置文件的路径
            String path = new ClassPathResource("fdfs_client.conf").getPath();
            ClientGlobal.init(path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String[] upload(FastDFSFile fastDFSFile){
        //获取作者的信息
        NameValuePair[] meta_list=new NameValuePair[1];
        meta_list[0]=new NameValuePair(fastDFSFile.getAuthor());
        String[] uploadResult=null;
        /**
         * uploadResult[0]=group1
         * uploadResult[1]=M00/00/00/wKgKCmXvwdKALtg-ABOfHfZQaSs194.jpg
         */
        try{
            //获取到TrackerClient
            TrackerClient trackerClient=new TrackerClient();
            //通过TrackerClient创建TrackerServer
            TrackerServer trackerServer=trackerClient.getConnection();
            //通过TrackerServer获取StorageClient
            StorageClient storageClient=new StorageClient(trackerServer,null);
            //执行文件
            uploadResult=storageClient.upload_file(fastDFSFile.getContent(),fastDFSFile.getExt(),meta_list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return uploadResult;
    }
    /**
     * 获取文件的信息
     * @param groupName 组名
     * @param remoteFileName 文件完整路径
     * @return
     */
    public static FileInfo getFile(String groupName, String remoteFileName){
        try{
            StorageClient storageClient = FastDFSClientOpt.getStorageClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件下载
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static InputStream downLoadFile(String groupName, String remoteFileName){
        try{
            StorageClient storageClient = FastDFSClientOpt.getStorageClient();
            //通过storageClient对象下载文件
            byte[] bytes = storageClient.download_file(groupName, remoteFileName);
            //将字节数组转换为字节输入流
            return new ByteArrayInputStream(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
