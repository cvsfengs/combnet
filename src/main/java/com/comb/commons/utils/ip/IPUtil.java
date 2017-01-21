package com.comb.commons.utils.ip;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ycfeng on 2016/11/7.
 */
public class IPUtil {

    static final String REGEX = "((25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|0?[1-9]\\d|0?0?\\d)";
    static final Pattern PATTERN = Pattern.compile(REGEX);

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
