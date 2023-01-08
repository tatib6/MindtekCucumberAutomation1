package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    /**
     * .openExcelFile("TEstData",""Sheet1)--> return void
     * .getValue(0,1);--> return String
     * .setValue(2,6,"Kim); --> return void
     */

    private static Sheet sheet;// - this Object will be created and navigated
    private static Workbook workbook;
    private static FileInputStream input;
    private static FileOutputStream output;
    private static String path;

    static void openExcelFile(String fileName, String SheetName) {
        path = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName + ".xlsx";
        try {
            input = new FileInputStream(path);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(SheetName);
        } catch (FileNotFoundException e) {
            System.out.println("Excel spreadsheet path is invalid " + path);
        } catch (IOException e) {
            System.out.println("Could not open Excel");
        }

    }

    //This method will return data from provided row and cell Number.
    public static String getValue(int rowNum, int cellNum) {
        return sheet.getRow(rowNum).getCell(cellNum).toString();
    }

    public static void setValue(int rowNum, int cellNum, String value) {

        if (sheet.getPhysicalNumberOfRows() <= rowNum) {
            sheet.createRow(rowNum).createCell(cellNum).setCellValue(value);
        } else if (sheet.getRow(rowNum).getPhysicalNumberOfCells() <= cellNum) {
            sheet.getRow(rowNum).createCell(cellNum).setCellValue(value);
        } else {
            sheet.getRow(rowNum).getCell(cellNum).setCellValue(value);
        }
        try {
            output = new FileOutputStream(path);
            workbook.write(output);
        } catch (FileNotFoundException e) {
            System.out.println("Excel spreadsheet path is invalid " + path);
        } catch (IOException e) {
            System.out.println("Couldn't save changes to Excel");
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                System.out.println("Couldn't close fileOutputStream object");
            }
        }

    }


}
