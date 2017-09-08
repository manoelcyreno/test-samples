package com.liferay.samples.functional.test.steps;

import static org.junit.Assert.assertEquals;

import com.liferay.gs.testFramework.WaitUtils;
import com.liferay.samples.functional.test.pages.WelcomePage;
import com.liferay.samples.functional.test.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WelcomeStepDefinitions {

	CommonMethods commonMethods = new CommonMethods();
	WelcomePage welcomePage = new WelcomePage();

	@When("^I will add a (-?[^\"]*) on (-?[^\"]*) of the Screen$")
	public void i_will_add_a_portlet_on_column_of_the_screen(String portletName, String column) {
		commonMethods.addPortletOnScreen(portletName, column);
	}

	@Then("^The (-?[^\"]*) will appear$")
	public void the_portlet_will_appear(String portletName) {
		WaitUtils.waitMediumTime();
		assertEquals(true, welcomePage.portletIsDisplayed(portletName));
	}

}
