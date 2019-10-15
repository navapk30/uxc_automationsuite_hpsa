package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutSignupLoginPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductDetailPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListBirthDeathMarriagePage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.RegisterABirthOrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterABirthStepDefs {
	
	WebDriver driver;
	HomePage homePage;
	DisplayProductListBirthDeathMarriagePage listingPage;
	DisplayProductDetailPage productDetailPage;
	CheckoutBirthDeathsAndMarriagesPage checkoutPage;
	CheckoutFinalReviewPage finalReviewPage;
	DisplayProductListPage productListPage;
	List<Map<String, String>> pageData;
	CheckoutSignupLoginPage guestCheckout;
	RegisterABirthOrderConfirmationPage confirmationPage;
	
	public RegisterABirthStepDefs() {
		driver = StepBaseSetup.driver;
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		pageData = new ArrayList<Map<String, String>>();
		//productListPage = StepBaseSetup.getPageObjectForClass("DisplayProductListPage");
		productListPage=PageFactory.initElements(driver, DisplayProductListPage.class);
		listingPage=PageFactory.initElements(driver, DisplayProductListBirthDeathMarriagePage.class);
		checkoutPage=StepBaseSetup.getPageObjectForClass(CheckoutBirthDeathsAndMarriagesPage.class);
		productDetailPage=PageFactory.initElements(driver, DisplayProductDetailPage.class);
		finalReviewPage=PageFactory.initElements(driver, CheckoutFinalReviewPage.class);
		guestCheckout=StepBaseSetup.getPageObjectForClass(CheckoutSignupLoginPage.class);
		confirmationPage=PageFactory.initElements(driver, RegisterABirthOrderConfirmationPage.class);
	}
	
	@Then("^verify PLP page with title \"([^\"]*)\"  will be displayed$")
	public void verify_PLP_page_with_title_will_be_displayed(String categoryName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_click_on_from_Top_menu");
		productListPage.verifyIsNavigatedToPLPPage(categoryName);
	    
	}

	@When("^User clicks Register a Birth Product button$")
	public void user_clicks_Register_a_Birth_Product_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_Register_a_Birth_Product_button");
		listingPage.addServiceToCartFromPLP("register-birth");
	}
	
	@Then("^User selects \"([^\"]*)\" option from Registration Options page$")
	public void user_selects_option_from_Registration_Options_page(String option) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_selects_option_from_Registration_Options_page");
		if(option.equalsIgnoreCase("two birth certificate"))
			checkoutPage.selectBundleOption("birthcert-print2-addon");
		else
			checkoutPage.selectBundleOption("none-birthcert-noprint-addon");
	}

	@Then("^User fills the Child Details form with valid data$")
	public void user_will_fills_the_Child_Details_form_with_valid_data(DataTable childDeatilsFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_fills_the_Child_Details_form_with_valid_data");
		List<Map<String, String>> childData = childDeatilsFormData.asMaps(String.class, String.class);
		pageData.addAll(childData);
		checkoutPage.enterRegisterBirthChildDetails(childData);
		
	}

	@Then("^User fills the Parent1 Details form with valid data$")
	public void user_will_fills_the_Parent1_Details_form_with_valid_data(DataTable parent1DetailsFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_fills_the_Parent1_Details_form_with_valid_data");
		List<Map<String, String>> parent1Data= parent1DetailsFormData.asMaps(String.class, String.class);
		pageData.addAll(parent1Data);
		checkoutPage.enterRegisterBirthParent1Details(parent1Data);
	}
	
	@Then("^User fills the Parent2 Details form with valid data$")
	public void user_will_fills_the_Parent2_Details_form_with_valid_data(DataTable parent2DetailsFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_fills_the_Parent2_Details_form_with_valid_data");
		List<Map<String, String>> parent2Data= parent2DetailsFormData.asMaps(String.class, String.class);
		pageData.addAll(parent2Data);
		if(parent2Data.get(0).get("Parent2IsUnknown").equals("True"))
			checkoutPage.parent2Unknown();
		else
		checkoutPage.enterRegisterBirthParent2Details(parent2Data);
	}


	@Then("^User fills the Shipment/Pickup location form with valid data$")
	public void user_will_fills_the_Shipment_Pickup_location_form_with_valid_data(DataTable shippingAddressData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_fills_the_Shipment_Pickup_location_form_with_valid_data");
		List<Map<String, String>> shippingData= shippingAddressData.asMaps(String.class, String.class);
		pageData.addAll(shippingData);
		checkoutPage.verifyIfShippingAddressStepIsDisplayedAndEnterAddress(shippingData);
	  
	}

	@Then("^User selects an \"([^\"]*)\" from the Shipping Method page$")
	public void user_selects_an_option_from_the_Shipping_Method_page(String deliveryMode) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_selects_an_option_from_the_Shipping_Method_page");
		checkoutPage.verifyIfShippingMethodStepIsDisplayedAndEnterShippingMethod(deliveryMode);
	}

	@Then("^User \"([^\"]*)\" the primary address in shipping address page for register a birth$")
	public void user_the_primary_address_in_shipping_address_page_for_register_a_birth(String usePrimaryAddressCheckbox) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_the_primary_address_in_shipping_address_page_for_register_a_birth");
		checkoutPage.checkOrUncheckBoxForLabel("usePrimaryAddressShip");
	}
	
	@Then("^User fills the Payment and Billing address form$")
	public void user_fills_the_Payment_and_Billing_address_form(DataTable paymentDetails) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_fills_the_Payment_and_Billing_address_form");
		List<Map<String, String>> paymentInfo= paymentDetails.asMaps(String.class, String.class);
		pageData.addAll(paymentInfo);
		checkoutPage.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentInfo);
	}
	
	@Then("^User can review register a birth service product before submitting$")
	public void user_reviews_register_a_birth_service_product_before_submitt(){
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_reviews_register_a_birth_service_product_before_submitt");
		checkoutPage.verifyReviewPage(pageData);
	}

	@When("^User submits the Regsiter a Birth form$")
	public void user_submits_the_Regsiter_a_Birth_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_submits_the_Regsiter_a_Birth_form");
		finalReviewPage.verifyIfUserCanPlaceOrder();
	}
	

     @Then("^User does a Guest login with \"([^\"]*)\" and \"([^\"]*)\"$")
     public void user_does_a_Guest_login_with_and(String guestEmailAddress, String guestConfirmEmailAddress) throws Throwable {
    	 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_does_a_Guest_login");
    	 guestCheckout.doGuestLogin(guestEmailAddress, guestConfirmEmailAddress);
    }
     
     @Then("^User can view the confirmation page$")
     public void user_can_view_the_confirmation_page() throws Throwable {
    	 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_can_view_the_confirmation_page");
    	 confirmationPage.registerABirthConfirmationPage(pageData);
     }
     
     @Then("^User does not selects a option from Registration Options page and clicks on next button$")
     public void user_does_not_selects_a_option_from_Registration_Options_page_and_clicks_on_next_button() throws Throwable {
    	 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_does_not_selects_a_option_from_Registration_Options_page");
    	 checkoutPage.registerABirthNextButton();
     }

     @Then("^User should be able to see the error message\\.$")
     public void user_should_be_able_to_see_the_error_message() throws Throwable {
    	 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_should_be_able_to_see_the_error_message");
    	 checkoutPage.bundlePageErrorMessage();
     }
     
     @Then("^User leaves the Child deatils form empty and clicks on next button$")
     public void user_leaves_the_Child_deatils_form_empty_and_clicks_on_next_button() throws Throwable {
    	 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_leaves_the_Child_deatils_form_empty");
    	 checkoutPage.registerABirthNextButton(); 
     }

     @Then("^User should be able to see the error message in child details form$")
     public void user_should_be_able_to_see_the_error_message_in_child_details_form() throws Throwable {
    	 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_should_be_able_to_see_the_error_message_in_child_details_form");
    	 checkoutPage.childDetailsErrorMessage();
     }

     @Then("^User clicks on saved card button$")
     public void user_clicks_on_saved_card_button() throws Throwable {
    	 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_saved_card_button");
    	 checkoutPage.verifyIfPaymentStepIsDisplayedAndUseSavedCard();
     }

}
