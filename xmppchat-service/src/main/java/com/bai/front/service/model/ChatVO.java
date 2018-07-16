package com.bai.front.service.model;

/**
 * 消息
 */
public class ChatVO extends BaseVO{
    private String  toUser;
    private String msg;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
