package paths;

import org.openqa.selenium.By;

/**
 * @author manoelcyreno
 *
 */
public class GooglePath {

	private static By searchLocator = By.name("q");

	public static By getSearchLocator() {
		return searchLocator;
	}

}
