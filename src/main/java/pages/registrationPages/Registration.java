package pages.registrationPages;

import io.appium.java_client.AppiumDriver;
import base.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;


public class Registration extends PageBase {

    public Registration(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id="startJourneyButton")
    public MobileElement journeyBtn;

    @AndroidFindBy(id="mail_sign_up_button")
    public MobileElement signupBtn;

    @AndroidFindBy(id = "firstName")
    public MobileElement fName;

    @AndroidFindBy(id = "lastName")
    public MobileElement lName;

    @AndroidFindBy(id = "email")

    public MobileElement email;

    @AndroidFindBy(id = "password")
    public MobileElement password;

    @AndroidFindBy(id = "birthdatePicker")
    public MobileElement birthdate;

    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText")
    public MobileElement birthdate2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    public MobileElement birthdate3;

    @AndroidFindBy(id = "joinButton")
    public MobileElement joinBtn;

    public void setJourneyBtn(){
        click(journeyBtn);
    }

    public void setSignupBtn(){
        click(signupBtn);
    }

    public void setFName(String FirstName){
        addText(fName, FirstName);
    }

    public void setlName(String LastName){
        addText(lName, LastName);
    }

    public void setEmail(String Email){
        addText(email, Email);
    }

    public void setPassword(String Password){
        addText(password, Password);
    }




    public void setBirthdate() throws InterruptedException {
        click(birthdate);
        click(birthdate2);
        addText(birthdate2,"2000");
        Thread.sleep(3000);
        addText(birthdate2,"2000");
        //click(birthdate2);
        click(birthdate3);
    }

    public void setJoinBtn(){
        click(joinBtn);
    }

    public boolean setJourneyBtn1(){

       return isExist(journeyBtn);


    }

}
