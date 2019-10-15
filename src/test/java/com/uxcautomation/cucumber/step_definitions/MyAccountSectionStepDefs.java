package com.uxcautomation.cucumber.step_definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import com.uxcautomation.cucumber.step_definitions.StepBaseSetup;
import com.uxcautomation.cucumber.step_definitions.CommonStepsDefs;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.MyAccountPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
public class MyAccountSectionStepDefs {
	
	WebDriver driver;
	MyAccountPage accountPage;
	HomePage homePage;
	
	public MyAccountSectionStepDefs(){
		driver = StepBaseSetup.driver;
		accountPage=StepBaseSetup.getPageObjectForClass(MyAccountPage.class);
		homePage=StepBaseSetup.getPageObjectForClass(HomePage.class);
	}
	
	@Then("^User clicks on \"([^\"]*)\" link$")
	public void user_clicks_on_link(String linkName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_link");
		homePage.clickOnMyAccountLink(linkName);
	}
	@Then("^User clicks on View Expired Documents button$")
	public void user_clicks_on_expired_document_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_link");
		accountPage.clickOnViewExpiredDraftButton();
	}
	
	@Then("^User clicks on \"([^\"]*)\" link under my account$")
	public void user_clicks_on_link_under_my_account(String myAccountOptionLinkName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_link_under_my_account");
		homePage.clickOnOptionUnderMyAccountLink(myAccountOptionLinkName);
	}

	@Then("^Then user verifies the my acount page$")
	public void then_user_verifies_the_my_acount_page() throws Throwable {
	 
	}

	@Then("^User verifies the my application and requests page for submitted service request$")
	public void user_verifies_the_my_application_and_requests_page_for_submitted_service_request() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_my_application_and_requests_page_for_submitted_service_request");
		accountPage.verifyMyApplicationRequestPage();
	}

	@Then("^User verifies the my application and requests page for submitted draft$")
	public void user_verifies_the_my_application_and_requests_page_for_submitted_draft() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_my_application_and_requests_page_for_submitted_draft");
		accountPage.verifyMyapplicationRequestForDraft();
	}

	@Then("^User clicks on delete icon for a specific draft$")
	public void user_clicks_on_delete_icon_for_a_specific_draft() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_delete_icon_for_a_specific_draft");
		accountPage.clickOnDeleteIcon();
	}

	@Then("^User clicks on confirm button on the draft overlay$")
	public void user_clicks_on_confirm_button_on_the_draft_overlay() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_confirm_button_on_the_draft_overlay");
		accountPage.clickOnDeleteDraftButton();
	}

	@Then("^User clicks on cancel button on the draft overlay$")
	public void user_clicks_on_cancel_button_on_the_draft_overlay() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_cancel_button_on_the_draft_overlay");
		accountPage.clickOnCancelButton();
	}

	@Then("^User clicks on specific service request$")
	public void user_clicks_on_specific_service_request() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_specific_service_request");
		accountPage.clickOnSubmittedServiceRequest();
	}

	@Then("^User verifies the submitted service request for payment and shipping information\\.$")
	public void user_verifies_the_submitted_service_request_for_payment_and_shipping_information() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_submitted_service_request_for_payment_and_shipping_information");
		accountPage.verifySubmittedServiceRequest();
	}

	@Then("^User verifies the personal details page$")
	public void user_verifies_the_personal_details_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_personal_details_page");
		accountPage.verifyPersonalDetailsPage();
	}

	@Then("^User updates the title and clicks on update button$")
	public void user_updates_the_title_and_clicks_on_update_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": User updates the title and clicks on update button");
		accountPage.updateTitleAndClickConfirm();
	}

	@Then("^User verifies Your profile has been updated message$")
	public void user_verifies_Your_profile_has_been_updated_message() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_Your_profile_has_been_updated_message");
		accountPage.verifyupdateSuccessMessage();
	}

	@Then("^User updates the title and clicks on cancel button$")
	public void user_updates_the_title_and_clicks_on_cancel_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_updates_the_title_and_clicks_on_cancel_button");
		accountPage.updateTitleAndClickCancel();
	}

	@Then("^User is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_is_navigated_to_the_home_page");
		homePage.verifyIfOnHomePage();
	}

	@Then("^User verifies the change password page$")
	public void user_verifies_the_change_password_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_change_password_page");
		accountPage.verifyChangePasswordPage();
	}

	@Then("^User clicks on cancel button$")
	public void user_clicks_on_cancel_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_change_password_page");
		accountPage.clickOnPasswordPageCancelButton();
	}

	@Then("^User clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_change_password_page");
		accountPage.clickOnAddAddressbutton();
	}

	@Then("^User adds the new address$")
	public void user_adds_the_new_address(DataTable address) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_adds_the_new_address");
		List<Map<String, String>> userAddress= address.asMaps(String.class, String.class);
		accountPage.enterUserAddress(userAddress);
	}

	@Then("^User clicks on save button$")
	public void user_clicks_on_save_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_save_button");
		accountPage.clickOnAddressSavebutton();
	}

	@Then("^User clicks on edit icon to edit the address$")
	public void user_clicks_on_edit_icon_to_edit_the_address() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_save_button");
		accountPage.clickOnEditIcon();
	}
	
	@Then("^User updates the title and clicks on update button on address book page$")
	public void user_updates_the_title_and_clicks_on_update_button_on_address_book_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_save_button");
		accountPage.updateAddressAndClickSave();
	}


	@Then("^User clicks on delete icon to delete the address$")
	public void user_clicks_on_delete_icon_to_delete_the_address() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_delete_icon_to_delete_the_address");
		accountPage.clickOnAddressPageDeleteIcon();
	}

	@Then("^User clicks on cancel button from the delete address overlay$")
	public void user_clicks_on_cancel_button_from_the_delete_address_overlay() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_cancel_button_from_the_delete_address_overlay");
		accountPage.clickOnAddressCancelButton();
	}
	
	@Then("^User is navigated back to address book page$")
	public void user_is_navigated_back_to_address_book_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_is_navigated_back_to_address_book_page");
		accountPage.verifyAddressBookPage();
	}


	@Then("^User clicks on Delete button from the delete address overlay$")
	public void user_clicks_on_Delete_button_from_the_delete_address_overlay() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_Delete_button_from_the_delete_address_overlay");
		accountPage.clickOnAddressDeleteOverlayButton();
	}

	@Then("^User verifies \"([^\"]*)\" message$")
	public void user_verifies_message(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_Delete_button_from_the_delete_address_overlay");
		accountPage.verifyDeleteAddressSuccessMessage();
	}

	@Then("^User verifies the my documents page$")
	public void user_verifes_the_my_documents_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifes_the_my_documents_page");
		accountPage.verifyMyDocumentPage();
	}

	@Then("^User verifies the expired documents page$")
	public void user_verifies_the_expired_documents_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_expired_documents_page");
		accountPage.verifyExpiredDocumentsPage();
	}



}
