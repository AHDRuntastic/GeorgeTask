package pages.logoutPages;

import base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OnBoarding extends PageBase {

    public OnBoarding(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "questionnaireContinueCta")
    public MobileElement onBoardingBtn;


    @AndroidFindBy(id = "onboardingSuggestedPlanSkipOption")
    public MobileElement skipTP;

    public void setOnBoardingBtn1(){

        click(onBoardingBtn);
    }

    public void setOnBoardingBtn2(){
        click(onBoardingBtn);
    }

    public void setOnBoardingBtn3(){
        click(onBoardingBtn);
    }

    public void setSkipTP(){

        click(skipTP);
    }


}
