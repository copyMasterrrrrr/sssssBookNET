package com.lin.controller;

import com.github.wxpay.sdk.WXPay;
import com.lin.common.VO.ResultVO;
import com.lin.common.config.MyPayConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.genid.GenId;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/vip")
@Api(value = "提供vip权限购买的接口",tags = "购买vip")
public class vipController {

    @GetMapping("/buy")
    @ApiImplicitParam(dataType = "String" ,name="oderId",value = "订单编号",required = true)
    public ResultVO buyVip(String orderId){
        try{
            //建立一个map保存订单信息
            HashMap<String,String> data=new HashMap<>();
            data.put("body","ssss书城vip购买");//商品描述
            data.put("out_trade_no",orderId);//交易号
            data.put("fee_type","CNY");//支付货币
            data.put("total_fee","1");//价格
            data.put("trade_type","NATIVE");//交易类型
            data.put("notify_url","http://sssss.free.idcfengye.com/pay/callback");//设置支付方法完成后的回调方法

            //发送请求，获取响应
            WXPay wxPay=new WXPay(new MyPayConfig());
            Map<String, String> order = wxPay.unifiedOrder(data);
            String code_url = order.get("code_url");
            if (code_url!=null){
                return new ResultVO(9999,"获取支付链接成功",code_url);
            }else{
                return new ResultVO(9998,"获取支付链接失败",null);
            }

        }catch (Exception e){
            return new ResultVO(9998,"获取支付链接失败",null);
        }

    }

}
