@FE
Feature: Login Flow
  This feature tests the login functionality of the Swag Labs application.
  It ensures that users can log in with valid credentials, that appropriate error messages are displayed
  when invalid or missing credentials are provided and that user can logout after logging in.

  Scenario: User can log in with valid credentials
    Given User is on Login page
    And User enters valid username and password
    When User clicks on login button
    Then Logout button is displayed

  Scenario: User cannot log in with invalid credentials
    Given User is on Login page
    And User enters invalid username and valid password
    And User clicks on login button
    And Username and password do not match error message is displayed
    When User enters valid username and invalid password
    And User clicks on login button
    Then Username and password do not match error message is displayed

  Scenario: User cannot log in without credentials
    Given User is on Login page
    And User enters valid username
    And User clicks on login button
    And Password is required error message is displayed
    And User is on Login page
    When User enters valid password
    And User clicks on login button
    Then Username is required error message is displayed

  Scenario: User can log out after successful login
    Given User is on Login page
    And User is logged in with valid credentials
    When User clicks on logout button
    Then Login button is displayed