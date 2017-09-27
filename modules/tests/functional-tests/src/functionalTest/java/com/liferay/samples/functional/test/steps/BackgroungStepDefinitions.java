package com.liferay.samples.functional.test.steps;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.samples.functional.test.pages.FormsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BackgroungStepDefinitions {

	private static final String liferayPortalUser = "manoel.cyreno@liferay.com";
	private static final String liferayPortalPassword = "test";
	private static final String liferayPortalUsernameAcronym = "MC";

	//TODO colocar usuários de teste
	private static final String formsPortalUser = "test@liferay.com";
	private static final String formsPortalPassword = "r3m3mb3r";

	LoginStepDefinitions lsd = new LoginStepDefinitions();
	FormsPage fp = new FormsPage();

	@Given("^the user is logged in liferay portal$")
	public void the_user_is_logged_in_liferay_portal() {
		lsd.i_am_on_home_page();
		lsd.i_fill_the_login_and_password_i_will_be_logged(liferayPortalUser, liferayPortalPassword);
	}
	
	@Given("^the user is logged in Forms portal$")
	public void the_user_is_logged_in_forms_portal() {
		SeleniumReadPropertyKeys.DRIVER.get("https://forms.liferay.com/signin");
		lsd.signInOnPortal(formsPortalUser, formsPortalPassword);
	}

	@Then("^he are on welcome page$")
	public void he_are_on_welcome_page() {
		lsd.the_username_is_displayed(liferayPortalUsernameAcronym);
	}

	@Then("^Forms initial page will appear$")
	public void forms_initial_page_will_appear() {
		fp.formsTitleIsDisplayed();
	}
}
