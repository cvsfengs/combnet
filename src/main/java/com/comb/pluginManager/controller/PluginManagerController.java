package com.comb.pluginManager.controller;

import com.comb.commons.utils.result.DefaultViewResult;
import com.comb.commons.utils.sys.SysUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2016/9/28.
 */
@Controller
@RequestMapping("/pluginManager")
public class PluginManagerController {

    @RequestMapping("getPluginList")
    public void getPluginList(HttpServletRequest request,HttpServletResponse response){
        String realPath1 = SysUtil.getWebPath(request);
       List<Map<String,Object>> menuList = new ArrayList<Map<String,Object>>();
        Map<String,Object> temp = new HashMap<String, Object>();
        String currentpath = realPath1+"\\static\\framework\\basement\\plugins";
        File file = new File(currentpath);
        File[] files = file.listFiles();
        //String[] exCludeName = new String[]{"cityInfo"};
        File[] webAppFiles = SysUtil.getWebStaticAppFiles(request);
        for (File webAppFile : webAppFiles) {
            System.out.println(webAppFile.toString());
        }
        for (File f : files) {
            //menuList.add(f.getName() + "/index.html");
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("desc",f.getName());
            map.put("href","/xcore/static/framework/basement/plugins/"+f.getName()+"/index.html");
            menuList.add(map);
        }
        Map<String,List> result = new HashMap<String, List>();
        result.put("pluginList",menuList);
        DefaultViewResult.defaultResult(response,result);
    }

}







