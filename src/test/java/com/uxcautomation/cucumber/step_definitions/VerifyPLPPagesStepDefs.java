package com.uxcautomation.cucumber.step_definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VerifyPLPPagesStepDefs {
	WebDriver driver;
	DisplayProductListPage productListPage;
	String categoryName;
	public VerifyPLPPagesStepDefs() {
		driver = StepBaseSetup.driver;
		productListPage = StepBaseSetup.getPageObjectForClass(DisplayProductListPage.class);
	}

	@Given("^user clicked on \"([^\"]*)\"$")
	public void user_clicked_on(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicked_on"+arg1);
		
		productListPage = StepBaseSetup.homePage.goToProductListingPage(arg1);
		// productListPage.goToProductListingPage(arg1);
		 categoryName=arg1;
	}
	@Then("^user should navigate to Go to PLP page with title \"([^\"]*)\"$")
	public void user_should_navigate_to_Go_to_PLP_page_with_title(String arg1) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_should_navigate_to_Go_to_PLP_page_with_title");
	    // Write code here that turns the phrase above into concrete actions
		productListPage.verifyIsNavigatedToPLPPage(arg1);
	    
	}



	@Then("^verify Product displayed should display following attributes:$")
	public void verify_Product_displayed_should_display_following_attributes(DataTable prodData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+":verify_Product_displayed_should_display_following_attributes");
		List<Map<String, String>> epiData = prodData.asMaps(String.class, String.class);
		System.out.println(epiData.size());
		
		for(Map<String, String> map :epiData){
			System.out.println(map);
			productListPage.verifyProductInformation(map);
		}
		
	}
	
}
