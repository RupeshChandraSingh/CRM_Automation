package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.WebDriverBase;


public class ContactsPage extends WebDriverBase {
	
	@FindBy (xpath = "//td[contains(text(),'Contacts')]")
	WebElement lblContacts;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactsLabel()
	{
		return lblContacts.isDisplayed();
	}
}
