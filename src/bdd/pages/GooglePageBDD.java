package pages;

import static paths.GooglePath.getSearchLocator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.liferay.gs.testFramework.utils.SeleniumCommonMethods;

/**
 * @author manoelcyreno
 *
 */
public class GooglePageBDD extends SeleniumCommonMethods {

	public GooglePageBDD(WebDriver webDriver) {
		super(webDriver);
	}

	public void searchSomething(String what_i_want_to_search) {
		clearAndWriteOnElement(getSearchLocator(), what_i_want_to_search);
		writeOnElement(getSearchLocator(), Keys.ENTER);
	}

}