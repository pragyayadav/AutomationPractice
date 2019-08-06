package com.automationPractice.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Product Page
 * @author pragya.a.yadav
 *
 */
public class ProductPage {

	public WebDriver ldriver;

	public ProductPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	WebElement tshirtsTab;

	@FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
	WebElement item;

	@FindBy(name = "Submit")
	WebElement addToCart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedCheckout;

	public void clickTShirtTab() {
		tshirtsTab.click();
	}

	public void clickItem() {
		item.click();
	}

	public void clickAddToCart() {
		addToCart.click();
	}

	public void clickProceedCheckout() throws InterruptedException {
		Thread.sleep(2000);
		proceedCheckout.click();
	}

}
