# Swag Labs e2e automation tests project

### Description
This project contains end-to-end (E2E) automated tests for the SwagLabs web application and API tests for
the Petstore demo application. It is built using Java, Selenium WebDriver, REST Assured and BDD tool - [Cucumber](https://cucumber.io/).
The tests cover critical functional workflows, SEO checks and API tests

### Structure of the project
 * src/main/java/pageObjects package contains page objects of each page in application
 * src/main/java/utilities package contains helper classes
 * src/main/java/configurations package contains configuration classes
 * src/main/java/dto package contains DTO classes
 * src/main/java/requests package contains Base and resource-specific request classes
 * src/test/java/features package contains feature files
 * src/test/java/steps package contains step definitions for feature files

As build tool [Maven](https://maven.apache.org/) is used.

### Test running
###### In console use commands:
* Run all tests `mvn test`