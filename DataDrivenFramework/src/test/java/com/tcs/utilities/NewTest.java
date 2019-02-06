package com.tcs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() throws IOException {

		String KeywordFile = System.getProperty("user.dir");
		File source = new File("C:\\Users\\Santosh\\SeleniumFrameworkStudy\\DataDrivenFramework\\src\\test\\resources\\testDataExcel\\TestData.xlsx");
		FileInputStream input= new FileInputStream(source);
		XSSFWorkbook wb= new XSSFWorkbook(input); 
		XSSFSheet TestCaseSheet = wb.getSheet("MercuryLoginData");   //TestCases Sheet
		
		
		String testdatasheet = TestCaseSheet.getSheetName();
		System.out.println(testdatasheet);
		int TestCaseRowCnt = TestCaseSheet.getLastRowNum();  //TestCase Sheet RowCount
		System.out.println(TestCaseRowCnt);
	}
}
