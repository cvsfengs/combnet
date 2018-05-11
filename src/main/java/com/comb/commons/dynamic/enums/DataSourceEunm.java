package com.comb.commons.dynamic.enums;

/**
 */
public enum  DataSourceEunm {
   R("读库","dataSourceR"),W("写库","dataSourceW");
    private String desc ;
    private String name ;

    private DataSourceEunm() {
    }

    private DataSourceEunm(String desc, String name) {
        this.desc = desc;
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
