package com.atguigu.cloud.resp;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReturnCodeEnum {

    RC999("999","999操作失败"),
    RC200("200","200操作成功"),
    RC404("404","404页面找不到导常"),
    RC500("500","500后端服务器错误");

    private final String code;
    private final String msg;

    private ReturnCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ReturnCodeEnum getByCodeV1(String code) {
        for (ReturnCodeEnum returnCodeEnum : ReturnCodeEnum.values()) {
              if (returnCodeEnum.getCode().equalsIgnoreCase(code)) {
                  return returnCodeEnum;
              }
        }
        return null;
    }

    public static ReturnCodeEnum getByCodeV2(String code) {
        return Arrays.stream(ReturnCodeEnum.values()).filter(returnCodeEnum -> returnCodeEnum.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        System.out.println("---------------200v1--------------");
        System.out.println(ReturnCodeEnum.getByCodeV1("200"));
        System.out.println(ReturnCodeEnum.getByCodeV1("200").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV1("200").getMsg());

        System.out.println("----------404v1-------------------");

        System.out.println(ReturnCodeEnum.getByCodeV1("404"));
        System.out.println(ReturnCodeEnum.getByCodeV1("404").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV1("404").getMsg());

        System.out.println("----------------500v1-------------");

        System.out.println(ReturnCodeEnum.getByCodeV1("500"));
        System.out.println(ReturnCodeEnum.getByCodeV1("500").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV1("500").getMsg());

        System.out.println("------------999v1-----------------");

        System.out.println(ReturnCodeEnum.getByCodeV1("999"));
        System.out.println(ReturnCodeEnum.getByCodeV1("999").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV1("999").getMsg());

        System.out.println("-----------200v2------------------");

        System.out.println(ReturnCodeEnum.getByCodeV2("200"));
        System.out.println(ReturnCodeEnum.getByCodeV2("200").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV2("200").getMsg());

        System.out.println("------------404v2-----------------");

        System.out.println(ReturnCodeEnum.getByCodeV2("404"));
        System.out.println(ReturnCodeEnum.getByCodeV2("404").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV2("404").getMsg());

        System.out.println("------------500v2-----------------");

        System.out.println(ReturnCodeEnum.getByCodeV2("500"));
        System.out.println(ReturnCodeEnum.getByCodeV2("500").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV2("500").getMsg());

        System.out.println("-----------999v2------------------");

        System.out.println(ReturnCodeEnum.getByCodeV2("999"));
        System.out.println(ReturnCodeEnum.getByCodeV2("999").getCode());
        System.out.println(ReturnCodeEnum.getByCodeV2("999").getMsg());


    }
}
