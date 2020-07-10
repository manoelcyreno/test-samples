package test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.selenium.commons.testFramework.FunctionalTest;
import com.selenium.commons.testFramework.core.SeleniumReadPropertyKeys;

import pages.GooglePage;

/**
 * @author manoelcyreno
 *
 */
public class GoogleTest extends FunctionalTest {

	private GooglePage gp = new GooglePage();

	@BeforeEach
	public void setUp() {
		getWebDriver().get(SeleniumReadPropertyKeys.getUrlToHome());
		getWebDriver().manage().timeouts().implicitlyWait(SeleniumReadPropertyKeys.getTimeOut(), TimeUnit.SECONDS);
	}

	@Test
	public void goToGooglePageAndAccessTheFirstResultAndCompareTheTitleWithRightTitleClass1() {
		gp.searchSomething("seleniumhq");

		assertTrue(getWebDriver().getTitle().contains("seleniumhq") && getWebDriver().getTitle().contains("Google"));
	}
}