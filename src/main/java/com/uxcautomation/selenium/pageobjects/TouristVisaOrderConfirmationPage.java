package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TouristVisaOrderConfirmationPage extends OrderConfirmationPage {

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-content']/div[1]/p")
	WebElement referenceNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-content']/div[2]/p")
	WebElement thankYouMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h1' and contains(text(),'Consent Declaration')]")
	WebElement consentDeclarationTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Application Totals')]")
	WebElement applictaionTotalsTitle;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Confirmation - Apply for Tourist Visa')]")
	WebElement confirmationTitle;

	
	public TouristVisaOrderConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void verifyTouristVisaConfirmationPageIsDisplayed(List<Map<String,String>> touristVisaPageData) {
		
		log.info("Tourist visa confirmation page");
		if (!referenceNumber.getText().contains("Reference Number")) {
			Assert.fail("Reference number not found");
		}
		if (!thankYouMessage.getText()
				.contains("Thank you for submitting your service order! We have sent a confirmation email")) {
			Assert.fail("confirmation email thank you message not found");
		}

		try {
			Assert.assertEquals("Confirmation - Apply for Tourist Visa", confirmationTitle.getText());
			Assert.assertEquals("Summary", summaryTitle.getText());
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
			Assert.assertEquals("Application Totals", applictaionTotalsTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}

}

