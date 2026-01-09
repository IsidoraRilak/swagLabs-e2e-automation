package requests;

import configuration.RequestSpecificationBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseRequests {

    private final RequestSpecificationBuilder requestSpecBuilder = new RequestSpecificationBuilder();
    private Response response;

    public Response doGetRequest(String entityPath) {
        response = given()
                .spec(requestSpecBuilder.basicSpecBuilder(entityPath))
                .get();
        return response;
    }

    public Response doPostRequest(String entityPath, Object object) {
        response = given()
                .spec(requestSpecBuilder.basicSpecBuilder(entityPath))
                .contentType(ContentType.JSON)
                .body(object)
                .post();
        return response;
    }

    public Response doDeleteRequest(String entityPath) {
        response = given()
                .spec(requestSpecBuilder.basicSpecBuilder(entityPath))
                .delete();
        return response;
    }

    public Response doPutRequest(String entityPath, Object object) {
        response = given()
                .spec(requestSpecBuilder.basicSpecBuilder(entityPath))
                .contentType(ContentType.JSON)
                .body(object)
                .put();
        return response;
    }
}
