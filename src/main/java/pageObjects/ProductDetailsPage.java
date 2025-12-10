package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {

    public final WebDriver webDriver;
    private WebDriverWait wait;

    private final By productName = By.cssSelector("[data-test='inventory-item-name']");
    private final By productDescription = By.cssSelector("[data-test='inventory-item-desc']");
    private final By productPrice = By.xpath("//div[@class='inventory_details_price']");
    private final By productImage = By.className("inventory_details_img");

    public ProductDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
    }

    private WebElement getProductDescription() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription));
    }

    private WebElement getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
    }

    private WebElement getProductImage() {
        return webDriver.findElement(productImage);
    }

    public boolean isProductNameDisplayed() {
        return getProductName().isDisplayed();
    }

    public boolean isProductDescriptionDisplayed() {
        return getProductDescription().isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return getProductPrice().isDisplayed();
    }

    public boolean isProductImageDisplayed() {
        return getProductImage().isDisplayed();
    }
}
