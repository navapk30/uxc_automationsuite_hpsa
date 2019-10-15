package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CheckoutBirthDeathsAndMarriagesPage extends CheckoutCartPage {
	
	@FindBy(how=How.CSS,using="div.card-section-h1")
	WebElement summaryTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='bundle-info']")
	WebElement summaryInfoField; 
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h1' and contains(text(),'Child Details')]")
	WebElement childDetailsTitle;
	
	@FindBy(how=How.CSS,using="div.card-450.col-xs-12.col-sm-12.col-md-12")
	WebElement childDeatilsInfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Birth Details')]")
	WebElement birthDetailsTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Birth Details')]/following-sibling::div")
	WebElement birthDetailsInfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Birth Address')]")
	WebElement birthAddressTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Birth Address')]/following-sibling::div")
	WebElement birthAddressInfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h1' and contains(text(),'Parent Details')]")
	WebElement parentDetailsTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Parent 1 Details')]")
	WebElement parentDetails1Title;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Parent 1 Details')]/following-sibling::div")
	WebElement parentDetails1InfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Parent 2 Details')]")
	WebElement parentDetails2Title;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Parent 2 Details')]/following-sibling::div")
	WebElement parentDetails2InfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h3' and contains(text(),'Contact Details')]")
	WebElement contactDetailsTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h3' and contains(text(),'Contact Details')]/following-sibling::div")
	WebElement contactDetailsInfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h3' and contains(text(),'Email Address')]")
	WebElement emailAddressTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h3' and contains(text(),'Email Address')]/following-sibling::div")
	WebElement emailAddressInfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Shipping Address')]")
	WebElement shippingAddressTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Shipping Method')]")
	WebElement shippingMethodTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Shipping Address')]/following-sibling::div")
	WebElement shippingaddressInfoSection;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Payment & Billing Address')]")
	WebElement paymentAndBillingAddressTitle;
	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Application Summary')]")
	WebElement applictaionSummaryTitle;
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Help Desk')]")
	WebElement helpDeskTitle;
	
	@FindBy(how=How.XPATH,using="(//div[@class='card-section-h3' and contains(text(),'Contact Details')])[2]/following-sibling::div[1]")
	WebElement parent2ContactDetails;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Parent 2 is unknown')]")
	WebElement parent2UnknownCheckBox;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Parent 2 is unknown')]")
	WebElement parent2UnknownText;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Next')]")
	WebElement nextButton;	
	
	@FindBy(how=How.XPATH,using="//div[contains(text()[2],'Please complete question [1] first.')]")
	WebElement bundlePageErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'first-name')]/span[1]")
	WebElement firstNameErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'last-name')]/span[1]")
	WebElement lastNameErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'birth-date')]/span[1]")
	WebElement dobErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'birth-weight')]/span[1]")
	WebElement birthWeightErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'address-line1')]/span[1]")
	WebElement address1ErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'city')]/span[1]")
	WebElement cityErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'post')]/span[1]")
	WebElement postErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Date of death')]")
	WebElement futureDateErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'dropdown-title')]/span[2]")
	WebElement deceasedTitleError;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'first-name-1')]/span[1]")
	WebElement deceasedFirstNameError;

	@FindBy(how=How.XPATH,using="//span[contains(@id,'last-name-1')]/span[1]")
	WebElement deceasedLastNameError;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'dropdown-gender')]/span[2]")
	WebElement deceasedGenderError;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'death-date')]/span[1]")
	WebElement deceaseddeathDateError;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'birth-date')]/span[1]")
	WebElement deceasedbirthDateError;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'control-15')]/span[1]")
	WebElement deceasedPOBError;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'first-name-2')]/span[1]")
	WebElement applicantFirstNameError;

	@FindBy(how=How.XPATH,using="//span[contains(@id,'last-name-2')]/span[1]")
	WebElement applicantLastNameError;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'email-address')]/span[1]")
	WebElement applicantEmailAddressError;
	
	@FindBy(how=How.XPATH,using="(//span[contains(@id,'upload-identification-control')]/span[2])[2]")
	WebElement applicantUploadError;
	
	public CheckoutBirthDeathsAndMarriagesPage(WebDriver driver) {
		super(driver);
	}

	public void enterRegisterBirthChildDetails(List<Map<String,String>> childDeatilFormData) {
		
		waitTillYFormLoadingIconDisappears();
		this.waitForPageToBeReady();
		System.out.println("Enter details in child details form...");
		enterYFormData("First Name", childDeatilFormData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", childDeatilFormData.get(0).get("LastName"), "text");
		enterYFormData("I understand that as parents,",null,"checkbox");
		enterYFormData("Date of Birth", childDeatilFormData.get(0).get("DOB"), "text");
		enterYFormData("Birth Weight", childDeatilFormData.get(0).get("BirthWeight"), "text");
		enterYFormData("Gender", childDeatilFormData.get(0).get("Gender"), "select");
		enterYFormData("Country", childDeatilFormData.get(0).get("Country"), "select");
		enterYFormData("Address Line 1", childDeatilFormData.get(0).get("Address1"), "text");
		enterYFormData("City", childDeatilFormData.get(0).get("City"), "text");
		enterYFormData("Post Code", childDeatilFormData.get(0).get("PostalCode"), "text");
		clickContinue();
	}

	public void enterRegisterBirthParent1Details(List<Map<String,String>> parent1DetailFormData) {
		
		waitTillYFormLoadingIconDisappears();
		System.out.println("Enter details in parent1 details form...");
		enterYFormData("Title", parent1DetailFormData.get(0).get("Title"), "select");
		enterYFormData("First Name", parent1DetailFormData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", parent1DetailFormData.get(0).get("LastName"), "text");
		enterYFormData("Gender", parent1DetailFormData.get(0).get("Gender"), "select");
		enterYFormData("Date of Birth", parent1DetailFormData.get(0).get("DOB"), "text");
		enterYFormData("Place of Birth", parent1DetailFormData.get(0).get("PlaceOfBirth"), "text");
		enterYFormData("Father", null, "radio");
		enterYFormData("Address Line 1", parent1DetailFormData.get(0).get("Address1"), "text");
		enterYFormData("City", parent1DetailFormData.get(0).get("City"), "text");
		enterYFormData("Postcode", parent1DetailFormData.get(0).get("PostalCode"), "text");
		enterYFormData("Phone Number", parent1DetailFormData.get(0).get("PhoneNumber"), "text");
		enterYFormData("Email Address",parent1DetailFormData.get(0).get("EmailAddress"), "text");
		clickContinue();
	}
	
    public void enterRegisterBirthParent2Details(List<Map<String,String>> parent2DetailFormData) throws InterruptedException {
		
    	waitTillYFormLoadingIconDisappears();
    	System.out.println("Enter details in parent2 details form...");
		enterYFormData("Title", parent2DetailFormData.get(0).get("Title"), "select");
		enterYFormData("First Name", parent2DetailFormData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", parent2DetailFormData.get(0).get("LastName"), "text");
		enterYFormData("Gender", parent2DetailFormData.get(0).get("Gender"), "select");
		enterYFormData("Date of Birth", parent2DetailFormData.get(0).get("DOB"), "text");
		enterYFormData("Place of birth", parent2DetailFormData.get(0).get("PlaceOfBirth"), "text");
		enterYFormData("Mother", null, "radio");
		enterYFormData("Address Line 1", parent2DetailFormData.get(0).get("Address1"), "text");
		enterYFormData("City", parent2DetailFormData.get(0).get("City"), "text");
		enterYFormData("Postcode", parent2DetailFormData.get(0).get("PostalCode"), "text");	
		enterYFormData("Phone Number", parent2DetailFormData.get(0).get("PhoneNumber"), "text");
		enterYFormData("Email Address",parent2DetailFormData.get(0).get("EmailAddress"), "text");
		clickContinue();

		
	}
    
    public void parent2Unknown(){
    	
    	waitTillYFormLoadingIconDisappears();
    	System.out.println("Parent2 details unknown");
    	this.clickElement(parent2UnknownCheckBox);
    	clickContinue();
    }
	

	public void verifyReviewPage(List<Map<String, String>> pageData){
		
		log.info("Verifying review page for Regsiter A Birth...");
		String registrationOption=summaryInfoField.getText();
		try {
			Assert.assertEquals("Summary", summaryTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		if(registrationOption.contains("2 printed certificate")){
		try{
			Assert.assertEquals("Registration Options"+"\n"+"How many printed birth certificates would you like to order with this registration?*"+"\n"+"2 printed certificates", summaryInfoField.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	  }
		else{
			try{
				Assert.assertEquals("Registration Options"+"\n"+"How many printed birth certificates would you like to order with this registration?*"+"\n"+"None", summaryInfoField.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
		try{
			Assert.assertEquals("Child Details", childDetailsTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Child Details"+"\n"+pageData.get(0).get("FirstName")+" "+pageData.get(0).get("LastName")+"\n"+"I understand that as parents, we have the right to choose the given names and surname or family name of our child. However, the Registrar-General may refuse to register a name which is obscene, offensive, too long or is contrary to public interest.", childDeatilsInfoSection.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Birth Details", birthDetailsTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals(pageData.get(0).get("DOB")+"\n"+pageData.get(0).get("BirthWeight")+" grams\n"+pageData.get(0).get("Gender"), birthDetailsInfoSection.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Birth Address", birthAddressTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals(pageData.get(0).get("Country")+"\n"+pageData.get(0).get("Address1")+"\n"+pageData.get(0).get("PostalCode")+","+" "+pageData.get(0).get("City"), birthAddressInfoSection.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Parent Details", parentDetailsTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Parent 1 Details", parentDetails1Title.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals(pageData.get(1).get("Title")+" "+pageData.get(1).get("FirstName")+" "+pageData.get(1).get("LastName")+"\n"+pageData.get(1).get("Gender")+"\n"+pageData.get(1).get("DOB")+"\n"+pageData.get(1).get("PlaceOfBirth")+"\n"+"Father", parentDetails1InfoSection.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Contact Details", contactDetailsTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals(pageData.get(1).get("Title")+" "+pageData.get(1).get("FirstName")+" "+pageData.get(1).get("LastName")+"\n"+pageData.get(1).get("Address1")+"\n"+pageData.get(1).get("Country")+"\n"+pageData.get(1).get("PostalCode")+","+" "+pageData.get(1).get("City")+"\n"+pageData.get(1).get("PhoneNumber"), contactDetailsInfoSection.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Email Address", emailAddressTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals(pageData.get(1).get("EmailAddress"), emailAddressInfoSection.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try{
			Assert.assertEquals("Parent 2 Details", parentDetails2Title.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		if(pageData.get(2).get("Parent2IsUnknown").equalsIgnoreCase("False")){
		
			try{
				Assert.assertEquals(pageData.get(2).get("Title")+" "+pageData.get(2).get("FirstName")+" "+pageData.get(2).get("LastName")+"\n"+pageData.get(2).get("Gender")+"\n"+pageData.get(2).get("DOB")+"\n"+pageData.get(2).get("PlaceOfBirth")+"\n"+"Mother", parentDetails2InfoSection.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
			try{
				Assert.assertEquals("Contact Details", contactDetailsTitle.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
			try{
				Assert.assertEquals(pageData.get(2).get("Title")+" "+pageData.get(2).get("FirstName")+" "+pageData.get(2).get("LastName")+"\n"+pageData.get(2).get("Address1")+"\n"+pageData.get(2).get("Country")+"\n"+pageData.get(2).get("PostalCode")+","+" "+pageData.get(2).get("City"), parent2ContactDetails.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
			try{
				Assert.assertEquals("Email Address", emailAddressTitle.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
			try{
				Assert.assertEquals(pageData.get(2).get("EmailAddress"), emailAddressInfoSection.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
		else{
			try{
				Assert.assertEquals("Parent 2 is unknown", parent2UnknownText.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}	
		}
		
		if(pageData.get(3).get("FillBillingAddress") == "Yes"){
			
			try{
				Assert.assertEquals("Shipping Address", shippingAddressTitle.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
			try{
				Assert.assertEquals(pageData.get(3).get("Title")+" "+pageData.get(3).get("FirstName")+" "+pageData.get(3).get("LastName")+"\n"+pageData.get(3).get("Address1")+"\n"+pageData.get(3).get("City")+","+"  "+pageData.get(3).get("PostalCode")+"\n"+pageData.get(3).get("Country"), shippingaddressInfoSection.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
			try{
				Assert.assertEquals("Shipping Method", shippingMethodTitle.getText());
			}
			catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
		try{
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Application Summary", applictaionSummaryTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try{
			Assert.assertEquals("Help Desk", helpDeskTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	public void registerABirthNextButton(){
	
		this.waitForPageToBeReady();
		this.clickElement(nextButton);
	}
	
	public void bundlePageErrorMessage(){
	
		String errorMessage=bundlePageErrorMessage.getText();
		try {
			Assert.assertTrue("Please complete question [1] first.",errorMessage.contains("Please complete question [1] first.") );
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	public void childDetailsErrorMessage(){
		
		try {
			Assert.assertEquals("Please enter a first name",firstNameErrorMessage.getText());
			Assert.assertEquals("Please enter a last name",lastNameErrorMessage.getText());
			Assert.assertEquals("Please select a date of birth",dobErrorMessage.getText());
			Assert.assertEquals("Please enter the birth weight",birthWeightErrorMessage.getText());
			Assert.assertEquals("Please enter an address", address1ErrorMessage.getText());
			Assert.assertEquals("Please enter a city", cityErrorMessage.getText());
			Assert.assertEquals("Please enter a post code", postErrorMessage.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void enterMarriageDetails(List<Map<String, String>> partnerData) {
		waitTillYFormLoadingIconDisappears();
		enterYFormData("Place of Marriage", partnerData.get(0).get("MarriagePlace"), "text");
		enterYFormData("Date of Marriage (example: 23/09/2016)", partnerData.get(0).get("MarriageDate"), "text");
		clickContinue();
	}

	public void enterPartner1Details(List<Map<String, String>> partnerData) {
		waitTillYFormLoadingIconDisappears();
		enterYFormData("Title", partnerData.get(0).get("Title"), "select");
		enterYFormData("First Name", partnerData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", partnerData.get(0).get("LastName"), "text");
		enterYFormData("Gender", partnerData.get(0).get("Gender"), "select");
		enterYFormData("Date of Birth (example: 23/09/2016)", partnerData.get(0).get("DOB"), "text");
		enterYFormData("Place of Birth", partnerData.get(0).get("PlaceOfBirth"), "text");
		enterYFormData("Country", partnerData.get(0).get("Country"), "select");
		enterYFormData("Address Line 1", partnerData.get(0).get("Address1"), "text");
		enterYFormData("City", partnerData.get(0).get("City"), "text");
		enterYFormData("Postcode", partnerData.get(0).get("PostalCode"), "text");
		enterYFormData("Email Address", partnerData.get(0).get("EmailAddress"), "text");
		enterYFormData("Please upload identification details", partnerData.get(0).get("identificationProof"), "file");
		enterYFormData("Title", partnerData.get(0).get("Title"), "select");
		clickContinue();
	}

	public void enterPartner2Details(List<Map<String, String>> partnerData) {
		waitTillYFormLoadingIconDisappears();
		enterYFormData("Title", partnerData.get(0).get("Title"), "select");
		enterYFormData("First Name", partnerData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", partnerData.get(0).get("LastName"), "text");
		enterYFormData("Gender", partnerData.get(0).get("Gender"), "select");
		enterYFormData("Date of Birth (example: 23/09/2016)", partnerData.get(0).get("DOB"), "text");
		enterYFormData("Place of Birth", partnerData.get(0).get("PlaceOfBirth"), "text");
		enterYFormData("Title", partnerData.get(0).get("Title"), "select");
		clickContinue();
	}
	
	public void enterDeceasedDetails(List<Map<String, String>> deceasedDetailsData) {
		waitTillYFormLoadingIconDisappears();
		enterYFormData("Title", deceasedDetailsData.get(0).get("Title"), "select");
		enterYFormData("First Name", deceasedDetailsData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", deceasedDetailsData.get(0).get("LastName"), "text");
		enterYFormData("Gender", deceasedDetailsData.get(0).get("Gender"), "select");
		enterYFormData("Address Line 1", deceasedDetailsData.get(0).get("Address1"), "text");
		enterYFormData("City", deceasedDetailsData.get(0).get("City"), "text");
		enterYFormData("Postcode", deceasedDetailsData.get(0).get("PostalCode"), "text");
		enterYFormData("Date of Death", deceasedDetailsData.get(0).get("DateOFDeath"), "text");
		enterYFormData("Date of Birth", deceasedDetailsData.get(0).get("DateOFBirth"), "text");
		enterYFormData("Place of Birth", deceasedDetailsData.get(0).get("PlaceOfBirth"), "text");
		clickContinue();
	}
	
	public void enterApplicantDetails(List<Map<String, String>> applicantDetailsData) {
		this.waitForPageToBeReady();
		waitTillYFormLoadingIconDisappears();
		enterYFormData("Title", applicantDetailsData.get(0).get("Title"), "select");
		enterYFormData("First Name", applicantDetailsData.get(0).get("FirstName"), "text");
		enterYFormData("Last Name", applicantDetailsData.get(0).get("LastName"), "text");
		enterYFormData("Gender", applicantDetailsData.get(0).get("Gender"), "select");
		enterYFormData("Date of Birth", applicantDetailsData.get(0).get("DOB"), "text");
		enterYFormData("Your Relationship to Deceased", applicantDetailsData.get(0).get("RelationshipWithDeceased"), "select");
		enterYFormData("Address Line 1", applicantDetailsData.get(0).get("Address1"), "text");
		enterYFormData("City", applicantDetailsData.get(0).get("City"), "text");
		enterYFormData("Postcode", applicantDetailsData.get(0).get("PostalCode"), "text");
		enterYFormData("Email Address", applicantDetailsData.get(0).get("EmailAddess"), "text");
		enterYFormData("Please upload identification details", "IdentificationProof.PNG", "file");
		clickContinue();
	}

	public void futureDeathDateError(){
		try{
			Assert.assertEquals("Date of death must not be in the future", futureDateErrorMessage.getText());
		}catch (Error e) {
	    	parseErrorMessageLog(e.toString());
	    }
	}
	
	public void deceasedDetailsErrorMessage(){
		try{
			Assert.assertEquals("Please select a title", deceasedTitleError.getText());
			Assert.assertEquals("Please enter a first name",deceasedFirstNameError.getText());
			Assert.assertEquals("Please enter a last name",deceasedLastNameError.getText());
			Assert.assertEquals("Please select an option", deceasedGenderError.getText());
			Assert.assertEquals("Please enter an address", address1ErrorMessage.getText());
			Assert.assertEquals("Please enter a town or city", cityErrorMessage.getText());
			Assert.assertEquals("Please enter a post code", postErrorMessage.getText());
			Assert.assertEquals("Please select the date of death", deceaseddeathDateError.getText());
			Assert.assertEquals("Please select a date of birth", deceasedbirthDateError.getText());
			Assert.assertEquals("Please enter a place of birth", deceasedPOBError.getText());
		}catch (Error e) {
	    	parseErrorMessageLog(e.toString());
	    }
	}
	
	public void applicaDetailsErrorMessage(){
		try{
			Assert.assertEquals("Please select a title", deceasedTitleError.getText());
			Assert.assertEquals("Please enter a first name",applicantFirstNameError.getText());
			Assert.assertEquals("Please enter a last name",applicantLastNameError.getText());
			Assert.assertEquals("Please select an option", deceasedGenderError.getText());
			Assert.assertEquals("Please select a date of birth", deceasedbirthDateError.getText());
			Assert.assertEquals("Please enter an address", address1ErrorMessage.getText());
			Assert.assertEquals("Please enter a town or city", cityErrorMessage.getText());
			Assert.assertEquals("Please enter a post code", postErrorMessage.getText());
			Assert.assertEquals("Please enter a valid email address - example@yourdomain.com", applicantEmailAddressError.getText());
			Assert.assertEquals("Please upload a valid file of type - pdf, .jpg, or .png and max. 3 MB in size", applicantUploadError.getText());
		}catch (Error e) {
	    	parseErrorMessageLog(e.toString());
	    }
	}
	
	public void registerABirthPrefilling(){
		this.waitForPageToBeReady();
		 try{
//			 	Assert.assertEquals("Miss", title.getAttribute("text"));
			 	Assert.assertEquals("Automation", firstName.getAttribute("value"));
				Assert.assertEquals("Citizen", lastName.getAttribute("value"));
				Assert.assertEquals("230 Primary Street", addressLine1.getAttribute("value"));
				Assert.assertEquals("Rosebud", city.getAttribute("value"));
				Assert.assertEquals("1000", registerBirthPostCode.getAttribute("value"));
				Assert.assertEquals("0011234567", phoneNumber.getAttribute("value"));
				Assert.assertEquals("automationtestuser@stateofrosebud.com", emailAddress.getAttribute("value"));
			}catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
	 }
	 
	 	
	public void saveAndCloseChildDeatilsErrorMessage(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Please enter a city", cityErrorMessage.getText());
			Assert.assertEquals("Please enter a post code", postErrorMessage.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

}
