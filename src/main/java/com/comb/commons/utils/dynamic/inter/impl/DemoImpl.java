package com.comb.commons.utils.dynamic.inter.impl;

import com.comb.commons.utils.dynamic.inter.Idemo;

/**
 * Created by ycfeng on 2017/2/24.
 */
public class DemoImpl implements Idemo{

    @Override
    public String hello(String str) {
        return "this is hello:" + str;
    }

    @Override
    public String hello() {
        return "this is none hello";
    }


}
