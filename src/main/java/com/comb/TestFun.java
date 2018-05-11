package com.comb;

import com.comb.commons.utils.ip.IPUtil;
import com.comb.commons.utils.result.DefaultViewResult;
import com.comb.commons.utils.spring.SpringWebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 */
@Controller
@RequestMapping("/testFun")
public class TestFun {

    @Autowired
    private SpringWebUtil springWebUtil;

    @RequestMapping("fun")
    public void testFun(HttpServletRequest request,HttpServletResponse response){
        String test = request.getParameter("test");
        Set<String> urls = springWebUtil.scanProjectUrls();

//        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
//        Set<RequestMappingInfo> requestMappingInfos = handlerMethods.keySet();
//
//        for (RequestMappingInfo requestMappingInfo : requestMappingInfos) {
//            System.out.println("key:"+requestMappingInfo+"__"+requestMappingInfo);
//        }

        try {
            response.getWriter().write(test);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("xcFunc")
    public void xcFunc(HttpServletRequest request,HttpServletResponse response){

        String clientIp = IPUtil.getClientIp(request);
        DefaultViewResult.defaultResult(response,clientIp);

    }
}
