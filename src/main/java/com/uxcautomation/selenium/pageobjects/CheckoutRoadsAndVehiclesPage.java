package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutRoadsAndVehiclesPage extends CheckoutCartPage {

	
	@FindBy(how = How.XPATH, using = "//div[@class='card-section-content']/div[1]/p")
	WebElement referenceNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-content']/div[2]/p")
	WebElement thankYouMessage;


	public CheckoutRoadsAndVehiclesPage(WebDriver driver) {
		super(driver);
	}

	public void enterRegisterBirthChildDetails(List<Map<String, String>> childDeatilFormData) {

		System.out.println("Enter details in child details form...");
		enterYFormData("First Name", childDeatilFormData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", childDeatilFormData.get(0).get("LastName"), "text");
		enterYFormData("I understand that as parents,", null, "checkbox");
		enterYFormData("Date of Birth", childDeatilFormData.get(0).get("DOB"), "text");
		enterYFormData("Birth Weight", childDeatilFormData.get(0).get("BirthWeight"), "text");
		enterYFormData("Gender", childDeatilFormData.get(0).get("Gender"), "select");
		enterYFormData("Country", childDeatilFormData.get(0).get("Country"), "select");
		enterYFormData("Address Line 1", childDeatilFormData.get(0).get("Address1"), "text");
		enterYFormData("City", childDeatilFormData.get(0).get("City"), "text");
		enterYFormData("Post Code", childDeatilFormData.get(0).get("PostalCode"), "text");
		clickContinue();
	}

	public void enterRegisterBirthParentDetails(List<Map<String, String>> parentDeatilFormData) {

		System.out.println("Enter details in parent details form...");
		enterYFormDataForMultipleFieldWithSameName("Title", parentDeatilFormData.get(0).get("Title"), "select", "1");
		enterYFormDataForMultipleFieldWithSameName("First Name", parentDeatilFormData.get(0).get("FirstName"), "text",
				"1");
		enterYFormDataForMultipleFieldWithSameName("Last Name", parentDeatilFormData.get(0).get("LastName"), "text",
				"1");
		enterYFormDataForMultipleFieldWithSameName("Gender", parentDeatilFormData.get(0).get("Gender"), "select", "1");
		enterYFormDataForMultipleFieldWithSameName("Date of Birth", parentDeatilFormData.get(0).get("DOB"), "text",
				"1");
		enterYFormDataForMultipleFieldWithSameName("City", parentDeatilFormData.get(0).get("City"), "text", "1");
		enterYFormDataForMultipleFieldWithSameName("Country", parentDeatilFormData.get(0).get("Country"), "select",
				"1");
		enterYFormData("Father", null, "radio");
		enterYFormDataForMultipleFieldWithSameName("Address Line 1", parentDeatilFormData.get(0).get("Address1"),
				"text", "1");
		enterYFormDataForMultipleFieldWithSameName("Country", parentDeatilFormData.get(0).get("Country"), "select",
				"2");
		enterYFormDataForMultipleFieldWithSameName("City", parentDeatilFormData.get(0).get("City"), "text", "2");
		enterYFormDataForMultipleFieldWithSameName("Postcode", parentDeatilFormData.get(0).get("PostalCode"), "text",
				"1");
		enterYFormDataForMultipleFieldWithSameName("Email Address", parentDeatilFormData.get(0).get("EmailAddress"),
				"text", "1");
		enterYFormData("Parent 2 is unknown", null, "checkbox");
		clickContinue();
	}

	public void enterApplicantDetails(List<Map<String, String>> parentData) {
		System.out.println("Enter details in child details form...");
		enterYFormData("Title", parentData.get(0).get("Title"), "select");
		enterYFormData("First Name", parentData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", parentData.get(0).get("LastName"), "text");
		enterYFormData("Date of Birth (example: 23/09/2016)", parentData.get(0).get("DOB"), "text");
		enterYFormData("Gender", parentData.get(0).get("Gender"), "select");
		enterYFormData("Please upload identification details", parentData.get(0).get("identificationProof"), "file");
		clickContinue();
	}

	public void enterLicenseDetails(List<Map<String, String>> parentData) {
		waitTillYFormLoadingIconDisappears();
		System.out.println("Enter details in license details form...");
		enterYFormDataForMultipleFieldWithSameName(
				parentData.get(0).get("disqualified, prohibited or refused from driving or riding"), "", "radio", "1");
		enterYFormData("What class of licence are you applying for?", parentData.get(0).get("class of licence"),
				"select");
		clickContinue();
		waitTillYFormLoadingIconDisappears();
	}

	public void enterHealthDetails(List<Map<String, String>> parentData) {
		System.out.println("Enter details in health details form...");
		waitTillYFormLoadingIconDisappears();
		enterYFormDataForMultipleFieldWithSameName("Yes", "", "radio", "1");
		enterYFormDataForMultipleFieldWithSameName(parentData.get(0).get("fainting or other unconsciousness"), "",
				"radio", "2");
		enterYFormDataForMultipleFieldWithSameName(
				parentData.get(0).get("any medical, physical or mental disabilities"), "", "radio", "3");
		enterYFormData("Do you require to wear glasses or contact lenses when driving?",
				parentData.get(0).get("wear glasses"), "select");
		clickContinue();
		waitTillYFormLoadingIconDisappears();
	}


	public void verifyInformationOnConfirmationPageDisplayed() {

		if (!referenceNumber.getText().contains("Reference Number")) {
			Assert.fail("Reference number not found");
		}
		if (!thankYouMessage.getText()
				.contains("Thank you for submitting your service order! We have sent a confirmation email")) {
			Assert.fail("confirmation email thank you message not found");
		}

		try {
			Assert.assertEquals("Confirmation - Apply for Learner Driver Licence", summaryTitle.getText());
			Assert.assertEquals("Shipping Address", shippingAddressTitle.getText());
			Assert.assertEquals("Shipping Method", shippingMethodTitle.getText());
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
			Assert.assertEquals("Consent Declaration", consentDeclarationTitle.getText());
			Assert.assertEquals("Application Totals", applictaionTotalsTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}


}
