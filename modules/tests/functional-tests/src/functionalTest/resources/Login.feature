#language:en
Feature: Login

@Login
Scenario Outline: Perform the Login with success
	Given I am on Home Page
	When I fill the <login> and <password> I will be logged
	Then The <usernameAcronym> is displayed

	Examples:
    |            login         |  password   | usernameAcronym  |
    |manoel.cyreno@liferay.com | test        |       MC         |

@Login
Scenario Outline: Perform the Login with fail
	Given I am on Home Page
	When I fill the <login> and <password> I will be logged
	Then The error message will appear related with <wrongField>

	Examples:
	|            login         |  password   | wrongField |
	| unexistUser@liferay.com  | unexistPass |    both    |
	|                          | noUserPass  |    user    |
	| unexistUser@liferay.com  |             |  password  |