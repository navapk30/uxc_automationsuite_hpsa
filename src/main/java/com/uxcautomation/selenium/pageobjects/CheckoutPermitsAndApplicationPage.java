package com.uxcautomation.selenium.pageobjects;

import java.util.List;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cucumber.api.DataTable;

public class CheckoutPermitsAndApplicationPage extends CheckoutCartPage {

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h1' and contains(text(),'Summary')]")
	WebElement summaryTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Summary')]")
	WebElement applicationSummaryTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Help Desk')]")
	WebElement helpDeskTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Payment & Billing Address')]")
	WebElement paymentAndBillingAddressTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h1' and contains(text(),'Consent Declaration')]")
	WebElement consentDeclarationTitle;

	@FindBy(how = How.XPATH, using = "//label[@class='control-label consentDeclarations']")
	WebElement consentDeclarationCheckbox;

	@FindBy(how = How.XPATH, using = "//form[contains(@id,'EVENT_Permit_WithAlcohol')]/p[contains(text(),'serve alcohol')]")
	WebElement alcholQuestionField;

	@FindBy(how = How.ID, using = "nextBtn")
	WebElement nextButton;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'complete question')]")
	WebElement bundlePageErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'event-title')]/span[1]")
	WebElement eventTitleErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'radiobutton')]/span[2]")
	WebElement eventPubilcErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'event-description')]/span[1]")
	WebElement eventDescriptionErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'event-start')]/span[1]")
	WebElement eventDateErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'addressline-1')]/span[1]")
	WebElement addressErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'city')]/span[1]")
	WebElement cityErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'post')]/span[1]")
	WebElement postErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'title')]/span[2]")
	WebElement titleErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'first-name')]/span[1]")
	WebElement firstNameErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'last-name')]/span[1]")
	WebElement lastNameErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'orgtype')]/span[2]")
	WebElement orgTypeErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'company-name')]/span[1]")
	WebElement orgNameErrorMessage;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Please accept consent declaration(s) before applying for service.')]")
	WebElement consentErrorMessage;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Application Totals')]")
	WebElement applicationTotals;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'Title-Name')]/span[2]")
	WebElement applicantTitle;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'first-name-1')]/span[1]")
	WebElement applicantFirstName;

	@FindBy(how=How.XPATH,using="//span[contains(@id,'last-name-1')]/span[1]")
	WebElement applicantLastName;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'dropdown-gender')]/span[2]")
	WebElement applicantGender;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'City-1-control')]/span[1]")
	WebElement applicantPlaceOfBirth;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'occupation-1-control')]/span[1]")
	WebElement applicantOccupation;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'control-6-control')]/span[1]")
	WebElement applicantDOB;
	
	public CheckoutPermitsAndApplicationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterEventDetails(List<Map<String,String>> eventDetailFormData) {
		this.waitForPageToBeReady();
	    waitTillYFormLoadingIconDisappears();
		log.info("Enter details in event details form...");
		this.waitForPageToBeReady();
		enterYFormData("Event Title", eventDetailFormData.get(0).get("EventTitle"), "text");
		enterYFormData("Yes", null, "radio");
		enterYFormData("Event Description", eventDetailFormData.get(0).get("EventDiscription"), "textarea");
		enterYFormData("Event Date", eventDetailFormData.get(0).get("EventDate"), "text");
		enterYFormData("Address Line 1", eventDetailFormData.get(0).get("Address1"), "text");
		enterYFormData("City", eventDetailFormData.get(0).get("City"), "text");
		enterYFormData("Postcode", eventDetailFormData.get(0).get("PostalCode"), "text");
		clickContinue();
	}

     public void enterApplicantDetails(List<Map<String,String>> ApplicantDetailFormData) {
	
    	 waitTillYFormLoadingIconDisappears();
    	 log.info("Enter details in applicant details form...");
    	 this.waitForPageToBeReady();
	     enterYFormData("Title", ApplicantDetailFormData.get(0).get("Title"), "select");
	     enterYFormData("First Name", ApplicantDetailFormData.get(0).get("FirstName"), "text");
	     enterYFormData("Last Name", ApplicantDetailFormData.get(0).get("LastName"), "text");	
	     enterYFormData("Organisation Type", ApplicantDetailFormData.get(0).get("OrganizationType"), "select");
	     enterYFormData("Company / Organisation Name", ApplicantDetailFormData.get(0).get("OrganizationName"), "text");
	     clickContinue();
   }

    public void verifyReviewPageForEventPermit(List<Map<String,String>> eventPermitPageData){
	
    log.info("Event Permit Review page");
    this.waitForPageToBeReady();
	try{
		Assert.assertEquals("Summary", summaryTitle.getText());
		Assert.assertEquals("Application Summary",applicationSummaryTitle.getText());
		Assert.assertEquals("Help Desk",helpDeskTitle.getText());
		Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
		Assert.assertEquals("Consent Declaration", consentDeclarationTitle.getText());
	}catch (Error e) {
		parseErrorMessageLog(e.toString());
	}
	
   }

   public void acceptConsentDeclaration() {
	consentDeclarationCheckbox.click();

   }
   
