package com.comb.commons.utils.mlog;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ycfeng on 2016/9/7.
 */
public class MAbsUtil {
    /**
     * 获取本机名称及相应ip
     */
    public static String getCurrentIp(){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String ip=addr.getHostAddress();//获得本机IP
            String address=addr.getHostName();//获得本机名称

            return address+":"+ip+"--->";
        } catch (UnknownHostException e) {
            return "UN Achieve Current IP" ;
        }
    }
}
