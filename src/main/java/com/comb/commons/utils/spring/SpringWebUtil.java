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

    public Set<String> scanProjectUrls() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMapping.getHandlerMethods();
        Set<String> urls = new HashSet<String>();
        if (map != null && map.size() > 0) {
            for (RequestMappingInfo info : map.keySet()) {
                String url = info.getPatternsCondition().getPatterns().toArray()[0].toString();
                if (!StringUtils.isBlank(url)) {
                    urls.add(url);
                }
            }
        }
        return urls;
    }

}
