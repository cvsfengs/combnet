package com.comb.commons.utils.regex;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17.
 */
public class RegexUtil {
    public static void getZH_CNDemo(){
        String zh = "adf中文fljkjj";
        String replaceAll = zh.replaceAll(RegexCst.CHINESE_NUM_CHAR, "");
        System.out.println(replaceAll);
    }

    public static void main(String[] args) throws Exception {
        String file = "E:\\ideaworkspace\\xcore\\src\\main\\java\\com\\xuser\\language\\pojo\\Language.java" ;
        InputStream is = new FileInputStream(new File(file));
        StringBuffer buffers = new StringBuffer();
        List<String> lines = IOUtils.readLines(is);
        for (String line : lines) {
            buffers.append(line);
        }



    }


}
