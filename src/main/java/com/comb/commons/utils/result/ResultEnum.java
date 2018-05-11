package com.comb.commons.utils.result;

/**
 * 返回结果集枚举
 */
public enum ResultEnum {

    SUCCESS(10001,"成功"),ERROR(-10001,"失败"),SERVERERROR(500,"后台错误");

    private Integer status ;
    private String  msg ;
    private ResultEnum(){};
    private ResultEnum(Integer status,String msg){
        this.status = status ;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
