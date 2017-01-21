package com.comb.base.pojo;

import com.comb.commons.utils.annotaion.ModelAnnotation;

/**
 * Created by Administrator on 2016/7/30.
 * 城市基础数据
 */
@ModelAnnotation(modelVal = "城市基础数据")
public class BaseCity {
    @ModelAnnotation(modelVal = "主键id")
    private Integer id  ;
    @ModelAnnotation(modelVal = "名称")
    private String name ;
    @ModelAnnotation(modelVal = "父级id")
    private Integer pid ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
