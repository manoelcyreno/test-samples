#language:en
Feature: Page

Background: Logged with success
    Given the user is logged in liferay portal
    Then he are on welcome page

@Page
Scenario Outline: Create Page
	Given I am on Home Page
	When I will create a page with the info: <PublicOrPrivatePage>, <PageName>
	Then The user will redirect to the <PageName> created

	Examples:
    | PublicOrPrivatePage  |  PageName  |
    |   Public     |   Public Page 1     |
    |   Private     |   Private Page 1     |
    