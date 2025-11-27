package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public final WebDriver webDriver;
    private WebDriverWait wait;

    private final By menuIcon = By.cssSelector("#react-burger-menu-btn");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getMenuIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(menuIcon));
    }

    public void clickOnMenuIcon() {
        getMenuIcon().click();
    }
}
