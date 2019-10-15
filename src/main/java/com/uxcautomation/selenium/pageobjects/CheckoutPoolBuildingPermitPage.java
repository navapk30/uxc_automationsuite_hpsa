package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class CheckoutPoolBuildingPermitPage extends CheckoutCartPage {

	public CheckoutPoolBuildingPermitPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsersWorkDetails(List<Map<String, String>> applicationData) {
		System.out.println("Enter users work details in pool building permit...");
		enterYFormDataForMultipleFieldWithSameName("Development Application Approval Number",
				applicationData.get(0).get("devAppApprovalNum"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Complying Development Certificate Approval Number",
				applicationData.get(0).get("complyDevCertApprovalNum"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Certifier Number", applicationData.get(0).get("certifierNum"),
				"text", "1");
		enterYFormDataForMultipleFieldWithSameName("Market Value of the Work",
				applicationData.get(0).get("marketValueOfTheWork"), "text", "1");
		enterYFormData("Attach your plan", "IdentificationProof.PNG", "file");
		enterYFormDataForMultipleFieldWithSameName(applicationData.get(0).get("offenceQuestion"), null, "radio", "1");
		enterYFormDataForMultipleFieldWithSameName(applicationData.get(0).get("certOfInsuranceQuestion"), null, "radio",
				"2");

		clickContinue();
	}

	public void enterUsersPersonalDetails(List<Map<String, String>> applicationData) {
		System.out.println("Enter users personal details in pool building permit...");
		this.waitForPageToBeReady();
		enterYFormDataForMultipleFieldWithSameName("Title", applicationData.get(0).get("title"), "select", "1");
		enterYFormDataForMultipleFieldWithSameName("First Name", applicationData.get(0).get("firstName"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Last Name", applicationData.get(0).get("lastName"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Date of Birth", applicationData.get(0).get("DOB"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Address Line 1", applicationData.get(0).get("addressLine1"), "text",
				"1");
		enterYFormDataForMultipleFieldWithSameName("City", applicationData.get(0).get("city"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Post Code", applicationData.get(0).get("postCode"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Email Address", applicationData.get(0).get("emailAddress"), "text",
				"1");
		clickContinue();
	}

}
