package com.comb.sitecollectmanager.pojo;

/**
 * Created by ycfeng on 2016/9/28.
 */
public class SiteCollect {
    /**
     * 收藏id
     */
    private Integer collectId ;
    /**
     * 图片
     */
    private byte[] img ;
    /**
     * 内容
     */
    private String content ;
    /**
     * 链接
     */
    private String url ;
    /**
     * 是否可用
     */
    private String isUse ;
    /**
     * 登录用户名
     */
    private String userName ;
    /**
     * 密码
     */
    private String passWord ;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