//   public void verifyAlcoholQuestion() throws InterruptedException{
//	   Thread.sleep(1000);
//	   try{
//		   Assert.assertEquals("Are you going to serve alcohol at this event?*",alcholQuestionField.getText());
//	   }
//	   catch (Error e) {
//			parseErrorMessageLog(e.toString());
//		}
//		
//	   
//   }
   
   public void eventPermitNextButton(){
	   
	   this.clickElement(nextButton);
   }
   
   public void bundlePageErrorMessage(){
	   
	   try{
			Assert.assertTrue("Please complete question [1, 2] first.", bundlePageErrorMessage.getText().contains("Please complete question [1, 2] first."));
		}catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
   }
   
   public void eventDetailsErrorMessage(){
	   
	   try{
			Assert.assertEquals("Please enter an event title", eventTitleErrorMessage.getText());
			Assert.assertEquals("Please select an option",eventPubilcErrorMessage.getText());
			Assert.assertEquals("Please enter an event description",eventDescriptionErrorMessage.getText());
			Assert.assertEquals("Please select a date", eventDateErrorMessage.getText());
			Assert.assertEquals("Please enter an address", addressErrorMessage.getText());
			Assert.assertEquals("Please enter a town or city", cityErrorMessage.getText());
			Assert.assertEquals("Please enter a postcode", postErrorMessage.getText());
		}catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void applicantDetailsErrorMessage() {

		try {
			Assert.assertEquals("Please select a title", titleErrorMessage.getText());
			Assert.assertEquals("Please enter a first name", firstNameErrorMessage.getText());
			Assert.assertEquals("Please enter a last name", lastNameErrorMessage.getText());
			Assert.assertEquals("Please select an option", orgTypeErrorMessage.getText());
			Assert.assertEquals("Please enter a company / organisation name", orgNameErrorMessage.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void enterParkingPermitApplicantDetails(List<Map<String, String>> applicantData) {
		waitTillYFormLoadingIconDisappears();
		log.info("Enter Disabled parking permit Applicant data...");
		enterYFormData("Title", applicantData.get(0).get("Title"), "select");
		enterYFormData("First Name", applicantData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", applicantData.get(0).get("LastName"), "text");
		enterYFormData("Gender", applicantData.get(0).get("Gender"), "select");
		enterYFormData("Date of Birth (example: 23/09/2016)", applicantData.get(0).get("DOB"), "text");
		enterYFormData("Your Identification details", applicantData.get(0).get("identificationProof"), "file");
	clickContinue();

	}

	public void enterMedicalDetails(List<Map<String, String>> medicalData) {
		waitTillYFormLoadingIconDisappears();
		log.info("Enter Diabled parking permit Medical Details data...");
		this.waitForPageToBeReady();
		enterYFormData("Medical Report", medicalData.get(0).get("medicalReport"),"file");
		enterYFormData("Practitioner", medicalData.get(0).get("practicionerName"),"text");
		enterYFormData(
				"I declare that the details in this medical report are true and complete and obtained from a registered medical practitioner",
				medicalData.get(0).get("declaration"), "checkbox");
		enterYFormData("Country", medicalData.get(0).get("Country"), "select");
		enterYFormData("Address Line 1", medicalData.get(0).get("Address1"), "text");
		enterYFormData("City", medicalData.get(0).get("City"), "text");
		enterYFormData("Post Code", medicalData.get(0).get("PostalCode"), "text");
		enterYFormData("Email address", medicalData.get(0).get("EmailAddress"), "text");
		
		clickContinue();

	}
	
	public void enterTouristVisaApplicantDetails(List<Map<String, String>> applicantData){
		
		waitTillYFormLoadingIconDisappears();
		log.info("Enter applicant details...");
		enterYFormData("Title", applicantData.get(0).get("Title"), "select");
		enterYFormData("First Name", applicantData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", applicantData.get(0).get("LastName"), "text");
		enterYFormData("Gender",applicantData.get(0).get("Gender"), "select");
		enterYFormData("Date Of Birth",applicantData.get(0).get("DOB"), "text");
		enterYFormData("Place of Birth",applicantData.get(0).get("PlaceOfBirth"), "text");
		enterYFormData("Relationship Status",applicantData.get(0).get("RelationshipStatus"), "select");
		enterYFormData("Occupation",applicantData.get(0).get("Occupation"), "text");
		clickContinue();
	}

	public void enterTouristVisaApplicantionDetails(List<Map<String, String>> applicantionData){
		
		waitTillYFormLoadingIconDisappears();
		log.info("Enter applicantion details...");
		enterYFormData("Passport Number", applicantionData.get(0).get("PassportNumber"), "text");
		enterYFormData("Date of Issue", applicantionData.get(0).get("DateOfIssue"), "text");
		enterYFormData("Date of Expiry", applicantionData.get(0).get("DateOfExpiry"), "text");
		enterYFormData("Place of Issue", applicantionData.get(0).get("PlaceOfIssue"), "text");
		enterYFormData("Address Line 1", applicantionData.get(0).get("Address1"), "text");
		enterYFormData("City", applicantionData.get(0).get("City"), "text");
		enterYFormData("Post Code", applicantionData.get(0).get("PostalCode"), "text");
		enterYFormData("Upto 6 Months", applicantionData.get(0).get("DurationOfStay"), "radio");
		enterYFormData("No", applicantionData.get(0).get("VisaForOtherStateOfRoseBud"), "radio");
		clickContinue();
	}
	
	public void enterTouristVisaHealthAndCharacterDetails(List<Map<String, String>> healthData){
		
		waitTillYFormLoadingIconDisappears();
		log.info("Enter Health and Character details...");
		enterYFormDataForMultipleFieldWithSameName("No", healthData.get(0).get("Question1Disease"), "radio","1");
		enterYFormDataForMultipleFieldWithSameName("No", healthData.get(0).get("Question2Offence"), "radio","2");
		enterYFormDataForMultipleFieldWithSameName("No", healthData.get(0).get("Question3LegalAction"), "radio","3");
		enterYFormDataForMultipleFieldWithSameName("Yes", healthData.get(0).get("Question4Arrest"), "radio","4");
		enterYFormDataForMultipleFieldWithSameName("No", healthData.get(0).get("Question5Offender"), "radio","5");
		enterYFormDataForMultipleFieldWithSameName("Yes", healthData.get(0).get("Question6Training"), "radio","6");
		enterYFormDataForMultipleFieldWithSameName("No", healthData.get(0).get("Question7Deported"), "radio","7");
		clickContinue();
	}

	 public void verifyReviewPageForTouristVisa(List<Map<String,String>> touristVisaPageData){
			
		    log.info("Tourist visa Review page");
			try{
				Assert.assertEquals("Summary", summaryTitle.getText());
				Assert.assertEquals("Application Summary",applicationSummaryTitle.getText());
				Assert.assertEquals("Help Desk",helpDeskTitle.getText());
				Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
				Assert.assertEquals("Application Totals", applicationTotals.getText());
			}catch (Error e) {
				parseErrorMessageLog(e.toString());
			}			
	 }
	 
	 public void applicantDetailErrorMessage(){
		 
		  try{
				Assert.assertEquals("Please select a title", applicantTitle.getText());
				Assert.assertEquals("Please enter a first name",applicantFirstName.getText());
				Assert.assertEquals("Please enter a last name",applicantLastName.getText());
				Assert.assertEquals("Please select an option", applicantGender.getText());
				Assert.assertEquals("Please enter a town or city", applicantPlaceOfBirth.getText());
				Assert.assertEquals("Please enter your occupation", applicantOccupation.getText());
			}catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
	 }
	 
	 public void dobErrorMessage(){
		 
		 try{
				Assert.assertEquals("You must be at least 18 years old to apply", applicantDOB.getText());
			}catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		 
	 }
	 
	 public void poolBuildingPermitPrefilling(){
		 try{
//			 	Assert.assertEquals("Miss", title.getAttribute("text"));
			 	Assert.assertEquals("Automation", firstName.getAttribute("value"));
				Assert.assertEquals("Citizen", lastName.getAttribute("value"));
				Assert.assertEquals("230 Primary Street", addressLine1.getAttribute("value"));
				Assert.assertEquals("Rosebud", city.getAttribute("value"));
				Assert.assertEquals("1000", postCode.getAttribute("value"));
				Assert.assertEquals("0011234567", phoneNumber.getAttribute("value"));
				Assert.assertEquals("automationtestuser@stateofrosebud.com", emailAddress.getAttribute("value"));
			}catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
	 }
}

