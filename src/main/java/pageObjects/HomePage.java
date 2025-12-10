package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class HomePage {

    public final WebDriver webDriver;
    private WebDriverWait wait;

    private final By logoutButton = By.xpath("//a[text()='Logout']");
    private final By menuIcon = By.cssSelector("#react-burger-menu-btn");
    private final By addToCartButton = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private final By cartIcon = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By productImages = By.cssSelector("img.inventory_item_img");
    private final By sortingDropdownMenu = By.cssSelector(".select_container");
    private final By productName = By.className("inventory_item_name");
    private final By productPrice = By.cssSelector(".inventory_item_price");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private By sortingOption(String sortingCriteria) {
        return By.xpath("//option[text()='" + sortingCriteria + "']");
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

    private List<WebElement> getProductImages() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productImages));
        return webDriver.findElements(productImages);
    }

    private WebElement getCartIcon() {
        return webDriver.findElement(cartIcon);
    }

    private WebElement getSortingDropdownMenu() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sortingDropdownMenu));
    }

    private WebElement getSortingOption(String sortingCriteria) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sortingOption(sortingCriteria)));
    }

    private List<WebElement> getProductNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return webDriver.findElements(productName);
    }

    private List<WebElement> getProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        return webDriver.findElements(productPrice);
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

    public boolean allProductImagesHaveAltAttribute() {
        for (WebElement image : getProductImages()) {
            String altText = image.getAttribute("alt");
            if (altText == null || altText.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean allProductImagesHaveDescriptiveFileNames() {
        for (WebElement image : getProductImages()) {
            String srcText = image.getAttribute("src");
            if (srcText == null || !srcText.contains(".jpg")) {
                return false;
            }
        }
        return true;
    }

    public void clickOnSortingDropdownMenu() {
        getSortingDropdownMenu().click();
    }

    public void selectSortingOption(String sortingCriteria) {
        getSortingOption(sortingCriteria).click();
    }

    public List<String> getProductNamesText() {
        List<String> productNames = new LinkedList<>();
        for (WebElement productName : getProductNames()) {
            productNames.add(productName.getText());
        }
        return productNames;
    }

    public List<Double> getProductPricesText() {
        List<Double> productPrices = new LinkedList<>();
        for (WebElement productPrice : getProductPrice()) {
            productPrices.add(Double.parseDouble(productPrice.getText().replace("$", "")));
        }
        return productPrices;
    }

    public void clickOnFirstProductName() {
        getProductNames().getFirst().click();
    }
}
