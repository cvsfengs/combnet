package com.comb.commons.utils.zookeeper.console.apiproxy.controller;

import com.comb.commons.utils.zookeeper.console.apiproxy.APIMonitor;
import com.comb.commons.utils.zookeeper.console.apiproxy.APIServerNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ycfeng on 2017/1/20.
 */
@Controller
@RequestMapping("/apiProxy")
public class ApiProxyController {
    @Autowired
    private APIMonitor apiMonitor ;

    @RequestMapping("/doProxy")
    @ResponseBody
    public APIServerNode doProxy(HttpServletRequest request, HttpServletResponse response) {

        String aid = request.getParameter("aid");
        String cid = request.getParameter("cid");
        String remoteIP = getRemoteIP(request);
        APIServerNode serverNode = getVersion(cid, remoteIP);

//        String uid = request.getParameter("uid");
//        String q = request.getParameter("q");

        Map<String, TreeSet<String>> apiMenu = apiMonitor.getRouteMenu();
        System.out.println(apiMenu);
        return serverNode;
    };

    @RequestMapping("/getApiList")
    @ResponseBody
    public Map<String, TreeSet<String>> getApiMenu(HttpServletRequest request, HttpServletResponse response) {
        Map<String, TreeSet<String>> apiMenu = apiMonitor.getRouteMenu();
        return apiMenu;
    } ;

    @RequestMapping("/getVersionIpMenu")
    @ResponseBody
    public Map<String, APIServerNode> getVersionIpMenu(HttpServletRequest request, HttpServletResponse response) {
        Map<String, APIServerNode> versionIpMenu = apiMonitor.getVersionIpMenu();
        return versionIpMenu;
    }

    ;

    private String getRemoteIP(HttpServletRequest request){
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
    public APIServerNode getVersion(String cid,String accessIP){
        int ipHashCode = accessIP.hashCode();
        Map<String, TreeSet<String>> menu = apiMonitor.getRouteMenu();
        Map<String, APIServerNode> versionIpMenu = apiMonitor.getVersionIpMenu();
        Set<String> serverIps = menu.get(cid);
        APIServerNode apiServerNode ;// = new APIServerNode();
        Object[] ips ;
        if(serverIps==null){
            Map<String, TreeSet<String>> groupAndVersion = apiMonitor.getGroupAndVersion();
            String groupId = cid.substring(0, 3);
            TreeSet<String> versions = groupAndVersion.get(groupId);
            if(versions==null){
                //throw new RuntimeException("不合法api访问,请检查节点："+cid+"是否存在");
                return null;
            }
            versions.comparator();
            String cidNew = groupId + versions.last();
            serverIps = menu.get(cidNew);
        }
        ips = serverIps.toArray();
        Object ip = ips[ipHashCode % ips.length];
        apiServerNode = versionIpMenu.get(ip);
        return apiServerNode ;
    }
/*
    public APIServerNode getVersion(String cid,String accessIP){//
        Map<String, TreeSet<String>> menu = apiMonitor.getRouteMenu();
        Map<String, APIServerNode> versionIpMenu = apiMonitor.getVersionIpMenu();
        Set<String> serverIps = menu.get(cid);
        APIServerNode apiServerNode = new APIServerNode();
        int ipHashCode = accessIP.hashCode();

        if(serverIps!=null){
            Object[] ips = (Object[])serverIps.toArray();
            Object ip = ips[ipHashCode % ips.length];
            apiServerNode = versionIpMenu.get(ip);
        }else {//当前组没有访问版本,访问版本最高一台机器
            Map<String, TreeSet<String>> groupAndVersion = apiMonitor.getGroupAndVersion();
            String groupId = cid.substring(0,3);
            TreeSet<String> versions = groupAndVersion.get(groupId);
            if(versions!=null){
                versions.comparator();
                String cidNew = groupId + versions.last();
                serverIps = menu.get(cidNew);
                Object[] ips = serverIps.toArray();
                Object ip = ips[ipHashCode % ips.length];
                apiServerNode = versionIpMenu.get(ip);
            }
        }
        return apiServerNode ;
    }
*/

    /******************************************************************************/

}
