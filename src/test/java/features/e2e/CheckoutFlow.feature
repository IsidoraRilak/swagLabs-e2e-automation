@FE
Feature: Checkout Flow
  This feature verifies that a user can successfully complete the checkout process and create an order

  Scenario: User can successfully create an order
    Given User is on Login page
    And User is logged in with valid credentials
    And User adds product to the cart
    And User clicks on cart icon
    And User clicks on checkout button
    And User fills in shipping information
    And User clicks on continue button
    When User clicks on finish button
    Then Order confirmation message is displayed