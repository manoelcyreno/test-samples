#language:en
Feature: User

Background: Logged with success
    Given the user is logged in liferay portal
    Then he are on welcome page

@User
Scenario Outline: Create User
	Given I am on Home Page
	When I will create a new user with the info: <ScreenName>, <EmailAddress>, <FirstName>, <LastName>, <Password>
	Then The <ScreenName> will appear on user list

	Examples:
    | ScreenName  |  EmailAddress  |  FirstName  |  LastName  |  Password  |
    |     test    |test@liferay.com|    test     |   test     |   test     |
