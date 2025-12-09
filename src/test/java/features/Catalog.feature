@FE
Feature: Catalog
  This feature tests product sorting by alphabetical order and by price in the catalog.

  Scenario: Products can be sorted alphabetically from A to Z
    Given User is on Login page
    And User is logged in with valid credentials
    When User clicks on sorting dropdown menu
    And User selects "Name (A to Z)" from the sorting dropdown menu
    Then Products are sorted "alphabetically from A to Z"

  Scenario: Products can be sorted alphabetically from Z to A
    Given User is on Login page
    And User is logged in with valid credentials
    When User clicks on sorting dropdown menu
    And User selects "Name (Z to A)" from the sorting dropdown menu
    Then Products are sorted "alphabetically from Z to A"

  Scenario: Products can be sorted by price low to high
    Given User is on Login page
    And User is logged in with valid credentials
    When User clicks on sorting dropdown menu
    And User selects "Price (low to high)" from the sorting dropdown menu
    Then Products are sorted "by price low to high"

  Scenario: Products can be sorted by price high to low
    Given User is on Login page
    And User is logged in with valid credentials
    When User clicks on sorting dropdown menu
    And User selects "Price (high to low)" from the sorting dropdown menu
    Then Products are sorted "by price high to low"