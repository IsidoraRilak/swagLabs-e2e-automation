package steps;

import io.cucumber.java.en.Then;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SEOHomePageSteps {
    HomePage homePage = new HomePage(BaseSteps.driver);

    @Then("All product images have non-empty alt attributes")
    public void allProductImagesHaveNonEmptyAltAttributes() {
        assertTrue(homePage.allProductImagesHaveAltAttribute(), "At least one product image does not have a non-empty alt attribute");
    }

    @Then("All product images have descriptive file names")
    public void allProductImagesHaveDescriptiveFileNames() {
        assertTrue(homePage.allProductImagesHaveDescriptiveFileNames(),
                "At least one product image has a non-descriptive file name");
    }
}
