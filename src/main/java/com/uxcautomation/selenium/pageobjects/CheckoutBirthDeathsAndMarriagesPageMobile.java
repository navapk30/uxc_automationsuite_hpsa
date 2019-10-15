package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutBirthDeathsAndMarriagesPageMobile extends CheckoutBirthDeathsAndMarriagesPage{

	public CheckoutBirthDeathsAndMarriagesPageMobile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void verifyReviewPage(List<Map<String, String>> pageData){
		
		log.info("Verifying review page for Regsiter A Birth...");
		this.waitForPageToBeReady();
		String registrationOption=summaryInfoField.getText();
		try {
			Assert.assertEquals("Summary", summaryTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		if(registrationOption.contains("2 printed certificate")){
		try{
			Assert.assertEquals("Registration Options"+"\n"+"How many printed birth certificates would you like to order with this registration?*"+"\n"+"2 printed certificate", summaryInfoField.getText());
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
			Assert.assertEquals(pageData.get(1).get("Title")+" "+pageData.get(1).get("FirstName")+" "+pageData.get(1).get("LastName")+"\n"+pageData.get(1).get("Address1")+"\n"+pageData.get(1).get("Country")+"\n"+pageData.get(1).get("PostalCode")+","+" "+pageData.get(1).get("City"), contactDetailsInfoSection.getText());
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
	}
}
