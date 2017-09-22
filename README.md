# Welcome to BDD Selenium Samples in Liferay.

This SAMPLES is based on GS Selenium Commons Framework, that code can be used for anyone of wanna make test in Liferay using Selenium with BDD.

## Samples:

1. Login (positive and negative scenarios) [/src/functionalTest/resources/Login.feature]
2. Add Portlet on screen (positive scenario) [/src/functionalTest/resources/Portlet.feature]
3. Create User on screen (positive scenario) [/src/functionalTest/resources/User.feature]
4. Create Page (positive scenario) [/src/functionalTest/resources/Page.feature]

## How Use?

1. Download the "BDD-selenium-sample-code.sh" file, into the Gradle project root folder.
2. Set the permission to execute on "BDD-selenium-sample-code.sh" file (command: chmod +x BDD-selenium-sample-code.sh)
3. Run the "BDD-selenium-sample-code.sh" file (command: ./BDD-selenium-sample-code.sh)

### What this script will make?

1. Create one backup of the "src" folder and "build.gradle" file.
2. Create a temporary structure of sample code
3. Copy this structure to "src" folder.
4. Delete the temporary structure.

## How Run after step above?

### Run by line command.

`./gradlew cucumberTest` into the root folder or into the functionalTest folder.

### Run by IDE.

`runTest.java` into the src/functionalTest/java/com/liferay/samples/functional/test folder.

## Goal of wiki project

Centralize all information related to the development of automated tests of the project, to allow quick access to them.

See the Wiki page of the GS Selenium Commons Framework: https://github.com/manoelcyreno/lfrgs-selenium-commons/wiki
