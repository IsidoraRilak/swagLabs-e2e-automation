package requests;

import dto.UserDTO;
import io.restassured.response.Response;

public class UserRequests extends BaseRequests {

    private static final String USER_PATH = "user";

    public Response getUser(String username) {
        return doGetRequest(USER_PATH + "/" + username);
    }

    public Response createUser(UserDTO userDTO) {
        return doPostRequest(USER_PATH, userDTO);
    }

    public Response deleteUser(String username) {
        return doDeleteRequest(USER_PATH + "/" + username);
    }

    public Response updateUser(UserDTO updatedUserDTO, String username) {
        return doPutRequest(USER_PATH + "/" + username, updatedUserDTO);
    }
}
