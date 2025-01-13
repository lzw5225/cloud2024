package com.atguigu.cloud.resp;

import cn.hutool.core.date.DateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultData<T> {

    private String code;
    private String msg;
    private T data;
    private String timestamp;


    public ResultData() {
        long l = System.currentTimeMillis();
        this.timestamp = new DateTime(l).toLocaleString();
    }

    public static <T>  ResultData<T> success(T data) {
       ResultData ord = new ResultData();
       ord.setCode(ReturnCodeEnum.RC200.getCode());
       ord.setMsg(ReturnCodeEnum.RC200.getMsg());
       ord.setData(data);
       return ord;
    }

    public static <T>  ResultData<T> fail(String code, String msg) {
        ResultData ord = new ResultData();
        ord.setCode(code);
        ord.setMsg(msg);
        ord.setData(null);
        return ord;
    }
}
