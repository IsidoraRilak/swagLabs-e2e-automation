@FE
Feature: SEO Home page
  This feature file tests basic SEO elements on the Home page, including alt attributes and descriptive
  file names for product images.

  Scenario: Verify that all product images on Home page have alt attributes
    Given User is on Login page
    When User is logged in with valid credentials
    Then All product images have non-empty alt attributes

  Scenario: Verify product image filenames are SEO-friendly
    Given User is on Login page
    When User is logged in with valid credentials
    Then All product images have descriptive file names