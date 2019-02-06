package com.tcs.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tcs.base.TestBase;

public class LoginTest extends TestBase {

	//@Test(dataProvider="dataProviderMethod")
	
	@Test(dataProvider="data-provider")
	public void loginToMercurySite() 
	{
		log.debug(" loginToMercurySite test --- STARTED");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		Assert.assertTrue(isElementPresent(By.xpath("//img[@src=\"/images/masts/mast_flightfinder.gif\"]")));
		log.debug(" loginToMercurySite test --- ENDED");
	}
/*
	 @DataProvider(name= "data-provider")
	public Object[][] dataProviderMethod()
	{
		String sheetName = "MercuryLoginData";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		for(int rowNum = 2;rowNum <= rows;rowNum++)
		{
			for(int colNum = 0;colNum < cols;colNum++)
			{
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	} */
	
}
