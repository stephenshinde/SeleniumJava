package com.automation.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.helpers.ConfigFileReader;

public class Base {
	public static WebDriver driver;
	
	ConfigFileReader reader = new ConfigFileReader();
	public void initializeTest() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+reader.getDriverPath());  
		driver = new ChromeDriver();
		driver.get(reader.getApplicationUrl());
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(reader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	public void tearDown() {
		driver.close();
	}
	

}
