package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutRoadsAndVehiclesPageMobile extends CheckoutRoadsAndVehiclesPage {

	public CheckoutRoadsAndVehiclesPageMobile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void verifyIfAllInformationInReviewPageIsDisplayed(List<Map<String, String>> pageData) {

		try {
			Assert.assertEquals("Summary", summaryTitle.getText());
			Assert.assertEquals("Shipping Address", shippingAddressTitle.getText());
			Assert.assertEquals("Shipping Method", shippingMethodTitle.getText());
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
			Assert.assertEquals("Consent Declaration", consentDeclarationTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
}
