package com.comb.commons.utils.random;

/**
 * Created by Administrator on 2016/7/30.
 */

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * 随机生成字符,字符串,普通测试数据工具类
 */
public class RandomUtil {

    public static String getRandomZH_CN(int leng) {
        String ret="";
        for(int i=0;i<leng;i++){
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try
            {
                str = new String(b, "GBK"); //转成中文
            }
            catch (UnsupportedEncodingException ex)
            {
                ex.printStackTrace();
            }
            ret+=str;
        }
       return ret ;
    }











}
