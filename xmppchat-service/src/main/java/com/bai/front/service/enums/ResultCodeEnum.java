package com.bai.front.service.enums;

public enum ResultCodeEnum {

    /** 成功 */
    SUCCESS(0,"成功"),
    /** 全局系统错误 **/
    FAIL(-1,"错误"),
    /** 业务错误码 */
    BIZ_FAIL(1000,"业务错误");


    private int code;
    private String desc;

    ResultCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
