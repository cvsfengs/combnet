package com.comb.commons.utils.hadoop;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by ycfeng on 2016/8/4.
 */
public class HDFSUtil {
    public static void main(String[] args) throws  Exception {
        /**/System.setProperty("hadoop.home.dir", "D:\\hadoop-2.4.1\\");
        Configuration conf = new Configuration();
        //注册,指定
        conf.set("fs.defaultFS","hdfs://www.fengyachao.com:9000");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("hdfs://www.fengyachao.com:9000/0220_2.jpg");
        FSDataOutputStream os = fs.create(path);
        FileInputStream is = new FileInputStream("D:\\0220_2.jpg");
        IOUtils.copy(is,os);
    }


}
