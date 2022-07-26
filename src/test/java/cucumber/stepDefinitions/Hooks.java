package cucumber.stepDefinitions;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks extends TestBase {


    @Before
    public void beforeScenario() throws MalformedURLException {
            startServer();
            AndroidSetUp();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot....");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","TrainingAppScenarios");
        }
        closeDriver();
        stopAppiumServer();
    }

}