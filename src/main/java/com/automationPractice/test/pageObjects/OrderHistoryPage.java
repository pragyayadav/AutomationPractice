package com.automationPractice.test.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Order History Page
 * @author pragya.a.yadav
 *
 */
public class OrderHistoryPage {
	

	public WebDriver ldriver;
	
	public OrderHistoryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = "#order-list tbody tr")
	WebElement orderList;
	
	public void getOrderList()
	{
		Assert.assertNotNull(orderList.getSize());
	}

}
