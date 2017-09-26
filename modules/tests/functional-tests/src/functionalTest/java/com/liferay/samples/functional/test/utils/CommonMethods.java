package com.liferay.samples.functional.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.SeleniumWaitMethods;

public class CommonMethods {

	public void waitElement(By locator) {
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void input(By locator, String text) {
		waitElement(locator);
		SeleniumReadPropertyKeys.DRIVER.findElement(locator).clear();
		SeleniumReadPropertyKeys.DRIVER.findElement(locator).sendKeys(text);
	}
}
