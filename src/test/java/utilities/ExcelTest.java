package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {
    public static void main(String[] args) throws IOException {

//        String path = System.getProperty("user.dir")+"/src/test/resources/testdata/Data1.xlsx";
//
//        FileInputStream input = new FileInputStream(path);//reading data in a file
//        Workbook workbook = new XSSFWorkbook(input);
//
//        Sheet sheet1 = workbook.getSheet("Sheet1");
//
//        String firstName = sheet1.getRow(1).getCell(0).toString();
//        System.out.println(firstName);
//        System.out.println(sheet1.getRow(2).getCell(1).toString());
//
//        sheet1.getRow(2).getCell(1).setCellValue("Nadkarni");
//        System.out.println(sheet1.getRow(2).getCell(1).toString());
//
//        FileOutputStream output = new FileOutputStream(path);//writing data
//        workbook.write(output);
//        output.close();
//

ExcelUtils.openExcelFile("Data1", "Sheet1");

System.out.println(ExcelUtils.getValue(1, 2));

ExcelUtils.setValue(1, 2, "coconut@gmail.com");

System.out.println(ExcelUtils.getValue(1, 2));

List<String> names = new ArrayList<>();
names.add("Raif");
names.add("Usha");
names.add("Najya");

for (String name : names) {
            ExcelUtils.setValue(1, 2, name);
            System.out.println(ExcelUtils.getValue(1, 2));
}


    }
}
