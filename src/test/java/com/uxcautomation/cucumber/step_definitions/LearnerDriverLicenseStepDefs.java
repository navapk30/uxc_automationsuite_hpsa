package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutRoadsAndVehiclesPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductDetailPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListBirthDeathMarriagePage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;
import com.uxcautomation.selenium.pageobjects.HomePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LearnerDriverLicenseStepDefs {

	WebDriver driver;
	HomePage homePage;
	DisplayProductListBirthDeathMarriagePage listingPage;
	DisplayProductDetailPage productDetailPage;
	CheckoutRoadsAndVehiclesPage checkoutPage;
	CheckoutFinalReviewPage finalReviewPage;
	DisplayProductListPage productListPage;
	List<Map<String, String>> pageData;

	public LearnerDriverLicenseStepDefs() {
		driver = StepBaseSetup.driver;

		homePage = StepBaseSetup.getPageObjectForClass(HomePage.class);
		pageData = new ArrayList<Map<String, String>>();
		productListPage = StepBaseSetup.getPageObjectForClass(DisplayProductListPage.class);
		listingPage = PageFactory.initElements(driver, DisplayProductListBirthDeathMarriagePage.class);
		checkoutPage = StepBaseSetup.getPageObjectForClass(CheckoutRoadsAndVehiclesPage.class);
		productDetailPage = PageFactory.initElements(driver, DisplayProductDetailPage.class);
		finalReviewPage = PageFactory.initElements(driver, CheckoutFinalReviewPage.class);
	}

	@When("^User clicks \"([^\"]*)\" button of \"([^\"]*)\" service$")
	public void user_clicks_button_of_service(String addToCartText, String serviceName) throws Throwable {
		StepBaseSetup
				.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_clicks_button_of_service");
		listingPage.verifyAddToCartTextAndAddServiceToCart(serviceName, addToCartText);
	}

	@Then("^User will fills the Applicant Details form with valid data$")
	public void user_will_fills_the_Applicant_Details_form_with_valid_data(DataTable applicationDetails)
			throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_will_fills_the_Applicant_Details_form_with_valid_data");
		List<Map<String, String>> parentData = applicationDetails.asMaps(String.class, String.class);
		pageData.addAll(parentData);
		checkoutPage.enterApplicantDetails(parentData);
	}

	@Then("^User will fills the License Details form with valid data$")
	public void user_will_fills_the_License_Details_form_with_valid_data(DataTable licenseDetails) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_will_fills_the_License_Details_form_with_valid_data");
		List<Map<String, String>> parentData = licenseDetails.asMaps(String.class, String.class);
		pageData.addAll(parentData);
		checkoutPage.enterLicenseDetails(parentData);
	}

	@Then("^User will fills the Health Details form with valid data$")
	public void user_will_fills_the_Health_Details_form_with_valid_data(DataTable healthDetails) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_will_fills_the_Health_Details_form_with_valid_data");
		List<Map<String, String>> parentData = healthDetails.asMaps(String.class, String.class);
		pageData.addAll(parentData);
		checkoutPage.enterHealthDetails(parentData);
	}

	@Then("^User reviews Learner Driver License service information$")
	public void user_reviews_Learner_Driver_License_service_information() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_reviews_Learner_Driver_License_service_information");
		checkoutPage.verifyIfAllInformationInReviewPageIsDisplayed(pageData);
	}

	@Then("^User accepts the consent declaration for Learner Driver Licence Service$")
	public void user_accepts_the_consent_declaration_for_the_service() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_accepts_the_consent_declaration_for_the_service");
		checkoutPage.acceptConsentDeclaration();
	}

	@When("^User submits the Learner Driver License form$")
	public void user_submits_the_Learner_Driver_License_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ": userSelectsAnAuser_submits_the_Learner_Driver_License_formpplicationTypeForWWCC");
		checkoutPage.placeOrder();
	}

	@When("^User should be able to see the error message that consent declaration is not selected$")
	public void user_should_be_able_to_see_the_error_message() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_should_be_able_to_see_the_error_message");
		checkoutPage.verifyIfConsentDeclarationErrorMessageIsShown();
	}

	@Then("^User is redirected to Learner Driver License confirmation page$")
	public void user_is_redirected_to_Learner_Driver_License_confirmation_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ": user_is_redirected_to_Learner_Driver_License_confirmation_page");
		checkoutPage.verifyIsConfirmationPageDisplayed();
	}

	@Then("^User verifies the information in confirmation page for Learner Driver Licence Service$")
	public void user_verifies_the_information_in_confirmation_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_verifies_the_information_in_confirmation_page");
		checkoutPage.verifyInformationOnConfirmationPageDisplayed();
	}

	@When("^User entered \"([^\"]*)\" \"([^\"]*)\" field as  \"([^\"]*)\"$")
	public void user_entered_field_as(String arg1, String arg2, String arg3) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_entered_field_as");
		checkoutPage.enterYFormData(arg1, arg3, arg2);
	}

	@Then("^User should be able to see the error message \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_error_message(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_should_be_able_to_see_the_error_message");
		checkoutPage.verifyErrorMessageForInvalidData(arg1);
	}

	@When("^User upload \"([^\"]*)\" file in the field \"([^\"]*)\"$")
	public void user_upload_file_in_the_field(String fileName, String fieldName) throws Throwable {
		StepBaseSetup
				.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_upload_file_in_the_field");
		checkoutPage.uploadInvalidFileInYForm(fileName, fieldName);
	}

	@When("^User clicks on next button in \"([^\"]*)\" yformPage$")
	public void user_clicks_on_next_button(String yformPageName) throws Throwable {
		StepBaseSetup
				.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_clicks_on_next_button");
		checkoutPage.waitTillYFormLoadingIconDisappears();
		checkoutPage.clickNext();
	}

	@Then("^User will get an error dialog message with error message \"([^\"]*)\"$")
	public void user_will_get_an_error_dialog_message_with_error_message(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_will_get_an_error_dialog_message_with_error_message");
		checkoutPage.verifyIfErrorDialogMessageIsShown(arg1);
	}

	@Then("^User clicks next button on \"([^\"]*)\" checkout page$")
	public void user_clicks_next_button_on_current_checkout_page(String checkoutPageName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_clicks_next_button_on_current_checkout_page");		
		Thread.sleep(1000);
		checkoutPage.clickNext();
	}

	@Then("^User \"([^\"]*)\" the primary address in shipping address page  for Learner Driver Licence Service$")
	public void user_the_primary_address_in_shipping_address_page(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_the_primary_address_in_shipping_address_page");
		checkoutPage.checkOrUncheckBoxForLabel("usePrimaryAddressShip");
	}

	@Then("^User fills the Shipment/Pickup location form with valid data for Learner Driver Licence Service$")
	public void user_will_fills_the_Shipment_Pickup_location_form_with_valid_data(DataTable shippingAddressData)
			throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()
				+ ": user_will_fills_the_Shipment_Pickup_location_form_with_valid_data");
		List<Map<String, String>> shippingData = shippingAddressData.asMaps(String.class, String.class);
		pageData.addAll(shippingData);
		checkoutPage.verifyIfShippingAddressStepIsDisplayedAndEnterAddress(shippingData);

	}

	@Then("^User selects an \"([^\"]*)\" from the Shipping Method page  for Learner Driver Licence Service$")
	public void user_selects_an_option_from_the_Shipping_Method_page(String deliveryMode) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_selects_an_option_from_the_Shipping_Method_page");
		checkoutPage.verifyIfShippingMethodStepIsDisplayedAndEnterShippingMethod(deliveryMode);
	}

	@Then("^User fills the Payment and Billing address form  for Learner Driver Licence Service$")
	public void user_fills_the_Payment_and_Billing_address_form(DataTable paymentDetails) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(
				CommonStepsDefs.scenario.getName() + ": user_fills_the_Payment_and_Billing_address_form");
		List<Map<String, String>> paymentInfo = paymentDetails.asMaps(String.class, String.class);
		pageData.addAll(paymentInfo);
		checkoutPage.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentInfo);
	}

}
