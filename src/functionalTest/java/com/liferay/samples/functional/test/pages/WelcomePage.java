package com.liferay.samples.functional.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.UtilsKeys;
import com.liferay.gs.testFramework.WaitUtils;
import com.liferay.samples.functional.test.utils.CommonMethods;

public class WelcomePage {

	CommonMethods commonMethods = new CommonMethods();

	private final By menuLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_sidenavToggleId']");
	private final By controlPanelLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_control_panelHeading']//a[@data-qa-id='productMenuControlPanelCategory']");
	private final By usersLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_control_panelCollapse']//a[(@data-qa-id='appGroup') and contains(text(), 'Us')]");
	private final By usersAndOrganizationsLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_portlet_com_liferay_users_admin_web_portlet_UsersAdminPortlet']");

	public void clickOnMenuButton() {
		// TODO Create a Javascript IF
		// colocar um if pra validar se esse elemento já esta aberto ou não, se
		// tiver não faz nada se não tiver ele abre o elemento

		commonMethods.waitElement(menuLocator);
		UtilsKeys.DRIVER.findElement(menuLocator).click();
	}

	public void clickOnControlPanel() {
		commonMethods.waitElement(controlPanelLocator);
		UtilsKeys.DRIVER.findElement(controlPanelLocator).click();
	}

	public void clickOnUsers() {
		commonMethods.waitElement(usersLocator);
		UtilsKeys.DRIVER.findElement(usersLocator).click();
	}

	public void clickOnUsersAndOrganizations() {
		commonMethods.waitElement(usersAndOrganizationsLocator);
		UtilsKeys.DRIVER.findElement(usersAndOrganizationsLocator).click();
	}

	public boolean usernameIsDisplayed(String usernameAcronym) {
		By usernameAcronymLocator = By
				.xpath(".//*[contains(@id, 'p_p_id_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_')]//*[contains(text(), '"
						+ usernameAcronym + "')]");

		WaitUtils.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(usernameAcronymLocator));

		return UtilsKeys.DRIVER.findElement(usernameAcronymLocator).isDisplayed();
	}

	public boolean portletIsDisplayed(String portletName) {
		By portletNameLocator = By
				.xpath("//*[contains(@id, 'portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet')]//*[contains(text(), '"
						+ portletName + "')]");

		return UtilsKeys.DRIVER.findElement(portletNameLocator).isEnabled();
	}

}
