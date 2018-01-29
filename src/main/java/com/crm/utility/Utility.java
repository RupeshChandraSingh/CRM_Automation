package com.crm.utility;

import org.openqa.selenium.WebElement;

import com.crm.base.WebDriverBase;

public class Utility extends WebDriverBase
{

	public static long page_Load_Time = 30;
	public static long implicit_Wait = 30;
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	public static void webElementOperations(String MpOperationType, WebElement MpElement, String MpElementName, String OpPageName, String MpInputData)
	{
		switch (MpOperationType.toLowerCase()) 
		{
		case "click":
		{
			MpElement.click();
		}
		
		
		}	
	}
	public static void click(WebElement element) {
		element.click();
	}
	public static void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	public static void clear(WebElement element) {
		element.clear();
	}

}
