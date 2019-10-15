package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutWorkingWithChildrenCheckPage;
import com.uxcautomation.selenium.pageobjects.CheckoutWorkingWithChildrenCheckReviewPage;
import com.uxcautomation.selenium.pageobjects.WorkingWithChildrenOrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * WorkingWithChildrenCheck step definitions
 * 
 * @author pkumar350
 */
public class WorkingWithChildrenCheckStepDefs {

	private WebDriver driver;
	private CheckoutWorkingWithChildrenCheckPage checkoutCartPage;
	private List<Map<String, String>> pageData;
	private CheckoutWorkingWithChildrenCheckReviewPage finalReviewPage;
	private WorkingWithChildrenOrderConfirmationPage orderConfirmationPage;

	public WorkingWithChildrenCheckStepDefs() {
		pageData = new ArrayList<>();
		driver = StepBaseSetup.driver;
		checkoutCartPage = PageFactory.initElements(driver, CheckoutWorkingWithChildrenCheckPage.class);
		finalReviewPage = PageFactory.initElements(driver, CheckoutWorkingWithChildrenCheckReviewPage.class);
		orderConfirmationPage = PageFactory.initElements(driver, WorkingWithChildrenOrderConfirmationPage.class);
	}

	@When("^User selects \"(.*)\" from Application Type page$")
	public void userSelectsAnApplicationTypeForWWCC(String bundleOption) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": userSelectsAnApplicationTypeForWWCC");
		pageData.add(Collections.singletonMap("bundleOption", bundleOption));
		checkoutCartPage.selectBundleOption(bundleOption);
	}

	@When("^user fills the application and organisations details with valid data$")
	public void userFillsApplicationAndOrganizationDetails(DataTable applicationDataTable) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": userFillsApplicationAndOrganizationDetails");
		List<Map<String, String>> applicationData = applicationDataTable.asMaps(String.class, String.class);
		pageData.addAll(applicationData);
		checkoutCartPage.enterApplicationAndOrganisationDetails(applicationData);
	}

	@When("^user fills his personal details with valid data$")
	public void userFillsPersonalInformation(DataTable personalInfoTable) throws Throwable {
		StepBaseSetup
				.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": userFillsPersonalInformation");
		List<Map<String, String>> applicantsData = personalInfoTable.asMaps(String.class, String.class);
		pageData.addAll(applicantsData);
		checkoutCartPage.enterApplicantsPersonalInfo(applicantsData);
	}

	@When("^user reviews working with children check service product and agrees to consent declaration before submitting$")
	public void userReviewsTheRequestAndGivesHisConsent() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": userReviewsTheRequestAndGivesHisConsent");
		finalReviewPage.verifyReviewPage(pageData);
		finalReviewPage.agreeAllConsentDeclaration();
	}

	@When("^user reviews working with children check service product and doesnot accept the consent declaration before submitting$")
	public void userReviewsServiceRequestAndDoesntAcceptConsentDeclaration() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": userReviewsServiceRequestAndDoesntAcceptConsentDeclaration");
		finalReviewPage.verifyReviewPage(pageData);
	}

	@Then("^an error is displayed to the user$")
	public void errorDisplayedToTheUser() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": errorDisplayedToTheUser");
		checkoutCartPage.errorDisplayedToUser();
	}

	@Then("^service request is submitted and user is redirected to confirmation page$")
	public void serviceRequestIsSubmittedSuccessfully() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": serviceRequestIsSubmittedSuccessfully");
		orderConfirmationPage.verifyWorkingWithChildrenConfirmationPage(pageData);
	}
}
