@BE
Feature: Pet tests

  Scenario: Pet can be created
    Given Pet data is prepared
    When POST request is sent to create a pet
    Then Response status code is 200 "OK"
    And Response contains pet information

  Scenario Outline: Pets can be retrieved by status
    Given GET request is sent to retrieve pets by status "<status>"
    Then Response status code is 200 "OK"
    And Response contains pets with status "<status>"
    Examples:
      | status    |
      | sold      |
      | available |
      | pending   |