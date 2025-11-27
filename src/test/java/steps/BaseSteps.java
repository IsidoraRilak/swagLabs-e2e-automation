package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class BaseSteps {

    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static WebDriver driver;

    @Before("@FE")
    public void setUpDriver (){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = WebDriverFactory.initializeWebDriver("chrome");
        driver.manage().window().maximize();
    }

    @After("@FE")
    public void stopDriver(){
        driver.quit();
    }

    @Given("User is on Home page")
    public void userIsOnHomePage(){
        driver.navigate().to(BASE_URL);
    }

}
