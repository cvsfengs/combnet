package com.comb.commons.utils.mail;

import com.comb.commons.utils.MarkInterface;
import com.comb.commons.utils.property.PropertyUtil;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by ycfeng on 2016/7/27
 * 邮件工具类.
 */
public class MailUtil implements MarkInterface {

    /**
     * 在进行邮件发送者,姓名地址的获取,我认为只要初始化一次即可
     */
    private static final int port = Integer.parseInt(PropertyUtil.getValueByKey("mail.serverPort"));
    private static final String server = PropertyUtil.getValueByKey("mail.serverHost");
    private static final String user = PropertyUtil.getValueByKey("mail.sendAddress");
    private static final String password = PropertyUtil.getValueByKey("mail.userPassword");

    //todo 这里我感觉换成LoggerUtil自己封装一层更好一些
    public static void sendEmail(String email, String from, String subject, String body) throws Exception {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", server);
            props.put("mail.smtp.port", String.valueOf(port));
            props.put("mail.smtp.auth", "true");
            Transport transport = null;
            Session session = Session.getDefaultInstance(props, null);
            transport = session.getTransport("smtp");
            transport.connect(server, user, password);
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            InternetAddress fromAddress = new InternetAddress(user, from, "UTF-8");
            msg.setFrom(fromAddress);
            InternetAddress[] toAddress = new InternetAddress[1];
            toAddress[0] = new InternetAddress(email);
            msg.setRecipients(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {

        for (int i = 0; i < 2; i++) {
            Thread.sleep(5000);
            sendEmail("470641852@qq.com", "StephenFeng", "邮件测试", "测试邮件");//收件人
            System.out.println("ok");
        }
    }

}
