package com.automationPractice.test.stepDefinition;

import org.junit.Assert;

import com.automationPractice.test.pageObjects.AccountPage;
import com.automationPractice.test.pageObjects.AddressPage;
import com.automationPractice.test.pageObjects.BaseClass;
import com.automationPractice.test.pageObjects.LoginPage;
import com.automationPractice.test.pageObjects.OrderHistoryPage;
import com.automationPractice.test.pageObjects.OrderSummaryPage;
import com.automationPractice.test.pageObjects.PaymentPage;
import com.automationPractice.test.pageObjects.PersonalInfoPage;
import com.automationPractice.test.pageObjects.ProductPage;
import com.automationPractice.test.pageObjects.ShippingPage;
import com.automationPractice.test.pageObjects.ShoppingCartPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/**
 * Place an Order
 * @author pragya.a.yadav
 *
 */
public class ManageOrders extends BaseClass {

	@Given("^I access the Automation Practice homepage$")
	public void i_access_the_automation_practice_homepage() throws Throwable {
		setUp();
		driver.get("http://automationpractice.com");

	}

	@When("^I click on T-shirt item$")
	public void i_click_on_tshirt_item() throws Throwable {

		product.clickItem();
	}

	@And("^I click on SignIn button$")
	public void i_click_on_signin_button() throws Throwable {
		login = new LoginPage(driver);
		login.clickSignIn();
	}

	@And("^I fill in login name \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_fill_in_login_name_something_and_password_something(String email, String password) throws Throwable {
		login.setUserName(email);
		login.setPassword(password);
	}

	@And("^I click on T-shirts tab$")
	public void i_click_on_tshirts_tab() throws Throwable {

		product = new ProductPage(driver);
		product.clickTShirtTab();
	}

	@And("^I click on Add to cart button$")
	public void i_click_on_add_to_cart_button() throws Throwable {
		product.clickAddToCart();
	}

	@And("^I click on Proceed to checkout button$")
	public void i_click_on_proceed_to_checkout_button() throws Throwable {
		product.clickProceedCheckout();
	}

	@And("^I click on Submit button$")
	public void i_click_on_submit_button() throws Throwable {
		login.clickSubmitLogin();
	}

	@Then("I logout")
	public void i_logout() {

		login.logout();
		driver.close();

	}

	@And("^I validate the total price is \"([^\"]*)\"$")
	public void i_validate_the_total_price_is_something(String price) throws Throwable {
		shop = new ShoppingCartPage(driver);
		Assert.assertEquals(price, shop.getTotalPrice());
	}

	@And("^I click on Proceed to checkout button on Shopping Cart page$")
	public void i_click_on_proceed_to_checkout_button_on_shopping_cart_page() throws Throwable {
	
		shop.clickCartProceedCheckout();
	}

	@And("^I click on Terms of service checkbox$")
	public void i_click_on_terms_of_service_checkbox() throws Throwable {

		ship = new ShippingPage(driver);
		ship.clickCheckBox();
	}

	@And("^I click on Proceed to checkout button on Shipping page$")
	public void i_click_on_proceed_to_checkout_button_on_shipping_page() throws Throwable {

		ship.clickProcessCarrier();
	}

	@And("^I select Pay by bank wire$")
	public void i_select_pay_by_bank_wire() throws Throwable {
		payment = new PaymentPage(driver);
		payment.clickPaymentModule();

	}

	@And("^I confirm my order$")
	public void i_confirm_my_order() throws Throwable {
		order = new OrderSummaryPage(driver);
		order.clickConfirmOrder();
	}

	@And("^I verified the order history$")
	public void i_verified_the_order_history() throws Throwable {

		orderHistory = new OrderHistoryPage(driver);
		orderHistory.getOrderList();

	}

	@And("^I click on Proceed to checkout button on Address page$")
	public void i_click_on_proceed_to_checkout_button_on_address_page() throws Throwable {

		address = new AddressPage(driver);
		address.clickAddressProceedCheckout();
	}

	@Then("I click on username to navigate to My Account page")
	public void i_click_on_username_to_navigate_to_My_Account_page() {
		account = new AccountPage(driver);
		account.clickUser();
	}

	@Then("I click on order history and details")
	public void i_click_on_order_history_and_details() {
		account.clickOrderHistory();

	}

	

}
