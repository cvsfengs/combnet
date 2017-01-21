package com.comb.menuManager.controller;

import com.comb.commons.pojo.EasyUIRequestPagination;
import com.comb.commons.pojo.EasyUIResponsePagination;
import com.comb.commons.utils.json.JsonUtil;
import com.comb.commons.utils.result.DefaultViewResult;
import com.comb.menuManager.pojo.MenuPojo;
import com.comb.menuManager.service.MenuManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ycfeng on 2016/8/16.
 * 菜单管理
 */
@Controller
@RequestMapping("/menu")
public class MenuManagerController {
    @Autowired
    private MenuManagerService menuManagerService;

    /**
     * 菜单新增(新增)
     */
    @RequestMapping("menuUpdate")
    public void menuAdd(HttpServletRequest request,HttpServletResponse response){
        String obj = request.getParameter("obj");
        MenuPojo menuPojo = JsonUtil.jsonToObject(obj,MenuPojo.class);
        Integer integer = menuManagerService.menuUpdate(menuPojo);
        DefaultViewResult.defaultResult(response, "success");
    }

    /**
     * 菜单删除
     */
    @RequestMapping("menuRemove")
    public void menuRemove(HttpServletRequest request,HttpServletResponse response){
        Integer menuId = Integer.parseInt(request.getParameter("menuId"));
        menuManagerService.menuRemove(menuId);
    }

    /**
     * 菜单修改
     */
    @RequestMapping("menuModify")
    public void menuModify(HttpServletRequest request,HttpServletResponse response){
        MenuPojo menuPojo = new MenuPojo();
        menuManagerService.menuModify(menuPojo);
    }

    /**
     * 菜单查询
     */
    @RequestMapping("menuSearch")
    public void menuSearch(HttpServletRequest request,HttpServletResponse response){

        Integer page = Integer.parseInt(request.getParameter("page"))-1;
        Integer rows = Integer.parseInt(request.getParameter("rows"));
        EasyUIRequestPagination pagination = new EasyUIRequestPagination();
        pagination.setPage(page);
        pagination.setRows(rows);
        EasyUIResponsePagination menuPojos = menuManagerService.menuSearch(pagination);
        DefaultViewResult.defaultResult(response,menuPojos);
    }








}
