package com.groupthree.yunjianyou.opera;

import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * @author He
 * @version 1.0.0
 * @title FastDFSClientOpt
 * @create 2024/6/8 13:44
 * @description
 */
public class FastDFSClientOpt {
    /**
     * 获取TrackerServer对象
     * @return
     * @throws Exception
     */
    public static TrackerServer getTrackerServer()throws  Exception{
        //创建TrackerClient对象
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }
    public static StorageClient getStorageClient()throws Exception{
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient=new StorageClient(trackerServer,null);
        return storageClient;
    }
}
