package com.comb.commons.utils.ip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ycfeng on 2016/11/7.
 */
public class IPUtil {

    static final String REGEX = "((25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)";
    static final Pattern PATTERN = Pattern.compile(REGEX);

    public static String LOCAL_IP = getLocalIp();

    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtil.class);

    private IPUtil() {
    }

    /**
     * 获取本机ip地址
     * 此方法为重量级的方法，不要频繁调用
     * @return
     */
    public static String getLocalIp() {
        if (LOCAL_IP != null) {
            return LOCAL_IP;
        }
        try {
            //根据网卡取本机配置的IP
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            String ip = null;
            a:
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress ipObj = ips.nextElement();
                    if (ipObj.isSiteLocalAddress()) {
                        ip = ipObj.getHostAddress();
                        break a;
                    }
                }
            }
            return ip;
        } catch (Exception e) {
            LOGGER.error("", e);
            return null;
        }
    }

    public  static String getClientIp(HttpServletRequest request) {
        //浏览器IP判断
        String ipArray = request.getHeader("x-forwarded-for");
        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("Proxy-Client-IP");
        }
        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipArray == null || ipArray.length() == 0 || "unknown".equalsIgnoreCase(ipArray)) {
            ipArray = request.getRemoteAddr();
        }
        if (ipArray != null) {
            String browserIp = ipArray.split(",")[0];
            //容错，如果IP错误，不走IP判断
            if (checkIpStr(browserIp)) {
                return browserIp;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public static boolean checkIpStr(String ipAddress) {
        Matcher m = PATTERN.matcher(ipAddress);
        return m.matches();
    }


}
