package admin_panel;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)                                        //foldername
@CucumberOptions(features="src/test/resources/Feature", glue= {"admin_panel"},
plugin= {"pretty","html:target/htmlReports/htmlReports.html"}
		)
public class runner {

}
