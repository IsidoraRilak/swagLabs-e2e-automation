package requests;

import dto.PetDTO;
import io.restassured.response.Response;

public class PetRequests extends BaseRequests {

    private static final String PET_PATH = "pet";
    private static final String FIND_BY_STATUS_PATH = "pet/findByStatus";

    public Response createPet(PetDTO petDTO) {
        return doPostRequest(PET_PATH, petDTO);
    }

    public Response getPetsByStatus(String statusValue) {
        return doGetRequestWithQueryParam(FIND_BY_STATUS_PATH, "status", statusValue);
    }

    public Response deletePet(Long id) {
        return doDeleteRequest(PET_PATH + "/" + id);
    }

    public Response getPetById(Long id) {
        return doGetRequest(PET_PATH + "/" + id);
    }

    public Response updatePet(PetDTO updatedPetDTO) {
        return doPutRequest(PET_PATH, updatedPetDTO);
    }
}
