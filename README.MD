Selenium Automation Framework
1. Project Overview
This project is a Selenium WebDriver automation framework developed using Java, TestNG and Maven.
The framework automates functional scenarios for the SauceDemo application and follows the Page Object Model (POM) design pattern.
The framework is designed with reusable components, configuration management, test-data management, logging, screenshot capture and CI/CD integration using GitHub Actions.

2. Technology Stack
Java 17 
Selenium WebDriver 4.35.0 
TestNG 7.11.0 
Maven 
Apache POI 
Log4j2 
Extent Reports 
Git & GitHub 
GitHub Actions 








3. Framework Structure
saucedemo-automation
├── .github
│   └── workflows
│       └── maven-test.yml
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── Baseclass.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │   ├── Login.java
│   │   │   │   └── Products.java
│   │   │   │
│   │   │   └── utils
│   │   │       ├── Configreader.java
│   │   │       ├── Excelreader.java
│   │   │       ├── Testlistener.java
│   │   │       └── Waitutils.java
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       ├── java
│       │   └── test
│       │       ├── Logintest.java
│       │       └── productstest.java
│       │
│       └── resources
│           ├── log4j2.xml
│           └── test data.xlsx
│
├── pom.xml
├── testng.xml
└── testing regression.xml

4. Framework Architecture
The framework follows the Page Object Model design pattern.
Execution flow:
Test Class → Page Object Class → Base Class / Utilities → Selenium WebDriver → SauceDemo Application
Baseclass
The Baseclass is responsible for:
WebDriver initialization 
Browser configuration 
Environment configuration 
Headless execution 
Opening the application URL 
Common browser setup 
Page Classes
The framework contains:
Login.java 
Products.java 
Page classes contain locators and reusable page-level actions.
Utility Classes
Configreader.java – Reads configuration values 
Excelreader.java – Reads test data from Excel 
Waitutils.java – Handles explicit waits 
Testlistener.java – Handles test execution events and failure screenshots 
Test Classes
Logintest.java 
productstest.java 

5. Page Object Model
The framework uses Page Object Model to separate page locators and page actions from test logic.
Login Page
The Login page contains reusable methods for:
Entering username 
Entering password 
Clicking Login 
Validating login error messages 
Products Page
The Products page contains reusable methods for:
Validating Products page 
Selecting a product 
Reading product price 
Adding product to cart 
Opening cart 
Validating product in cart 
Validating cart price 
Returning to the Products page 
Opening menu 
Logging out 
Validating the Add to Cart button state 
This improves maintainability because page locator changes can be handled within the respective Page Object.

6. Reusable Components and Utilities
Waitutils
Explicit waits are implemented using Waitutils.
The framework uses waits for conditions such as:
Element visibility 
Element clickability 
Hard-coded waits are avoided wherever possible.
Configreader
Configuration values are maintained in:
src/test/resources/config.properties
Excelreader
Test data is maintained in:
src/test/resources/test data.xlsx
The Excelreader utility reads username and password values used by the login tests.
Testlistener
The TestNG listener is used for test execution handling and screenshot capture when a test fails.

7. Configuration Management
Configuration is maintained in:
src/test/resources/config.properties
Example:
browser=chrome
qa.url=https://www.saucedemo.com/
headless=false
The framework also supports overriding configuration values from the command line.
Example:
mvn clean test -Dgroups=regression -Dbrowser=firefox -Dheadless=true
This allows the same framework to be executed with different browser and execution configurations without changing the source code.

8. Browser Configuration
The framework supports:
Chrome 
Firefox 
Browser selection is controlled through configuration.
Example:
browser=chrome
For Firefox:
mvn clean test -Dgroups=regression -Dbrowser=firefox -Dheadless=true

9. Headless Execution
The framework supports headless execution for CI/CD environments.
Chrome uses ChromeOptions for headless execution.
Firefox uses FirefoxOptions for headless execution.
Example:
mvn clean test -Dgroups=smoke -Dheadless=true

10. Test Data Management
Login test data is maintained separately in:
src/test/resources/test data.xlsx
The Excelreader utility is used to read the required test data.
The login scenarios include:
Valid username and password 
Invalid username 
Missing password 
Missing username 
This approach keeps test data separate from the test implementation.

11. Test Scenarios Covered
Login Scenarios
Successful login with valid credentials 
Login with invalid credentials 
Validation of login error message 
Missing password validation 
Missing username validation 
Product / Business Flow
Login with valid credentials 
Validate Products page 
Select a product 
Capture product price 
Add product to cart 
Navigate to cart 
Validate product is present in cart 
Validate product price 
Return to Products page 
Validate selected product no longer displays Add to Cart 
Validate product remains added to cart 
1.Logout 
2.Validate user is redirected to the login page 

