package customer_signup_testing;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",
	glue = {"customer_signup_testing"},
	plugin = {"pretty", "html: target/HtmlReport/CustomerLoginSignup.html",
		"json: target/JsonReport/CustomerLoginSignup.json"}
		)

public class Runner {

}
