package com.uxcautomation.cucumber.step_definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.DisplayProductDetailPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class VerifyPDPPagesStepDefs {
	
	WebDriver driver;
	DisplayProductDetailPage productDetailPage;
	DisplayProductListPage productListingPage;
	
	public VerifyPDPPagesStepDefs(){
		
		driver=StepBaseSetup.driver;
		productDetailPage = StepBaseSetup.getPageObjectForClass(DisplayProductDetailPage.class);
		productListingPage=PageFactory.initElements(driver, DisplayProductListPage.class);
		
	}
	
	@Then("^User clicks on view details button of \"([^\"]*)\" service request$")
	public void user_clicks_on_view_details_button_of_serviceProduct_service_request(String serviceProduct) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_clicks_on_view_details_button_of_serviceProduct_service_request");
		productListingPage.goToPDPFromPLP(serviceProduct);
	}
	
	@Then("^verify user will be redirected back to PDP page$")
	public void verify_user_will_be_redirected_back_to_PDP_page(DataTable pdpData) throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+":verify_user_will_be_redirected_back_to_PDP_page");
		List<Map<String, String>> pdpInfo = pdpData.asMaps(String.class, String.class);
		productDetailPage.verifyPDPInformation(pdpInfo);
		}
}
