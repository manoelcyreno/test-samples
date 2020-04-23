package test;

import static org.junit.Assert.assertTrue;
import static paths.GooglePath.getSearchLocator;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.FunctionalTest;
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

/**
 * @author manoelcyreno
 *
 */
public class GoogleTest2 extends FunctionalTest {

	@Before
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