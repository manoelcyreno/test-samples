package com.liferay.samples.functional.test.steps;

import static org.junit.Assert.assertTrue;

import com.liferay.gs.testFramework.SeleniumWaitMethods;
import com.liferay.samples.functional.test.pages.FormsPage;
import com.liferay.samples.functional.test.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormsStepDefinitions {

	CommonMethods commonMethods = new CommonMethods();
	FormsPage formsPage = new FormsPage();

	@Given("^I will create a forms with the (-?[^\"]*) and (-?[^\"]*)$")
	public void i_will_create_a_forms_with_the_formsTitle_and_pageTitle(String formsTitle, String pageTitle) {
		formsPage.clickOnAddButton();
		SeleniumWaitMethods.waitLongTime();
		SeleniumWaitMethods.waitLongTime();
		SeleniumWaitMethods.waitMediumTime();
		formsPage.fillTitlePageLocator(pageTitle);
		formsPage.fillTitleFormsLocator(formsTitle);
	}

	@When("^I will create a forms with the field: (-?[^\"]*)$")
	public void i_will_create_a_forms_with_the_field(String field) {

		formsPage.clickFieldToAddOnForm(field);
//		formsPage.fillFormTextBodyTextLocator(field);
		System.out.println(field);
		formsPage.clickOnPublishFormButton();
	}

	@Then("^The user will be redirect to a new forms page$")
	public void the_user_will_be_redirect_to_a_new_forms_page() {
		assertTrue(formsPage.isTheNewForm());
	}
}
