package cn.aegisa.project.trading.controller;

import cn.aegisa.project.trading.config.MailSender;
import cn.aegisa.project.trading.service.HnaOrderService;
import cn.aegisa.project.trading.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/15 13:41
 */
@Controller
public class JobController {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JobService jobService;

    @Autowired
    private HnaOrderService hnaOrderService;

    @RequestMapping("/jobFlightSuccess")
    @ResponseBody
    public String jobFlight() {
        try {
            jobService.doFlightSuccessJob();
            return "ok";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping("/hnaorder")
    @ResponseBody
    public String hnaOrder() {
        try {
            hnaOrderService.doHnaOrderJob();
            return "ok";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @ResponseBody
    @RequestMapping("/mail")
    public String testMail(String message) {
        mailSender.sendMail(new String[]{"selext@yeah.net"}, "测试邮件11111", message);
        return "ok";
    }
}
