package com.comb.user.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 用户模块接口
 */

/**
 * 用户模型
 */
public class User implements Serializable{
    /**
     * 用户id
     */
    private Integer userId ;
    /**
     * 姓名
     */
    private String userName ;
    /**
     * 地址
     */
    private String address ;
    /**
     * 手机号
     */
    private String mobile ;
    /**
     * 邮箱
     */
    private String email ;
    /**
     * 密码
     */
    private String password ;

    private List<String> ls ;

    public List<String> getLs() {
        return ls;
    }

    public void setLs(List<String> ls) {
        this.ls = ls;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
