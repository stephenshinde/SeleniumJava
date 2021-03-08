package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.helpers.ReportHelper;
import com.automation.pages.SearchPage;

public class SearchTest extends TestBase {
	

	@Test
	public void SearchProduct() throws Exception {
		String projectpath=System.getProperty("user.dir");
		System.out.println(projectpath);
		
		ReportHelper.extenttest = ReportHelper.addTestCasename("Search Product", "Search product and verift car year and price");

		SearchPage searchpage= new SearchPage();
		ReportHelper.extenttest.info("I navigated to search pageverify page title");
		Assert.assertEquals(searchpage.getSearchPgeTitle(),"Jetzt Top-Gebrauchtwagen online kaufen | Autohero.com");
		
		ReportHelper.extenttest.info("I click on first registration filter button");
		searchpage.clickonFirsRegistration();
		
		ReportHelper.extenttest.info("I apply filter from year 2015");
		searchpage.selectFromyear("2015");
		
		ReportHelper.extenttest.info("I click to close first registration filter button");
		searchpage.clickonFirsRegistration();
		
		ReportHelper.extenttest.info("I apply sort from highest price");
		searchpage.selectHighestprice(2);
		
		ReportHelper.extenttest.info("I verify filter sort web URL");
		Assert.assertEquals(searchpage.getSearchFilterURL(), "https://www.autohero.com/de/search/?sort=PRICE_DESC&yearMin=2015");
		
		ReportHelper.extenttest.info("I wait to load car name");
		searchpage.waittoloadCarNameTitle();
		
		ReportHelper.extenttest.info("I Verify all cars are filtered by first registration (2015+)");
		// Verify the first registration year is 2015+
		for(int i=0;i<searchpage.getyearCount();i++) {
			String getYear = searchpage.getelementsText(i);
			int year =Integer.parseInt(getYear); 
			System.out.println("Car registration year is ....."+year);

			Assert.assertTrue(year >=2015);

		}
		
		System.out.println(searchpage.getPriceorderList());
		System.out.println(searchpage.descendingsortedOrderList());
		
		ReportHelper.extenttest.info("I Verify all cars are sorted by price descending");
		Assert.assertTrue(searchpage.getPriceorderList().equals(searchpage.descendingsortedOrderList()));

		ReportHelper.extenttest.info("I executed test case successfully");
	}
}