#language:en
Feature: WebContent

Background: Logged with success
    Given the user is logged in liferay portal
    Then he are on welcome page

Scenario: Add WebContent Display on Screen
	Given I am on Home Page
	When I will add a "Web Content Display" on Screen
	Then The "Web Content Display" will appear