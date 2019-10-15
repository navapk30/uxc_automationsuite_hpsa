package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPermitsAndApplicationPage;
import com.uxcautomation.selenium.pageobjects.CheckoutRoadsAndVehiclesPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductDetailPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListBirthDeathMarriagePage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPermitsAndApplicationsPage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.MarriageCertificateOrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisabledParkingPermitStepDefs {

	WebDriver driver;
	HomePage homePage;
	DisplayProductListPermitsAndApplicationsPage listingPage;
	DisplayProductDetailPage productDetailPage;
	CheckoutPermitsAndApplicationPage checkoutPage;
	MarriageCertificateOrderConfirmationPage orderConfirmationPage;
	
	DisplayProductListPage productListPage;
	List<Map<String, String>> pageData;

	public DisabledParkingPermitStepDefs() {
		driver = StepBaseSetup.driver;
		homePage = StepBaseSetup.getPageObjectForClass(HomePage.class);
		
		productListPage = StepBaseSetup.getPageObjectForClass(DisplayProductListPage.class);
		listingPage = StepBaseSetup.getPageObjectForClass(DisplayProductListPermitsAndApplicationsPage.class);
		checkoutPage = StepBaseSetup.getPageObjectForClass(CheckoutPermitsAndApplicationPage.class);
		orderConfirmationPage = StepBaseSetup.getPageObjectForClass(MarriageCertificateOrderConfirmationPage.class);
		productDetailPage = StepBaseSetup.getPageObjectForClass(DisplayProductDetailPage.class);
		
		pageData = new ArrayList<Map<String, String>>();
	}

	@Then("^User fills the Applicant Details form with valid data for disabled parking permit$")
	public void user_will_fills_the_Applicant_Details_form_with_valid_data(DataTable applicationDetails)
			throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ": user_will_fills_the_Applicant_Details_form_with_valid_data");
		List<Map<String, String>> PartnerData = applicationDetails.asMaps(String.class, String.class);
		pageData.addAll(PartnerData);
		checkoutPage.enterParkingPermitApplicantDetails(PartnerData);
	}

	@Then("^User fills the Medical Details form with valid data for disabled parking permit$")
	public void user_will_fills_the_Medical_Details_form_with_valid_data(DataTable Partner1Details) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ": user_will_fills_the_Medical_Details_form_with_valid_data");
		List<Map<String, String>> PartnerData = Partner1Details.asMaps(String.class, String.class);
		pageData.addAll(PartnerData);
		checkoutPage.enterMedicalDetails(PartnerData);
	}
	
	@Then("^User clicks next button on \"([^\"]*)\" checkout page for Disabled Parking Permit Service$")
	public void user_clicks_next_button_on_checkout_page_for_Disabled_Parking_Permit_Service(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_clicks_next_button_on_current_checkout_page");
		checkoutPage.clickNext();
	}

	@Then("^User reviews Disabled Parking Permit service information$")
	public void user_reviews_Disabled_Parking_Permit_service_information() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_reviews_Disabled_Parking_Permit_service_information");
		checkoutPage.verifyIfAllInformationInReviewPageIsDisplayed(pageData);
	}

	@Then("^User accepts the consent declaration for Disabled Parking Permit Service$")
	public void user_accepts_the_consent_declaration_for_the_service() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_accepts_the_consent_declaration_for_the_service");
		checkoutPage.acceptConsentDeclaration();
	}

	@When("^User submits the Disabled Parking Permit form$")
	public void user_submits_the_Learner_Driver_Partner1_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_submits_the_Learner_Driver_Partner1_form");
		checkoutPage.placeOrder();
	}

	@Then("^User is redirected to Disabled Parking Permit confirmation page$")
	public void user_is_redirected_to_Disabled_Parking_Permit_confirmation_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_is_redirected_to_Disabled_Parking_Permit_confirmation_page");
		checkoutPage.verifyIsConfirmationPageDisplayed();
	}

	@Then("^User verifies the information in confirmation page for Disabled Parking Permit Service$")
	public void user_verifies_the_information_in_confirmation_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_verifies_the_information_in_confirmation_page");
		orderConfirmationPage.verifyInformationOnConfirmationPageDisplayed();
	}

	@Then("^User \"([^\"]*)\" the primary address in shipping address page  for Disabled Parking Permit Service$")
	public void user_the_primary_address_in_shipping_address_page(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_the_primary_address_in_shipping_address_page");
		checkoutPage.checkOrUncheckBoxForLabel("usePrimaryAddressShip");
	}

	@Then("^User fills the Shipment/Pickup location form with valid data for Disabled Parking Permit Service$")
	public void user_will_fills_the_Shipment_Pickup_location_form_with_valid_data(DataTable shippingAddressData)
			throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_will_fills_the_Shipment_Pickup_location_form_with_valid_data");
		List<Map<String, String>> shippingData = shippingAddressData.asMaps(String.class, String.class);
		pageData.addAll(shippingData);
		checkoutPage.verifyIfShippingAddressStepIsDisplayedAndEnterAddress(shippingData);

	}

	@Then("^User selects an \"([^\"]*)\" from the Shipping Method page  for Disabled Parking Permit Service$")
	public void user_selects_an_option_from_the_Shipping_Method_page(String deliveryMode) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_selects_an_option_from_the_Shipping_Method_page");
		checkoutPage.verifyIfShippingMethodStepIsDisplayedAndEnterShippingMethod(deliveryMode);
	}

	@Then("^User fills the Payment and Billing address form  for Disabled Parking Permit Service$")
	public void user_fills_the_Payment_and_Billing_address_form(DataTable paymentDetails) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ":user_fills_the_Payment_and_Billing_address_form");
		List<Map<String, String>> paymentInfo = paymentDetails.asMaps(String.class, String.class);
		pageData.addAll(paymentInfo);
		checkoutPage.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentInfo);
	}

}
