#language:en
Feature: Google Search

@Search
Scenario Outline: Perform some search on google with success
	Given I am on Google Page
	When I search by <searchableWord>
	Then The <searchableWord> is displayed

	Examples:
    | searchableWord |
    | seleniumhq |

@Search
Scenario Outline: Perform some search on google with fail
	Given I am on Google Page
	When I search by <searchableWord>
	Then The <searchableWord> is not displayed

	Examples:
    | searchableWord |
    | wordthatnoexistwillappearsomeerror |
	