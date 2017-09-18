package com.liferay.samples.functional.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.SeleniumWaitMethods;
import com.liferay.samples.functional.test.utils.CommonMethods;

public class WelcomePage {

	CommonMethods commonMethods = new CommonMethods();

	private final By menuLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_sidenavToggleId']");
	private final By controlPanelLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_control_panelHeading']//a[@data-qa-id='productMenuControlPanelCategory']");
	private final By usersLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_control_panelCollapse']//a[(@data-qa-id='appGroup') and contains(text(), 'Us')]");
	private static By addButtonLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addToggleId']");

	private static By navigationLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_site_administrationCollapse']//a[contains(@href, 'navigation')]");
	private static By publicPagesOptionsLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_layoutsTreeContainer']//a[(@data-qa-id='publicPagesOptions')]");
	private static By addPublicPageLocator = By.xpath(".//a[(@data-qa-id='addPublicPage')]");
	private static By addPrivatePageLocator = By.xpath(".//a[(@data-qa-id='addPrivatePage')]");

	private static void clickOnAddButton() {
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(addButtonLocator));
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.elementToBeClickable(addButtonLocator));
		SeleniumReadPropertyKeys.DRIVER.findElement(addButtonLocator).click();
		SeleniumWaitMethods.waitMediumTime();
	}

	public void clickOnMenuButton() {
		clickOnAddButton();
		commonMethods.waitElement(menuLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(menuLocator).click();
	}

	public void clickOnControlPanel() {
		commonMethods.waitElement(controlPanelLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(controlPanelLocator).click();
	}

	public void clickOnUsers() {
		commonMethods.waitElement(usersLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(usersLocator).click();
	}

	public void clickOnUsersAndOrganizations() {
		By usersAndOrganizationsLocator = By.xpath(
				".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_portlet_com_liferay_users_admin_web_portlet_UsersAdminPortlet']");

		commonMethods.waitElement(usersAndOrganizationsLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(usersAndOrganizationsLocator).click();
	}

	public boolean usernameIsDisplayed(String usernameAcronym) {
		By usernameAcronymLocator = By.xpath(
				".//*[contains(@id, 'p_p_id_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_')]//*[contains(text(), '"
						+ usernameAcronym + "')]");

		SeleniumWaitMethods.getWaitDriver()
				.until(ExpectedConditions.visibilityOfElementLocated(usernameAcronymLocator));

		return SeleniumReadPropertyKeys.DRIVER.findElement(usernameAcronymLocator).isDisplayed();
	}

	public boolean portletIsDisplayed(String portletName) {
		By portletNameLocator = By.xpath(
				"//*[contains(@id, 'portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet')]//*[contains(text(), '"
						+ portletName + "')]");

		return SeleniumReadPropertyKeys.DRIVER.findElement(portletNameLocator).isEnabled();
	}

	public void clickOnNavigation() {
		SeleniumWaitMethods.waitMediumTime();
		commonMethods.waitElement(navigationLocator);

		boolean isPublicPagesOptionsLocatorDisplayed = SeleniumReadPropertyKeys.DRIVER
				.findElement(publicPagesOptionsLocator).isDisplayed();

		if (!isPublicPagesOptionsLocatorDisplayed) {
			SeleniumReadPropertyKeys.DRIVER.findElement(navigationLocator).click();
		}

	}

	public void clickOnPublicPagesOptions() {
		commonMethods.waitElement(publicPagesOptionsLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(publicPagesOptionsLocator).click();
	}

	public void clickOnAddPublicPage() {
		commonMethods.waitElement(addPublicPageLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(addPublicPageLocator).click();
	}

	public void clickOnAddPrivatePage() {
		commonMethods.waitElement(addPrivatePageLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(addPrivatePageLocator).click();
	}
}
