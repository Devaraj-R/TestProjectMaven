package CucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Feature",
		glue="stepDefinations" //when there is package under sameparent use glue
		)
public class TestRunner {

}
