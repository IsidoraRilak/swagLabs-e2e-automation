package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CatalogSteps {

    HomePage homePage = new HomePage(BaseSteps.driver);

    @When("User clicks on sorting dropdown menu")
    public void userClicksOnSortingDropdownMenu() {
        homePage.clickOnSortingDropdownMenu();
    }

    @And("User selects {string} from the sorting dropdown menu")
    public void userSelectsFromTheSortingDropdownMenu(String sortingCriteria) {
        homePage.selectSortingOption(sortingCriteria);
    }

    @Then("Products are sorted {string}")
    public void productsAreSorted(String sortingCriteria) {
        List<String> productNames = homePage.getProductNamesText();
        List<String> sortedProductNames = new LinkedList<>();
        List<Double> productPrices = homePage.getProductPricesText();
        List<Double> sortedProductPrices = new LinkedList<>();
        switch (sortingCriteria) {
            case "alphabetically from A to Z":
                sortedProductNames = productNames.stream().sorted().toList();
                assertEquals(sortedProductNames, productNames, "Products are not sorted " + sortingCriteria);
                break;
            case "alphabetically from Z to A":
                sortedProductNames = productNames.stream().sorted(Comparator.reverseOrder()).toList();
                assertEquals(sortedProductNames, productNames, "Products are not sorted " + sortingCriteria);
                break;
            case "by price low to high":
                sortedProductPrices = productPrices.stream().sorted().toList();
                assertEquals(sortedProductPrices, productPrices, "Products are not sorted " + sortingCriteria);
                break;
            case "by price high to low":
                sortedProductPrices = productPrices.stream().sorted(Comparator.reverseOrder()).toList();
                assertEquals(sortedProductPrices, productPrices, "Products are not sorted " + sortingCriteria);
                break;
        }
    }
}
