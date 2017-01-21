//package com.comb.interceptors;
//
//import com.comb.commons.dynamic.DataSource;
//import com.comb.commons.dynamic.datasource.AynamicDataSource;
//import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.AsyncHandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by ycfeng on 2016/8/3.
// */
//public class DataSourceInterceptor extends RequestMappingHandlerMapping implements AsyncHandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HandlerMethod handlerInternal = getHandlerInternal(request);
//        Object bean = handlerInternal.getBean();
//        DataSource methodAnnotation = handlerInternal.getMethodAnnotation(DataSource.class);
//        if(methodAnnotation!=null){
//            System.out.println(methodAnnotation.dataId().getName());
//            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//            AynamicDataSource dynamicDataSource = webApplicationContext.getBean("dataSource",AynamicDataSource.class);
//            BasicDataSource datasource = webApplicationContext.getBean(methodAnnotation.dataId().getName(), BasicDataSource.class);
//            dynamicDataSource.setDefaultTargetDataSource(datasource);
//            ServletContext application = webApplicationContext.getServletContext();
//            application.setAttribute("dataSource",dynamicDataSource);
//
//            /***************************************************/
//            ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
//            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
//
//            // 获取bean工厂并转换为DefaultListableBeanFactory
//            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
//
//            // 通过BeanDefinitionBuilder创建bean定义
//            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BasicDataSource.class);
//            // 设置属性userAcctDAO,此属性引用已经定义的bean:userAcctDAO
//            beanDefinitionBuilder.addPropertyReference("dataSource", "dataSource");
//
//            // 注册bean
//            defaultListableBeanFactory.registerBeanDefinition("dataSource",beanDefinitionBuilder.getRawBeanDefinition());
//
//
//        }
//        return true;
//    }
//
//    @Override
//    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
////    public static void main(String[] args) {
////
////    }
//
//}
