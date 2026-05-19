package com.groupthree.yunjianyou.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author He
 * @version 1.0.0
 * @title AliPayConfig
 * @create 2024/6/12 19:33
 * @description
 */
public class AliPayConfig {

    //定义APP_ID
    public static String APP_ID="9021000138606836";
    //定义私钥
    public static String APP_PRIVATE_KEY="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC7FNo2ybBN5mtwaX/w23oJqH35U9bUJLa9BDSr7U9QMXKDGBAbAik9YsZ3fx3+IwBt0dkkA/Bat6xZNl6TncD/UcZho1XVLZBfFP7+sIZIYcPCgJu7o7eGkc8Bu2MZOQXigFGrEmUVoyQaGZs2iVxpCgVuF+4a/iZ7mqdP/3ukajQ1hZvB8lW71T8PBktkSXy2RWGusYjej+iuceqVsZt6y6MuxS0JPsMAKCYwMK0zBziGRdC+IBk6SbxUQQNoWxgvaL3QQZnBNcoMmDPMQ9yNYaakD8CGFYu9DH1chLIs+oRkD/FrlYNusUpQ8eJmPj1LSb5xGDYtyJsvjUXJdnrVAgMBAAECggEBAJpVZIOINWK+cOnGjt5zISUwk+QI7xQJyZr7Cjy/RAwDDtXpFvhA+yaCAvp3qpWJ6IOwd3LHsRQVrB/Yw4MBxEKdAoxvw5JeyVg3KPmRROYXiPg/Qro0IGXqiZyDKwiWyy0E8NqxDSUhddn2P95oyQx6UOp24V3xRmv3tIlBWY3TCi8WIhgzJXdkH8S64a7YtiS9Px3X9f0i7kh4leClNNXJgwy06dxChvCB2wOwK2yvixuXkvaMjDSVzl5vgz218pseti69oz7bMVTKcmuIHrhhHFPUN29/YJftUTtSdz66c029ptSp1sV+K/echHW0h9Gv7Ooc8yuHn2VCn1VcKk0CgYEA44V05m/k7Wy5dD+d92jGnOTAEgOHnGYxE6lNid5G8Ft0wB9ASsuWrzLe2crguafBYjhcuWVXaWgblw4vsIbpbzjHEhBarWxLqFPkJBw0+Ia8X0r7Kyce/xRGg2zscfq1BhoN691J4vjsH1l0xgYrVw3k2Lyn67oUqe3DY9OIMKMCgYEA0n+RRfScJGHe6IcqqpjdP1E97SkPBR7P76ENrSX+Yp/N3XeuQX/kqUhBnZ9wVXES77itf4H2UJgOvQCROmxP9/x2rhYqdr+yeG39fcXWOHatcEXxiv0FB13NydMqvtpiw+N4hdri4rh7geJamzPKsTc+mPCu5qPHXHV4s8oTxicCgYEAtUzAVWvukV8k/MRA3Uipk5YYk4Iqiu9HxjIP7n+oKZnHE90TP0ayAVPZDtXCc06BJAJjqPxfRkhGS/1q9RDcbNtijjtn9m+obi7DSh8L+spqysiWEtHuujZu5gVi+IRdwcn7M+s3GF1g0q5XBgEeghU5OZhDeuzh0HL9UsvZ518CgYAFHqkv5GUv1VmQmkkFYTZwZc91xzvgSgGQuIAWqAfp6i0dp92LJksvetxtswUObvOg9QLzSPvuteQV4L+nhh7jzzYrwcpCnSMAHty9hGRTdz98rZbUZJcMuNFaiVJO1gz06sFxsAM4tHf8jr7Za4cQjGFvYts+LNmafBj1doLInQKBgQDatO3sRFDsrztFguMOYqcS7DHpa7nyjTLQFiUz32SY61DbjTP2WibEnC46UALElOEIBocHA9N3/BMMrSn/o3TZ3oS07kSNTkgOgk4h6SBpznXe8N7xLOZ61Br3HtEDsikh+fUpjC0CFXNyd54icfe68+yOTHbHh7mPJBIiW1y2HQ==";
    //定义支付宝的公钥R
    public static String APP_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuxTaNsmwTeZrcGl/8Nt6Cah9+VPW1CS2vQQ0q+1PUDFygxgQGwIpPWLGd38d/iMAbdHZJAPwWresWTZek53A/1HGYaNV1S2QXxT+/rCGSGHDwoCbu6O3hpHPAbtjGTkF4oBRqxJlFaMkGhmbNolcaQoFbhfuGv4me5qnT/97pGo0NYWbwfJVu9U/DwZLZEl8tkVhrrGI3o/ornHqlbGbesujLsUtCT7DACgmMDCtMwc4hkXQviAZOkm8VEEDaFsYL2i90EGZwTXKDJgzzEPcjWGmpA/AhhWLvQx9XISyLPqEZA/xa5WDbrFKUPHiZj49S0m+cRg2LcibL41FyXZ61QIDAQAB";
    //回调地址
    public static String NOTIFY_URL="http://localhost:8086/myPay/toNotify";
    //支付成功之后进行的返回的地址
    public static String RETURN_URL="http://localhost:8086/myPay/succ";
    //签名的方式
    public static String SIGN_TYPE="RSA2";
    //编码格式
    public static String CHARSET="utf-8";
    //支付宝的网关地址
    public static String GATEWAY_URL="https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    //日志存放的父级路径
    public static String LOG_PATH="D:\\tmp\\";
    public static void logResult(String word){
        FileWriter writer=null;
        try {
            //D:/tmp/alipay_log_17646748956739.txt
            writer=new FileWriter(LOG_PATH+"alipay_log_"+System.currentTimeMillis()+".txt");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
