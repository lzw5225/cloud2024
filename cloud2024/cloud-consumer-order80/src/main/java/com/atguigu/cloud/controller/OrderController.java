package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    //public static final String PaymentSrv_URL = "http://localhost:8001";
    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }

    @GetMapping("/consumer/pay/delete/{id}")
    public ResultData<String> deleteOrder(@PathVariable("id") Integer id,PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/delete/{id}",payDTO,ResultData.class);
    }

    @GetMapping("/consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/update",payDTO,ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id,PayDTO payDTO) {
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class,id);
    }

    /*@GetMapping("/consumer/pay/getall")
    public ResultData getAllPay(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/getall",payDTO,ResultData.class);
    }*/

    /*@GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }*/
}
