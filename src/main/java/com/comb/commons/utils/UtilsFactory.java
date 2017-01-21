package com.comb.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ycfeng on 2016/7/27.
 * 工具类工厂
 */
public class UtilsFactory {

    public static void main(String[] args) {
        String str = "//工具类工厂//工具类工//工具类工厂*工具类工厂*工具类工厂*/";
        String str2 = "//工具类工厂*/";
//        Pattern pattern = Pattern.compile("/((^|[^\"':\\s])\\/\\/.*$)|((^|[^\"':s])/*(.|s)*?*/)/g");
//        Matcher matcher = pattern.matcher(str);

//        List<String> ls=new ArrayList<String>();
//        while(matcher.find()){
//            ls.add(matcher.group());
//        }
//       System.out.println(ls.toString());
        String reg_3 = "(?<!:)\\/\\/.*|\\/\\*(\\s|.)*?\\*\\/";
        String reg_4 = "\\/\\/[^\\n]*";
        Pattern pattern3 = Pattern.compile(reg_3);
        Pattern pattern4 = Pattern.compile(reg_4);
        Matcher matcher3 = pattern3.matcher(str);
        Matcher matcher4 = pattern4.matcher(str);
        List<String> ls=new ArrayList<String>();
        while (matcher3.find()){
            ls.add(matcher3.group());
        };
        System.out.println(ls.toString());
//        List<String> ls=new ArrayList<String>();
//        while (matcher4.find()){
//            ls.add(matcher4.group());
//        };
//    String reg = "/(\"([^\\\\\\\"]*(\\\\.)?)*\")|('([^\\\\\\']*(\\\\.)?)*')|(\\/{2,}.*?(\\r|\\n))|(\\/\\*(\\n|.)*?\\*\\/)/g";// 正则表达式
//        String s = str2.replaceAll(reg, "");
//           String reg2 = "^[\\u4E00-\\u9FFF]+$";
//        String replaceAll = s.replaceAll(reg2, "");
//        System.out.println(s);
//        String regex="([\u4e00-\u9fa5]+)";
//        Matcher matcher = Pattern.compile(regex).matcher(replaceAll);
//        if(matcher.find()){
//            System.out.println(matcher.group(0));
//        }
    }





}
