package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources",
		glue = {"StepDefinitions"},
		monochrome = true,
		plugin = {"pretty", "html:target/reports/HtmlRepotr/cucumber.html",
							"json:target/reports/JsonReport/cucumber.json",
							"junit:target/reports/XmlReport/cucumber.xml"})

public class TestRuner  {
	
	
	}


