package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserLoginFlowSteps {

    LoginPage loginPage = new LoginPage(BaseSteps.driver);
    HomePage homePage = new HomePage(BaseSteps.driver);

    @And("User enters valid email and password")
    public void userEntersValidEmailAndPassword() {
        loginPage.enterEmailAndPassword("standard_user", "secret_sauce");
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();

    }

    @Then("Logout button is displayed")
    public void logoutButtonIsDisplayed() {        homePage.clickOnMenuIcon();
        assertTrue(loginPage.isLogoutButtonDisplayed(),"Logout button is not displayed");
    }
}
