package com.comb.commons.utils.file;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/**
 * Created by ycfeng on 2016/8/29.
 * 文件操作工具类
 */
public class FileUtil {
    /**
     * 当前项目路径
     */
    public static final String CURRENTPATH = SystemUtils.getUserDir().getPath();
    /**
     * 文件目录不存在则创建
     */
    public boolean fileNotExistCreate(String src){
        File file = new File(src);
        if(!file.getParentFile().exists()){
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                return true ;
            } catch (IOException e) {
                System.out.println("文件创建失败,或不为文件:"+file.getPath()+"\n"+e);
                return false ;

            }
        }
        return true ;
    }
    /**
     * 获取文件后缀
     */
    public static String getSuffix(Object o){

        String suffix = null ;

        if(o instanceof File){
            File file = (File)o;
            suffix= fileSuffix(file);
        }else if(o instanceof String){
            File file  = new File((String)o);
            suffix= fileSuffix(file);
        }
        return suffix ;
    }
    public static String getPrefix(String f){
        if(StringUtils.isBlank(f)){
            return "";
        }
        File file = new File(f);
        if(file.isFile()){
            String fileName = file.getName();
            String[] split = fileName.split("\\.");
            return split[0];
        }
        return "" ;
    }
    private static String fileSuffix(File file){
        try{
            String fileName = file.getName();
            if(StringUtils.isBlank(fileName)){
                return null;
            }
            return fileName.substring(fileName.indexOf("."));
        }catch (Exception e){
            return "" ;
        }
    }
    /**
     * 转成file对象
     */
    public static File toFile(Object o){
        if(o==null||o.equals("")){
           return null;
        }
        if(o instanceof File){
            return (File)(o);
        }else if(o instanceof String){
            String s = (String)(o);
            File file = new File(s);
            if(file.isFile()){
                return file ;
            }
        }
        return null ;
    }

    /**
     * 获取文件对应输入流
     * key:文件名称
     * value:输入流
     */
    public static Map<String,InputStream> toInputStream(HttpServletRequest o){
        HttpServletRequest request = (HttpServletRequest)o;
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
        Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
        Set<String> keys = fileMap.keySet();
        if(keys.isEmpty()){
            return null ;
        }
        Map<String,InputStream> fileMaps = new HashMap<String, InputStream>();
        try {
            for (String key : keys) {
                MultipartFile multipartFile = fileMap.get(key);
                String filename = multipartFile.getOriginalFilename();
                InputStream inputStream = multipartFile.getInputStream();
                fileMaps.put(filename,inputStream);
;            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileMaps ;
    }
    /**
     * 判断是否为一个文件,或目录
     */
    public static boolean isFile(Object o){
        return (toFile(o) != null);
    }

    /**TODO 未进行文件可读判断
     * 1.file 为文件夹 则获取指定目录下所有文件
     * 2.file 为文件,则获取文件
     */
    public static List<File> getDirOrFileList(File file){
        if(file==null){
            return null;
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            return  Arrays.asList(files);
        }if(file.isFile()){
            List<File> files  = new ArrayList<File>();
            files.add(file);
            return files;
        }
        return null;
    }

    /**
     * 获取指定文件占用空间大小
     * 1.如果为目录(不可进行目录递归获取),则获取目录下所有可读文件大小总和
     * 2.如果为文件,则返回单个文件大小
     * 3.文件标尺为：KB
     * 4.TODO 之所以这样获取,是为了模仿storm进行实时流向分析,可另开一个线程,进行文件的读取
     */
    public static Long getFileMemory(File file){
        List<File> dirOrFileList = getDirOrFileList(file);
        Long memory = new Long(0);
        if(dirOrFileList!=null){
            for (File f : dirOrFileList) {
                memory=memory+f.length()/1024;
            }
        }
        return  memory ;
    }
    public static boolean fileIsAccessAble(File file){
        return file.canRead();
    }

    /**
     * 文件拷贝
     */
    public static Boolean copyTO(InputStream is,String file){
        if(is==null||file==null){
            return false;
        }
        OutputStream os = null ;
        try {
            os = new FileOutputStream(file);
            IOUtils.copy(is,os);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false ;
    }
    public static Boolean copyTo(String in,String out){
        InputStream is = null ;
        try{
            is = new FileInputStream(in);
            copyTO(is,out);
            return true ;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false ;
    }
    public static void main(String[] args) {
        //System.out.println(isFile("C:\\Users\\ycfeng\\Desktop\\merger"));
//        List<File> dirFileList = FileUtil.getDirOrFileList(new File("D:\\入门篇\\我来说说面向对象"));
//        Long fileMemory = getFileMemory(new File("D:\\入门篇\\J2SE高深讲解"))/1024;
//        System.out.println(fileMemory);;
        System.out.println(FileUtil.CURRENTPATH);
    }
}
