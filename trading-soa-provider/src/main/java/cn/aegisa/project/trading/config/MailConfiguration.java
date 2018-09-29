package cn.aegisa.project.trading.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/15 11:14
 */
@Configuration
public class MailConfiguration {

    @Value("${mail.host}")
    private String host;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.username}")
    private String username;

    private static final Integer port = 25;

    private Properties properties = new Properties();

    {
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.timeout", "2500000");
//        properties.setProperty("mail.debug", "true");//启用调试
        properties.setProperty("mail.smtp.port", Integer.toString(port));//设置端口
    }

    private Session javaMailSession() {
        return Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setDefaultEncoding("UTF-8");
        javaMailSender.setPassword(password);
        javaMailSender.setSession(javaMailSession());
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    @Bean
    public MailSender mailSender() {
        return new MailSender(javaMailSender(), username);
    }
}
