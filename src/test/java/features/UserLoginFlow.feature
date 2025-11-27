@FE
Feature: Login Flow
  By providing valid email and password on Login page user is able to log in to Swag Labs application

  Scenario: User can log in with valid credentials
    Given User is on Home page
    And User enters valid email and password
    When User clicks on login button
    Then Logout button is displayed