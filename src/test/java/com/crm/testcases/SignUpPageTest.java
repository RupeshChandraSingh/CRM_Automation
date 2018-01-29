package com.crm.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.WebDriverBase;
import com.crm.pages.LoginPage;
import com.crm.pages.SignUpPage;
import com.crm.utility.ReadExcelData;

public class SignUpPageTest extends WebDriverBase {
	
	LoginPage loginPage;
	SignUpPage signUpPage;
	public ReadExcelData excelData;
	String fName, lName, email, confirmEmail, uName, pwd, confirmPwd;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization(browserName,url);
		loginPage = new LoginPage();
		signUpPage = new SignUpPage();
		excelData = new ReadExcelData("F:\\Docs\\Rupesh\\crmTestData.xlsx");
		
	}
	@Test
	public void signUpValidation()
	{
		fName = excelData.getCellData("signUpPage", "firstname", 3);
		System.out.println(" ======================== "+fName  );
		lName = excelData.getCellData("signUpPage", "lastname", 3);
		email = excelData.getCellData("signUpPage", "email", 3);
		confirmEmail = excelData.getCellData("signUpPage", "confirmemail", 3);
		uName = excelData.getCellData("signUpPage", "username", 3);
		pwd = excelData.getCellData("signUpPage", "password", 3);
		confirmPwd = excelData.getCellData("signUpPage", "confirmpassword", 3);
		loginPage.clickOnSignUpButton();
		signUpPage.fillSignUpPage(fName, lName, email, confirmEmail, uName, pwd, confirmPwd);
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
