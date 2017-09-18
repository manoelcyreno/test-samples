package com.liferay.samples.functional.test.pages;

import org.openqa.selenium.By;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.samples.functional.test.utils.CommonMethods;

public class PagePage {

	CommonMethods commonMethods = new CommonMethods();

	private static By pageNameLocator = By
			.xpath(".//*[@id='_com_liferay_layout_admin_web_portlet_GroupPagesPortlet_name']");
	private static By addPageLocator = By.xpath(
			".//button[contains(@id, '_com_liferay_layout_admin_web_portlet_GroupPagesPortlet') and contains(@type, 'submit')]");
	private static By successMessageLocator = By
			.xpath(".//*[contains(@class, 'alert-success') and contains(@class, 'alert-success-content')]");

	public void clickOnAddPage() {
		commonMethods.waitElement(addPageLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(addPageLocator).click();
	}

	public void fillPageName(String pageName) {
		commonMethods.input(pageNameLocator, pageName);
	}
	
	public void successMessageLocatorAppear() {
		commonMethods.waitElement(successMessageLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(successMessageLocator).isDisplayed();
	}


}
