package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty","html:target/test-reports/test_report.html"}, features = {"src/test/resources/features"}, glue = {"StepDefinitions"})

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
