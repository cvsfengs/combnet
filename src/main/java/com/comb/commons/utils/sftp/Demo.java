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
        ChannelSftp channelSftp = sftpUtils.connect("1", 22, "log", "456");
        sftpUtils.download("/3", "uog", "E:\\traces.log",channelSftp);



    }

}
