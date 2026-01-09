package steps.e2e;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import steps.BaseSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserLoginFlowSteps {

    LoginPage loginPage = new LoginPage(BaseSteps.driver);
    HomePage homePage = new HomePage(BaseSteps.driver);

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("Logout button is displayed")
    public void logoutButtonIsDisplayed() {
        homePage.clickOnMenuIcon();
        assertTrue(homePage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }

    @And("^User enters (.*)$")
    public void userEnters(String credentials) {
        switch (credentials) {
            case "valid username and password":
                loginPage.enterUsername("standard_user");
                loginPage.enterPassword("secret_sauce");
                break;
            case "invalid username and valid password":
                loginPage.enterUsername("invalid@mail.com");
                loginPage.enterPassword("secret_sauce");
                break;
            case "valid username and invalid password":
                loginPage.enterUsername("standard_user");
                loginPage.enterPassword("invalidPassword");
                break;
            case "valid username":
                loginPage.enterUsername("standard_user");
                break;
            case "valid password":
                loginPage.enterPassword("secret_sauce");
                break;
        }
    }

    @And("^(.*) error message is displayed$")
    public void errorMessageIsDisplayed(String errorMessage) {
        assertTrue(loginPage.isErrorMessageDisplayed(errorMessage), errorMessage + " error message is not displayed");
    }

    @And("User is logged in with valid credentials")
    public void userIsLoggedInWithValidCredentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @When("User clicks on logout button")
    public void userClicksOnLogoutButton() {
        homePage.clickOnLogoutButton();
    }

    @Then("Login button is displayed")
    public void loginButtonIsDisplayed() {
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
    }
}
