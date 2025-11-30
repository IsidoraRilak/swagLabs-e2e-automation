package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    public final WebDriver webDriver;
    private WebDriverWait wait;

    private final By checkoutButton = By.id("checkout");
    private final By firstNameInputField = By.id("first-name");
    private final By lastNameInputField = By.id("last-name");
    private final By zipCodeInputField = By.id("postal-code");
    private final By continueButton = By.xpath("//input[@type='submit']");
    private final By finishButton = By.xpath("//button[@name='finish']");
    private final By orderConfirmationMessage = By.xpath("//h2[text()='Thank you for your order!']");

    public CheckoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getCheckoutButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }

    private WebElement getFirstNameInputField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInputField));
    }

    private WebElement getLastNameInputField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInputField));
    }

    private WebElement getZipCodeInputField() {
        return webDriver.findElement(zipCodeInputField);
    }

    private WebElement getContinueButton() {
        return webDriver.findElement(continueButton);
    }

    private WebElement getFinishButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(finishButton));
    }

    private WebElement getOrderConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage));
    }

    public void clickOnCheckoutButton() {
        getCheckoutButton().click();
    }

    public void enterFirstName(String firstName) {
        getFirstNameInputField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameInputField().sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        getZipCodeInputField().sendKeys(zipCode);
    }

    public void clickOnContinueButton() {
        getContinueButton().click();
    }

    public void clickOnFinishButton() {
        getFinishButton().click();
    }

    public boolean isOrderConfirmationMessageDisplayed() {
        return getOrderConfirmationMessage().isDisplayed();
    }
}
