package com.comb.commons.utils.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

import java.io.IOException;

/**
 * Created by ycfeng on 2016/9/19.
 */
public class Demo {

    public static void main(String[] args) throws SftpException, IOException {

        SFTPUtils sftpUtils = new SFTPUtils();
        ChannelSftp channelSftp = sftpUtils.connect("10.202.1.41", 22, "log", "zc123456");
        sftpUtils.download("/usr/local/LogServ/ucar/test/ucmapi/ucmapi01-10.104.90.213", "ucmapi_log", "E:\\traces.log",channelSftp);



    }

}
