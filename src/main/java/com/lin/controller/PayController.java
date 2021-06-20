package com.lin.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.lin.common.websocket.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {
    /**
     * 当用户完成扫码支付后微信平台就回请求这个接口，将支付状态传递过来
     * @param request
     * @return
     */
    @RequestMapping("/callback")
    public String paySuccess(HttpServletRequest request)throws Exception{
        System.out.println("------------------------going");
        ServletInputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[1024];
        int len=-1;
        StringBuilder builder = new StringBuilder();
        if ((len=inputStream.read(bytes))!=-1){
            builder.append(new String(bytes,0,len));
        }
        //request请求接受到的微信平台传递的数据被读取出来为WXxml(xml格式)
        String WXxml = builder.toString();
        Map<String, String> WXMap = WXPayUtil.xmlToMap(WXxml);
        if (WXMap!=null&&"SUCCESS".equalsIgnoreCase(WXMap.get("result_code"))){
            //支付成功
            String orderId = WXMap.get("out_trade_no");
            //向socket发生交易成功消息
            WebSocketServer.sendMsg(orderId,"1");
        }
        //响应微信平台
        HashMap<String, String> respMap = new HashMap<>();
        respMap.put("return_code",WXMap.get("return_code"));
        respMap.put("result_code",WXMap.get("result_code"));
        respMap.put("appid",WXMap.get("appid"));
        respMap.put("return_msg","OK");
        return WXPayUtil.mapToXml(respMap);
    }
}
