package com.comb.commons.utils.md5;

import java.security.MessageDigest;
/**
 * Created by Administrator on 2016/7/30.
 * 传入对象,获取MD5加密串
 */
public class MD5Util {
    private static MD5Util md5Util ;
    private static ThreadLocal<MD5Util> md5UtilLocal = new ThreadLocal<MD5Util>();
    private MD5Util(){};

    /**
     * 获取一个MD5工具实例
     */
    public static MD5Util getInstance(){
        if(md5UtilLocal.get()==null){
            md5UtilLocal.set(new MD5Util());
        }
        return md5UtilLocal.get();
    }

    /**
     * 进行md5加密,返回一个加密串
     */
    public static String toMd5(Object obj){
        char hexDigits[] = { '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            String s = obj.toString();
            byte[] btInput = s.getBytes();
            //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md = mdInst.digest();
            //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
