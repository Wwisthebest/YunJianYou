package com.groupthree.yunjianyou.utils;

/**
 * @author He
 * @version 1.0.0
 * @title FastDFSFile
 * @create 2024/6/8 13:29
 * @description
 */
public class FastDFSFile {
    //文件名称
    private String name;
    //文件内容
    private byte[] content;
    //文件扩展名
    private String ext;
    //文件MD5值
    private String MD5;
    //文件创建作者
    private String author;
    public FastDFSFile(String name, byte[] content, String ext, String MD5, String author) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.MD5 = MD5;
        this.author = author;
    }
    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;

    }

    public FastDFSFile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
