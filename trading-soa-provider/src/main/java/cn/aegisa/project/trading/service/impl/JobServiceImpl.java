package cn.aegisa.project.trading.service.impl;

import cn.aegisa.project.trading.config.MailSender;
import cn.aegisa.project.trading.model.OrderMain;
import cn.aegisa.project.trading.service.JobService;
import cn.aegisa.project.trading.vo.FlightSuccessDO;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/21 10:39
 */
@SuppressWarnings("Duplicates")
@Service
@Slf4j
public class JobServiceImpl implements JobService {

    @Autowired
    @Qualifier("modelCommonService")
    private ICommonService orderCommonService;

    @Autowired
    private MailSender mailSender;

    @Value("${flight.mail.sendTo}")
    private String flightMailSendTo;


    @Override
    public void doFlightSuccessJob() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();
        LocalDate _7daysAgo = today.minusDays(7L);
        LocalDateTime startLocalDateTime = _7daysAgo.atStartOfDay();
        String startTime = startLocalDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String endTime = today.atStartOfDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("执行完成的机票查询定时任务。范围：{}到{}。", startTime, endTime);
        List<FlightSuccessDO> flightList = orderCommonService.getListBySqlId(OrderMain.class, "selectFlightSuccess", "startTime", startTime, "endTime", endTime);
        log.info("查询出记录条数：" + flightList.size());

        flightList.sort(Comparator.comparing(FlightSuccessDO::getCreateTime));

        ClassPathResource resource = new ClassPathResource("excel/flightOrder.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(resource.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        log.info("初始化机票信息模板成功");
        int rowIndex = 1;
        for (FlightSuccessDO flight : flightList) {
            XSSFRow row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(flight.getOrderNo());
            row.createCell(1).setCellValue(getTimeStr(flight.getCreateTime()));
            row.createCell(2).setCellValue(getTimeStr(flight.getPayTime()));
            row.createCell(3).setCellValue(flight.getDepartCityName());
            row.createCell(4).setCellValue(flight.getArrCityName());
            row.createCell(5).setCellValue(flight.getCode());
            row.createCell(6).setCellValue(flight.getCarrierName());
            row.createCell(7).setCellValue(flight.getPeopleCount());
            row.createCell(8).setCellValue(flight.getTotalPrice());
            String departDate = flight.getDepartDate();
            try {
                long timestamp = Long.parseLong(departDate);
                Date date = new Date(timestamp);
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                row.createCell(9).setCellValue(time);
            } catch (Exception ignored) {
            }
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
            String todayStr = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            fileName = "机票成功明细" + todayStr;
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
            String[] receiver = flightMailSendTo.split(",");
            mailSender.sendMailWithAttachment(receiver, fileName, "每周定时任务已完成。", map);
            log.info("电子邮件发送成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTimeStr(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
