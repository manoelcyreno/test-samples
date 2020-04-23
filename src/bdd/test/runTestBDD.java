package test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.liferay.gs.testFramework.driver.WebDriverManager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author manoelcyreno
 *
 */
@CucumberOptions(
		features = "src/bdd/resources",
		glue = { "steps" },
		plugin = { "pretty", "html:reports/cucumber" },
		tags = {})
@RunWith(Cucumber.class)
public class runTestBDD {

	@AfterClass
	public static void afterClass() {
		_webDriverManager.quitAll();
	}

	private static WebDriverManager _webDriverManager = new WebDriverManager();

}
