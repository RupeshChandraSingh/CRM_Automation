package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.WebDriverBase;

public class SignUpPage extends WebDriverBase {
	
	
	@FindBy(name = "first_name")
	WebElement txtFirstName;
	
	@FindBy(name = "surname")
	WebElement txtLastName;
	
	@FindBy(name = "email")
	WebElement txtEmail;
	
	@FindBy(name = "email_confirm")
	WebElement txtConfirmEmail;
	
	@FindBy(name = "username")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "passwordconfirm")
	WebElement txtPasswordConfirm;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void fillSignUpPage(String fName, String lName, String email, String conEmail, String uName, String pwd, String conPwd)
	{
		txtFirstName.sendKeys(fName);
		txtLastName.sendKeys(lName);
		txtEmail.sendKeys(email);
		txtConfirmEmail.sendKeys(conEmail);
		txtUserName.sendKeys(uName);
		txtPassword.sendKeys(pwd);
		txtPasswordConfirm.sendKeys(conPwd);
		
	}

}
