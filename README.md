# Welcome to Tests Samples Framework.


## Functional Tests (Without BDD Samples):

1. Google Search [/src/functional/]

## Functional Tests (With BDD Samples):

1. Google Search [/src/bdd/resources/googleSearch.feature]

## Integration Samples (Integration Tests):

1. pending...

## Unit Samples (Unit Tests):

1. Notes from a student [src/test/java/unit/samples1]
2. Product Exchange [src/test/java/unit/samples2]

## Java Script - Unit Test (Java Script Unit Tests):

1. Test Suite for verify something
2. Test Suite for verify using specific methods

## How Run after step above?

### Run by line command into the root folder.

1. `PENDING` into the functional-tests-withoutBDD folder.
2. `PENDING` into the functional-tests folder.
3. `PENDING` into the integration-tests folder.
4. `gradle test` into the unit-tests folder.
5. For Java Script Tests :

#### Using Karma Mocha:

1. Go to `src/js-unit-tests/mocha-karma`
2. Run `npm i`
3. Perform `npm run test` command to run

OBS: node should be on version v10.24.1

#### 5.2 Using Jest:

1. Go to `src/js-unit-tests/jest`
2. Run `npm run clean` to remove any trash folder and install dependencies.
3. Perform `npm run test` command to run

OBS: OBS: node should be on version v10.24.1

### Run by IDE - PENDING...

Configure your project according: (https://github.com/manoelcyreno/lfrgs-selenium-commons/wiki/Setup#how-to-use)

1. `runAllTests.java` into the src/functional/testsSuite folder.
2. `<class_name>Test.java` into the src/functional/test folder.
3. `runTest.java` into the src/test/java/unit/samples(1 or 2) folder.
