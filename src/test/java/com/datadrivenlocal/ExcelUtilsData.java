package com.datadrivenlocal;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsData {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static int rowCount;

    public ExcelUtilsData(String excelPath, String sheetName)
    {
        try 
        {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    // To get Row Count
    public static int getRowCount() 
    {
        return sheet.getPhysicalNumberOfRows();
    }

    // To get cellValue
    // public static void getCellData(int rowNum,int colNum)
    // {
    //     DataFormatter formatter = new DataFormatter();
    //     Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    //     System.out.println(value);
    // }

    public static String getCellData(int rowNum, int colNum) 
    {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }

    public int getColumnCount() 
    {
        Row headerRow = sheet.getRow(0);
        if (headerRow != null) 
        {
            return headerRow.getLastCellNum();
        } 
        else
        {
            return 0; // Header row does not exist
        }
    }


}
