package com.automationPractice.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Payment Page
 * @author pragya.a.yadav
 *
 */
public class PaymentPage {

	public WebDriver ldriver;

	public PaymentPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "bankwire")
	WebElement paymentModule;

	public void clickPaymentModule() {
		paymentModule.click();
	}

}
