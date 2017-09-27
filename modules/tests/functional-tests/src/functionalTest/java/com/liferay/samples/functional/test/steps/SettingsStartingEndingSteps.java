package com.liferay.samples.functional.test.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SettingsStartingEndingSteps {

//	CommonMethods commonMethods = new CommonMethods();

	@Before
	public void beforeScenario() {
		SeleniumReadPropertyKeys.DRIVER.get(SeleniumReadPropertyKeys.getUrlToHome());
		SeleniumReadPropertyKeys.DRIVER.manage().window().maximize();
		SeleniumReadPropertyKeys.DRIVER.manage().timeouts().implicitlyWait(SeleniumReadPropertyKeys.getTimeOut(), TimeUnit.SECONDS);
	}

//	@After(value = "@RunRemoveAllPortletsFromPage")
//	public void removeAllPortletsFromPage() {
//		commonMethods.removeAllPorlets();
//	}
	
	@After(value = "@AfterForForms")
	public void afterForForms() {
		SeleniumReadPropertyKeys.DRIVER.navigate().to("https://forms.liferay.com/" + SeleniumReadPropertyKeys.getLinkToLogOut());
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) SeleniumReadPropertyKeys.DRIVER).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}

		SeleniumReadPropertyKeys.DRIVER.navigate().to(SeleniumReadPropertyKeys.getUrlToHome() + SeleniumReadPropertyKeys.getLinkToLogOut());
	}
}
