package com.comb.commons.utils.spring;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ycfeng on 2016/8/19.
 * http://jinnianshilongnian.iteye.com/category/333854
 */
public class SpringUtil<T> {


    private SpringUtil(){};

    public static ApplicationContext getApplicationContext(){

        return new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    /**
     * 获取bean
     */
    public static <T> T getBean(String beanName,T t){
        if(StringUtils.isBlank(beanName)||t==null){
            return null;
        }
        return (T)getApplicationContext().getBean(beanName, t);
    }
    /**
     * 获取bean
     */
    public static Object  getBean(String beanName){
        if(StringUtils.isBlank(beanName)){
            return null;
        }
        return getApplicationContext().getBean(beanName);
    }

}
