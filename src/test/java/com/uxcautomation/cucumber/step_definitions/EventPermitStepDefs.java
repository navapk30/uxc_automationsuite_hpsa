package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutBundlePage;
import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPaymentBillingAddressPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPermitsAndApplicationPage;
import com.uxcautomation.selenium.pageobjects.EventPermitOrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EventPermitStepDefs {
	
	WebDriver driver;
	List<Map<String, String>> eventPermitPageData;
	CheckoutPermitsAndApplicationPage checkoutPage;
	CheckoutFinalReviewPage finalReviewPage; 
	EventPermitOrderConfirmationPage confirmationPage;
	CheckoutBundlePage bundlepage;
	CheckoutPaymentBillingAddressPage paymentPage;
	CheckoutBirthDeathsAndMarriagesPage birthPage;
	
	
	
	public EventPermitStepDefs(){
		driver = StepBaseSetup.driver;
		eventPermitPageData = new ArrayList<Map<String, String>>();
		checkoutPage=StepBaseSetup.getPageObjectForClass(CheckoutPermitsAndApplicationPage.class);	
		finalReviewPage=PageFactory.initElements(driver, CheckoutFinalReviewPage.class);
		confirmationPage=PageFactory.initElements(driver, EventPermitOrderConfirmationPage.class);
		bundlepage=PageFactory.initElements(driver, CheckoutBundlePage.class);
		paymentPage=PageFactory.initElements(driver, CheckoutPaymentBillingAddressPage.class);
		birthPage=PageFactory.initElements(driver, CheckoutBirthDeathsAndMarriagesPage.class);
	}
	
	@Then("^User selects \"([^\"]*)\" option from Event Permit page$")
	public void user_selects_option_from_Event_Permit_page(String bundleOption) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_selects_option_from_Event_Permit_page");
		System.out.println(CommonStepsDefs.scenario.getName()+": user_selects_option_from_Event_Permit_page");
		checkoutPage.selectBundleOption(bundleOption);  
	}
	
	@Then("^User selects \"([^\"]*)\" option from Event Permit page and can view second question$")
	public void user_selects_option_from_Event_Permit_page_and_can_view_second_question(String bundleOption) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_selects_option_from_Event_Permit_page_and_can_view_second_question");
		bundlepage.selectBundleOption(bundleOption);  
	}

	@Then("^User fills the Event Details form with valid data$")
	public void user_fills_the_Event_Details_form_with_valid_data(DataTable eventDetailsForm) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user fills event details form");
		List<Map<String, String>> eventDetailsData = eventDetailsForm.asMaps(String.class, String.class);
		eventPermitPageData.addAll(eventDetailsData);
		checkoutPage.enterEventDetails(eventDetailsData);
	}

	@Then("^User fills the Applicant Details form with valid data$")
	public void user_fills_the_Applicant_Details_form_with_valid_data(DataTable applicantDetailsForm) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user fills applicant details form");
		List<Map<String, String>> applicantDetailsData = applicantDetailsForm.asMaps(String.class, String.class);
		eventPermitPageData.addAll(applicantDetailsData);
		checkoutPage.enterApplicantDetails(applicantDetailsData);
	}
	
	@And("^User fills the Payment and Billing address form for event permit$")
	public void user_fills_the_payment_and_billing_address_form_for_event_permit(DataTable paymentForm) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user fills payment form for event permit");
		List<Map<String, String>> paymentAndBillingData = paymentForm.asMaps(String.class, String.class);
		eventPermitPageData.addAll(paymentAndBillingData);
		checkoutPage.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentAndBillingData);
	}

	@Then("^User can review event permit service request before submitting$")
	public void user_can_review_event_permit_service_request_before_submitting() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user reviews event permit");
		checkoutPage.verifyReviewPageForEventPermit(eventPermitPageData);
	}

	@Then("^User accepts the consent declaration for Event Permit Service request$")
	public void user_accepts_the_consent_declaration_for_Event_Permit_Service_request() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user accepts consent declaration for event permit");
		checkoutPage.acceptConsentDeclaration();
	}

	@When("^User submits the event permit form$")
	public void user_submits_the_event_permit_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user submits event permit");
		finalReviewPage.verifyIfUserCanPlaceOrder();
	}

	@Then("^User can view the confirmation page for event permit$")
	public void user_can_view_the_confirmation_page_for_event_permit() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user can view confirmation page for event permit");
		confirmationPage.verifyEventPermitConfirmationPageIsDisplayed(eventPermitPageData);
	}

	@Then("^User view alcohol question and selects \"([^\"]*)\" option from event page\\.$")
	public void user_view_alcohol_question_and_selects_option_from_event_page(String liquorBundleOption) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user can view alcohol question event permit");
//		checkoutPage.verifyAlcoholQuestion();
		checkoutPage.selectBundleOption(liquorBundleOption);
	}
	
	@Then("^User uses saved card for payment$")
	public void user_uses_saved_card_for_payment() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user uses saved card for payment");
		paymentPage.selectSavedCard();
	}
	
	@Then("^User does not select any option from Event Permit page and clicks on next button$")
	public void user_does_not_select_any_option_from_Event_Permit_page_and_clicks_on_next_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user does not selects any option for event permit");
		checkoutPage.eventPermitNextButton();
	}

	@Then("^User view error message on Event Permit page$")
	public void user_view_error_message_on_Event_Permit_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user can view error message event permit");
		checkoutPage.bundlePageErrorMessage();
	}
	
	@Then("^User leaves the Event deatils form empty and clicks on next button$")
	public void user_leaves_the_Event_deatils_form_empty_and_clicks_on_next_button() throws Throwable {

		Thread.sleep(1000);
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user leaves event details form empty");
		birthPage.registerABirthNextButton();
	}

	@Then("^User should be able to see the error message in event details form$")
	public void user_should_be_able_to_see_the_error_message_in_event_details_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user can view error message in event details form");
		checkoutPage.eventDetailsErrorMessage();
	}

	@Then("^User leaves the Applicant Details form empty and clicks on next button$")
	public void user_leaves_the_Applicant_Details_form_empty_and_clicks_on_next_button() throws Throwable {
	   
		Thread.sleep(3000);
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user leaves applicant details form empty");
		birthPage.registerABirthNextButton();
	}

	@Then("^User should be able to see the error message in Applicant details form$")
	public void user_should_be_able_to_see_the_error_message_in_Applicant_details_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user can view error message in applicant details form");
		checkoutPage.applicantDetailsErrorMessage();
	}
	
	@Then("^User does not accepts the consent declaration for Event Permit Service request$")
	public void user_does_not_accepts_the_consent_declaration_for_Event_Permit_Service_request() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_does_not_accepts_the_consent_declaration_for_Event_Permit_Service_request");
		finalReviewPage.verifyIfUserCanPlaceOrder();
	}

	@Then("^User can view the error message to accept the consent declaration$")
	public void user_can_view_the_error_message_to_accept_the_consent_declaration() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_does_not_accepts_the_consent_declaration_for_Event_Permit_Service_request");
		checkoutPage.verifyIfConsentDeclarationErrorMessageIsShown();
	}


}
