package com.liferay.samples.functional.test.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.samples.functional.test.pages.PagePage;
import com.liferay.samples.functional.test.pages.WelcomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PageStepDefinitions {

	PagePage pagePage = new PagePage();
	WelcomePage welcomePage = new WelcomePage();

	@When("^I will create a page with the info: (-?[^\"]*), (-?[^\"]*)$")
	public void i_will_create_a_page_with_the_info_PublicOrPrivate_PageName(String publicOrPrivate, String pageName) {
		welcomePage.clickOnMenuButton();
		welcomePage.clickOnNavigation();
		welcomePage.clickOnPublicPagesOptions();
		switch (publicOrPrivate.toLowerCase().toString()) {
		case "public":
			welcomePage.clickOnAddPublicPage();
			break;
		case "private":
			welcomePage.clickOnAddPrivatePage();
			break;
		default:
			// This switch will catch the failure if the others cases weren't mapped
			assertEquals(true, false);
		}
		String newPageName = removeWhiteSpace(pageName);
		pagePage.fillPageName(newPageName);
		pagePage.clickOnAddPage();
		pagePage.successMessageLocatorAppear();
	}

	@Then("^The user will redirect to the (-?[^\\\"]*) created$")
	public void the_user_will_redirect_to_the_page_created(String pageName) {

		String newPageName = removeWhiteSpace(pageName);
		String url = SeleniumReadPropertyKeys.DRIVER.getCurrentUrl();

		if (url.contains(newPageName)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	private String removeWhiteSpace(String text) {
		String newText = text;
		return newText.replaceAll(" ", "").toLowerCase();
	}

}
