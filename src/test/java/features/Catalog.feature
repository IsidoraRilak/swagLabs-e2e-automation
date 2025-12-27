@FE
Feature: Catalog
  This feature tests product sorting by alphabetical order and by price in the catalog, adding a product to the cart
  from product details page and navigation from product details page to the home page

  Background: User is logged in to Swag Labs application
    Given User is on Login page
    And User is logged in with valid credentials

  Scenario: Products can be sorted alphabetically from A to Z
    When User clicks on sorting dropdown menu
    And User selects "Name (A to Z)" from the sorting dropdown menu
    Then Products are sorted "alphabetically from A to Z"

  Scenario: Products can be sorted alphabetically from Z to A
    When User clicks on sorting dropdown menu
    And User selects "Name (Z to A)" from the sorting dropdown menu
    Then Products are sorted "alphabetically from Z to A"

  Scenario: Products can be sorted by price low to high
    When User clicks on sorting dropdown menu
    And User selects "Price (low to high)" from the sorting dropdown menu
    Then Products are sorted "by price low to high"

  Scenario: Products can be sorted by price high to low
    When User clicks on sorting dropdown menu
    And User selects "Price (high to low)" from the sorting dropdown menu
    Then Products are sorted "by price high to low"

  Scenario: Product details are displayed when user opens the product
    When User clicks on first product name
    Then Product details are displayed

  Scenario: Product can be added to the cart from the product details page
    And User clicks on first product name
    And Product details are displayed
    When User clicks on add to cart button
    Then Product is added to cart

  Scenario: User can navigate back to home page from product details page
    And User clicks on first product name
    And Product details are displayed
    When User clicks on back to products button
    Then Home page is displayed

  Scenario: User can remove product from the cart from the product details page
    And User clicks on first product name
    And Product details are displayed
    And User clicks on add to cart button
    And Product is added to cart
    When User clicks on remove button
    Then Product is removed from cart

  Scenario: User can remove product from the cart from the home page
    And User adds product to the cart
    And Product is added to cart
    When User clicks on remove button
    Then Product is removed from cart