package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutPoolBuildingPermitPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPoolBuildingPermitReviewPage;
import com.uxcautomation.selenium.pageobjects.PoolBuildingPermitOrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PoolBuildingPermitStepDefs {

	private WebDriver driver;
	private List<Map<String, String>> pageData;
	private CheckoutPoolBuildingPermitPage checkoutPage;
	private CheckoutPoolBuildingPermitReviewPage finalReviewPage;
	private PoolBuildingPermitOrderConfirmationPage orderConfirmationPage;

	public PoolBuildingPermitStepDefs() {
		pageData = new ArrayList<>();
		driver = StepBaseSetup.driver;
		checkoutPage = PageFactory.initElements(driver, CheckoutPoolBuildingPermitPage.class);
		finalReviewPage = PageFactory.initElements(driver, CheckoutPoolBuildingPermitReviewPage.class);
		orderConfirmationPage = PageFactory.initElements(driver, PoolBuildingPermitOrderConfirmationPage.class);
	}

	@When("^user fills his work details$")
	public void userFillsHisWorkDetails(DataTable applicationDataTable) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": userFillsHisWorkDetails");
		List<Map<String, String>> applicationData = applicationDataTable.asMaps(String.class, String.class);
		pageData.addAll(applicationData);
		checkoutPage.enterUsersWorkDetails(applicationData);
	}

	@When("^user fills his personal information with valid data$")
	public void userFillsHisPersonalDetails(DataTable applicationDataTable) throws Throwable {
		StepBaseSetup
				.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": userFillsHisPersonalDetails");
		List<Map<String, String>> applicationData = applicationDataTable.asMaps(String.class, String.class);
		pageData.addAll(applicationData);
		checkoutPage.enterUsersPersonalDetails(applicationData);
	}

	@When("^user reviews pool building permit service product$")
	public void userReviewsTheRequest() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": userReviewsTheRequest");
		finalReviewPage.verifyReviewPage(pageData);
	}

	@When("^user submits pool build permit service request$")
	public void userSubmitsServiceRequest() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": userSubmitsServiceRequest");
		finalReviewPage.verifyIfUserCanPlaceOrder();
	}

	@Then("^pool building permit service request is submitted and user is redirected to confirmation page$")
	public void serviceRequestIsSubmittedSuccessfully() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": serviceRequestIsSubmittedSuccessfully");
		orderConfirmationPage.verifyPoolBuildingPermitConfirmationPage(pageData);
	}

}
