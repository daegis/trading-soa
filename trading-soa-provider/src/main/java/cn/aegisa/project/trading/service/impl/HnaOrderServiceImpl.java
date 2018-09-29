package cn.aegisa.project.trading.service.impl;

import cn.aegisa.project.trading.config.MailSender;
import cn.aegisa.project.trading.model.UserBaseInfo;
import cn.aegisa.project.trading.service.HnaOrderService;
import cn.aegisa.project.trading.vo.HnaOrderDO;
import cn.aegisa.selext.dao.service.ICommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/21 17:10
 */
@SuppressWarnings("Duplicates")
@Service
@Slf4j
public class HnaOrderServiceImpl implements HnaOrderService {

    @Autowired
    @Qualifier("hireportCommonService")
    private ICommonService hiCommonService;

    @Autowired
    private MailSender mailSender;

    @Value("${hna.order.mail.sendTo}")
    private String hnaReceiver;


    @Override
    public void doHnaOrderJob() throws IOException {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();
        LocalDate yestorday = today.minusDays(1L);
        String yestordayStr = yestorday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime startOfToday = today.atStartOfDay();
        LocalDateTime startOfYestorday = startOfToday.minusDays(1L);
        List<HnaOrderDO> hnaOrderList = hiCommonService.getListBySqlId(UserBaseInfo.class, "selectHnaOrder",
                "startTime", getTimeStr(startOfYestorday),
                "endTime", getTimeStr(startOfToday));
        String todayStr = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String title = todayStr + "海航订单结果";
        if (hnaOrderList.size() == 0) {
            log.info(todayStr + "无海航订单");
            mailSender.sendMail(hnaReceiver.split(","), title, "昨日无海航订单。");
            return;
        }
        ClassPathResource resource = new ClassPathResource("excel/hnaorder.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(resource.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        log.info("初始化海航订单模板成功");
        int rowIndex = 1;
        for (HnaOrderDO hnaOrder : hnaOrderList) {
            XSSFRow row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(hnaOrder.getOrderNo());
            row.createCell(1).setCellValue(hnaOrder.getProductName());
            row.createCell(2).setCellValue(hnaOrder.getTotalPrice());
            row.createCell(3).setCellValue(hnaOrder.getPaidPrice());
            LocalDateTime orderTime = hnaOrder.getOrderTime();
            row.createCell(4).setCellValue(orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            row.createCell(5).setCellValue(hnaOrder.getOrderType());
            row.createCell(6).setCellValue(hnaOrder.getMobile());
            row.createCell(7).setCellValue(hnaOrder.getUserId());
            row.createCell(8).setCellValue(hnaOrder.getEmployeeStatus());
        }
        FileOutputStream outputStream = null;
        String fullPath;
        String fileName;
        String fileSuffix = ".xlsx";
        try {
            String os = System.getProperty("os.name");
            String path;
            if (os != null && os.contains("Windows")) {
                path = "d:/";
            } else {
                path = "/root/job/excel/";
            }
            fileName = "海航订单" + yestordayStr;
            fullPath = path + fileName + fileSuffix;
            outputStream = new FileOutputStream(fullPath);
            workbook.write(outputStream);
            log.info(fullPath + "已写入磁盘成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }

        // 尝试发动电子邮件
        try {
            File file = new File(fullPath);
            Map<String, File> map = new LinkedHashMap<>();
            map.put(fileName + fileSuffix, file);
            String[] receiver = hnaReceiver.split(",");
            mailSender.sendMailWithAttachment(receiver, fileName, "每日海航订单已完成。", map);
            log.info("每日海航订单电子邮件发送成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTimeStr(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
