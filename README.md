# Hybrid Test Automation Framework
## Overview
This repository contains a hybrid test automation framework built using Selenium, TestNG, Maven, and Java. The framework is designed to facilitate automated testing of web applications, offering a robust and scalable solution for test automation.

## Framework Architecture
![image](https://github.com/user-attachments/assets/071ef836-a6d2-4117-a8b6-e892ff2a1fbf)

## Features
- **Selenium**: For browser automation and interaction with web elements.
- **TestNG**: For managing test cases, running tests in parallel, and reporting.
- **Maven**: For project management and build automation.
- **Java**: For writing test scripts and framework logic.
- **Page Factory Design Pattern**: For creating reusable page classes.
- **Data-Driven Testing**: Utilizing JSON files to drive test data.
- **Parallel Test Execution**: Running tests concurrently to reduce execution time.
-**Singleton Design Pattern**: Single Instance is created for driver and report and used throughout the test execution.
-**Extent Reports**: For enhanced reporting purpose.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven 3.6.0 or higher
- An IDE such as Eclipse

## Directory Structure
src/main/java: Contains the main source code for the framework.
  - actiondriver/: class for common selenium methods
  - base/: Factory classes for browser, driver initialization.
  - pages/: Page Object Model classes.
  - Reports/: Classes for report methods and extent factory.
  - utilities/: Utility classes for common read operations.
src/test/java: Contains test cases and test-specific classes.
  - tests/: Test classes and test suites.
src/test/resources: Contains configuration files and test data.
  - testdata.json: JSON file with test data.
  - Config.properties: Environment configuration.
testng.xml – For sequential execution.
testng-parallel.xml – For parallel execution.

## Setup and Installation

1. **Clone the Repository**:
   - git clone https://github.com/your-username/your-repo-name.git
   - cd your-repo-name
			or
    **Download the project**
  - Download the project as a ZIP file from GitHub, extract it, and then import it into Eclipse

2. **Install Dependencies**: 
Ensure Maven is installed and then run:
mvn install

3. **Update Project**: 
Before running any test cases, ensure you perform a mvn clean and update the Maven project.

## Test Execution

**Running Tests via testNG:**

Run Tests Sequentially:
Right-click on testng.xml and select "Run as TestNG Suite" to execute the test cases sequentially.

Run Tests in Parallel: 
Right-click on testng-parallel.xml and choose "Run as TestNG Suite" to execute test cases in parallel, with thread count and parallel execution pre-configured.

**Running Tests via Maven:**

Run Tests via pom.xml:
Perform a mvn clean, update the Maven project, and run mvn install. Then, right-click on pom.xml and select "Run as Maven Test" to execute the test cases.

Run Tests in Maven command prompt:
Ensure Apache Maven is installed and environment variables are set. Navigate to the project folder and run the following commands:
- mvn clean 
- mvn test -Dparallel=tests -DthreadCount=4
