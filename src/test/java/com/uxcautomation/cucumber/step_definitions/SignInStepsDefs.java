/**
 * 
 */
package com.uxcautomation.cucumber.step_definitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.HomePageMobile;
import com.uxcautomation.selenium.pageobjects.LoginPage;
import com.uxcautomation.selenium.pageobjects.LoginPageMobile;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author tarundeepsharma
 *
 */
public class SignInStepsDefs {

	WebDriver driver;
	LoginPage login;
	HomePage homePage;
	// String baseUrl = loadConfig.getsiteUrl();

	/**
	 * @throws IOException
	 */
	public SignInStepsDefs() throws IOException {
		super();
		driver = StepBaseSetup.driver;
		
		if(StepBaseSetup.isMobileUI()){
			login = PageFactory.initElements(driver, LoginPageMobile.class); 
		} else {
			login = PageFactory.initElements(driver, LoginPage.class); 
		}
	}

	@Then("^Verify Login form will be displayed to Customer$")
	public void verify_Login_form_will_be_displayed_to_Customer() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": login_form_will_be_displayed_to_Customer");
		//login = PageFactory.initElements(driver, LoginPage.class);
		login.verifyLoginPageDisplayed();

	}

	@And("^Customer submit the login form with valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void customer_submit_the_login_form_with_valid_data(String arg1, String arg2) throws Throwable {

		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": customer_submit_the_login_form_with_valid_data");
		login.verifyIsLoginSuccessfullwithCorrectCredentials(arg1, arg2);
	}

	@Then("^Customer will be in Signed in state$")
	public void customer_will_be_in_Signed_in_state() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	// Invalid login steps
	@And("^Customer submit the login form with invalid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void customer_submit_the_login_form_with_invalid_credentials(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": customer_submit_the_login_form_with_valid_credentials");
		login.verifyIsLoginNotSuccessfulwithBadCredentials(arg1, arg2);
	}

	@Then("^Customer will not be in Signed in state$")
	public void customer_will_not_be_in_Signed_in_state() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": customer_will_not_be_in_Signed_in_state");
		try {
			Assert.assertEquals("Your email address or password was incorrect.", login.getStringErrorMessageFromErrorDiv(login.loginErrorField2));
		} catch (Error e) {
 
			login.parseErrorMessageLog(e.toString());
		}
	}
}
