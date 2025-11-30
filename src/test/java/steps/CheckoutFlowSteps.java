package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutFlowSteps {

    HomePage homePage = new HomePage(BaseSteps.driver);
    CheckoutPage checkoutPage = new CheckoutPage(BaseSteps.driver);

    @And("User adds product to the cart")
    public void userAddsProductToTheCart() {
        homePage.addProductToCart();
    }

    @And("User clicks on cart icon")
    public void userClicksOnCartIcon() {
        homePage.clickOnCartIcon();
    }

    @And("User clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        checkoutPage.clickOnCheckoutButton();
    }

    @And("User fills in shipping information")
    public void userFillsInShippingInformation() {
        checkoutPage.enterFirstName("TestName");
        checkoutPage.enterLastName("TestLastName");
        checkoutPage.enterZipCode("11000");
    }

    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        checkoutPage.clickOnContinueButton();
    }

    @When("User clicks on finish button")
    public void userClicksOnFinishButton() {
        checkoutPage.clickOnFinishButton();
    }

    @Then("Order confirmation message is displayed")
    public void orderConfirmationMessageIsDisplayed() {
        assertAll(
                () -> assertTrue(checkoutPage.isOrderConfirmationMessageDisplayed(), "Order confirmation message is not displayed"),
                () -> assertTrue(checkoutPage.isCheckoutCompleteLabelDisplayed(), "Checkout complete label is not displayed")
        );
    }
}
