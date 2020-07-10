package testSuite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import test.Google2Test;
import test.GoogleTest;

/**
 * @author manoelcyreno
 *
 */
@RunWith(JUnitPlatform.class)
@SelectClasses( { GoogleTest.class, Google2Test.class } )
public class RunAllTests {}
