package runner;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/main/resources/Feature", glue={"stepDefination"}, tags = {"@API"},  plugin = { "pretty", "html:target/cucumber-reports" },
monochrome = true)

public class TestRunner {

}
