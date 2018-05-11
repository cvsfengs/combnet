package com.comb.commons.utils.compress;

import com.comb.commons.utils.MarkInterface;

/**
 * 压缩、解压缩 工具类
 */
public class CompressUtil implements MarkInterface {
    /**
     * 采取单例模式获取各个对象
     */
   private CompressUtil(){}

   private static CompressUtil compress ;

   public static CompressUtil getInstance(){
       if(compress==null){
            compress = new CompressUtil();
           return compress;
       }
       return compress;
   };
}
