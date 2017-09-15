package com.liferay.samples.functional.test.steps;

import static org.junit.Assert.assertEquals;

import com.liferay.gs.testFramework.SeleniumCommonMethods;
import com.liferay.gs.testFramework.SeleniumWaitMethods;
import com.liferay.samples.functional.test.pages.WelcomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WelcomeStepDefinitions {

	WelcomePage welcomePage = new WelcomePage();

	@When("^I will add a (-?[^\"]*) on (-?[^\"]*) of the Screen$")
	public void i_will_add_a_portlet_on_column_of_the_screen(String portletName, String column) {
		SeleniumCommonMethods.addPortletOnScreen(portletName, column);
	}

	@Then("^The (-?[^\"]*) will appear$")
	public void the_portlet_will_appear(String portletName) {
		SeleniumWaitMethods.waitMediumTime();
		assertEquals(true, welcomePage.portletIsDisplayed(portletName));
	}

}
