package ucmapi.generator.code.pojo;


import ucmapi.generator.code.cst.GeneratorCst;

/**
 * Created by ycfeng on 2016/8/30.
 */
public class ClazzInfo{

    /**
     * 请求类型
     */
    private String requestType ;
    /**
     * 响应类型
     */
    private String responseType ;
    /**
     * 自动生类所在包路径
     */
    private String packageSrc = GeneratorCst.DEFAULT_PACKAGE_NAME;
    /**
     * java文件名称
     */
    private String ClazzName ;
    /**
     *api请求url
     */
    private String apiUrl ;
    /**
     * server id
     */
    private String serverId = GeneratorCst.DEFAULT_SERVER_ID;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getPackageSrc() {
        return packageSrc;
    }

    public void setPackageSrc(String packageSrc) {
        this.packageSrc = packageSrc;
    }

    public String getClazzName() {
        return ClazzName;
    }

    public void setClazzName(String clazzName) {
        ClazzName = clazzName;
    }
}
