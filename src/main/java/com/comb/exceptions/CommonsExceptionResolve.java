package com.comb.exceptions;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/7/28.
 * 通用异常处理
 */
public class CommonsExceptionResolve implements HandlerExceptionResolver {
    private static Logger logger = Logger.getLogger(CommonsExceptionResolve.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception exception) {
        //用于传递错误信息
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {

        }
        CommonsException exp = null;
        ModelAndView mv = new ModelAndView();
        if(exception instanceof CommonsException){
            exp = ((CommonsException)exception);
            logger.error(Integer.toString(exp.status) + " Message: " + exp.getMessage());
            logger.error(exp);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.setStatus(exp.status);
            String string = "";

            if (exp.getMessage() != null) {
                string = exp.getMessage();
            }
            //判断用户登录异常
            if (401==exp.status) {
                logger.info("Response: " + string);
                writer.write(exception.getMessage());
                writer.write(exp.status);
                writer.flush();
            }
        }//判断http异常,直接将异常写出
        else if (exception instanceof HttpException) {
            if(exception.getMessage().equals("Need_admin_auth")){
                mv.setViewName("post/admin/login");
                return mv;
            }else if (exception.getMessage().equals("Need_Member_auth")) {
                mv.setViewName("post/index");
                return mv;
            }

            writer.write(exception.getMessage());
            writer.flush();
            return null;
        }
        return null;
    }
}
