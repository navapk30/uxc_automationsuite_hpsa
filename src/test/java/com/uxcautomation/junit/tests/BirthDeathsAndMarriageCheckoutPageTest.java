package com.uxcautomation.junit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.uxcautomation.selenium.pageobjects.CheckoutSignupLoginPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListBirthDeathMarriagePage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;

public class BirthDeathsAndMarriageCheckoutPageTest extends TestBaseSetup {

	DisplayProductListBirthDeathMarriagePage display;

	public BirthDeathsAndMarriageCheckoutPageTest() throws IOException {

	}

	@Before
	public void setup() throws Exception {

		driver = getDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void testRegisterBirthCheckout() throws Exception {

		/*driver.get(baseUrl);
		homePage.goToProductListingPage("births-deaths-and-marriage");
		display = PageFactory.initElements(driver, DisplayProductListBirthDeathMarriagePage.class);

		display.verifyProductListingIsDisplayed();
		display.addServiceToCartFromPLP("register-birth");

		CheckoutSignupLoginPage signUp = PageFactory.initElements(driver, CheckoutSignupLoginPage.class);
		signUp.doGuestLogin("mani@mani.com", "mani@mani.com");

		BirthDeathsAndMarriagesCheckoutCartPage cartPage = PageFactory.initElements(driver,
				BirthDeathsAndMarriagesCheckoutCartPage.class);
		cartPage.selectBundleOption("birthcert-print1-addon");
		//cartPage.enterRegisterBirthChildDetails();
		//cartPage.enterRegisterBirthParentDetails();
		String[] deliveryInfo = { "Jersey","Mr.", "City", "First Name", "addressLine1", "Last name", "12464" };
		cartPage.verifyIfShippingAddressStepIsDisplayedAndEnterAddress(deliveryInfo);
		cartPage.verifyIfShippingMethodStepIsDisplayedAndEnterShippingMethod("standard-gross");
		String[] paymentInfo = { "Visa", "Manikandan", "4111111111111111", "2020", "08", "123" };
		cartPage.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentInfo);
		cartPage.verifyIfReviewPageStepIsDisplayedAndPlaceOrder();
	    cartPage.verifyIsConfirmationDisplayed();*/
	    
	}

	@After
	public void tearDown() throws Exception {
//		 driver.quit();

	}

}
