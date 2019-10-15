package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * CheckoutWorkingWithChildrenCheckPage object
 * 
 * @author pkumar350
 */
public class CheckoutWorkingWithChildrenCheckPage extends CheckoutCartPage {

	@FindBy(how = How.XPATH, using = "//label[contains(@class,'xforms-label') and contains(text(),'There are validation errors')]")
	private WebElement validationError;

	public CheckoutWorkingWithChildrenCheckPage(WebDriver driver) {
		super(driver);
	}

	public void enterApplicationAndOrganisationDetails(List<Map<String, String>> applicationData) {
		waitTillYFormLoadingIconDisappears();
		this.waitForPageToBeReady();
		System.out.println("Enter details in application and organisation details form...");
		enterYFormDataForMultipleFieldWithSameName("Child-related sector", applicationData.get(0).get("sector"),
				"select", "1");
		enterYFormDataForMultipleFieldWithSameName(applicationData.get(0).get("appliedBefore"), null, "radio", "1");
		enterYFormDataForMultipleFieldWithSameName(applicationData.get(0).get("organizationDetailsAvailable"), null,
				"radio", "2");
		if (applicationData.get(0).get("organizationDetailsAvailable").equalsIgnoreCase("yes")) {
			enterYFormDataForMultipleFieldWithSameName("Organisation Name",
					applicationData.get(0).get("organizationName"), "text", "1");
			enterYFormDataForMultipleFieldWithSameName("Address Line 1", applicationData.get(0).get("addressLine1"),
					"text", "1");
			enterYFormDataForMultipleFieldWithSameName("City", applicationData.get(0).get("city"), "text", "1");
			enterYFormDataForMultipleFieldWithSameName("Post Code", applicationData.get(0).get("postCode"), "text",
					"1");
			enterYFormDataForMultipleFieldWithSameName("Phone Number", applicationData.get(0).get("PhoneNumber"),
					"text", "1");
		}
		clickContinue();
	}

	public void enterApplicantsPersonalInfo(List<Map<String, String>> applicantsData) throws InterruptedException {
		System.out.println("Enter details in application and organisation details form...");
		waitTillYFormLoadingIconDisappears();
		enterYFormDataForMultipleFieldWithSameName("Title", applicantsData.get(0).get("title"), "select", "1");
		enterYFormDataForMultipleFieldWithSameName("First Name", applicantsData.get(0).get("firstName"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Last Name", applicantsData.get(0).get("lastName"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("No", null, "radio", "1");
		enterYFormDataForMultipleFieldWithSameName("gender", applicantsData.get(0).get("gender"), "select", "1");
		enterYFormDataForMultipleFieldWithSameName("Place of Birth", applicantsData.get(0).get("placeOfBirth"), "text",
				"1");
		enterYFormDataForMultipleFieldWithSameName("Date of Birth", applicantsData.get(0).get("DOB"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Country", applicantsData.get(0).get("country"), "select", "1");
		enterYFormDataForMultipleFieldWithSameName("Address Line 1", applicantsData.get(0).get("addressLine1"), "text",
				"1");
		enterYFormDataForMultipleFieldWithSameName("City", applicantsData.get(0).get("city"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Postcode", applicantsData.get(0).get("postCode"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Phone Number", applicantsData.get(0).get("PhoneNumber"),
				"text", "1");
		enterYFormDataForMultipleFieldWithSameName("Email Address", applicantsData.get(0).get("emailAddress"), "text",
				"1");
		enterYFormData("Your Identification Details", "IdentificationProof.PNG", "file");
		clickContinue();
	}

	public void errorDisplayedToUser() {
		log.info("Verifying xform error");
		try {
			Assert.assertEquals(
					"There are validation errors. Please retry once all fields have been properly filled-out.",
					validationError.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
}
