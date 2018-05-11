package com.comb.user.controller;

import com.comb.commons.utils.md5.MD5Util;
import com.comb.commons.utils.result.DefaultViewResult;
import com.comb.commons.utils.result.ResultEnum;
import com.comb.commons.utils.result.ResultObject;
import com.comb.user.pojo.User;
import com.comb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public void login(HttpServletRequest request,HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(request.getCookies()!=null&&request.getCookies().length>0){
            String name = request.getCookies()[0].getName();
            String value = request.getCookies()[0].getValue();
            ResultObject resultObject = new ResultObject();
            resultObject.setMsg(ResultEnum.SUCCESS.getMsg());
            resultObject.setStatus(ResultEnum.SUCCESS.getStatus());
            try {
                response.sendRedirect("http://16.103:8080/xcore/static/common/index.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            DefaultViewResult.defaultResult(response,resultObject);
        }else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(MD5Util.toMd5(password));
            Cookie cookie = new Cookie("email",email);
            response.addCookie(cookie);
            DefaultViewResult.defaultResult(response,userService.getUser(user));
        }

    }
}
