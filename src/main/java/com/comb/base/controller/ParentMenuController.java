package com.comb.base.controller;

import com.comb.base.pojo.ParentMenu;
import com.comb.base.service.ParentMenuService;
import com.comb.commons.utils.result.DefaultViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/13.
 * 功能菜单
 */
@Controller
@RequestMapping("/base")
public class ParentMenuController {
    @Autowired
    private ParentMenuService parentMenuService ;
    //新增功能菜单
    @RequestMapping("saveParentMenu")
    public void addParentMenu(HttpServletRequest request,HttpServletResponse response){
        String pName = request.getParameter("pName");
        Integer isUse = Integer.parseInt(request.getParameter("isUse"));
        String link = request.getParameter("link");
        String menuDesc = request.getParameter("menuDesc");
        ParentMenu parentMenu = new ParentMenu();
        parentMenu.setIsUse(isUse);
        parentMenu.setpName(pName);
        parentMenu.setLink(link);
        parentMenu.setMenuDesc(menuDesc);
        Integer integer = parentMenuService.addParentMenu(parentMenu);
        DefaultViewResult.defaultResult(response,"success");
    }
    //获取所有功能菜单
    @RequestMapping("getAllParentMenu")
    public void getAllParentMenu(HttpServletRequest request,HttpServletResponse response){
        Integer isUse = 1;
        DefaultViewResult.defaultResult(response,parentMenuService.getAllParentMenu(isUse));
    }

}
