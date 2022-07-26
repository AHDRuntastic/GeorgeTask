package cucumber.stepDefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.logoutPages.MoreTab;
import pages.logoutPages.OnBoarding;
import pages.registrationPages.LegalConsent;
import pages.registrationPages.Registration;

public class MyStepdefs extends TestBase {
    Registration registration;
    LegalConsent legalConsent;
    OnBoarding onBoarding;
    MoreTab moreTab;

    public void definingObj() {
        registration = new Registration(driver);
        legalConsent = new LegalConsent(driver);
        onBoarding = new OnBoarding(driver);
        moreTab = new MoreTab(driver);
    }


    @Given("Fresh app installed")
    public void freshAppInstalled() {
        definingObj();
        registration.setJourneyBtn();


    }

    @And("Registration page is shown to the new user")
    public void registrationPageIsShownToTheNewUser() {
        registration.setSignupBtn();
    }

    @And("The user's mandatory data {string}, {string}, {string}, {string}  added correctly")
    public void theUserSMandatoryDataAddedCorrectly(String FirstName, String LastName, String Email, String Password) throws InterruptedException {
        registration.setFName(FirstName);
        registration.setlName(LastName);
        registration.setEmail(Email);
        registration.setPassword(Password);
        registration.setBirthdate();
    }

    @When("The user taps on the register option")
    public void theUserTapsOnTheRegisterOption() {
        registration.setJoinBtn();
    }

    @Then("Extra legal consents are shown")
    public void extraLegalConsentsAreShown() {
        legalConsent.setExtraLegalConsent1();
        legalConsent.setExtraLegalConsent2();
        legalConsent.setExtraLegalConsent3();
        Assert.assertEquals(legalConsent.setConsentExist(),true);

        legalConsent.setConsentBtn();
    }

    @And("The marketing consent is shown")
    public void theMarketingConsentIsShown() {
        Assert.assertEquals(legalConsent.setMarketingExist(),true);
        legalConsent.setMarketingConsent();
    }

    @Given("The user registered new account")
    public void theUserRegisteredNewAccount() {
        definingObj();
        onBoarding.setOnBoardingBtn1();
        onBoarding.setOnBoardingBtn2();
        onBoarding.setOnBoardingBtn3();
        onBoarding.setSkipTP();

    }

    @And("The more tab is shown to the user")
    public void theMoreTabIsShownToTheUser() throws InterruptedException {
        Thread.sleep(6000);
        moreTab.setMoreTab();
        moreTab.scroll();
    }

    @When("The user taps on the logout option")
    public void theUserTapsOnTheLogoutOption() {

        moreTab.setScroll();
        moreTab.setLogout();
    }

    @Then("The user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        Assert.assertEquals(registration.setJourneyBtn1(),true);

    }
}
