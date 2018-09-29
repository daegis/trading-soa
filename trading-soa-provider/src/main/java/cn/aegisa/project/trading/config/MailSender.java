package cn.aegisa.project.trading.config;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/15 13:13
 */
public class MailSender {

    private JavaMailSender javaMailSender;
    private String from;

    public MailSender(JavaMailSender javaMailSender, String from) {
        this.javaMailSender = javaMailSender;
        this.from = from;
    }

    public void sendMail(String[] to, String head, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setFrom(from);
        mail.setSubject(head);
        mail.setText(body);
        javaMailSender.send(mail);
    }

    public void sendMailWithAttachment(String[] to, String head, String body, Map<String, File> attachments) throws Exception {
        if (attachments == null || attachments.size() == 0) {
            throw new Exception("附件邮件你至少得给我传一个附件吧。。。");
        }
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, true);
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(head);//主题
        mail.setText(body);//正文
        for (Map.Entry<String, File> entry : attachments.entrySet()) {
            String fileName = entry.getKey();
            File file = entry.getValue();
            if (!file.exists() || file.isDirectory()) {
                throw new Exception("要传输的文件" + fileName + "不存在，或者是一个文件夹，不支持文件夹");
            }
            mail.addAttachment(fileName, file);
        }
        javaMailSender.send(mimeMessage);
    }
}
