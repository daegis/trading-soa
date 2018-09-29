import cn.aegisa.project.trading.config.MailSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/15 13:24
 */
public class TestMail extends BaseJunit4Test {

    @Autowired
    private MailSender mailSender;

    @Test
    public void test01() {
        mailSender.sendMail(new String[]{"selext@yeah.net"}, "测试邮件1", "测试内容123" + UUID.randomUUID().toString());
    }

    @Test
    public void test02() throws Exception {
        Map<String, File> map = new LinkedHashMap<>();
        map.put("aaa.jpg", new File("D:\\utils\\123.jpg"));
        map.put("bbb.jpg", new File("D:\\utils\\微信图片_20180423105544.jpg"));
        mailSender.sendMailWithAttachment(new String[]{"selext@yeah.net"}, "测试附件邮件2", "测试内容" + UUID.randomUUID().toString(), map);
    }

}
