package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.liferay.gs.testFramework.FunctionalTest;
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePageBDD;

/**
 * @author manoelcyreno
 *
 */
public class GoogleSearchStepDefinition extends FunctionalTest {

	GooglePageBDD gpbdd  = new GooglePageBDD(getWebDriver());
	
	@Given("^I am on Google Page$")
	public void i_am_on_Google_Page() {
		getWebDriver().get(SeleniumReadPropertyKeys.getUrlToHome());
	}

	@When("^I search by (-?[^\"]*)$")
	public void i_search_by_searchableWord(String searchableWord) {

		gpbdd.searchSomething(searchableWord);
	}

	@Then("^The (-?[^\"]*) is not displayed$")
	public void the_searchableWord_is_not_displayed(String searchableWord) {
		assertFalse(getWebDriver().getTitle().contains("seleniumhq") && getWebDriver().getTitle().contains("Google"));
	}

	@Then("^The (-?[^\"]*) is displayed$")
	public void the_searchableWord_is_displayed(String searchableWord) {
		assertTrue(getWebDriver().getTitle().contains("seleniumhq") && getWebDriver().getTitle().contains("Google"));
	}
}