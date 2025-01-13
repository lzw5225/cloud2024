package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "支付微服务模块")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "增加")
    public ResultData<String> addPay(@RequestBody Pay pay) {
       int add = payService.add(pay);
       String s = "成功插入记录" + add + "条，这条记录是：" + pay.toString();
       //return s;
        return ResultData.success(s);
    }

    @DeleteMapping("/pay/delete/{id}")
    @Operation(summary = "删除")
    public ResultData<String> deletePay(@PathVariable("id") Integer id) {
        int delete = payService.delete(id);
        String s = "成功删除记录" + delete + "条，这条记录的id号是：" + id;
        return ResultData.success(s);
    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.update(pay);
        String s = "成功修改记录" + update + "条，这条记录是：" + payDTO.toString();
        return ResultData.success(s);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "给一个id号获取这个id号的记录")
    public ResultData<String> getPay(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        if(pay != null) {
            String s = "成功查到记录,这条记录是：" + pay.toString();
            return ResultData.success(s);
        }else{
            String s = "没有查到这条记录";
            return ResultData.fail(ReturnCodeEnum.RC999.getCode(), ReturnCodeEnum.RC999.getMsg());
        }
    }

    @GetMapping("/pay/getall")
    @Operation(summary = "获取所有")
    public ResultData<String> getAllPay() {
        List<Pay> pay = payService.getAll();
        String s1 = "成功查到所有记录，它们分别是：";
        String s2 = "";
        for(Pay pay1 : pay) {
            s2 = s2 + pay1.toString();
        }
        return ResultData.success(s1 + s2);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String info) {
            return "lzwinfo:" + info + "/t" + "port:" + port;
    }


}