12. TestNG Groups
TestNG groups are used to categorize test cases.
Smoke
Smoke tests are used for important functionality that needs to be validated quickly.
Example:
@Test(groups = {"smoke"})
Regression
Regression tests cover the broader functional flow.
Example:
@Test(groups = {"regression"})
A test can also belong to both groups:
@Test(groups = {"smoke", "regression"})

13. Test Execution
Run Smoke Tests
mvn clean test -Dgroups=smoke
Run Regression Tests
mvn clean test -Dgroups=regression
Run Regression in Headless Mode
mvn clean test -Dgroups=regression -Dheadless=true
Run Smoke in Headless Mode
mvn clean test -Dgroups=smoke -Dheadless=true
Run Regression on Firefox
mvn clean test -Dgroups=regression -Dbrowser=firefox -Dheadless=true
Run Smoke on Chrome
mvn clean test -Dgroups=smoke -Dbrowser=chrome -Dheadless=true

14. Individual Test Execution
Individual tests can be executed from the IDE using TestNG.
For example:
Right-click Logintest.java 
Select Run As 
Select TestNG Test 
The same approach can be used for productstest.java.

15. Complete Test Suite Execution
The complete TestNG suite is configured in:
testng.xml
The complete suite can be executed using:
mvn clean test
The Maven Surefire plugin is configured to execute the TestNG suite.

16. Assertions and Validations
TestNG assertions are used to validate expected application behaviour.
Examples include:
Product page is displayed 
Login error message is displayed 
Product is added to cart 
Product price matches the selected product price 
User is redirected to the Products page 
Add to Cart button is not displayed for the selected product after it has been added 
User is successfully logged out 
Example:
Assert.assertTrue(p.istitledisplayed(), "Product page is not displayed");

17. Wait Strategy
The framework uses explicit waits through:
Waitutils.java
Examples include waiting for:
Element visibility 
Element clickability 
This reduces synchronization issues and avoids unnecessary hard-coded waits.

18. Logging
Log4j2 is used for logging.
The framework logs important execution information such as:
Test data being executed 
Login success 
Login failure validation 
Product selection 
Product price validation 
Cart validation 
Logout validation 
Example log messages:
Testing row: 2
login error displayed
login successful - product is displayed
Product added to the cart
Product price is validated successfully
user successfully loggedout
Logging helps in debugging and understanding test execution.

19. Screenshot Capture
The TestNG listener captures screenshots when a test fails.
Screenshots are stored in:
Screenshot/
The screenshot name includes the execution date and time to help identify the failure.

20. Error and Exception Handling
The framework uses assertions to identify functional failures and TestNG listener handling for failure-related actions such as screenshot capture.
Configuration also validates unsupported browser values.
For example, an unsupported browser results in an exception indicating that the browser is not supported.

21. Test Reporting
Maven Surefire generates test execution reports under:
target/surefire-reports
The report provides execution information including:
Number of tests executed 
Passed tests 
Failed tests 
Skipped tests 
Failure details 
Extent Reports are also included in the framework for HTML-based reporting.

22. CI/CD - GitHub Actions
GitHub Actions is used to execute the automation framework in a CI/CD environment.
The workflow is located at:
.github/workflows/maven-test.yml
The CI/CD process performs the following steps:
Checkout the source code 
Set up Java 17 
Configure Maven caching 
Execute Selenium tests 
Run tests in headless mode 
Upload test reports as artifacts 

23. CI/CD Test Execution
The pipeline can execute the required TestNG group.
For Smoke:
mvn clean test -Dgroups=smoke -Dheadless=true
For Regression:
mvn clean test -Dgroups=regression -Dheadless=true
The test group can therefore be selected through the Maven command used in the GitHub Actions workflow.

24. CI/CD Triggers
The GitHub Actions workflow is configured to execute on:
Push to the master branch 
Pull request to the master branch 
Manual workflow execution 
Test reports can be uploaded as GitHub Actions artifacts for later review.

25. Assumptions
SauceDemo is used as the publicly available demo application. 
Test credentials are used for automation purposes. 
Test data is maintained in an Excel file. 
Chrome and Firefox are supported browsers. 
CI/CD execution uses headless browser mode. 
The framework is currently configured for the QA environment. 
Internet access is required to access the SauceDemo application. 

26. Known Limitations
The current framework covers the defined SauceDemo scenarios and is not intended to cover every application feature. 
Test data is currently maintained using Excel. 
The current browser support is Chrome and Firefox. 
CI/CD execution is currently configured using GitHub Actions. 
The framework can be further enhanced with parallel execution, additional page objects, additional test data sources and expanded automation coverage. 

27. Repository
GitHub Repository:
https://github.com/Sathishkumar121295/Selenium-automation-assessment

28. Author
Sathish Kumar
