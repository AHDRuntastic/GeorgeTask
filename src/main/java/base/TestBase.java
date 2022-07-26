package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class TestBase extends AbstractTestNGCucumberTests  {
    public static AppiumDriver driver;
    public static AppiumDriverLocalService service;
    public static Process process;


    /**
     *
     * Method to automatically start the server and should exist in every test class
     */
    public void startServer()

    {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        //Set Capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("0.0.0.0");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();



    }


    /**
     *
     * Here The desired Capabilities are defined for both Platform iOS/Android
     */
    public void AndroidSetUp() throws MalformedURLException {


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("platformVersion","11.0");
        cap.setCapability("deviceName","Pixel 4 XL AHD");
        cap.setCapability("appPackage", "com.runtastic.android.results.lite");
        cap.setCapability("appActivity", "com.runtastic.android.results.MainActivity");
        cap.setCapability("app",System.getProperty("user.dir")+"/application/AdiTrainingApp.apk");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),cap);
    }

    public void closeDriver() throws IOException{

        if (null != driver){

            driver.quit();
        }
    }

    public static void stopAppiumServer() throws IOException {
        if (process != null) {
            process.destroy();
        }
        System.out.println("Appium server stop");
    }

}
