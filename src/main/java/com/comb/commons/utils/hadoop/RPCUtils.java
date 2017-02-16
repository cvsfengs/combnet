package com.comb.commons.utils.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class RPCUtils {

    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        RPC.Builder builder = new RPC.Builder(conf);
        builder.setInstance(new DemoInterImpl()).setBindAddress("127.0.0.1").setPort(10000).setProtocol(DemoInter.class);
        RPC.Server build = builder.build();
        build.start();


    }

}
