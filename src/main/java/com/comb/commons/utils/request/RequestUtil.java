package com.comb.commons.utils.request;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by ycfeng on 2016/7/29.
 */
public class RequestUtil {
    private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
    private static RequestUtil requestUtil = new RequestUtil();
    private RequestUtil(){};
    public static RequestUtil getInstance(HttpServletRequest req){
        if(request.get()==null){
            request.set(req);
        }
        if(requestUtil==null){
            requestUtil = new RequestUtil();
        }
        return requestUtil;
    }
    /**
     * 获取request里 post get 传递过来的参数,转换成相应对象
     */
    public static <T> T fromRequestToObject(HttpServletRequest request,Class<T> clazz) throws Exception {

        Map<String,Object> parameterMap = request.getParameterMap();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(parameterMap==null){
            return null;
        }
        Iterator<String> iterator = parameterMap.keySet().iterator();
        //获取声明的字段
        Field[] fields = clazz.getDeclaredFields();
        T obj = clazz.newInstance();
        //clazz.getDeclaredMethods();
        StringBuffer sb = new StringBuffer();
        sb.delete(0,sb.length());
        while (iterator.hasNext()){
            //获取当前key
            String key = iterator.next();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();

                if(name.equals(key)){
                    sb.append("set").append(name.substring(0,1).toUpperCase()).append(name.substring(1, name.length()));

                    Method method = obj.getClass().getMethod(sb.toString(),field.getType());
                    if(field.getType().getName().equals("String")){
                        method.invoke(obj,(String)parameterMap.get(key));
                    }if(field.getType().getName().equals("Integer")){
                        method.invoke(obj,(Integer)parameterMap.get(key));
                    }if(field.getType().getName().equals("Long")){
                        method.invoke(obj,(Long)parameterMap.get(key));
                    }if(field.getType().getName().equals("Date")){
                        method.invoke(obj,(Date)parameterMap.get(key));
                    }else{
                        method.invoke(obj,parameterMap.get(key));
                    }
                    sb.delete(0,sb.length());

                }
            }
        }
        return obj ;
    }

    /**
     *转换request get post 方法所带参数为 Map
     */
    public static Map<String,Object> fromRequestToMap(HttpServletRequest request){

        Map<String,String[]> parameterMap = request.getParameterMap();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(parameterMap==null){
            return new HashMap<String, Object>();
        }
        Iterator<String> iterator = parameterMap.keySet().iterator();
        while (iterator.hasNext()){
            //获取当前key
            String key = iterator.next();
            String[] values = parameterMap.get(key);
            if(values.length==1){
                resultMap.put(key,values[0]);
            }else {
                 resultMap.put(key,values);
            }
        }
        return resultMap ;
    };

}
