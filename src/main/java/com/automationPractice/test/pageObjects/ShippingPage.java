package com.automationPractice.test.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Shipping Page Objects
 * @author pragya.a.yadav
 *
 */
public class ShippingPage {

	public WebDriver ldriver;

	public ShippingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "cgv")
	WebElement checkBox;

	@FindBy(name = "processCarrier")
	WebElement processCarrier;

	public void clickCheckBox() {
		checkBox.click();
	}

	public void clickProcessCarrier() {
		processCarrier.click();
	}

}
