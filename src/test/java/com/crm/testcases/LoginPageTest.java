package com.crm.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.crm.base.WebDriverBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends WebDriverBase
{
	//Logger log = LoggerFactory.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest()
	{
		super();
	}
	
	/*@BeforeTest(alwaysRun = true)
	public void setUP()
	{
		//log.info("This is to initalize test.......!");
		
		
	}*/
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization(browserName,url);
		loginPage = new LoginPage();
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		//test = reports.createTest("loginPageTitleTest");
		String loginPageTitle = loginPage.validateLoginPageTitle();
		
		//log.info("Validaating login page title. Login page title is :- " + loginPageTitle);
		Assert.assertEquals(loginPageTitle, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest()
	{
		//test = reports.createTest("loginPageLogoTest");
		boolean flag = loginPage.validateCRMLLogo();
		flag = false;
		//log.info("Validaating CRM logo. CRM logo is :- " + flag);
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void loginTest() throws InterruptedException 
	{
		//test = reports.createTest("loginTest");
		//log.info("Step - 1. Enter userName :- " + userName + " and password :- " + password);
		loginPage.login(userName, password);
		//log.info("Step - 2. Verify User logged in successfully!");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{	
		if(driver != null) 
		{
			driver.close();
		}
		
	}

}
