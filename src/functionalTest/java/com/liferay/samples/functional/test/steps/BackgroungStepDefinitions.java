package com.liferay.samples.functional.test.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BackgroungStepDefinitions {

	private static final String liferayPortalUser = "manoel.cyreno@liferay.com";
	private static final String liferayPortalPassword = "test";
	private static final String liferayPortalUsernameAcronym = "MC";

	LoginStepDefinitions lsd = new LoginStepDefinitions();

	@Given("^the user is logged in liferay portal$")
	public void the_user_is_logged_in_liferay_portal() {
		lsd.i_am_on_home_page();
		lsd.i_fill_the_login_and_password_i_will_be_logged(liferayPortalUser, liferayPortalPassword);
	}

	@Then("^he are on welcome page$")
	public void he_are_on_welcome_page() {
		lsd.the_username_is_displayed(liferayPortalUsernameAcronym);
	}
}
