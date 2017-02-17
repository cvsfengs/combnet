package com.comb.commons.utils.spring;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ycfeng on 2017/1/21.
 */
@Component
public class SpringWebUtil{
    @Autowired
    @Qualifier(value = "mappingHandlerMapping")
    private RequestMappingHandlerMapping requestMapping;

//    public Set<String> scanProjectUrls() {
//        Map<RequestMappingInfo, HandlerMethod> map = requestMapping.getHandlerMethods();
//        Set<String> urls = new HashSet<String>();
//        if (map != null && map.size() > 0) {
//            for (RequestMappingInfo info : map.keySet()) {
//                String url = info.getPatternsCondition().getPatterns().toArray()[0].toString();
//                if (!StringUtils.isBlank(url)) {
//                    urls.add(url);
//                }
//            }
//        }
//        return urls;
//    }

    public Map<String, Set<String>> scanProjectBeansAndUrls() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMapping.getHandlerMethods();
        Set<String> urls = new HashSet<String>();
        Map<String, Set<String>> rs = new HashMap<String, Set<String>>();
        if (map != null && map.size() > 0) {
            Set<RequestMappingInfo> requestMappingInfos = map.keySet();
            for (RequestMappingInfo info : requestMappingInfos) {
                /**bean全类名定义*/
                HandlerMethod handlerMethod = map.get(info);
                String beanName = handlerMethod.getBeanType().getName();
                Set<String> values = rs.get(beanName);
                if (values == null) {
                    values = new HashSet<String>();
                }
                String url = info.getPatternsCondition().getPatterns().toArray()[0].toString();
                values.add(url);
                rs.put(beanName, values);
                if (!StringUtils.isBlank(url)) {
                    urls.add(url);
                }
            }
        }
        return rs;
    }

    public Set<String> scanProjectUrls() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMapping.getHandlerMethods();
        Set<String> urls = new HashSet<String>();
        if (map != null && map.size() > 0) {
            Set<RequestMappingInfo> requestMappingInfos = map.keySet();
            for (RequestMappingInfo info : requestMappingInfos) {
                /**bean全类名定义*/
                HandlerMethod handlerMethod = map.get(info);
                String url = info.getPatternsCondition().getPatterns().toArray()[0].toString();
                if (!StringUtils.isBlank(url)) {
                    urls.add(url);
                }
            }
        }
        return urls;
    }

}
