package ucmapi.generator.wiki.cst;

import org.apache.commons.lang.SystemUtils;

/**
 * Created by ycfeng on 2016/8/30.
 */
public class WikiGeneratorCst {

    public static String USERNAME = "yc.feng01@zuche.com" ;

    public static Integer API_VERSION = 236 ;

    public static String appVersion = "1.2.3" ;

    public static String isLogin = "是" ;

    public static String httpType = "HTTP/GET" ;
    /**
     * 输出文件源
     */
    public static String outPutSrc = SystemUtils.getUserDir().getPath()+"\\src\\test\\resources\\tempWiki.log"; ;

    public static String javasrc = SystemUtils.getUserDir().getPath()+"\\src\\test\\java\\ucmapi\\generator\\code\\pojo\\BookOrderFilterParam.java";

    public static String javasrcS = SystemUtils.getUserDir().getPath()+"\\src\\test\\java\\ucmapi\\generator\\code\\pojo\\BookOrderFilterParam.java";
    /**
     * 下一行
     */
    public static String nextLine = System.getProperty("line.separator");
    /**
     * 缩进
     */
    public static String suojin  = "\t";


}
