package customer_errors_testing;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",
	glue = {"customer_errors_testing"},
	plugin = {"pretty", "html: target/HtmlReport/CustomerErrors.html",
		"json: target/JsonReport/CustomerErrors.json"}
		)

public class Runner {

}
