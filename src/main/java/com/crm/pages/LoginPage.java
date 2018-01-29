package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.WebDriverBase;

public class LoginPage extends WebDriverBase 
{
	//Object Repository
	@FindBy(name = "username")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement btnSignUp;
	
	@FindBy(xpath = "//img[contains(@src,'freecrm')]")
	WebElement lgCRMLogo;
	
	//Initialization of page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLLogo()
	{
		return lgCRMLogo.isDisplayed();
	}
	
	public HomePage login(String userName, String password) throws InterruptedException 
	{
		txtUserName.sendKeys(userName);
		Thread.sleep(3000);
		txtPassword.sendKeys(password);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		btnLogin.click();
		
		return new HomePage();
	}
	public void clickOnSignUpButton()
	{
		btnSignUp.click();
	}

}
