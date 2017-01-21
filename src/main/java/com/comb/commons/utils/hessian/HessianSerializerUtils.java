package com.comb.commons.utils.hessian;

import com.caucho.hessian.server.HessianServlet;
import com.comb.commons.utils.serialize.SerializeUtil;

/**
 * Created by ycfeng on 2016/10/25.
 */
public class HessianSerializerUtils extends HessianServlet {

    public static void main(String[] args) {
        String[] a = new String[]{"a","b"};
        byte[] serialize = SerializeUtil.serialize(a);
        System.out.println(serialize);
        String[] o = (String[])SerializeUtil.unSerialize(serialize);
        System.out.println(o[1]);
    }

}
