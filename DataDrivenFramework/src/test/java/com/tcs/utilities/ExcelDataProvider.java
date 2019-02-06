package com.tcs.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	
	@Test(dataProvider="test1Data")
	public void test1(String username,String password)
	{
		System.out.println(username + " | " +password );
	}
	


	@DataProvider(name = "test1Data")	
	public  Object[][] getData() throws IOException
	{
		
		Object data[][] =testData("C:\\Users\\Santosh\\SeleniumFrameworkStudy\\DataDrivenFramework\\src\\test\\resources\\testDataExcel\\TestData.xlsx", "MercuryLoginData");
		return data;
		
	}
	
	
	

	public static Object[][] testData(String excelPath,String sheetName) throws IOException
	{
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
        Object data[][] = new Object[rowCount-1][colCount];
		
		for(int row = 1; row < rowCount ; row++ )
		{
			for(int col = 0;col < colCount;col++)
			{
				String cellData = excel.getCellDataString(row, col);
				//System.out.println(cellData);
				data[row-1][col] = cellData;
				
			}

		}
		return data;
	}
}
