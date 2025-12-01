package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class SEOLoginPageSteps {

    LoginPage loginPage = new LoginPage(BaseSteps.driver);

    @Then("Login page has a title tag")
    public void loginPageHasATitleTag() {
        String title = loginPage.getTitleText();
        assertAll(
                () -> assertNotNull(title, "Title tag does not exist"),
                () -> assertFalse(title.isEmpty(), "Title tag is empty"),
                () -> assertEquals("Swag Labs", title, "Title tag text is incorrect")
        );
    }

    @And("Login page has a meta description")
    public void loginPageHasAMetaDescription() {
        String metaDescription = loginPage.getMetaDescriptionContent();
        assertAll(
                () -> assertNotNull(metaDescription, "Meta description does not exist"),
                () -> assertFalse(metaDescription.isEmpty(), "Meta description is empty")
        );
    }

    @Then("Login page has meta viewport tag with correct content")
    public void loginPageHasMetaViewportTagWithCorrectContent() {
        String content = loginPage.getViewportTagContent();
        assertAll(
                () -> assertNotNull(loginPage.getViewportTagContent(), "Login page does not have meta viewport tag"),
                () -> assertNotNull(content, "Meta viewport tag does not have content"),
                () -> assertTrue(content.contains("width=device-width"), "Meta viewport tag has incorrect content")
        );
    }
}
