package com.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.crm.base.WebDriverBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.Utility;

public class HomePageTest extends WebDriverBase 
{
	LoginPage loginPage;
	HomePage homePage;
	Utility util;
	ContactsPage conPage;
	
	
	@BeforeMethod
	public void setUP() throws InterruptedException 
	{
		loginPage = new LoginPage();
		util = new Utility();
		homePage = loginPage.login(url, password);
	}
	
	
	@Test(priority = 1)
	public void homePageTitleTest()
	{
		String homePateTitle = homePage.validateHomePageTitle();
		AssertJUnit.assertEquals(homePateTitle, "CRMPRO");
		
	}
	
	@Test(priority = 2)
	public void homePageUserLabelTest()
	{
		util.switchToFrame();
		boolean flag = homePage.validateUserNameLable();
		driver.manage().timeouts().implicitlyWait(Utility.implicit_Wait, TimeUnit.SECONDS);
		AssertJUnit.assertTrue(flag);
		
	}
	
	@Test(priority = 3)
	public void homePageContactsLinkTest()
	{
		util.switchToFrame();
		conPage = homePage.clicOnContactsLink();
	
	}
	


	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
