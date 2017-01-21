package com.comb.commons.utils.result;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/30.
 */
public class ResultObject <T> implements Serializable{
    private Integer status ;
    private Object obj ;//返回结果
    private String msg ;//返回结果集

    public ResultObject() {
    }

    public ResultObject(Integer status, Object obj, String msg) {
        this.status = status;
        this.obj = obj;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
