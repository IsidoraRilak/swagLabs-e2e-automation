package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import dto.UserDTO;
import requests.UserRequests;
import steps.CommonDataSteps;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UserApiSteps {
    private final UserRequests userRequests = new UserRequests();
    private UserDTO userDTO;
    private UserDTO updatedUserDTO;
    private Response response;
    private CommonDataSteps commonDataSteps;
    private String nonExistingUsername = "username" + randomAlphabetic(5);

    public UserApiSteps(CommonDataSteps commonDataSteps) {
        this.commonDataSteps = commonDataSteps;
    }

    @When("GET request is sent to retrieve user information")
    public void getRequestIsSentToRetrieveUserInformation() {
        response = userRequests.getUser(userDTO.getUsername());
        commonDataSteps.response = response;
    }

    @And("Response contains user information")
    public void responseContainsUserInformation() {
        assertAll(
                () -> assertEquals(userDTO.getUsername(), response.jsonPath().getString("username"),
                        "Response contains incorrect username"),
                () -> assertEquals(userDTO.getEmail(), response.jsonPath().getString("email"),
                        "Response contains incorrect email"),
                () -> assertEquals(userDTO.getFirstName(), response.jsonPath().getString("firstName"),
                        "Response contains incorrect first name"),
                () -> assertEquals(userDTO.getLastName(), response.jsonPath().getString("lastName"),
                        "Response contains incorrect last name"),
                () -> assertEquals(userDTO.getId(), response.jsonPath().getInt("id"),
                        "Response contains incorrect user id")
        );
    }

    @When("POST request is sent to create new user")
    public void postRequestIsSentToCreateNewUser() {
        response = userRequests.createUser(userDTO);
        commonDataSteps.response = response;
    }

    @Given("User data is prepared")
    public void userDataIsPrepared() {
        userDTO = new UserDTO();
        userDTO.setUsername("testUserName");
        userDTO.setEmail("test@mail.com");
        userDTO.setId(5);
        userDTO.setUserStatus(1);
        userDTO.setPhone("21357");
        userDTO.setFirstName("testName");
        userDTO.setLastName("testLastName");
    }

    @When("GET request is sent to retrieve user information for non-existing user")
    public void getRequestIsSentToRetrieveUserInformationForNonExistingUser() {
        response = userRequests.getUser(nonExistingUsername);
        commonDataSteps.response = response;
    }

    @When("Delete user request is sent")
    public void deleteUserRequestIsSent() {
        response = userRequests.deleteUser(userDTO.getUsername());
        commonDataSteps.response = response;
    }

    @When("PUT request is sent to update the user")
    public void putRequestIsSentToUpdateTheUser() {
        updatedUserDTO = new UserDTO();
        updatedUserDTO.setId(userDTO.getId());
        updatedUserDTO.setUsername(userDTO.getUsername());
        updatedUserDTO.setFirstName("newFirstName");
        updatedUserDTO.setLastName("newLastName");
        updatedUserDTO.setEmail("new@mail.com");
        updatedUserDTO.setPhone("999999");
        updatedUserDTO.setUserStatus(1);

        response = userRequests.updateUser(updatedUserDTO, userDTO.getUsername());
        commonDataSteps.response = response;
    }

    @And("Response contains updated user information")
    public void responseContainsUpdatedUserInformation() {
        assertAll(
                () -> assertEquals(updatedUserDTO.getEmail(), response.jsonPath().getString("email"),
                        "Email is not updated"),
                () -> assertEquals(updatedUserDTO.getFirstName(), response.jsonPath().getString("firstName"),
                        "First name is not updated"),
                () -> assertEquals(updatedUserDTO.getLastName(), response.jsonPath().getString("lastName"),
                        "Last name is not updated")
        );
    }

    @When("DELETE request is sent to delete non-existing user")
    public void deleteRequestIsSentToDeleteNonExistingUser() {
        response = userRequests.deleteUser(nonExistingUsername);
        commonDataSteps.response = response;
    }
}
