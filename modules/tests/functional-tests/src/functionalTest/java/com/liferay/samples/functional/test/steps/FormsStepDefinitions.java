package com.liferay.samples.functional.test.steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
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
		By loaderLocator = By.xpath(".//*[contains(@class,'loading-animation')]");
		SeleniumReadPropertyKeys.DRIVER.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		try {
			while (SeleniumReadPropertyKeys.DRIVER.findElement(loaderLocator).isDisplayed()) {
				SeleniumWaitMethods.waitShortTime();
			}
		} catch (Exception e) {
			System.out.println("The loader is not appear anymore");
		}

		formsPage.fillTitlePageLocator(pageTitle);
		formsPage.fillTitleFormsLocator(formsTitle);
	}

	@When("^I will create a forms with the field: (-?[^\"]*)$")
	public void i_will_create_a_forms_with_the_field(String field) {

		formsPage.clickFieldToAddOnForm(field);
		formsPage.clickOnPublishFormButton();
	}

	@Then("^The sucess message appear on Forms$")
	public void the_sucess_message_appear_on_forms() {
		assertTrue(formsPage.isDisplayedTheSucessMessageOnForms());
	}
}
