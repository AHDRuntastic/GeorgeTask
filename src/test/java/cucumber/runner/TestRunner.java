package cucumber.runner;

import base.TestBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Registration.feature",
        glue = {"cucumber/stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber-report.json"},
        monochrome = true
)
public class TestRunner extends TestBase {
}
