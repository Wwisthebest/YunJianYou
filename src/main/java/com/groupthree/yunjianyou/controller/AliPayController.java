package com.groupthree.yunjianyou.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.groupthree.yunjianyou.config.AliPayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author He
 * @version 1.0.0
 * @title AliPayController
 * @create 2024/6/12 19:37
 * @description
 */

@Controller
@RequestMapping(value = "/myPay")
public class AliPayController {
    //成功之后的跳转地址
    @GetMapping(value = "/succ")
    public String succ(){
        AliPayConfig.logResult("支付成功，跳转到成功页面................");
        return "/pay/succ";
    }
    /**
     * 回调地址
     */
    @GetMapping(value = "/toNotify")
    public String toNotify(){
        return "/pay/toNotify";
    }

    /**
     * 使用支付宝支付
     * @param request
     * @param response
     * @throws Exception
     */
    @PostMapping(value = "/pay")
    public void pay(HttpServletRequest request, HttpServletResponse response)throws Exception{
        AlipayClient alipayClient=new DefaultAlipayClient(
                AliPayConfig.GATEWAY_URL,
                AliPayConfig.APP_ID,
                AliPayConfig.APP_PRIVATE_KEY,
                "json",
                AliPayConfig.CHARSET,
                AliPayConfig.APP_PUBLIC_KEY,
                AliPayConfig.SIGN_TYPE
        );
        //设置请求参数
        AlipayTradePagePayRequest alipayTradePagePayRequest=new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(AliPayConfig.RETURN_URL);
        alipayTradePagePayRequest.setNotifyUrl(AliPayConfig.NOTIFY_URL);
        //获取订单号
        String out_trad_no = request.getParameter("tradeNo");
        //商品名称
        String subject = request.getParameter("name");
        //商品总价
        String total_amount = request.getParameter("amount");
        //商品描述
        String body = request.getParameter("desc");

        alipayTradePagePayRequest.setBizContent("{\"out_trade_no\":\""+ out_trad_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\"10m\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form="";
        try {
            //使用SDK生成表单
            form=alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
        }catch (AlipayApiException e){
            e.printStackTrace();
        }
        //response.setContentType("text/html;charset="+AliPayConfig.CHARSET);
        response.setContentType("text/html;charset="+AliPayConfig.CHARSET);
        //直接将完整的表单写入到html页面
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
