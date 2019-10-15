/**
 * 
 */
package com.uxcautomation.cucumber.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.UserRegistrationPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author tarundeepsharma
 *
 */
public class UserRegistrationStepsDefs {
	WebDriver driver;
	UserRegistrationPage userRegistration;
	

	/**
	 * 
	 */
	public UserRegistrationStepsDefs() {
		driver = StepBaseSetup.driver;
	}

	@When("^Customer click on Registration Link$")
	public void customer_click_on_Registration_Link() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": customer_click_on_Registration_Link");
		userRegistration = StepBaseSetup.homePage.userRegistration();
		// Write code here that turns the phrase above into concrete actions
	
	}

	@Then("^Registration form will be displayed to Customer$")
	public void registration_form_will_be_displayed_to_Customer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": registration_form_will_be_displayed_to_Customer");
		userRegistration.verifyRegistrationFormDisplayed();
	}

	@And("^Customer will submit Registration form with valid information$")
	public void customer_will_submit_Registration_form_with_valid_information() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": customer_will_submit_Registration_form_with_valid_information");
		userRegistration.verifyRegistrationIsSubmitted();
	}

	@Then("^Customer will able to get Registered sucessfully$")
	public void customer_will_able_to_get_Registered_sucessfully() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": customer_will_able_to_get_Registered_sucessfully");
		userRegistration.verifyRegistrationIsSuccesfull();
		
	}
	


}
