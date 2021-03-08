package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.core.Base;

public class BasePage extends Base{

	public void clickButton(WebElement element) {
		element.click();
	}

	public void sendText(WebElement element ,String value) {
		element.sendKeys(value);
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public String getTextName(WebElement element) {
		return element.getText();
	}

	public String getcurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPagetitle() {
		return driver.getTitle();
	}

	public void movetoElement(WebElement element) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		} catch (NoSuchElementException e) {

			System.out.println(e.getMessage());

		}
	}

	public void movetoElementifNotDisplay(WebElement element) {
		if(!element.isDisplayed()) {
			try {
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
			} catch (NoSuchElementException e) {

				System.out.println(e.getMessage());

			}

		}
	}
	
	public void selectbyText(WebElement element ,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectbyValue(WebElement element ,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectbyIndex(WebElement element ,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}



}
