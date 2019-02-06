package com.tcs.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.tcs.utilities.ExcelUtils;


/*
 * Creation of Maven Project+ Updates to POM.xml --> Done
 * BaseClass Creatio -- used for driver initialization,declaration of static variables to globally access config.proprties ad
 * and OR.properties --> Done
 * WebDriver --> Done
 * Accessing Properties in Test Case Script --> Done
 * Logs --> Required - Log4j.jar, aplication.log, seleium.log,Log4j.properties,Logger class  --> Done
 * 
 * 
 * 
 * 
 * 
 */

public class TestBase {
	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log =Logger.getLogger("devpinoyLogger");
	//public static ExcelUtils excel ;
	
	//@Test
	//public void f() {
	//}

	@BeforeSuite
	public void setUp() throws IOException 
	{
		if(driver==null)
		{    
			String  ProjectPath = System.getProperty("user.dir");
			FileInputStream fio = new FileInputStream(ProjectPath+"\\src\\test\\resources\\properties\\Config.properties");
			Config.load(fio);
			log.debug("Config properties loaded");
		}
		if(Config.getProperty("browser").equals("Chrome"))
		{
			String  ProjectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", ProjectPath+"\\src\\test\\resources\\executables\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Config.getProperty("testsiteUrl"));
			log.debug("URL loaded");
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.MILLISECONDS);
		}
		else if(Config.getProperty("browser").equals("ie"))
		{
			String  ProjectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", ProjectPath+"\\src\\test\\resources\\executables\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(Config.getProperty("testsiteUrl"));
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MILLISECONDS);
		}
	}
	@AfterSuite
	public void tearDown() 
	{
		if(driver!=null) 
		{
			driver.quit();
		}
		log.debug("Test execution completed");
	}
	
	public boolean isElementPresent(By by)
	{	
		try
		{
			driver.findElement(by);
			log.debug("Assertion Passed for element :"+by);
			return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
		
		
	}
	
}
