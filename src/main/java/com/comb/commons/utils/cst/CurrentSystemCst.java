package com.comb.commons.utils.cst;

import org.apache.commons.lang.SystemUtils;

/**
 * Created by Administrator on 2016/8/31.
 * 当前系统常量类
 */
public class CurrentSystemCst {

    public static String getCurrentProjectPath(){
        String path = SystemUtils.getUserDir().getPath();
        System.out.println(path);
        return null ;

    }

    public static void main(String[] args) {
        getCurrentProjectPath();
    }
}
