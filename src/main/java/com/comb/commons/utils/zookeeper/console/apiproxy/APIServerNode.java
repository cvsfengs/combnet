package com.comb.commons.utils.zookeeper.console.apiproxy;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ycfeng on 2017/1/19.
 */
public class APIServerNode implements Serializable {

    /**
     * 实例版本
     */
    private String version;

    /**
     * 版本描述
     */
    private String desc;

    /**
     * 地址
     */
    private String address;

    /**
     * 项目名
     */
    private String name;

    /**
     * 实例下的所有API列表
     */
    private List<ServerApi> apiList ;

    public APIServerNode() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ServerApi> getApiList() {
        return apiList;
    }

    public void setApiList(List<ServerApi> apiList) {
        this.apiList = apiList;
    }
}
