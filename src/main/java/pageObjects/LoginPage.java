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

    private final By usernameInputField = By.id("user-name");
    private final By passwordInputField = By.id("password");
    private final By loginButton = By.cssSelector(".submit-button.btn_action");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getUsernameInputField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputField));
    }

    private WebElement getPasswordInputField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputField));
    }

    private WebElement getLoginButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    private WebElement getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        String actualText = getErrorMessage().getText();
        return actualText.contains(errorMessage);
    }

    public void enterUsername(String username) {
        getUsernameInputField().clear();
        getUsernameInputField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(password);
    }

    public boolean isLoginButtonDisplayed() {
        return getLoginButton().isDisplayed();
    }
}
