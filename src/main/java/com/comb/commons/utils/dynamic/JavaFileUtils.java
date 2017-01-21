package com.comb.commons.utils.dynamic;

import com.comb.commons.utils.file.FileUtil;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ycfeng on 2016/10/18.
 */
public class JavaFileUtils {

    public static void fromThisToOther() throws Exception {
        String file = "E:\\ideaworkspace\\xcore\\src\\main\\java\\com\\xuser\\language\\pojo\\Language.java" ;
        File files = new File(file);
        String prefix = FileUtil.getPrefix(file);
        InputStream is = new FileInputStream(new File(file));
        StringBuffer buffers = new StringBuffer();
        List<String> lines = IOUtils.readLines(is);
        for (String line : lines) {
            if(line.contains(prefix)){

            }
            buffers.append(line);
        }
    }

    public static void main(String[] args) throws Exception {
        fromThisToOther();
    }
}
