package com.uxcautomation.cucumber.step_definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutCartPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPaymentBillingAddressPage;
import com.uxcautomation.selenium.pageobjects.MyBillsPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class ReviewAndPayBillPaymentStepDefs {
	
	WebDriver driver;
	MyBillsPage billPage;
	CheckoutPaymentBillingAddressPage paymentPage;
	
	public ReviewAndPayBillPaymentStepDefs(){
		driver = StepBaseSetup.driver;	
		billPage=PageFactory.initElements(driver, MyBillsPage.class);
		paymentPage=PageFactory.initElements(driver, CheckoutPaymentBillingAddressPage.class);
	}

	@Then("^User clicks on the \"([^\"]*)\" bill for which the part payment is allowed$")
	public void user_clicks_on_the_bill_for_which_the_part_payment_is_allowed(String billType) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_the_bill_for_which_the_part_payment_is_allowed");
		billPage.clickOnPayThisBillButton(billType);   
	}

	@Then("^User verifies if the enter amount filed is visible$")
	public void user_verifies_if_the_enter_amount_filed_is_visible() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": User verifies if the enter amount filed is visible");
		billPage.verifyIfPartialAmountFieldIsVisible();
	}
	
	@Then("^User clicks on the \"([^\"]*)\" bill for which the part payment is not allowed$")
	public void user_clicks_on_the_bill_for_which_the_part_payment_is_not_allowed(String billType) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_the_bill_for_which_the_part_payment_is_not_allowed");
		billPage.clickOnPayThisBillButton(billType);  
	}

	@Then("^User verifies if the enter amount filed is not visible$")
	public void user_verifies_if_the_enter_amount_filed_is_not_visible() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": User verifies if the enter amount filed is not visible");
		billPage.verifyIfPartialAmountFieldIsVisible();
	}

	@Then("^User enters \"([^\"]*)\" in the partial amount field$")
	public void user_enters_in_the_partial_amount_field(String amount) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_enters_in_the_partial_amount_field");
		billPage.enterAmountInPartialAmountField(amount);
	}

	@Then("^User fills the card details and makes payment and clicks on pay now button$")
	public void user_fills_the_card_details_and_makes_payment(DataTable paymentInfo) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": User fills the card details and makes payment and clicks on pay now button");
		List<Map<String, String>> paymentAndBillingData = paymentInfo.asMaps(String.class, String.class);
		paymentPage.enterPaymentInfo(paymentAndBillingData, false, false);
		billPage.clickOnPayNowButton();
	}

	@Then("^User uses the saved card for payment$")
	public void user_uses_the_saved_card_for_payment() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_uses_the_saved_card_for_payment");
		paymentPage.selectSavedCard();
		billPage.clickOnPayNowButton();
	}

	@Then("^User verifies the error message$")
	public void user_verifies_the_error_message() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_error_message");
		billPage.verifyErrorMessage();
	}
}
