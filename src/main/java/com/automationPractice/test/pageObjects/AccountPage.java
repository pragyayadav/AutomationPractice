package com.automationPractice.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import junit.framework.Assert;


/**
 * My Account Page
 * @author pragya.a.yadav
 *
 */
public class AccountPage {	
	public WebDriver ldriver;

	public AccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className="account")
	WebElement userAccount;

	@FindBy(xpath = "//a[@title='Orders']")
	WebElement orderHistory;
	
	@FindBy(xpath = "//a[@title='Information']")
	WebElement personalInfo;
	
	public void clickUser()
	{
		userAccount.click();
	}

	public void clickOrderHistory()
	{
		orderHistory.click();
	}
	
	public void clickPersonalInfo()
	{
		personalInfo.click();
	}
	
		
	/**
	 * Validate UserName
	 * @param updatedUserName
	 */
	/**
	 * @author pragya.a.yadav
	 *
	 */
	public void assertUserName(String updatedUserName)
	{
	 Assert.assertEquals(updatedUserName, userAccount.getText());
	}


}
