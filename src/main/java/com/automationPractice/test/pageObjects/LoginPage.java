package com.automationPractice.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Login Page Objects
 * @author pragya.a.yadav
 *
 */
public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(className = "login")
	WebElement signIn;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id ="passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;
	
	@FindBy(className ="logout")
	WebElement logout;
	
	
	public void setUserName(String uname)
	{
		email.clear();
		email.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickSignIn()
	{
		signIn.click();
	}
	
	public void clickSubmitLogin()
	{
		submitLogin.click();
	}
	
	public void logout()
	{
		logout.click();
	}
	
	
}
