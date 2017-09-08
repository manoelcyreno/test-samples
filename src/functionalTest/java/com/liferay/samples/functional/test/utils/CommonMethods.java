package com.liferay.samples.functional.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.UtilsKeys;
import com.liferay.gs.testFramework.WaitUtils;

public class CommonMethods {

	private final By addButtonLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addToggleId']");
	private final By applicationHeadingLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addApplicationHeading']");
	private final By searchApplicationLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_searchApplication']");

	private final By column1Locator = By.xpath(".//*[@id='column-1']");

	public void waitElement(By locator) {
		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void input(By locator, String text) {
		waitElement(locator);
		UtilsKeys.DRIVER.findElement(locator).clear();
		UtilsKeys.DRIVER.findElement(locator).sendKeys(text);
	}

	public void addPortletOnScreen(String portletName) {
		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(addButtonLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(addButtonLocator));
		UtilsKeys.DRIVER.findElement(addButtonLocator).click();

		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(applicationHeadingLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(applicationHeadingLocator));
		// TODO Create a Javascript IF
		// colocar um if pra validar se esse elemento já esta aberto ou não, se
		// tiver não faz nada se não tiver ele abre o elemento
		// UtilsKeys.DRIVER.findElement(applicationHeadingLocator).click();

		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(searchApplicationLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(searchApplicationLocator));
		UtilsKeys.DRIVER.findElement(searchApplicationLocator).sendKeys(portletName);
		WaitUtils.waitMediumTime();

		By searchApplicationResultLocator = By
				.xpath(".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_portletCategory0']//*[contains (text(), '"
						+ portletName + "')]");

		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(searchApplicationResultLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(searchApplicationResultLocator));
		WebElement element = UtilsKeys.DRIVER.findElement(searchApplicationResultLocator);
		WebElement target = UtilsKeys.DRIVER.findElement(column1Locator);
		(new Actions(UtilsKeys.DRIVER)).dragAndDrop(element, target).perform();

		WaitUtils.waitMediumTime();
		UtilsKeys.DRIVER.findElement(applicationHeadingLocator).click();
		UtilsKeys.DRIVER.findElement(addButtonLocator).click();

	}

}
