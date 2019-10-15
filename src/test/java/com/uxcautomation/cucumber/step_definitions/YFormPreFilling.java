package com.uxcautomation.cucumber.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPermitsAndApplicationPage;
import com.uxcautomation.selenium.pageobjects.CheckoutReportAnIssuePage;

import cucumber.api.java.en.Then;

public class YFormPreFilling {
	
	CheckoutPermitsAndApplicationPage checkOutPage; 
	CheckoutReportAnIssuePage checkOutReportGraffitipage;
	CheckoutBirthDeathsAndMarriagesPage checkoutRegisterABirthPage;
	WebDriver driver;
	
	public YFormPreFilling(){
		driver = StepBaseSetup.driver;
		checkOutPage=PageFactory.initElements(driver, CheckoutPermitsAndApplicationPage.class);
		checkOutReportGraffitipage=PageFactory.initElements(driver, CheckoutReportAnIssuePage.class);
		checkoutRegisterABirthPage=PageFactory.initElements(driver, CheckoutBirthDeathsAndMarriagesPage.class);
	}
	
	@Then("^User verifies the personal details form is prepopulated$")
	public void user_verifies_the_personal_details_form_is_prepopulated() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_personal_details_form_is_prepopulated");
		checkOutPage.poolBuildingPermitPrefilling();
	}

	@Then("^User verifies the Report Graffiti form is prepopulated$")
	public void user_verifies_the_Report_Graffiti_form_is_prepopulated() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_verifies_the_Report_Graffiti_form_is_prepopulated");
		checkOutReportGraffitipage.reportGraffitiPrefilling();
	}
	
	@Then("^User Verfies Parent details form is prefilled$")
	public void user_Verfies_parent_details_form_is_prefilled() throws Throwable {
		StepBaseSetup.updateSauceTestCaseNameMethod(CommonStepsDefs.scenario.getName()+": user_Verfies_parent_details_form_is_prefilled");
		checkoutRegisterABirthPage.registerABirthPrefilling();
	}

}
