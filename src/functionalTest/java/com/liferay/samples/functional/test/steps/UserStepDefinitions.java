package com.liferay.samples.functional.test.steps;

import static org.junit.Assert.assertEquals;

import com.liferay.samples.functional.test.pages.UserPage;
import com.liferay.samples.functional.test.pages.WelcomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefinitions {

	UserPage userPage = new UserPage();
	WelcomePage welcomePage = new WelcomePage();

	@When("^I will create a new user with the info: (-?[^\"]*), (-?[^\"]*), (-?[^\"]*), (-?[^\"]*), (-?[^\"]*)$")
	public void i_will_create_a_new_user_with_the_info_ScreenName_EmailAddress_FirstName_LastName_Password(
			String screenName, String emailAddress, String firstName, String lastName, String password) {
		welcomePage.clickOnMenuButton();
		welcomePage.clickOnControlPanel();
		welcomePage.clickOnUsers();
		welcomePage.clickOnUsersAndOrganizations();
		userPage.clickOnAddButton();
		userPage.fillScreenNameField(screenName);
		userPage.fillEmailAddressField(emailAddress);
		userPage.fillFirstNameField(firstName);
		userPage.fillLastNameField(lastName);
		userPage.clickOnSaveButton();
		userPage.fillPasswordField(password);
		userPage.fillRepeatPasswordField(password);
		userPage.clickOnSaveButton();
	}

	@Then("^The (-?[^\"]*) will appear on user list$")
	public void the_ScreenName_will_appear_on_user_list(String screenName) {
		welcomePage.clickOnUsersAndOrganizations();
		Boolean screenNameDisplayed = userPage.isScreenNameDisplayedOnUserTable(screenName);
		assertEquals(true, screenNameDisplayed);
	}

}
