package TestUtilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class ReadExcel {

    //public FileInputStream fis = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row;
    private XSSFCell cell=null;
    DataFormatter formatter;

    public ReadExcel() throws IOException {

        // //Create an object of File class to open xlsx file

        File file = new File(System.getProperty("user.dir") + "\\TestData\\RegistrationData.xlsx");
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Sheet1");
        formatter = new DataFormatter(Locale.US);

    }
    public String getFirstName (String sheetName,int colnum, int rownum){

        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);
        System.out.println(cell.getStringCellValue());
        return (cell.getStringCellValue());


    }
    public String getLastName (String sheetName,int colnum, int rownum){
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);
        formatter.formatCellValue(cell);
        System.out.println(cell.getStringCellValue());
        return (cell.getStringCellValue());

    }
    public String getEmail(String sheetName,int colnum,int rownum){
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);
        return (cell.getStringCellValue());

    }
    public String getPassword(String sheetName,int colnum,int rownum){
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);
        return (cell.getStringCellValue());
    }
    public String getConfirmPassword(String sheetName,int colnum,int rownum){
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);
        return (cell.getStringCellValue());
    }
}





