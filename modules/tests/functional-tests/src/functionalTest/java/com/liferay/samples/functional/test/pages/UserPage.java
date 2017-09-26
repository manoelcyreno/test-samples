package com.liferay.samples.functional.test.pages;

import org.openqa.selenium.By;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.samples.functional.test.utils.CommonMethods;

public class UserPage {

	CommonMethods commonMethods = new CommonMethods();

	private final By addButtonLocator = By
			.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_menuItem']");
	private final By screenNameLocator = By
			.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_screenName']");
	private final By emailAddressLocator = By
			.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_emailAddress']");
	private final By firstNameLocator = By
			.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_firstName']");
	private final By lastNameLocator = By
			.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_lastName']");
	private final By saveButtonLocator = By.xpath(
			".//button[contains(@id, '_com_liferay_users_admin_web_portlet_UsersAdminPortlet')]//*[contains(text(), 'Sa')]");
	private final By passwordLocator = By
			.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_password1']");
	private final By RepeatPasswordLocator = By
			.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_password2']");

	private final By saveMessageLocator = By.xpath(
			".//div[contains(@class, 'alert-success') and contains(@class, 'alert-success-content') and contains(@class, 'alert')]");

	public void clickOnAddButton() {
		commonMethods.waitElement(addButtonLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(addButtonLocator).click();
	}

	public void clickOnSaveButton() {
		commonMethods.waitElement(saveButtonLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(saveButtonLocator).click();
		commonMethods.waitElement(saveMessageLocator);
	}

	public void fillScreenNameField(String screenName) {
		commonMethods.input(screenNameLocator, screenName);
	}

	public void fillEmailAddressField(String emailAddress) {
		commonMethods.input(emailAddressLocator, emailAddress);
	}

	public void fillFirstNameField(String firstName) {
		commonMethods.input(firstNameLocator, firstName);
	}

	public void fillLastNameField(String lastName) {
		commonMethods.input(lastNameLocator, lastName);
	}

	public void fillPasswordField(String password) {
		commonMethods.input(passwordLocator, password);
	}

	public void fillRepeatPasswordField(String password) {
		commonMethods.input(RepeatPasswordLocator, password);
	}

	public boolean isScreenNameDisplayedOnUserTable(String screenName) {
		By screenNameOnTableLocator = By
				.xpath(".//*[@id='_com_liferay_users_admin_web_portlet_UsersAdminPortlet_usersSearchContainer']//*[contains(text(), '"
						+ screenName + "')]");
		return SeleniumReadPropertyKeys.DRIVER.findElement(screenNameOnTableLocator).isDisplayed();
	}

}
