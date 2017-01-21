package com.comb.commons.utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //http://note.youdao.com/share/?id=018151142354a540711e6e279383fd1b&type=note#/
        for (int i = 0; i < 100; i++) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet("http://note.youdao.com/share/?id=018151142354a540711e6e279383fd1b&type=note#/");
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                int l;
                byte[] tmp = new byte[2048];
                while ((l = instream.read(tmp)) != -1) {
                    System.out.println((char)l);
                }
            }
        }
    }

}
