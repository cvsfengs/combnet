package com.comb.commons.utils.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * 动态代理调用对象
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxy  ;//代理对象
    private Object target ;//目标对象
    private static Logger logger = LoggerFactory.getLogger(DynamicProxyHandler.class);
    //如果采用TreeMap 则需要实现Compareable 接口
    private static HashMap<Class<?>, DynamicProxyHandler> route = new HashMap<Class<?>, DynamicProxyHandler>();
    public static <T> T getInstance(Class<T> cls){
        DynamicProxyHandler handler = route.get(cls);
        if(handler==null){
            try {
                System.out.println("-------");
                handler = new DynamicProxyHandler();
                T tar = cls.newInstance();
                T proxy = (T) Proxy.newProxyInstance(cls.getClassLoader(), tar.getClass().getInterfaces(), handler);
                handler.setProxy(proxy);
                handler.setTarget(tar);
                route.put(cls,handler);
            } catch (Exception e) {
                logger.error("代理对象获取出错",e);
            }
        }
        return (T)handler.getProxy();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------------------");
        Object invoke = method.invoke(target, args);
        System.out.println(invoke);
        System.out.println("======================");
        return invoke;
    }

    private DynamicProxyHandler() {
    }
    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }
}
