package com.uxcautomation.cucumber.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.BillRetrievePage;
import com.uxcautomation.selenium.pageobjects.HomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BillRetrieveStepDefs {
	
	WebDriver driver;
	BillRetrievePage billRetrievePage;
	HomePage homePage;
	
	public BillRetrieveStepDefs(){
		driver = StepBaseSetup.driver;
		homePage=PageFactory.initElements(driver, HomePage.class);
		billRetrievePage=PageFactory.initElements(driver, BillRetrievePage.class);
	}
	
	@Then("^User clicks on \"([^\"]*)\" link available in footer section$")
	public void user_clicks_on_link_available_in_footer_section(String linkName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_clicks_on_link_available_in_footer_section");
		homePage.navigateToBillRetrievePage();
	}


	@And("^User retrieves bill by entering valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_retrieves_bill_by_entering_valid_data(String billId, String lastName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_retrieves_bill_by_entering_valid_data");
		billRetrievePage.retrieveBill(billId, lastName);
	}

	@Then("^User is redirected to the bill details page$")
	public void user_is_redirected_to_the_bill_details_page() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_retrieves_bill_by_entering_valid_data");
		billRetrievePage.verifyBillDetailPage();
	}
	
	@And("^User retrieves bill by entering invalid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_retrieves_bill_by_entering_invalid_data(String billId, String lastName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_retrieves_bill_by_entering_invalid_data");
		billRetrievePage.retrieveBill(billId, lastName);
	}

	@Then("^User verifies \"([^\"]*)\" error message$")
	public void user_verifies_error_message(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_verifies_error_message");
		billRetrievePage.verifyErrorMessage();
	}
	
	@And("^User retrieves bill by leaving blank for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_retrieves_bill_by_leaving_blank_for_billId_and_lastname(String billId, String lastName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_retrieves_bill_by_leaving_blank_for_billId_and_lastname");
		billRetrievePage.retrieveBill(billId, lastName);
	}
	
	@And("^User retrieves bill by entering \"([^\"]*)\" and \"([^\"]*)\" for a Bill that is Fully Paid, i.e. Outstanding Amount = 0$")
	public void user_retrieves_bill_by_entering_and_for_a_Bill_that_is_Fully_Paid_i_e_Outstanding_Amount(String billId, String lastName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_retrieves_bill_by_entering_and_for_a_Bill_that_is_Fully_Paid_i_e_Outstanding_Amount");
		billRetrievePage.retrieveBill(billId, lastName);
	}
	
	@Then("^User retrieves bill by entering \"([^\"]*)\" and \"([^\"]*)\" for a Bill that is Overdue and the Overdue Payment Allowed is set to False$")
	public void user_retrieves_bill_by_entering_and_for_a_Bill_that_is_Overdue_and_the_Overdue_Payment_Allowed_is_set_to_False(String billId, String lastName) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName() + ": user_retrieves_bill_by_entering_and_for_a_Bill_that_is_Overdue_and_the_Overdue_Payment_Allowed_is_set_to_False");
		billRetrievePage.retrieveBill(billId, lastName);
	}
}
