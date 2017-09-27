package com.liferay.samples.functional.test.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.SeleniumWaitMethods;
import com.liferay.samples.functional.test.utils.CommonMethods;

public class FormsPage {

	CommonMethods commonMethods = new CommonMethods();

	private final By FormsLocator = By.xpath(".//*[@data-qa-id='headerTitle']");
	private final By addLocator = By.xpath(".//*[@data-qa-id='addButton']");
	private final By titleFormsLocator = By
			.xpath(".//*[@id='_com_liferay_dynamic_data_lists_form_web_portlet_DDLFormAdminPortlet_nameEditor']");
	private final By titlePageLocator = By.xpath(
			".//*[@id='_com_liferay_dynamic_data_lists_form_web_portlet_DDLFormAdminPortlet_formBuilder']//textarea[1]");

	private final By addFieldLocator = By.xpath(
			".//*[contains(@class,'form-builder-field-list-add-button') and contains(@class,'form-builder-field-list-add-button-large')]");

	private final By formTextBodyTextLocator = By.xpath(".//*[@data-placeholder='Enter body text.']/p");

	private final By publishFormLocator = By
			.xpath(".//*[@id='_com_liferay_dynamic_data_lists_form_web_portlet_DDLFormAdminPortlet_publish']");

	public void formsTitleIsDisplayed() {
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(FormsLocator));
		assertEquals(true, SeleniumReadPropertyKeys.DRIVER.findElement(FormsLocator).isDisplayed());
	}

	public void clickOnAddButton() {
		commonMethods.waitElement(addLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(addLocator).click();
	}

	public void fillTitleFormsLocator(String titleForms) {
		commonMethods.waitElement(titleFormsLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(titleFormsLocator).click();
		commonMethods.input(titleFormsLocator, titleForms);
	}

	public void fillTitlePageLocator(String titlePage) {
		commonMethods.input(titlePageLocator, titlePage);
	}

	public void fillFormTextBodyTextLocator(String formTextBodyText) {

		 commonMethods.input(formTextBodyTextLocator, formTextBodyText);
	}

	public void clickFieldToAddOnForm(String fieldToAddOnForm) {
		commonMethods.waitElement(addFieldLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(addFieldLocator).click();

		By fieldToAddOnFormLocator = By
				.xpath(".//*[contains(@class, 'form-builder-field-types-list')]//*[contains(text(), '"
						+ fieldToAddOnForm + "')]");

		commonMethods.waitElement(fieldToAddOnFormLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(fieldToAddOnFormLocator).click();

		SeleniumWaitMethods.waitLongTime();
		SeleniumWaitMethods.waitMediumTime();

		By fieldOnScreen = By.cssSelector(".form-builder-field-content-target");

		SeleniumReadPropertyKeys.DRIVER.findElement(fieldOnScreen).sendKeys(Keys.ESCAPE);
		SeleniumReadPropertyKeys.DRIVER.findElement(By.xpath(".//*[contains(text(), 'Yes, cancel')]"))
				.sendKeys(Keys.ESCAPE);

		assertTrue(SeleniumReadPropertyKeys.DRIVER.findElement(fieldOnScreen).isDisplayed());
	}

	public void clickOnPublishFormButton() {
		commonMethods.waitElement(publishFormLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(publishFormLocator).click();
	}

	public boolean isTheNewForm() {
		SeleniumWaitMethods.waitMediumTime();
		commonMethods.waitElement(titleFormsLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(titleFormsLocator).click();
		Boolean titleIsEmpty = SeleniumReadPropertyKeys.DRIVER.findElement(titleFormsLocator).getText().isEmpty();
		return titleIsEmpty;
	}

}
