package com.comb.commons.utils.mlog;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ycfeng on 2016/9/5.
 * 获取当前环境properties 配置文件属性
 */
public class CurrentEvnProperties {

    private static String apiResource = "mlog.properties";

    public static String getProperties(String key){

        InputStream is = CurrentEvnProperties.class.getClassLoader().getResourceAsStream(apiResource);
        Properties prop = new Properties();
        String val = "" ;
        try {
            prop.load(is);
            val = prop.get(key).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return val ;
    };
}
