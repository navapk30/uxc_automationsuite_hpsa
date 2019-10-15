/**
 * 
 */
package com.uxcautomation.cucumber.step_definitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.LoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author tarundeepsharma
 *
 */
public class CommonStepsDefs {

	WebDriver driver;
	LoginPage login;
	// HomePage homePage;
	// HomePageMobile homePageMobile;
	// String baseUrl = loadConfig.getsiteUrl();
	public static Scenario scenario;

	private CheckoutFinalReviewPage finalReviewPage;



	/**
	 * @throws IOException
	 */
	public CommonStepsDefs() throws IOException {
		driver = StepBaseSetup.driver;
		System.out.println("Mobile Device: " + StepBaseSetup.isMobileUI());
		finalReviewPage = PageFactory.initElements(driver, CheckoutFinalReviewPage.class);
	}

	@Given("^Customer is on homepage of site$")
	public void navigateToSite() throws Throwable {

		StepBaseSetup.updateSauceTestCaseNameMethod("navigateToSite");
		System.out.println(StepBaseSetup.baseUrl);
		driver.get(StepBaseSetup.baseUrl);
		//driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(480, 640));
//		driver.get("javascript:document.getElementById('overridelink').click();");
	}

	@When("^Customer click on Signin Link$")
	public void clickOnSignIn() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod("clickOnSignIn");

		login = StepBaseSetup.homePage.goToLoginPage();
	}

	@When("^user submits service request$")
	public void userSubmitsServiceRequest() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": userSubmitsServiceRequest");
		finalReviewPage.verifyIfUserCanPlaceOrder();
	}

	@Then("^an payment info error is displayed to the user$")
	public void noPaymentInfoErrorDisplayedToUser() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": noPaymentInfoErrorDisplayedToUser");
		finalReviewPage.verifyPaymentInfoErrorIsDisplayed();
	}

	@Then("^user will be intimated to accept consent declaration$")
	public void userIntimatedToAcceptConsentDeclaration() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": userIntimatedToAcceptConsentDeclaration");
		finalReviewPage.verifyConsentDeclarationErrorIsDisplayed();
	}
}
