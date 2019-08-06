package com.automationPractice.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;


/**
 * Personal Info Page
 * @author pragya.a.yadav
 *
 */
public class PersonalInfoPage {

	public WebDriver ldriver;

	public PersonalInfoPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(name="submitIdentity")
	WebElement submitIdentity;
	
	@FindBy(id="old_passwd")
	WebElement oldPassword;
	
	@FindBy(id="passwd")
	WebElement newPassword;
	
	@FindBy(id="confirmation")
	WebElement confirmPassword;
	
	@FindBy(css=".alert.alert-success")
	WebElement successMessage;

	
	public void updateFirstName(String name)
	{
		firstName.click();
		firstName.clear();
		firstName.sendKeys(name);
		
	}
	
	public void submitIdentity()
	{
		submitIdentity.click();	
	}
	
	public void updatePassword(String pwd)
	{
		oldPassword.click();
		oldPassword.sendKeys(pwd);
		
		newPassword.click();
		newPassword.sendKeys(pwd);
		
		confirmPassword.click();
		confirmPassword.sendKeys(pwd);
	}
	
	public void assertMessage(String expectedMessage)
	{
		Assert.assertEquals(expectedMessage, successMessage.getText());
	}

}
