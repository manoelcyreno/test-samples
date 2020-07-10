package test;

import static paths.GooglePath.getSearchLocator;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.selenium.commons.testFramework.FunctionalTest;
import com.selenium.commons.testFramework.core.SeleniumReadPropertyKeys;
import com.selenium.commons.testFramework.utils.SeleniumWaitMethods;

/**
 * @author manoelcyreno
 *
 */
public class Google2Test extends FunctionalTest {

	@BeforeEach
	public void setUp() {
		getWebDriver().get(SeleniumReadPropertyKeys.getUrlToHome());
		getWebDriver().manage().timeouts().implicitlyWait(SeleniumReadPropertyKeys.getTimeOut(), TimeUnit.SECONDS);
	}

	@Test
	public void goToGooglePageAndAccessTheFirstResultAndCompareTheTitleWithRightTitleClass2() {
		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), getSearchLocator(),
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);

		getWebDriver().findElement(getSearchLocator()).clear();
		getWebDriver().findElement(getSearchLocator()).sendKeys("seleniumhq");
		getWebDriver().findElement(getSearchLocator()).sendKeys(Keys.ENTER);

		assertTrue(getWebDriver().getTitle().contains("seleniumhq") && getWebDriver().getTitle().contains("Google"));
	}
}