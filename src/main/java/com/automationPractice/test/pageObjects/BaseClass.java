package com.automationPractice.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Contains driver info
 * @author pragya.a.yadav
 *
 */
public class BaseClass {

	public WebDriver driver;
	public LoginPage login;
	public ProductPage product;
	public ShoppingCartPage shop;
	public AddressPage address;
	public OrderSummaryPage order;
	public ShippingPage ship;
	public PaymentPage payment;
	public OrderHistoryPage orderHistory;
	public AccountPage account;
	public PersonalInfoPage personalInfo;

	String projectPath = System.getProperty("user.dir");

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
}
