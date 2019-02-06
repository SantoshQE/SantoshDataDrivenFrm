package com.tcs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


	static XSSFWorkbook workbook;
	static XSSFSheet sheet;


	public  ExcelUtils(String excelPath,String sheetName) throws IOException 
	{
		try 
		{
			//File source = new File(excelPath);
			//FileInputStream input= new FileInputStream(source);
			workbook= new XSSFWorkbook(excelPath);
			System.out.println(sheetName.toString());
			sheet= workbook.getSheet(sheetName);
			System.out.println(sheet.toString());

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int getRowCount()
	{
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("No. of rows : "+rowCount);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	public static int getColumnCount()
	{
		int columnCount = 0;
		try {
			columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("No. of columns : "+columnCount);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return columnCount;

	}
	public static String getCellDataString(int rowNum,int Column)
	{
		String cellData= null;
		cellData = sheet.getRow(rowNum).getCell(Column).getStringCellValue();
		//System.out.println(cellData);
		return cellData;

	}


}
