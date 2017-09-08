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

	@When("^I will add a \"(.*)\" on Screen$")
	public void i_will_add_a_portlet_on_screen(String portletName) {
		commonMethods.addPortletOnScreen(portletName);
	}

	@Then("^The \"(.*)\" will appear$")
	public void the_portlet_will_appear(String portletName) {
		WaitUtils.waitMediumTime();
		assertEquals(true, welcomePage.portletIsDisplayed(portletName));
	}

}
