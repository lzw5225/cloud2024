package com.atguigu.cloud.controller;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;
import cn.hutool.core.util.IdUtil;

@RestController
public class PayCircuitController {

    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id) {
        if (id == -4) throw new RuntimeException("----circuit id 不能负数");

        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Hello, circuit! inputId:  " + id + " \t " + IdUtil.simpleUUID();

    }
}
