@FE
Feature: SEO Login page
  This feature file tests basic SEO elements on the Login page, including verification of the page title,
  meta description, and mobile responsiveness.

  Scenario: Verify title and meta description on the Login page
    When User is on Login page
    Then Login page has a title tag
    And Login page has a meta description

  Scenario: Verify viewport meta tag on the Login page
    When User is on Login page
    Then Login page has meta viewport tag with correct content