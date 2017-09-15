#language:en
@RunRemoveAllPortletsFromPage
Feature: Portlet

Background: Logged with success
    Given the user is logged in liferay portal
    Then he are on welcome page

@WebContent
Scenario Outline: Add Web Content Display on Screen
	Given I am on Home Page
	When I will add a <portletName> on <column> of the Screen
	Then The <portletName> will appear

	Examples:
    |        portletName   |  column   |
    |  Web Content Display | column-1  |
