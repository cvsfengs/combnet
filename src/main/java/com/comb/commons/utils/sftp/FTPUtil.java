package com.comb.commons.utils.sftp;

import com.comb.commons.utils.number.NumberUtil;
import com.comb.commons.utils.sys.SysUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Properties;

/**
 */
public class FTPUtil {

    private static final FTPClient ftpClient = new FTPClient();
    //todo 获取相应prop属性
    private static final Properties config = null;//SysUtil.getProperties(SysUtil.FTP_PROPERTIES_NAME);
    private static final String hostName = config.getProperty("ftp.host");
    ;
    private static final int port = NumberUtil.parseInt(config.getProperty("ftp.port"));
    private static final String userName = config.getProperty("ftp.name");
    ;
    private static final String password = config.getProperty("ftp.password");
    ;
    private static final Logger log = LoggerFactory.getLogger(FTPUtil.class);

    public static void upload(String remoteDir, InputStream in, String targetFileName) {
        try {
            ftpClient.connect(hostName, port);
            boolean b = ftpClient.login(userName, password);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                log.error("FTP server refused connection.");
                return;
            }
            ftpClient.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            ftpClient.changeWorkingDirectory(remoteDir);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("GBK");
            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.storeFile(targetFileName, in);
            IOUtils.closeQuietly(in);
            ftpClient.logout();
        } catch (SocketException e) {
            log.error("socketException:", e);
        } catch (IOException e) {
            log.error("socketException:", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                log.error("socketException:", e);
            }
        }
    }

}
