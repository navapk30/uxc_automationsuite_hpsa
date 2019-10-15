package com.uxcautomation.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutReportAnIssuePage;
import com.uxcautomation.selenium.pageobjects.DisplayProductDetailPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListReportAnIssuePage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.OrderConfirmationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportGraffitiUserStepDefs {

	WebDriver driver;
	HomePage homePage;
	DisplayProductListReportAnIssuePage listingPage;
	DisplayProductDetailPage productDetailPage;
	CheckoutReportAnIssuePage checkoutPage;
	OrderConfirmationPage orderPage;
	DisplayProductListPage productListPage;
	List<Map<String, String>> pageData;

	public ReportGraffitiUserStepDefs() {
		driver = StepBaseSetup.driver;
		pageData = new ArrayList<Map<String, String>>();
		// homePage = PageFactory.initElements(driver, HomePage.class);
		listingPage = PageFactory.initElements(driver, DisplayProductListReportAnIssuePage.class);
		checkoutPage = PageFactory.initElements(driver, CheckoutReportAnIssuePage.class);
		productDetailPage = PageFactory.initElements(driver, DisplayProductDetailPage.class);
		orderPage = PageFactory.initElements(driver, OrderConfirmationPage.class);
		// productListPage =
		// StepBaseSetup.getPageObjectForClass("DisplayProductListPage");
		productListPage = PageFactory.initElements(driver, DisplayProductListPage.class);
	}

	@When("^user click on \"([^\"]*)\" from Top menu$")
	public void user_click_on_from_Top_menu(String productName) throws Throwable {
		 StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_click_on_from_Top_menu");
		productListPage = StepBaseSetup.homePage.goToProductListingPage(productName);
		// homePage.goToProductListingPage(productName);
	}

	@Then("^verify PLP page with \"([^\"]*)\" will be displayed$")
	public void verify_PLP_page_with_will_be_displayed(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": verify_PLP_page_with_will_be_displayed");
		productListPage.verifyIsNavigatedToPLPPage(arg1);

	}

	@When("^User clicks \"([^\"]*)\" Product button$")
	public void user_clicks_Product_button(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_Product_button");
		productListPage.addServiceToCartFromPLP(arg1);
		// listingPage.addServiceToCartFromPLP(arg1);
	}

	@Then("^User will fill the form with data$")
	public void user_will_fill_the_form_with_data(DataTable yFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_fill_the_form_with_data");
		List<Map<String, String>> epiData = yFormData.asMaps(String.class, String.class);
		pageData.addAll(epiData);
		checkoutPage.reportAnIssueFillYformPage(epiData);

	}
	@Then("^User will fill the form with pothole data$")
	public void user_will_fill_the_form_with_pothole_data(DataTable yFormData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_fill_the_form_with_data");
		List<Map<String, String>> epiData = yFormData.asMaps(String.class, String.class);
		pageData.addAll(epiData);
		checkoutPage.reportAnIssueFillYformPagePothole(epiData);

	}
	@Then("^Verify Email and Name fields are hidden$")
	public void verify_Email_and_Name_fields_are_hidden() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": verify_Email_and_Name_fields_are_hidden");
		checkoutPage.reportAnIssueKeepUpdateCheckFalse();
	}

	@When("^User will submit the form$")
	public void user_will_submit_the_form() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_submit_the_form");
		checkoutPage.clickOnReportAnIssueCheckoutCartButton();
	}

	@Then("^User will be redirected to Confirmation page with \"([^\"]*)\" message and correct data$")
	public void user_will_be_redirected_to_Confirmation_page_with_message_and_following_data(String serviceProduct)
			throws Throwable {
		StepBaseSetup.
		updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_be_redirected_to_Confirmation_page_with_message_and_following_data");
		// List<Map<String, String>>
		// dataToCompare=yFormData.asMaps(String.class, String.class);
		orderPage.verifyReportGraffitiConfirmationPage(pageData);
	}

	@Then("^user will be redirected to Confirmation page with Success Message$")
	public void user_will_be_redirected_to_Confirmation_page_with_Success_Message() throws Throwable {
		StepBaseSetup.
		updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_will_be_redirected_to_Confirmation_page_with_Success_Message");
		checkoutPage.verifyIsConfirmationPageDisplayed();
	}

	@Then("^Verify Email and Name fields are visible$")
	public void verify_Email_and_Name_fields_are_visible() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": verify_Email_and_Name_fields_are_visible");
		checkoutPage.reportAnIssueKeepUpdateCheckFalse();
	}

	@Then("^user can fill Email and Name$")
	public void user_can_fill_Email_and_Name(DataTable updateFieldData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_can_fill_Email_and_Name");
		List<Map<String, String>> updateData = updateFieldData.asMaps(String.class, String.class);
		pageData.addAll(updateData);
		System.out.println("Checking->" + pageData);
		checkoutPage.reportAnIssueKeepUpdateCheckTrue(updateData);
	}

	@Given("^user leave the \"([^\"]*)\" form empty and hit CancelButton$")
	public void user_leave_the_form_empty_and_hit_CancelButton(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_leave_the_form_empty_and_hit_CancelButton");
		checkoutPage.clickOnReportAnIssueCancelButton();
	}

	@Then("^verify user will be redirected back to \"([^\"]*)\" PDP page$")
	public void verify_user_will_be_redirected_back_to_PDP_page(String serviceRequest) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": verify_user_will_be_redirected_back_to_PDP_page");
		if (serviceRequest.equalsIgnoreCase("Report Graffiti")) {
			productDetailPage.verifyIfProductDisplayPageIsDisplayed();
			productDetailPage.verifyReportGraffitiPDP();
		}

		else {
			productDetailPage.verifyIfProductDisplayPageIsDisplayed();
			productDetailPage.verifyReportPotholePDP();
		}
	}

	@Given("^User leave the \"([^\"]*)\" form empty and hit submit Button$")
	public void user_leave_the_form_empty_and_hit_submit_Button(String serviceProduct) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_leave_the_form_empty_and_hit_submit_Button");
		checkoutPage.clickOnReportAnIssueCheckoutCartButton();
	}

	@Then("^User clicks on Ok button in the Popup$")
	public void user_clicks_on_Ok_button_in_the_Popup() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_Ok_button_in_the_Popup");
		checkoutPage.clickOnReportAnIsssuePopUp();
	}

	@Then("^verify user should be able to see the field level error message for \"([^\"]*)\"$")
	public void verify_user_should_be_able_to_see_the_field_level_error_message(String serviceProduct)
			throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": verify_user_should_be_able_to_see_the_field_level_error_message");
		checkoutPage.verifyReportAnIssueErrorMessage(serviceProduct);
	}

}
