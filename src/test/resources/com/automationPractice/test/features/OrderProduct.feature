@test
Feature: Order a product

  Scenario: Order T-shirt and verify in order history
    Given I access the Automation Practice homepage
    And I click on SignIn button
    And I fill in login name "someone1@example.com" and password "example"
    And I click on Submit button
    And I click on T-shirts tab
    When I click on T-shirt item
    And I click on Add to cart button
    And I click on Proceed to checkout button
    Then I validate the total price is "$18.51"
    And I click on Proceed to checkout button on Shopping Cart page
    And I click on Proceed to checkout button on Address page
    And I click on Terms of service checkbox
    And I click on Proceed to checkout button on Shipping page
    And I select Pay by bank wire
    And I confirm my order
    Then I click on username to navigate to My Account page
    And I click on order history and details
    And I verified the order history
    And I logout
