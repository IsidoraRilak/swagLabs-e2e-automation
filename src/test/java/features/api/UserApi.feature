@BE
Feature: User tests
  This feature tests user management endpoints in the Petstore API
  It covers creating, retrieving, updating, and deleting users, as well as negative scenarios
  for non-existing users to ensure the API responds correctly with proper status codes and messages

  Scenario: User can be created
    Given User data is prepared
    And POST request is sent to create new user
    And Response status code is 200 "OK"
    When GET request is sent to retrieve user information
    Then Response contains user information

  Scenario: Non-existing user cannot be retrieved
    When GET request is sent to retrieve user information for non-existing user
    Then Response status code is 404 "Not found"
    And Response contains "User not found" error message

  Scenario: Created user can be deleted
    Given User data is prepared
    And POST request is sent to create new user
    And Response status code is 200 "OK"
    When Delete user request is sent
    Then Response status code is 200 "OK"
    And GET request is sent to retrieve user information
    And Response status code is 404 "Not found"

  Scenario: Non-existing user cannot be deleted
    When DELETE request is sent to delete non-existing user
    Then Response status code is 404 "Not found"

  Scenario: User can be updated
    Given User data is prepared
    And POST request is sent to create new user
    And Response status code is 200 "OK"
    When PUT request is sent to update the user
    Then Response status code is 200 "OK"
    And GET request is sent to retrieve user information
    And Response contains updated user information