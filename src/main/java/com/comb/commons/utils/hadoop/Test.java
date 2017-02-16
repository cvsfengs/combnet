package com.comb.commons.utils.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        DemoInter proxy = RPC.getProxy(DemoInter.class, 1l, new InetSocketAddress("127.0.0.1", 10000), conf);
        String jim = proxy.getMy("ajimS");
        System.out.println(jim);
    }


}
