package steps.api;

import dto.PetDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requests.PetRequests;
import steps.CommonDataSteps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PetApiSteps {

    private final PetRequests petRequests = new PetRequests();
    private PetDTO petDTO;
    private Response response;
    private CommonDataSteps commonDataSteps;
    private long nonExistingPetId = 999L;

    public PetApiSteps(CommonDataSteps commonDataSteps) {
        this.commonDataSteps = commonDataSteps;
    }

    @Given("Pet data is prepared")
    public void petDataIsPrepared() {
        petDTO = new PetDTO();
        petDTO.setName("doggie");
        petDTO.setStatus("available");
        petDTO.setPhotoUrls(List.of("string"));

        PetDTO.Category category = new PetDTO.Category();
        category.setId(0);
        category.setName("string");
        petDTO.setCategory(category);

        PetDTO.Tag tag = new PetDTO.Tag();
        tag.setId(0);
        tag.setName("string");
        petDTO.setTags(List.of(tag));
    }

    @When("POST request is sent to create a pet")
    public void postRequestIsSentToCreateAPet() {
        response = petRequests.createPet(petDTO);
        commonDataSteps.response = response;
        petDTO.setId(response.jsonPath().getLong("id"));
    }

    @And("Response contains pet information")
    public void responseContainsPetInformation() {
        assertAll(
                () -> assertEquals(petDTO.getName(), response.jsonPath().getString("name"),
                        "Response contains incorrect pet name"),
                () -> assertEquals(petDTO.getStatus(), response.jsonPath().getString("status"),
                        "Response contains incorrect status"),
                () -> assertEquals(petDTO.getCategory().getName(), response.jsonPath().getString("category.name"),
                        "Response contains incorrect category name"),
                () -> assertEquals(petDTO.getCategory().getId(), response.jsonPath().getInt("category.id"),
                        "Response contains incorrect category id"),
                () -> assertEquals(petDTO.getTags().get(0).getName(), response.jsonPath().getString("tags[0].name"),
                        "Response contains incorrect tag name"),
                () -> assertEquals(petDTO.getTags().get(0).getId(), response.jsonPath().getInt("tags[0].id"),
                        "Response contains incorrect tag id"),
                () -> assertEquals(petDTO.getPhotoUrls().get(0), response.jsonPath().getString("photoUrls[0]"),
                        "Response contains incorrect photo URL")
        );
    }

    @Given("GET request is sent to retrieve pets by status {string}")
    public void getRequestIsSentToRetrievePetsByStatus(String status) {
        response = petRequests.getPetsByStatus(status);
        commonDataSteps.response = response;
    }

    @And("Response contains pets with status {string}")
    public void responseContainsPetsWithStatus(String status) {
        List<String> statuses = response.jsonPath().getList("status");

        assertFalse(statuses.isEmpty(), "Response should not be empty");

        statuses.forEach(petStatus ->
                assertEquals(status, petStatus, "Pet has incorrect status")
        );
    }

    @When("DELETE request is sent to delete the pet")
    public void deleteRequestIsSentToDeleteThePet() {
        response = petRequests.deletePet(petDTO.getId());
        commonDataSteps.response = response;
    }

    @And("GET request is sent to retrieve pet information")
    public void getRequestIsSentToRetrievePetInformation() {
        response = petRequests.getPetById(petDTO.getId());
        commonDataSteps.response = response;
    }

    @When("DELETE request is sent to delete non-existing pet")
    public void deleteRequestIsSentToDeleteNonExistingPet() {
        response = petRequests.deletePet(nonExistingPetId);
        commonDataSteps.response = response;
    }

    @When("GET request is sent to retrieve the pet by non-existing id")
    public void getRequestIsSentToRetrieveThePetByNonExistingId() {
        response = petRequests.getPetById(nonExistingPetId);
        commonDataSteps.response = response;
    }
}
