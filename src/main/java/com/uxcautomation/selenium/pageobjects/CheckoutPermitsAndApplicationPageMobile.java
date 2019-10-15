package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutPermitsAndApplicationPageMobile extends CheckoutPermitsAndApplicationPage {

	public CheckoutPermitsAndApplicationPageMobile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyReviewPageForEventPermit(List<Map<String,String>> eventPermitPageData){
		
	    log.info("Event Permit Review page");
		try{
			Assert.assertEquals("Summary", summaryTitle.getText());
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
			Assert.assertEquals("Consent Declaration", consentDeclarationTitle.getText());
		}catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
	   }
	
	 public void verifyReviewPageForTouristVisa(List<Map<String,String>> touristVisaPageData){
			
		    log.info("Tourist visa Review page");
			try{
				Assert.assertEquals("Summary", summaryTitle.getText());
				Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
				Assert.assertEquals("Application Totals", applicationTotals.getText());
			}catch (Error e) {
				parseErrorMessageLog(e.toString());
			}			
	 }

}
