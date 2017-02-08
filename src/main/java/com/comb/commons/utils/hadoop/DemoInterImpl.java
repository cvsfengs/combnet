package com.comb.commons.utils.hadoop;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class DemoInterImpl implements DemoInter {
    public String getMy(String name) {
        if(name.startsWith("a")){
            throw new RuntimeException("名称咋能用a呢");
        }
        return "hello"+name;
    }
}
