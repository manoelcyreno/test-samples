# Welcome to Liferay GS Tests Samples.

These SAMPLES are based on Liferay GS Selenium Commons Framework, that code can be used for anyone of wanna make tests in Liferay using Selenium with BDD.

## BDD Samples (Functional Tests):

1. Login (positive and negative scenarios) [/src/functionalTest/resources/Login.feature]
2. Add Portlet on screen (positive scenario) [/src/functionalTest/resources/Portlet.feature]
3. Create User on screen (positive scenario) [/src/functionalTest/resources/User.feature]
4. Create Page (positive scenario) [/src/functionalTest/resources/Page.feature]
5. Create some forms structure (positive scenario) [/src/functionalTest/resources/Forms.feature]

## Integration Samples (Integration Tests):

1. Create and Delete a Page By Rest API (positive and negative scenarios)

## Unit Samples (Unit Tests):

1. Notes from a student (positive and negative scenarios) [samples1]
2. Product Exchange (positive scenario) [samples2]
3. TestApp portlet that is a portlet how print some text on it own portlet. (positive and negative scenarios) [samples3]

## How Use?

1. Download the "tests-sample-code.sh" file, into the Gradle project root folder.
2. Set the permission to execute on "tests-sample-code.sh" file (command: chmod +x tests-sample-code.sh)
3. Run the "tests-sample-code.sh" file (command: ./tests-sample-code.sh)
4. Configure your `defaultProperties.properties` and your `web driver` according the Framework Setup (https://github.com/manoelcyreno/lfrgs-selenium-commons/wiki/Setup)

### What this script will make?

1. Create one backup of the "src" and "modules" folder and "settings.gradle" file.
2. Create a temporary structure of sample code
3. Copy this structure to "modules" folder.
4. Delete the temporary structure.

## How Run after step above?

### Run by line command into the specific test folder.

`./gradlew cucumberTest` into the functional-tests folder.
<br> `./gradlew integrationTest` into the unit-tests folder.
<br> `./gradlew unitTest` into the unit-tests folder.

### Run by line command into the root folder.

`./gradlew modules:tests:functional-tests:cucumberTest` into the root folder.
<br> `./gradlew modules:tests:integration-tests:integrationTest` into the root folder.
<br> `./gradlew modules:tests:unit-tests:unitTest` into the root folder.


### Run by IDE.

`runTest.java` into the src/functionalTest/java/com/liferay/samples/functional/test folder.
<br> `runTest.java` into the src/integrationTest/java/com/liferay/samples/integration/test folder.
<br> `runTest.java` into the src/unitTest/java/com/liferay/samples(1, 2 or 3)/unit/test folder.

## Goal of wiki project

Centralize all information related to the development of automated tests of the project, to allow quick access to them.

See the Wiki page of the GS Selenium Commons Framework: https://github.com/manoelcyreno/lfrgs-selenium-commons/wiki
