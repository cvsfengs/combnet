package com.comb.commons.utils.dynamic;

import com.comb.commons.utils.dynamic.inter.Idemo;
import com.comb.commons.utils.dynamic.inter.impl.DemoImpl;

/**
 * Created by ycfeng on 2017/2/24.
 */
public class Main {

    public static void main(String[] args) throws Exception {


//        Idemo idemo = new DemoImpl();
//        Class<?> aClass = Class.forName("ucmapi.dynamicMagic.DemoImpl");
//        Idemo o1 = (Idemo)aClass.newInstance();
//        System.out.println(o1.hello());
//        RemoteHandler remoteHandler = new RemoteHandler(idemo);
//        Idemo o = (Idemo)Proxy.newProxyInstance(idemo.getClass().getClassLoader(), idemo.getClass().getInterfaces(), remoteHandler);
//        System.out.println(o.hello("jim"));
        Idemo instance = DynamicProxyHandler.getInstance(DemoImpl.class);
        instance.hello();
//        for (int i = 0; i < 10; i++) {
//            String he = instance.hello("he");
//            System.out.println(he);
//        }
    }

}
