package com.automation.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.helpers.WaitHelper;


public class SearchPage extends BasePage{

	public SearchPage(){
		PageFactory.initElements(driver, this);// 'this' means current class objects. 		
	}

	@FindBy(xpath="//button[@id='yearFilter']")
	private WebElement firstRegistrationBtn;

	@FindBy(css = ".containerBottomEnd___1NYoL #rangeStart")
	private WebElement fromYeardropdown;

	@FindBy(css  = "#sortBy")
	private WebElement sortFilterdropdown;
	
	@FindBy(xpath="//h2[@data-qa-selector='title']")
	private WebElement carNameTitle;

	@FindBy(xpath  = "//div[contains(@class,'infoContainer')]//ul//child::li[1]")
	private List<WebElement> yearResulttxt;

	//ul[contains(@class,'specList']//child::li[1]

	@FindBy(xpath  = "//div[@class='titleWrapper___3XjH7']//child::div")
	private List<WebElement> priceResulttxt;


	public void clickonFirsRegistration() {
		clickButton(firstRegistrationBtn);
	}

	public void selectFromyear(String text) {
		selectbyText(fromYeardropdown, text);
	}

	public void selectHighestprice(int index) {
		selectbyIndex(sortFilterdropdown, index);
	}

	public List<String> getPriceorderList() {
		List<String> actualList= new ArrayList<>();
		for(WebElement ele :priceResulttxt ) {
			String data =ele.getText();
			actualList.add(data);
		}

		return actualList;
	}
	
	public List<String> descendingsortedOrderList() {
		List<String> temp = new ArrayList<>();
		temp.addAll(getPriceorderList());
		Collections.sort(temp, Collections.reverseOrder());
		return temp;
	}
	
	
	public Iterator<WebElement> iterateYear() {
		
		return yearResulttxt.iterator();
	}
	
	public int getyearCount() {
		return yearResulttxt.size();
	}
	
	public String getelementsText(int index) {
		return yearResulttxt.get(index).getText();
	}

	public String getSearchPgeTitle() {
		return getPagetitle();
	}
	
	public String getSearchFilterURL() {
		return getcurrentUrl();
	}
	
	public void waittoloadCarNameTitle() {
		WaitHelper.waituntillElementVisible(driver, carNameTitle);
	}

}
