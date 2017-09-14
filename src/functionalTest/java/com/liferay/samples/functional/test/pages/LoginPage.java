package com.liferay.samples.functional.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.SeleniumWaitMethods;
import com.liferay.samples.functional.test.utils.CommonMethods;

public class LoginPage {

	CommonMethods commonMethods = new CommonMethods();

	private final By signInLocator = By.xpath(
			".//*[@id='p_p_id_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_']");
	private final By emailAddressLocator = By.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_login']");
	private final By passwordLocator = By.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_password']");
	private final By signInButtonOnModalLocator = By
			.xpath(".//*[contains(@id, '_com_liferay_login_web_portlet_LoginPortlet') and contains(@type, 'submit')]");

	private final By alertErrorLocator = By.xpath(
			".//*[contains(@class, 'alert-danger') and contains(@class, 'alert-danger-content') and contains(@class, 'liferayalert')]");
	private final By loginHelperLocator = By
			.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_loginHelper']");
	private final By passwordHelperLocator = By
			.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_passwordHelper']");

	public void fillEmailAddressField(String userLogin) {
		commonMethods.input(emailAddressLocator, userLogin);
	}

	public void fillPasswordField(String userPassword) {
		commonMethods.input(passwordLocator, userPassword);
	}

	public void clickOnSignIn() {
		commonMethods.waitElement(signInLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(signInLocator).click();
	}

	public void clickOnSignInOfTheModal() {
		commonMethods.waitElement(signInButtonOnModalLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(signInButtonOnModalLocator).click();
	}

	public boolean alertErrorIsDisplayed() {
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(alertErrorLocator));
		return SeleniumReadPropertyKeys.DRIVER.findElement(alertErrorLocator).isDisplayed();
	}

	public boolean loginHelperIsDisplayed() {
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(loginHelperLocator));
		return SeleniumReadPropertyKeys.DRIVER.findElement(loginHelperLocator).isDisplayed();
	}

	public boolean passwordHelperIsDisplayed() {
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(passwordHelperLocator));
		return SeleniumReadPropertyKeys.DRIVER.findElement(passwordHelperLocator).isDisplayed();
	}

}