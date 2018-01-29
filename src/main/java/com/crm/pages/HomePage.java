package com.crm.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.WebDriverBase;



public class HomePage extends WebDriverBase
{
//	public ContactsPage contactPage;
//	public DealsPage dealsPage;
//	public TasksPage tasksPage;
	Logger log = Logger.getLogger(HomePage.class);
	
	@FindBy(xpath = "//td[contains(text(),'rupesh Singh')]")
	WebElement lblUser;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement lnkContacts;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement lnkDeals;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement lnkTasks;
	
	//Initialization of page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean validateUserNameLable()
	{
		boolean flag = lblUser.isDisplayed();
		
		return flag;
	}
	
	public String validateHomePageTitle()
	{
		
		return driver.getTitle();
	}
		
	public ContactsPage clicOnContactsLink()
	{
		lnkContacts.click();
		log.info("Clicked on Contacts Link");
		
		return new ContactsPage();
	}
	
	public DealsPage clicOnDealsLink()
	{
		lnkDeals.click();
		log.info("Clicked on Deals Link");
		return new DealsPage();
	}
		
	public TasksPage clicOnTasksLink()
	{
		lnkTasks.click();
		
		return new TasksPage();
	}
		
		

}
