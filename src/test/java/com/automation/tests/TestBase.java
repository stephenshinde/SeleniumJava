package com.automation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.automation.core.Base;
import com.automation.helpers.ConfigFileReader;
import com.automation.helpers.ReportHelper;

public class TestBase extends Base {
	ConfigFileReader reader = new ConfigFileReader();
	
	@BeforeClass
	public void initializeSetting() {
		// start extent report methood
		ReportHelper.startExtentReport(System.getProperty("user.dir")+reader.getExtentReportPath());

	}
	
	@BeforeMethod
	public void startTest() {
		initializeTest();
	}
	
	
	@AfterMethod
	public void endTest() {
		tearDown();
	}
	
	@AfterClass
	public void endSetting() {
		ReportHelper.closeExtentReport();
	}
	
	

}
