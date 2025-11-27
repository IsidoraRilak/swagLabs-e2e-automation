package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public final WebDriver webDriver;
    private WebDriverWait wait;

    private final By userNameInputField = By.id("user-name");
    private final By passwordInputField = By.id("password");
    private final By loginButton = By.cssSelector(".submit-button.btn_action");
    private final By logoutButton = By.xpath("//a[text()='Logout']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getUsernameInputField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInputField));
    }

    private WebElement getPasswordInputField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputField));
    }

    private WebElement getLoginButton() {
        return webDriver.findElement(loginButton);
    }

    private WebElement getLogoutButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    public void enterEmailAndPassword(String email, String password) {
        getUsernameInputField().clear();
        getPasswordInputField().clear();
        getUsernameInputField().sendKeys(email);
        getPasswordInputField().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public boolean isLogoutButtonDisplayed() {
        return getLogoutButton().isDisplayed();
    }
}
