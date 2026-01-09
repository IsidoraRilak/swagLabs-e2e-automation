package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSteps {

    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static WebDriver driver;
    private final CommonDataSteps commonDataSteps;

    public BaseSteps(CommonDataSteps commonDataSteps) {
        this.commonDataSteps = commonDataSteps;
    }

    @Before("@FE")
    public void setUpDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = WebDriverFactory.initializeWebDriver("chrome");
        driver.manage().window().maximize();
    }

    @After("@FE")
    public void stopDriver() {
        driver.quit();
    }

    @Given("User is on Login page")
    public void userIsOnLoginPage() {
        driver.navigate().to(BASE_URL);
    }

    @Then("Response status code is {int} {string}")
    public void responseStatusCodeIs(int responseStatusCode, String statusCodeMessage) {
        assertEquals(responseStatusCode, commonDataSteps.response.getStatusCode(),
                "Response status code is not: " + responseStatusCode + " " + statusCodeMessage);
    }

    @And("Response contains {string} error message")
    public void responseContainsErrorMessage(String errorMessage) {
        assertEquals(errorMessage, commonDataSteps.response.jsonPath().getString("message"),
                "Response error message is incorrect");
    }
}
