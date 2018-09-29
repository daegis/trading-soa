import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/21 11:48
 */
public class TestExcel extends BaseJunit4Test {

    @Test
    public void test01() throws IOException {
        ClassPathResource resource = new ClassPathResource("excel/hnaorder.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(resource.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("哇啦哇啦");
        String os = System.getProperty("os.name");
        String path;
        if (os != null && os.contains("Windows")) {
            path = "d:/";
        } else {
            path = "/root/xyd/summary/";
        }
        String fileName = "海航订单1";
        String fileSuffix = ".xlsx";
        FileOutputStream outputStream = new FileOutputStream(path + fileName + fileSuffix);
        workbook.write(outputStream);
        outputStream.close();
    }

}
