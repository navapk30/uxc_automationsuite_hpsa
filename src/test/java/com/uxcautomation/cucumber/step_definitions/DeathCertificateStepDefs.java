package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPaymentBillingAddressPage;
import com.uxcautomation.selenium.pageobjects.DeathCertificateOrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeathCertificateStepDefs {
	
	WebDriver driver;
	List<Map<String, String>> deathCertificatePageData;
	CheckoutBirthDeathsAndMarriagesPage checkoutPage;
	CheckoutFinalReviewPage finalReviewPage; 
	DeathCertificateOrderConfirmationPage orderConfirmationPage;
	CheckoutPaymentBillingAddressPage paymentPage;
	CheckoutBirthDeathsAndMarriagesPage birthPage;
		
	public DeathCertificateStepDefs(){
		driver = StepBaseSetup.driver;
		deathCertificatePageData = new ArrayList<Map<String, String>>();
		checkoutPage=PageFactory.initElements(driver, CheckoutBirthDeathsAndMarriagesPage.class);
		finalReviewPage=PageFactory.initElements(driver, CheckoutFinalReviewPage.class);
		orderConfirmationPage=PageFactory.initElements(driver, DeathCertificateOrderConfirmationPage.class);
		paymentPage=PageFactory.initElements(driver, CheckoutPaymentBillingAddressPage.class);
		birthPage=PageFactory.initElements(driver, CheckoutBirthDeathsAndMarriagesPage.class);
	}
	
	@Then("^User fills the Deceased Details form with valid data$")
	public void user_fills_the_Deceased_Details_form_with_valid_data(DataTable deceasedDetailsFom) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": User fills the Deceased Details form");
		List<Map<String, String>> deceasedDetailsData = deceasedDetailsFom.asMaps(String.class, String.class);
		deathCertificatePageData.addAll(deceasedDetailsData);
		checkoutPage.enterDeceasedDetails(deceasedDetailsData);
	}

	@Then("^User fills the Applicant Details form with valid data for Death Certificate$")
	public void user_fills_the_Applicant_Details_form_with_valid_data_for_Death_Certificate(DataTable applicantDetailsForm) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": User fills the Deceased Details form");
		List<Map<String, String>> applicantDetailsData = applicantDetailsForm.asMaps(String.class, String.class);
		deathCertificatePageData.addAll(applicantDetailsData);
		checkoutPage.enterApplicantDetails(applicantDetailsData);
	}
	
	@Then("^User \"([^\"]*)\" the primary address in shipping address page for Death Certificate$")
	public void user_the_primary_address_in_shipping_address_page(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_unchecks_primary_address_in_shipping_address_page");
		checkoutPage.checkOrUncheckBoxForLabel("usePrimaryAddressShip");
	}

	@Then("^User fills the Shipment/Pickup location form with valid data for Death Certificate$")
	public void user_fills_the_Shipment_Pickup_location_form_with_valid_data_for_Death_Certificate(DataTable shippingAddressData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_fills_the_Shipment_Pickup_location_form_for_Death_Certificate");
		List<Map<String, String>> shippingData= shippingAddressData.asMaps(String.class, String.class);
		deathCertificatePageData.addAll(shippingData);
		checkoutPage.verifyIfShippingAddressStepIsDisplayedAndEnterAddress(shippingData);
	}

	@Then("^User selects an \"([^\"]*)\" from the Shipping Method page for Death Certificate$")
	public void user_selects_an_from_the_Shipping_Method_page_for_Death_Certificate(String deliveryMode) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_selects_an_option_from_the_Shipping_Method_page_for_death_certificate");
		checkoutPage.verifyIfShippingMethodStepIsDisplayedAndEnterShippingMethod(deliveryMode);
	}

	@Then("^User fills the Payment and Billing address form for Death Certificate$")
	public void user_fills_the_Payment_and_Billing_address_form_for_Death_Certificate(DataTable paymentDetails) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_fills_the_Payment_and_Billing_address_form");
		List<Map<String, String>> paymentInfo= paymentDetails.asMaps(String.class, String.class);
		deathCertificatePageData.addAll(paymentInfo);
		checkoutPage.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentInfo);
	}

	@Then("^User can review Death Certificate service request before submitting$")
	public void user_can_review_Death_Certificate_service_request_before_submitting() throws Throwable {
		checkoutPage.verifyIfAllInformationInReviewPageIsDisplayed();
	}

	@Then("^User accepts the consent declaration for Death Certificate Service request$")
	public void user_accepts_the_consent_declaration_for_Death_Certificate_Service_request() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_accepts_consent_declaration_for_the_Death_Certificate_service");
		checkoutPage.acceptConsentDeclaration();
	}

	@When("^User submits the Death Certificate form$")
	public void user_submits_the_Death_Certificate_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user submits death certficate");
		finalReviewPage.verifyIfUserCanPlaceOrder();
	}

	@Then("^User can view the confirmation page for Death Certificate$")
	public void user_can_view_the_confirmation_page_for_Death_Certificate() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": Death Certicate Confirmation page");
		orderConfirmationPage.verifyDeathCertificateConfirmationPageIsDisplayed(deathCertificatePageData);
	}
	
	@Then("^User clicks next button on \"([^\"]*)\" checkout page for Death Certificate$")
	public void user_clicks_next_button_on_checkout_page_for_Death_Certificate(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_clicks_next_button_on_current_checkout_page");
		checkoutPage.clickNext();
	}

	@Then("^User uses saved card for payment for Death Certificate$")
	public void user_uses_saved_card_for_payment_for_Death_Certificate() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user uses saved card for payment");
		paymentPage.selectSavedCard();
	}
	
	@Then("^User can view the error message$")
	public void user_can_view_the_error_message() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user van view error message");
		checkoutPage.futureDeathDateError();
	}
	
	@Then("^User leaves the Deceased Details form empty and clicks on next button$")
	public void user_leaves_the_Deceased_Details_form_empty_and_clicks_on_next_button() throws Throwable {
		Thread.sleep(1000);
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user leaves deceased details form empty");
		birthPage.registerABirthNextButton();
	}

	@Then("^User should be able to see the error message in Deceased Details form$")
	public void user_should_be_able_to_see_the_error_message_in_Deceased_Details_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user van view error message in deceased details");
		checkoutPage.deceasedDetailsErrorMessage();
	}
	
	@Then("^User leaves the Applicant Details form for death certificate empty and clicks on next button$")
	public void user_leaves_the_Applicant_Details_form_for_death_certificate_empty_and_clicks_on_next_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user leaves applicant details form empty");
		birthPage.registerABirthNextButton();
	}

	@Then("^User should be able to see the error message in Applicant Details form$")
	public void user_should_be_able_to_see_the_error_message_in_Applicant_Details_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user van view error message in applicant details");
		checkoutPage.applicaDetailsErrorMessage();
	}

}