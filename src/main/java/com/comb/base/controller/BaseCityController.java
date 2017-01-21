package com.comb.base.controller;

import com.comb.base.service.BaseCityService;
import com.comb.commons.pojo.EasyUIRequestPagination;
import com.comb.commons.pojo.EasyUIResponsePagination;
import com.comb.commons.utils.result.DefaultViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/7/30.
 */
@Controller
@RequestMapping("/base")
public class BaseCityController {
    @Autowired
    private BaseCityService baseCityService ;

    @RequestMapping("getCity")
    public void init(HttpServletRequest request,HttpServletResponse response){
        Integer page = Integer.parseInt(request.getParameter("page"))-1;
        Integer rows = Integer.parseInt(request.getParameter("rows"));
        EasyUIRequestPagination pagination = new EasyUIRequestPagination();
            pagination.setPage(page);
            pagination.setRows(rows);
        EasyUIResponsePagination responsePagination = baseCityService.getBaseCity(pagination);
        DefaultViewResult.defaultResult(response, responsePagination);
    }
}
