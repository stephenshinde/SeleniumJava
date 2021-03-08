package com.automation.helpers;

import org.openqa.selenium.WebElement;

public class WebElementHelper {
	
	public static boolean isElementDisplayed(WebElement elemet) {
		try {
			elemet.isDisplayed();
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public static boolean isElementEnabled(WebElement elemet) {
		try {
			elemet.isEnabled();
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public static boolean isElementSelected(WebElement elemet) {
		try {
			elemet.isSelected();
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

}
