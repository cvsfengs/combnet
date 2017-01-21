package com.comb.commons.utils.sys;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 * 获取系统常量工具类
 */
public class SysUtil {
   /**
    * 文件分隔符
    */
   public static String FILE_SEPARATOR = System.getProperty("file.separator");
   /**
    * 获取项目所在根路径
    */
   public static String getWebPath(HttpServletRequest request){
      if(request==null){
         return "";
      }
      return request.getSession().getServletContext().getRealPath("")+FILE_SEPARATOR;
   }
   /**
    * 获取webapp跟目录
    */
   public static File[] getWebStaticAppFiles(HttpServletRequest request){
      String target = getWebPath(request);
      File dir = new File(target);
      if(dir!=null){
         File[] files = dir.listFiles();
         return files;
      }else {
         return null;
      }
   }
   /**
    * 获取webapp下static文件夹下所有目录,不包含指定文件夹下目录
    */
   public static File[] getWebStaticAppFiles(HttpServletRequest request,String[] excludeName){
      String target = getWebPath(request)+"static";
      File dir = new File(target);
      if(dir!=null){
         File[] files = dir.listFiles();
         if(excludeName.length==0){
            return files;
         }
         List<File> ls = new ArrayList<File>();
         for (File file : files) {
            for (String name : excludeName) {
               if(!file.getName().equals(name)){
                   ls.add(file);
               }
            }
         }
         files = new File[ls.size()];
         for (int i = 0; i < ls.size(); i++) {
            files[i]=ls.get(i);
         }
       //  files = new File[ls.size()];

         return files;
      }else {
         return null;
      }
   }

}
