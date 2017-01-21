package com.comb.commons.utils.property;

import com.comb.commons.utils.MarkInterface;
import com.comb.commons.utils.spring.SpringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * Created by cvsFeng on 2016/7/27.
 * 属性工具类
 */
public class PropertyUtil implements MarkInterface {
    /**
     * 读文件
     */
    private Set<String> files;
    /**
     * 外层包裹容器
     */
    private static final Properties container = new Properties();
    /**
     * 获取spring所管理的util
     */
    private static PropertyUtil propertyUtil =  SpringUtil.getApplicationContext().getBean("propUtil", PropertyUtil.class);
    /**
     * 将属性至于本地线程中
     */
    private static ThreadLocal<Properties> propLac = new ThreadLocal<Properties>();

    /**
     * 获取properties文件key所对应value值
     */
    public static String getValueByKey(String key) {
        if (propLac.get() != null) {
            return propLac.get().getProperty(key);
        }
        try {
            Set<String> fileNames = propertyUtil.getFiles();
            if (fileNames.size() == 0) {
                return null;
            }
            ClassLoader classLoader = PropertyUtil.class.getClassLoader();
            InputStream is = null;
            for (String fileName : fileNames) {
                Properties properties = new Properties();
                is = classLoader.getResourceAsStream(fileName);
                properties.load(is);
                container.putAll(properties);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        propLac.set(container);
        return container.getProperty(key);
    }

    public Set<String> getFiles() {
        return files;
    }

    public void setFiles(Set<String> files) {
        this.files = files;
    }
}
