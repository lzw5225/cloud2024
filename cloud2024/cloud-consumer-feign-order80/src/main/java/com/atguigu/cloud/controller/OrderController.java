package com.atguigu.cloud.controller;

import com.atguigu.cloud.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getidorder(@PathVariable("id") Integer id){
        ResultData resultData =payFeignApi.getpayid(id);
        return resultData;
    }

}
