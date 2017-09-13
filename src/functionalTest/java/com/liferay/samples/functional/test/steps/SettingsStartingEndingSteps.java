package com.liferay.samples.functional.test.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.liferay.gs.testFramework.UtilsKeys;
import com.liferay.samples.functional.test.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SettingsStartingEndingSteps {

	CommonMethods commonMethods = new CommonMethods();

	@Before
	public void beforeScenario() {
		UtilsKeys.DRIVER.get(UtilsKeys.getUrlToHome());
		UtilsKeys.DRIVER.manage().window().maximize();
		UtilsKeys.DRIVER.manage().timeouts().implicitlyWait(UtilsKeys.getTimeOut(), TimeUnit.SECONDS);
	}

//	@After(value = "@RunRemoveAllPortletsFromPage")
//	public void removeAllPortletsFromPage() {
//		commonMethods.removeAllPorlets();
//	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) UtilsKeys.DRIVER).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}

		UtilsKeys.DRIVER.navigate().to(UtilsKeys.getUrlToHome() + UtilsKeys.getLinkToLogOut());
	}
}
