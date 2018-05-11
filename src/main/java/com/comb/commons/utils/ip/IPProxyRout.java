package com.comb.commons.utils.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 */
public class IPProxyRout {

    private static Integer pos = 0;
    public static HashMap<String, Integer> serverWeightMap = new HashMap<String, Integer>();

    static {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        // 权重为4
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        // 权重为3
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        // 权重为2
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }

    public static String getServerHash() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IPProxyRout.serverWeightMap);
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        // 在Web应用中可通过HttpServlet的getRemoteIp方法获取
        String remoteIp = "127.0.0.1";
        int hashCode = remoteIp.hashCode();
        int serverListSize = keyList.size();
        int serverPos = hashCode % serverListSize;
        return keyList.get(serverPos);

    }

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题

        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IPProxyRout.serverWeightMap);
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        String server = null;
        synchronized (pos) {
            if (pos > keySet.size())
                pos = 0;
            server = keyList.get(pos);
            pos++;
        }
        return server;
    }

    public static String getServerRandom()

    {
        // 重建一个Map，避免服务器的上下线导致的并发问题

        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IPProxyRout.serverWeightMap);
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(keyList.size());
        return keyList.get(randomPos);

    }


}
