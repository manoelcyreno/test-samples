package com.liferay.samples.functional.test.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.UtilsKeys;
import com.liferay.gs.testFramework.WaitUtils;

public class CommonMethods {

	private Actions actionBuilder = new Actions(UtilsKeys.DRIVER);

	private final By addButtonLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addToggleId']");
	private final By applicationHeadingLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addApplicationHeading']");
	private final By searchApplicationLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_searchApplication']");

	public void waitElement(By locator) {
		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void input(By locator, String text) {
		waitElement(locator);
		UtilsKeys.DRIVER.findElement(locator).clear();
		UtilsKeys.DRIVER.findElement(locator).sendKeys(text);
	}

	public void addPortletOnScreen(String portletName, String column) {
		clickOnAddButton();
		clickOnApplicationCategory();
		searchForPortletByName(portletName);
		dragAndDropPortletToColumn(portletName, column);
	}

	private void dragAndDropPortletToColumn(String portletName, String column) {
		WaitUtils.waitMediumTime();

		By searchApplicationResultLocator = By
				.xpath(".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_portletCategory0']//*[contains (text(), '"
						+ portletName + "')]");

		By columnLocator = By.xpath(".//*[@id='" + column + "']");

		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(searchApplicationResultLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(searchApplicationResultLocator));
		WebElement element = UtilsKeys.DRIVER.findElement(searchApplicationResultLocator);
		WebElement target = UtilsKeys.DRIVER.findElement(columnLocator);
		(new Actions(UtilsKeys.DRIVER)).dragAndDrop(element, target).perform();
		WaitUtils.waitMediumTime();
	}

	public void removeAllPorlets() {
		List<WebElement> portlets = UtilsKeys.DRIVER.findElements(By.cssSelector(".portlet-layout .portlet"));
		for (WebElement portlet : portlets) {
			openPortletActionDropDown(portlet);
			clickOnPortletConfigurationMenu("Remove");
			acceptBrowserDialog();
		}
	}

	private void searchForPortletByName(String portletName) {
		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(searchApplicationLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(searchApplicationLocator));
		UtilsKeys.DRIVER.findElement(searchApplicationLocator).sendKeys(portletName);
	}

	private void clickOnAddButton() {
		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(addButtonLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(addButtonLocator));
		UtilsKeys.DRIVER.findElement(addButtonLocator).click();
	}

	private void clickOnApplicationCategory() {
		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(applicationHeadingLocator));
		WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(applicationHeadingLocator));

		By portletContentCategories = By.cssSelector(".add-content-menu .lfr-content-category");
		boolean isApplicationCategoriesDisplayed = UtilsKeys.DRIVER.findElement(portletContentCategories).isDisplayed();

		if (!isApplicationCategoriesDisplayed) {
			WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(applicationHeadingLocator));
			WaitUtils.getWaitDriver().until(ExpectedConditions.elementToBeClickable(applicationHeadingLocator));
			UtilsKeys.DRIVER.findElement(applicationHeadingLocator).click();
		}
	}

	private void openPortletActionDropDown(WebElement portletElement) {
		WebElement configButton = portletElement.findElement(By.cssSelector(".lexicon-icon-ellipsis-v"));
		actionBuilder.moveToElement(configButton).pause(Duration.ofMillis(200)).perform();
		configButton.click();
	}

	private void clickOnPortletConfigurationMenu(String title) {
		By dropDownMenu = By.cssSelector(".dropdown-menu");
		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(dropDownMenu));

		WebElement dropDownMenuElement = UtilsKeys.DRIVER.findElement(dropDownMenu);

		List<WebElement> elements = dropDownMenuElement.findElements(By.cssSelector("li a.lfr-icon-item"));
		WebElement element = elements.stream().filter(el -> el.getText().trim().equals(title)).findFirst().get();
		element.click();
	}

	private static void acceptBrowserDialog() {
		Alert alert = UtilsKeys.DRIVER.switchTo().alert();
		alert.accept();
	}
}
