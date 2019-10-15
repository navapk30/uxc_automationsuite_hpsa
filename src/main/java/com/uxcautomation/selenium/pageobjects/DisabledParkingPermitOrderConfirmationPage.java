package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author mkuppuchamy
 *
 */
public class DisabledParkingPermitOrderConfirmationPage extends OrderConfirmationPage {


	public DisabledParkingPermitOrderConfirmationPage(WebDriver driver) {
		super(driver);
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
			Assert.assertEquals("Confirmation - Apply for Disabled Parking Permit", summaryTitle.getText());
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
