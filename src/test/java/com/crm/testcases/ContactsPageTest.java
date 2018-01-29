package com.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.testng.annotations.BeforeMethod;

import com.crm.base.WebDriverBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.Utility;

public class ContactsPageTest extends WebDriverBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage conPage;
	Utility util;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUP() throws InterruptedException
	{
		
		loginPage = new LoginPage();
		homePage = loginPage.login(userName, password);
		util = new Utility();
		util.switchToFrame();
		loginPage.initialization(browserName, url);
		conPage = homePage.clicOnContactsLink();
	}
	
	@Test
	public void contactsPageLabelTest()
	{
		boolean flag = conPage.validateContactsLabel();
		AssertJUnit.assertTrue(flag);
	}
	


	//@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
