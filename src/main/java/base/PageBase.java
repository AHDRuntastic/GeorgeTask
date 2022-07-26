package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    public AppiumDriver<?> driver;
    WebDriverWait wait;
    AndroidTouchAction actions;


    /**
     *
     * This constructor method is to check initialize the driver based on the platform
     */
    public PageBase(AppiumDriver driver){

        this.driver = (AndroidDriver) driver;

    }


    /**
     *
     * This method is to wait for the element before an action
     * @param e
     */
    public void waitForElement(MobileElement e){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void scroll(){
        Dimension dimension = driver.manage().window().getSize();
        int startScroll = (int) (dimension.getHeight()* 0.8);
        int endScroll = (int) (dimension.getHeight()* -0.4);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0,startScroll))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(0,endScroll)).release().perform();

    }

    public void click (MobileElement e){
        waitForElement(e);
        e.click();
    }

    public void addText (MobileElement e, String string){
        waitForElement(e);
        e.sendKeys(string);
    }

    public  String getText(MobileElement e){
        waitForElement(e);
        String text = e.getText();
        return text;
    }

    public boolean isExist (MobileElement e){
        waitForElement(e);
        boolean result = e.isDisplayed();
        return result;
    }

}
