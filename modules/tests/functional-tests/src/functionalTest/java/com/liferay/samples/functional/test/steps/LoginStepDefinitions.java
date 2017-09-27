package com.liferay.samples.functional.test.steps;

import static org.junit.Assert.assertEquals;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.samples.functional.test.pages.LoginPage;
import com.liferay.samples.functional.test.pages.WelcomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {

	LoginPage loginPage = new LoginPage();
	WelcomePage welcomePage = new WelcomePage();

	@Given("^I am on Home Page$")
	public void i_am_on_home_page() {
		SeleniumReadPropertyKeys.DRIVER.get(SeleniumReadPropertyKeys.getUrlToHome());
	}

	@When("^I fill the (-?[^\"]*) and (-?[^\"]*) I will be logged$")
	public void i_fill_the_login_and_password_i_will_be_logged(String emailAddress, String password) {
		loginPage.clickOnSignIn();
		signInOnPortal(emailAddress, password);
	}

	@Then("^The (-?[^\"]*) is displayed$")
	public void the_username_is_displayed(String username) {
		assertEquals(true, welcomePage.usernameIsDisplayed(username));
	}

	@Then("^The error message will appear related with (-?[^\"]*)$")
	public void the_error_message_will_appear_related_with(String wrongField) {
		switch (wrongField.toLowerCase().toString()) {
		case "both":
			assertEquals(true, loginPage.alertErrorIsDisplayed());
			break;
		case "user":
			assertEquals(true, loginPage.loginHelperIsDisplayed());
			break;
		case "password":
			assertEquals(true, loginPage.passwordHelperIsDisplayed());
			break;
		default:
			//This switch will catch the failure if the others cases weren't mapped
			assertEquals(true, false);
		}
	}
	
	public void signInOnPortal(String emailAddress, String password) {
		loginPage.fillEmailAddressField(emailAddress);
		loginPage.fillPasswordField(password);
		loginPage.clickOnSignInOfTheModal();
	}


}
