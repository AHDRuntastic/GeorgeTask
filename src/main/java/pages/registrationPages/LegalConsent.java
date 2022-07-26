package pages.registrationPages;

import base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class LegalConsent extends PageBase {

    public LegalConsent(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "dataTransferSelection")
    public MobileElement extraLegalConsent1;

    @AndroidFindBy(id = "tosSelection")
    public MobileElement extraLegalConsent2;

    @AndroidFindBy(id = "privacyPolicySelection")
    public MobileElement extraLegalConsent3;

    @AndroidFindBy(id = "consentButton")
    public MobileElement consentBtn;

    @AndroidFindBy(id = "primaryButton")
    public MobileElement marketingConsent;



    public void setExtraLegalConsent1(){
        click(extraLegalConsent1);
    }

    public void setExtraLegalConsent2(){
        click(extraLegalConsent2);
    }

    public void setExtraLegalConsent3(){
        click(extraLegalConsent3);
    }

    public void setConsentBtn(){
        click(consentBtn);
    }

    public void setMarketingConsent(){

        click(marketingConsent);
    }

    public boolean setConsentExist(){

        return isExist(consentBtn);


    }

    public boolean setMarketingExist(){

        return isExist(marketingConsent);


    }


}