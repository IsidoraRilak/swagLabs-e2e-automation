package configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    private final RequestSpecBuilder requestSpecBuilder;

    public RequestSpecificationBuilder() {
        this.requestSpecBuilder = new RequestSpecBuilder();
    }

    /**
     * Method for specifying base uri
     *
     * @param uri base uri
     * @return base uri
     */
    public RequestSpecificationBuilder setBaseUri(String uri) {
        requestSpecBuilder.setBaseUri(uri);
        return this;
    }

    /**
     * Method for specifying base path
     *
     * @param path base path
     * @return base path
     */
    public RequestSpecificationBuilder setBasePath(String path) {
        requestSpecBuilder.setBasePath(path);
        return this;
    }

    /**
     * Method for building request specification
     *
     * @return request specification
     */
    public RequestSpecification build() {
        return requestSpecBuilder.build();
    }

    /**
     * Method for specifying basic request specification
     *
     * @param path entity path
     * @return request specification
     */
    public RequestSpecification basicSpecBuilder(String path) {
        return new RequestSpecificationBuilder().setBaseUri(BASE_URI).setBasePath(path).build();
    }
}
