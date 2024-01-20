package com.tests;

import ExcelUtils.ExcelUtilsData;

public class TestExcelUitils 
{
	public static void main(String[] args)
	{
		String excelPath="C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\RestAssuredDemo\\data\\TestData.xlsx";
		//if(excelPath.contains(excelPath))
		//System.out.println("file exists");
		
		String sheetName="Sheet1";
		
		ExcelUtilsData excel=new ExcelUtilsData(excelPath, sheetName);
		
		excel.getrowCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
	}
	
}
