package pages;

import static paths.GooglePath.getSearchLocator;

import org.openqa.selenium.Keys;

import com.selenium.commons.testFramework.FunctionalTest;
import com.selenium.commons.testFramework.utils.SeleniumCommonMethods;

/**
 * @author manoelcyreno
 *
 */
public class GooglePageBDD extends FunctionalTest {

	private SeleniumCommonMethods scm = new SeleniumCommonMethods();

	public void searchSomething(String what_i_want_to_search) {
		scm.clearAndWriteOnElement(getSearchLocator(), what_i_want_to_search);
		scm.writeOnElement(getSearchLocator(), Keys.ENTER);
	}

}