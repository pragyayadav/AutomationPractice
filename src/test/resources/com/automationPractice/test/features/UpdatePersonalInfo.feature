@test
Feature: Update personal information of user

  Scenario: Update Personal Information (First Name) in My Account
    Given User access the Automation Practice homepage
    And User click on SignIn button
    And User fill in login name "someone1@example.com" and password "example"
    And User click on Submit button
    And User click on My Personal Information
    When User updated user first name to "Automation"
    And User enter password "example"
    Then User click on Save button
    And The success message is "Your personal information has been successfully updated."
    And User verified updated name is "Automation Example"
    And User logout
