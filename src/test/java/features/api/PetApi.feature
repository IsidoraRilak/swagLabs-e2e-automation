@BE
Feature: Pet tests
  This feature tests pet management endpoints. It includes scenarios for creating, retrieving and deleting pets,
  as well as handling negative cases with non-existing pets, ensuring correct responses and status codes.

  @DeletePetAfterTestExecution
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

  Scenario: Created pet can be deleted
    Given Pet data is prepared
    And POST request is sent to create a pet
    And Response status code is 200 "OK"
    When DELETE request is sent to delete the pet
    Then Response status code is 200 "OK"
    And GET request is sent to retrieve pet information
    And Response status code is 404 "Not Found"

  Scenario: Non-existing pet cannot be deleted
    When DELETE request is sent to delete non-existing pet
    Then Response status code is 404 "Not found"

  @DeletePetAfterTestExecution
  Scenario: Pet can be retrieved by id
    Given Pet data is prepared
    And POST request is sent to create a pet
    And Response status code is 200 "OK"
    When GET request is sent to retrieve pet information
    Then Response status code is 200 "OK"
    And Response contains pet information

  Scenario: Non-existing pet cannot be retrieved
    When GET request is sent to retrieve the pet by non-existing id
    Then Response status code is 404 "Not Found"

  @DeletePetAfterTestExecution
  Scenario: Existing pet can be updated
    Given Pet data is prepared
    And POST request is sent to create a pet
    And Response status code is 200 "OK"
    When PUT request is sent to update the pet
    Then Response status code is 200 "OK"
    And GET request is sent to retrieve pet information
    And Response contains updated pet information