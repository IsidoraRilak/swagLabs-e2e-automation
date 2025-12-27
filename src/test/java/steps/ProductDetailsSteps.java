package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductDetailsSteps {

    HomePage homePage = new HomePage(BaseSteps.driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(BaseSteps.driver);

    @When("User clicks on first product name")
    public void userClicksOnFirstProductName() {
        homePage.clickOnFirstProductName();
    }

    @Then("Product details are displayed")
    public void productDetailsAreDisplayed() {
        assertAll(
                () -> assertTrue(productDetailsPage.isProductNameDisplayed(), "Product name is not displayed"),
                () -> assertTrue(productDetailsPage.isProductDescriptionDisplayed(), "Product description is not displayed"),
                () -> assertTrue(productDetailsPage.isProductPriceDisplayed(), "Product price is not displayed"),
                () -> assertTrue(productDetailsPage.isProductImageDisplayed(), "Product image is not displayed")
        );
    }

    @When("User clicks on add to cart button")
    public void userClicksOnAddToCartButton() {
        productDetailsPage.clickOnAddToCartButton();
    }

    @When("User clicks on back to products button")
    public void userClicksOnBackToProductsButton() {
        productDetailsPage.clickOnBackToProductsButton();
    }

    @Then("Home page is displayed")
    public void homePageIsDisplayed() {
        assertTrue(homePage.isHomePageDisplayed(), "Product page is not displayed");
    }
}
