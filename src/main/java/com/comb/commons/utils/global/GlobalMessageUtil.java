package com.comb.commons.utils.global;

/**
 * Created by ycfeng on 2017/2/16.
 */

import java.io.File;

/**
 * 全局信息
 */
public final class GlobalMessageUtil {

    public static final String PATH_ENV = "logfile.path";

    //上下文路径
    private static String contextPath;

    //项目路径
    private static String projectPath;
    //当前项目名称
    private static String projectName;
    //tomcat 监听 http port
    private static int httpPort;

    private static String defaultLogfilePath = System.getProperty("catalina.home") + File.separator + "logs" + File.separator;

    private GlobalMessageUtil() {
    }

    public static String getProjectName() {
        return projectName;
    }

    public static String getPath() {
        return contextPath;
    }

    public static void setPath(String path) {
        GlobalMessageUtil.contextPath = path;
    }

    public static String getProjectPath() {
        return projectPath;
    }

    public static void setProjectPath(String projectPath) {
        GlobalMessageUtil.projectPath = projectPath;
        projectName = projectPath.substring(1, projectPath.length() - 1);
        System.setProperty("framework.web.projectName", projectName);
    }

    public static int getHttpPort() {
        return httpPort;
    }

    static void setHttpPort(int httpPort) {
        GlobalMessageUtil.httpPort = httpPort;
    }

    public static String getProjectNameNew() {
        if (getProjectName() == null) {
            return System.getProperty("sz.framework.projectName");
        }
        return getProjectName();
    }

    public static String getLogfilePath() {
        String filePath = System.getProperty(PATH_ENV);
        if (filePath == null)
            return defaultLogfilePath;
        if (filePath.endsWith(File.separator)) {
            return filePath;
        } else {
            return filePath + File.separator;
        }
    }

}
