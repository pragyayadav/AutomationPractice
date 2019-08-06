
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
 * Update User's Personal Information
 * @author pragya.a.yadav
 *
 */
public class UpdatePersonalInfo extends BaseClass {


		@Given("^User access the Automation Practice homepage$")
		public void i_access_the_automation_practice_homepage() throws Throwable {
			setUp();
			driver.get("http://automationpractice.com");

		}

		
		@And("^User click on SignIn button$")
		public void i_click_on_signin_button() throws Throwable {
			login = new LoginPage(driver);
			login.clickSignIn();
		}

		@And("^User fill in login name \"([^\"]*)\" and password \"([^\"]*)\"$")
		public void i_fill_in_login_name_something_and_password_something(String email, String password) throws Throwable {
			login.setUserName(email);
			login.setPassword(password);
		}

		
		@And("^User click on Submit button$")
		public void i_click_on_submit_button() throws Throwable {
			login.clickSubmitLogin();
		}
		
		@Given("User click on My Personal Information")
		public void i_click_on_My_Personal_Information() {
			account = new AccountPage(driver);
			account.clickPersonalInfo();
		}

		@When("User updated user first name to {string}")
		public void i_updated_user_first_name_to(String name) {
			personalInfo = new PersonalInfoPage(driver);
			personalInfo.updateFirstName(name);
		}

		@When("User enter password {string}")
		public void i_enter_password(String pwd) {

			personalInfo.updatePassword(pwd);
		}

		@When("User click on Save button")
		public void i_click_on_Save_button() {

			personalInfo.submitIdentity();
		}

		@And("^The success message is \"([^\"]*)\"$")
		public void the_success_message_is_something(String message) throws Throwable {
			
			personalInfo.assertMessage(message);
			
		}

		@Then("User verified updated name is {string}")
		public void i_verified_updated_name_is(String updatedName) {
			
			account.assertUserName(updatedName);
		}

		@Then("User logout")
		public void i_logout() {

			login.logout();
			driver.close();

		}


		

	

}
