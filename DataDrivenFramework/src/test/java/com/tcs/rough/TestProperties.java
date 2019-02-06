package com.tcs.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
	
		String ProjectPath = System.getProperty("user.dir");
		Properties Config = new Properties();
		FileInputStream fio = new FileInputStream(ProjectPath+"\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fio);
		
		System.out.println(Config.getProperty("browser"));
		System.out.println(Config.getProperty("testsiteUrl"));

	}

}
