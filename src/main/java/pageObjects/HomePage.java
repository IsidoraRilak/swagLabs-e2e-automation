package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    public final WebDriver webDriver;
    private WebDriverWait wait;

    private final By logoutButton = By.xpath("//a[text()='Logout']");
    private final By menuIcon = By.cssSelector("#react-burger-menu-btn");
    private final By addToCartButton = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private final By cartIcon = By.xpath("//a[@data-test='shopping-cart-link']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getLogoutButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    }

    private WebElement getMenuIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(menuIcon));
    }

    private List<WebElement> getAddToCartButtons() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        return webDriver.findElements(addToCartButton);
    }

    private WebElement getCartIcon() {
        return webDriver.findElement(cartIcon);
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public boolean isLogoutButtonDisplayed() {
        return getLogoutButton().isDisplayed();
    }

    public void clickOnMenuIcon() {
        getMenuIcon().click();
    }

    public void addProductToCart() {
        getAddToCartButtons().getFirst().click();
    }

    public void clickOnCartIcon() {
        getCartIcon().click();
    }
}
