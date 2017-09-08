package com.liferay.samples.functional.test.steps;

import java.util.concurrent.TimeUnit;

import com.liferay.gs.testFramework.UtilsKeys;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SettingsStartingEndingSteps {

	@Before
	public void beforeScenario() {
		UtilsKeys.DRIVER.get(UtilsKeys.getUrlToHome());
		UtilsKeys.DRIVER.manage().window().maximize();
		UtilsKeys.DRIVER.manage().timeouts().implicitlyWait(UtilsKeys.getTimeOut(), TimeUnit.SECONDS);
	}

	@After
	public void afterScenario() {
		UtilsKeys.DRIVER.navigate().to(UtilsKeys.getUrlToHome() + UtilsKeys.getLinkToLogOut());
	}

}
