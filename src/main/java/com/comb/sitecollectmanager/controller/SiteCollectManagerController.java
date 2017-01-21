package com.comb.sitecollectmanager.controller;

import com.google.gson.Gson;
import com.comb.commons.utils.result.DefaultViewResult;
import com.comb.sitecollectmanager.pojo.SiteCollect;
import com.comb.sitecollectmanager.service.SiteCollectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ycfeng on 2016/9/28.
 */
@Controller
@RequestMapping("/siteCollectManager")
public class SiteCollectManagerController
{
    @Autowired
    private SiteCollectManagerService siteCollectManagerService ;

    @RequestMapping("collectUpdate")
    public void collectUpdate(HttpServletRequest request,HttpServletResponse response)
    {
        String obj = request.getParameter("obj");
        Gson gson = new Gson();
        SiteCollect siteCollect = gson.fromJson(obj, SiteCollect.class);
        Integer integer = siteCollectManagerService.addCollect(siteCollect);
        //SiteCollect siteCollect = JsonUtil.objecToObject(obj,SiteCollect.class);
        DefaultViewResult.defaultResult(response, "success");

    }
    @RequestMapping("siteSearch")
    public void siteSearch(HttpServletRequest request,HttpServletResponse response)
    {
        String obj = request.getParameter("obj");
        List<SiteCollect> listCollect = siteCollectManagerService.getListCollect(1);
        DefaultViewResult.defaultResult(response, listCollect);

    }

}
