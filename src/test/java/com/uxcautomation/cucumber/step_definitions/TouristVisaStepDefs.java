package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPaymentBillingAddressPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPermitsAndApplicationPage;
import com.uxcautomation.selenium.pageobjects.TouristVisaOrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TouristVisaStepDefs {
	
	WebDriver driver;
	List<Map<String, String>> touristVisaPageData;
	CheckoutPermitsAndApplicationPage checkoutPage;
	CheckoutPaymentBillingAddressPage paymentPage;
	CheckoutFinalReviewPage finalReviewPage;
	TouristVisaOrderConfirmationPage confirmationPage;
	CheckoutBirthDeathsAndMarriagesPage birthPage;
	
	public TouristVisaStepDefs(){
		
		driver = StepBaseSetup.driver;
		touristVisaPageData = new ArrayList<Map<String, String>>();
		checkoutPage=StepBaseSetup.getPageObjectForClass(CheckoutPermitsAndApplicationPage.class);	
		paymentPage=PageFactory.initElements(driver, CheckoutPaymentBillingAddressPage.class);
		finalReviewPage=PageFactory.initElements(driver, CheckoutFinalReviewPage.class);
		confirmationPage=PageFactory.initElements(driver, TouristVisaOrderConfirmationPage.class);
		birthPage=PageFactory.initElements(driver, CheckoutBirthDeathsAndMarriagesPage.class);
	}

	@Then("^User fills the Applicant Details form under tourist visa with valid data$")
	public void user_fills_the_Applicant_Details_form_under_tourist_visa_with_valid_data(DataTable applicantDetailsFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_fills_the_Applicant_Details_for_tourist_visa");
		List<Map<String, String>> applicantDetailsData = applicantDetailsFormData.asMaps(String.class, String.class);
		touristVisaPageData.addAll(applicantDetailsData);
		checkoutPage.enterTouristVisaApplicantDetails(applicantDetailsData);
	}
	
	@Then("^User fills the Applicantion Details form with valid data$")
	public void user_fills_the_Applicantion_Details_form_with_valid_data(DataTable applicationDetailsFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_fills_the_Applicantion_Details_for_tourist_visa");
		List<Map<String, String>> applicantionDetailsData = applicationDetailsFormData.asMaps(String.class, String.class);
		touristVisaPageData.addAll(applicantionDetailsData);
		checkoutPage.enterTouristVisaApplicantionDetails(applicantionDetailsData);
	}
	
	@Then("^User fills the Health&Character form with valid data$")
	public void user_fills_the_Health_Character_form_with_valid_data(DataTable healthCharacterFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_fills_the_Health_Details_for_tourist_visa");
		List<Map<String, String>> healthCharacterDetailsData = healthCharacterFormData.asMaps(String.class, String.class);
		touristVisaPageData.addAll(healthCharacterDetailsData);
		checkoutPage.enterTouristVisaHealthAndCharacterDetails(healthCharacterDetailsData);
	}

	@Then("^User fills the Payment and Billing address form for Tourist Visa$")
	public void user_fills_the_Payment_and_Billing_address_form_for_Tourist_Visa(DataTable paymentForm) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_fills_the_PaymentAndBillingForm_for_tourist_visa");
		List<Map<String, String>> paymentAndBillingData = paymentForm.asMaps(String.class, String.class);
		touristVisaPageData.addAll(paymentAndBillingData);
		checkoutPage.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentAndBillingData);
	}

	@Then("^User can review tourist visa service request before submitting$")
	public void user_can_review_tourist_visa_service_request_before_submitting() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_can_review_tourist_visa_service_request_before_submitting");
		checkoutPage.verifyReviewPageForTouristVisa(touristVisaPageData);
	}

	@When("^User submits the tourist visa form$")
	public void user_submits_the_tourist_visa_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_submits_the_tourist_visa_form");
		finalReviewPage.verifyIfUserCanPlaceOrder();
	}

	@Then("^User can view the confirmation page for tourist visa$")
	public void user_can_view_the_confirmation_page_for_tourist_visa() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_can_view_the_confirmation_page_for_tourist_visa");
		confirmationPage.verifyTouristVisaConfirmationPageIsDisplayed(touristVisaPageData);
	}
	
	@Then("^User uses saved card for paying Tourist Visa$")
	public void user_uses_saved_card_for_paying_Tourist_Visa() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_uses_saved_card_for_paying_Tourist_Visa");
		paymentPage.selectSavedCard();
	}
	@Then("^User leaves Applicant Details form empty and clicks on next button$")
	public void user_leaves_Applicant_Details_form_empty_and_clicks_on_next_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_leaves_Applicant_Details_form_empty");
		birthPage.registerABirthNextButton();
	}
	
	@Then("^User should be able to see the error message in applicant details form$")
	public void user_should_be_able_to_see_the_error_message_in_applicant_details_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_sees_error_message_in_applicant_details_form");
		checkoutPage.applicantDetailErrorMessage();
	}
	
	@Then("^User should be able to see \"([^\"]*)\" error message$")
	public void user_should_be_able_to_see_error_message(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_should_be_able_to_see_error_message");
		checkoutPage.dobErrorMessage();
	}


}
