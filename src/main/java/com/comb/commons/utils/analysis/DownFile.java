package com.comb.commons.utils.analysis;

import com.jcraft.jsch.ChannelSftp;
import com.comb.commons.utils.property.PropertyUtil;
import com.comb.commons.utils.sftp.SFTPUtils;

/**
 * Created by ycfeng on 2016/9/22.
 */
public class DownFile {

    public static void main(String[] args) {

        String ftpIp = PropertyUtil.getValueByKey("ftpIp");
        String ftpPort = PropertyUtil.getValueByKey("ftpPort");
        String ftpUserName = PropertyUtil.getValueByKey("ftpUserName");
        String ftpPassword = PropertyUtil.getValueByKey("ftpPassword");
        SFTPUtils sftpUtils = new SFTPUtils();
        ChannelSftp channelsftp = sftpUtils.connect(ftpIp,Integer.parseInt(ftpPort),ftpUserName,ftpPassword);
        String outFile = "E:\\uccrm_log";
        sftpUtils.download("/usr/local/LogServ/ucar/test/uccrm/uccrm01-10.104.90.194", "uccrm_log",outFile,channelsftp);

    }
}
