package com.comb.commons.utils.http;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * http 操作类
 */
public class HttpUtils {

    /**
     * 执行 http get 请求
     */
    public static String doGet(String url){
        if(StringUtils.isBlank(url)){
            return "";
        }
        BufferedReader in = null;
        String content = null;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String ns = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + ns);
            }
            in.close();
            content = sb.toString();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
               return content;
        }

    }

    public static void main(String[] args) {
        String s = HttpUtils.doGet("http://www.baidu.com");
        System.out.println(s);
    }
}
