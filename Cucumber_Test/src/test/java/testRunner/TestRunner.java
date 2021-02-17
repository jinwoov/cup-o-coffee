package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"}, // this is to tell where the features are in
        glue = {"steps"}, // this is to declare where the steps is
        plugin = {"pretty", "json:Reports"} // output or log after the test is ran / can be json, html, junit
//        dryRun = false // if there are any step that doesn't have definition associated with them.
//        strict = true // it is necessary to have all of the definition.
//        monochrome = false // the way it is executed will give more cleaner format, no color
//        tags = {"@P1"}
//        name = {"Logo"} // run only the scenario that has keyword
)
public class TestRunner {
}
