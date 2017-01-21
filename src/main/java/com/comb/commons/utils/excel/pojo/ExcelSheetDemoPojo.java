package com.comb.commons.utils.excel.pojo;

import java.util.Date;

/**
 * Created by ycfeng on 2016/9/2.
 * excel临时demo尽量考虑到所有的数据类型
 */
public class ExcelSheetDemoPojo {

    /**
     * 简单String类型属性
     */
    private String simpleString ;
    /**
     * 简单date类型
     */
    private Date simpleDate;
    /**
     * 简单整形
     */
    private Integer simpleInteger;
    /**
     * 简单Long类型
     */
    private Long simpleLong ;
    /**
     * 简单double类型
     */
    private Double simpleDouble ;
    /**
     * 简单 布尔值
     */
    private Boolean simpleBoolean ;

    public Boolean getSimpleBoolean() {
        return simpleBoolean;
    }

    public void setSimpleBoolean(Boolean simpleBoolean) {
        this.simpleBoolean = simpleBoolean;
    }

    public String getSimpleString() {
        return simpleString;
    }

    public void setSimpleString(String simpleString) {
        this.simpleString = simpleString;
    }

    public Date getSimpleDate() {
        return simpleDate;
    }

    public void setSimpleDate(Date simpleDate) {
        this.simpleDate = simpleDate;
    }

    public Integer getSimpleInteger() {
        return simpleInteger;
    }

    public void setSimpleInteger(Integer simpleInteger) {
        this.simpleInteger = simpleInteger;
    }

    public Long getSimpleLong() {
        return simpleLong;
    }

    public void setSimpleLong(Long simpleLong) {
        this.simpleLong = simpleLong;
    }

    public Double getSimpleDouble() {
        return simpleDouble;
    }

    public void setSimpleDouble(Double simpleDouble) {
        this.simpleDouble = simpleDouble;
    }
}
