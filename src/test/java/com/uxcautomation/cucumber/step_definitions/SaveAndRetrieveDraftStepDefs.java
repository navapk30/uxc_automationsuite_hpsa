package com.uxcautomation.cucumber.step_definitions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutCartPage;
import com.uxcautomation.selenium.pageobjects.DraftConfirmationPage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.MyAccountPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SaveAndRetrieveDraftStepDefs {
	
	WebDriver driver;
	CheckoutCartPage cartPage;
	HomePage homePage;
	DraftConfirmationPage draftPage;
	MyAccountPage accountPage;
	CheckoutBirthDeathsAndMarriagesPage birthPage;
	
	public SaveAndRetrieveDraftStepDefs(){
		driver = StepBaseSetup.driver;
		cartPage=PageFactory.initElements(driver, CheckoutCartPage.class);
		homePage=StepBaseSetup.getPageObjectForClass(HomePage.class);
		draftPage=PageFactory.initElements(driver, DraftConfirmationPage.class); 
		accountPage=PageFactory.initElements(driver, MyAccountPage.class);
		birthPage=PageFactory.initElements(driver, CheckoutBirthDeathsAndMarriagesPage.class);
	}
	
	@Then("^User clicks on cancel button on the review page$")
	public void user_clicks_on_cancel_button_on_the_review_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_cancel_button_on_the_review_page");
		cartPage.clickOnChekoutPageCancelButton();
	}
	
	@Then("^User verifies in \"([^\"]*)\" page under \"([^\"]*)\" that draft has not been saved$")
	public void user_verifies_in_page_that_draft_has_not_been_saved(String linkName,String myAccountOptionLinkName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_in_page_that_draft_has_not_been_saved");
		homePage.clickOnMyAccountLink(linkName);
		homePage.clickOnOptionUnderMyAccountLink(myAccountOptionLinkName);
	}

	@Then("^User clicks on save and close button$")
	public void user_clicks_on_save_and_close_button() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_save_and_close_button");
		cartPage.clickOnChekoutPageSaveAndCloseButton();
	}
	
	@Then("^User clicks on save and close button on bundled page$")
	public void user_clicks_on_save_and_close_button_on_bundled_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_save_and_close_button_on_bundled_page");
		cartPage.clickOnBundledPageSaveAndCloseButton();
	}
	
	@Then("^User clicks on save and close button on non-yform page$")
	public void user_clicks_on_save_and_close_button_on_nonyform_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_save_and_close_button_on_nonyform_page");
		cartPage.clickOnNonYformPageSaveAndCloseButton();
	}

	@Then("^User verifies the draft confirmation page$")
	public void user_verifies_the_draft_conifrmation_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_draft_conifrmation_page");
		draftPage.verifyDraftConfirmationPage();
	}

	@Then("^User verifies from my account section, if page2 is considered as last visited page$")
	public void user_verifies_from_my_account_section_if_page2_is_considered_as_last_visited_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_from_my_account_section_if_page2_is_considered_as_last_visited_page");
		draftPage.getDraftNumber();
		draftPage.clickOnMyApplicationLink();
		accountPage.clickToRestoreDraft();
		draftPage.page2LastRestoredPage();
	}

	@Then("^User verifies from my account section, if page3 is considered as last visited page$")
	public void user_verifies_from_my_account_section_if_page3_is_considered_as_last_visited_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_from_my_account_section_if_page2_is_considered_as_last_visited_page");
		draftPage.getDraftNumber();
		draftPage.clickOnMyApplicationLink();
		accountPage.clickToRestoreDraft();
		draftPage.page3LastRestoredPage();
	}

	@Then("^User verifies global error message on child details page$")
	public void user_verifies_global_error_message_on_child_details_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_global_error_message_on_child_details_page");
		birthPage.saveAndCloseChildDeatilsErrorMessage();
	}

	@Then("^User verifies from my account section, if non-yform page is considered as last visited page$")
	public void user_verifies_from_my_account_section_if_non_yform_page_is_considered_as_last_visited_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_from_my_account_section_if_non_yform_page_is_considered_as_last_visited_page");
		draftPage.getDraftNumber();
		draftPage.clickOnMyApplicationLink();
		accountPage.clickToRestoreDraft();
		draftPage.nonYFormPageLastRestored();
	}
	
	@Then("^User verifies from my account section, if bundled page is considered as last visited page$")
	public void user_verifies_from_my_account_section_if_bundled_page_is_considered_as_last_visited_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_from_my_account_section_if_bundled_page_is_considered_as_last_visited_page");
		draftPage.getDraftNumber();
		draftPage.clickOnMyApplicationLink();
		accountPage.clickToRestoreDraft();
		draftPage.bundledPageLastRestoredPage();
	}
	
	@And("^User verifies from my account section, if event permit bundled page is considered as last visited page$")
	public void user_verifies_from_my_account_section_if_event_permit_bundled_page_is_considered_as_last_visited_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_from_my_account_section_if_event_permit_bundled_page_is_considered_as_last_visited_page");
		draftPage.getDraftNumber();
		draftPage.clickOnMyApplicationLink();
		accountPage.clickToRestoreDraft();
		draftPage.eventPermitBundledPageLastRestoredPage();
	}


}
