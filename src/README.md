# Swag Labs e2e automation tests project

### Description
This project contains FE oriented automation tests for Swag Labs application using Selenium WebDriver,
Java and BDD tool - [Cucumber](https://cucumber.io/).
The tests cover both functional flows and SEO-related checks on key pages of the application.

### Structure of the project
 * src/main/java/pageObjects package contains page objects of each page in application
 * src/main/java/utilities package contains helper classes
 * src/test/java/features package contains feature files
 * src/test/java/steps package contains step definitions for feature files

As build tool [Maven](https://maven.apache.org/) is used.

### Test running
###### In console use commands:
* Run all tests `mvn test`