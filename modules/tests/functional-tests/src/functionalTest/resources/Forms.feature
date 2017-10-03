#language:en
@AfterForForms
Feature: Forms

Background: Logged with success
    Given the user is logged in Forms portal
    Then Forms initial page will appear

@Forms
Scenario Outline: Create Forms with only one fields
	Given I will create a forms with the <FormsTitle> and <PageTitle>
	When I will create a forms with the field: <Field>
	Then The sucess message appear on Forms

	Examples:
    |FormsTitle                      | PageTitle  |           Field    |
    |forms title1 Text Field         | page title1| Text Field         |
    |forms title2 Select from List   | page title2| Select from List   |
    |forms title3 Single Select      | page title3| Single Select      |
    |forms title4 Date               | page title4| Date               |
    |forms title5 Multiple Select    | page title5| Multiple Select    |
    |forms title6 Grid               | page title6| Grid               |
    |forms title7 Numeric            | page title7| Numeric            |