package ucmapi.generator.wiki.pojo;

import ucmapi.generator.wiki.cst.WikiGeneratorCst;

/**
 * Created by ycfeng on 2016/8/30.
 */
public class BaseWikiPojo <Req,Rep>{
    /**
     * 请求类型
     */
    private Class<Rep> requestType ;
    /**
     * 响应类型
     */
    private Class<Req> responseType ;
    /**
     * wiki创建者用户名
     */
    private String userName = WikiGeneratorCst.USERNAME;
    /**
     * api Version
     */
    private Integer apiVersion = WikiGeneratorCst.API_VERSION;
    /**
     * app version
     */
    private String appVersion = WikiGeneratorCst.appVersion;

    /**
     * 是否需要登录
     */
    private String isLogin = WikiGeneratorCst.isLogin;
    /**
     * api 请求url
     */
    private String url ;
    /**
     * 请求 shttp 类型
     */
    private String hTTPType = WikiGeneratorCst.httpType;



    public String gethTTPType() {
        return hTTPType;
    }

    public void sethTTPType(String hTTPType) {
        this.hTTPType = hTTPType;
    }

    public BaseWikiPojo() {
    }

    public BaseWikiPojo(Class<Rep> requestType, Class<Req> responseType) {
        this.requestType = requestType;
        this.responseType = responseType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public Class<Rep> getRequestType() {
        return requestType;
    }

    public void setRequestType(Class<Rep> requestType) {
        this.requestType = requestType;
    }

    public Class<Req> getResponseType() {
        return responseType;
    }

    public void setResponseType(Class<Req> responseType) {
        this.responseType = responseType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(Integer apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
