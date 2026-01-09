@FE
Feature: Product details
  This feature tests product details page behavior, including displaying product information, navigation back to
  the home page and adding and removing products from the cart.

  Background: User is logged in to Swag Labs application
    Given User is on Login page
    And User is logged in with valid credentials

  Scenario: Product details are displayed when user opens the product
    When User clicks on first product name
    Then Product details are displayed

  Scenario: User can navigate back to home page from product details page
    And User clicks on first product name
    And Product details are displayed
    When User clicks on back to products button
    Then Home page is displayed

  Scenario: Product can be added to the cart from the product details page
    And User clicks on first product name
    And Product details are displayed
    When User clicks on add to cart button
    Then Product is added to cart

  Scenario: User can remove product from the cart from the product details page
    And User clicks on first product name
    And Product details are displayed
    And User clicks on add to cart button
    And Product is added to cart
    When User clicks on remove button
    Then Product is removed from cart