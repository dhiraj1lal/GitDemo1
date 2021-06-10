package cucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/searchItem.feature", glue = {"stepDefinitions"})
//,
//@monochrome=true,
//plugin= {"pretty","junit:target/HTMLReports/xml.reports",
//		"json:target/JSonReports/report.json",
//		"html:target/HTMLReports/report.html"},
//tags="@smoketest")
public class TestRunner  {
//	AbstractTestNGCucumberTests

}
