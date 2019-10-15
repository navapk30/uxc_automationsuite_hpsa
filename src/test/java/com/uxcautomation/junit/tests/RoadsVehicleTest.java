package com.uxcautomation.junit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutRoadsAndVehiclesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutSignupLoginPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListRoadsAndVehiclesPage;
import com.uxcautomation.selenium.pageobjects.HomePage;

public class RoadsVehicleTest extends TestBaseSetup{
	
	DisplayProductListRoadsAndVehiclesPage display;

	public RoadsVehicleTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Before
	public void setUp()  throws Exception{
		driver = getDriver();		
		
		homePage =PageFactory.initElements(driver, HomePage.class);		
	}
	
	@Test
	public void userCanSearchStores() throws Exception{
		
		driver.get(baseUrl);
	    homePage.goToProductListingPage("roads-and-vehicles");
	    display = PageFactory.initElements(driver, DisplayProductListRoadsAndVehiclesPage.class);
	    display.verifyProductListingIsDisplayed();
	    display.verifyRoadsAndVechilePLP();
	    display.addServiceToCartFromPLP("apply-learner-driver-licence");
		CheckoutSignupLoginPage chp3 = PageFactory.initElements(driver, CheckoutSignupLoginPage.class);
		chp3.doGuestLogin("test@test.com", "test@test.com");
		
		CheckoutRoadsAndVehiclesPage checkoutCart = PageFactory.initElements(driver, CheckoutRoadsAndVehiclesPage.class);
		/*checkoutCart.fillApplicationDetailsForm();
		checkoutCart.learnerDriverLicense_FillLicenseDetailsForm();
		checkoutCart.learnerDriverLicense_FillHealthDetailsForm();*/
		//String[] paymentInfo = { "Visa", "Manikandan", "4111111111111111", "2020", "08", "123","United Kingdom", "Mr.","Test","Test","Address1","City","Code" };
		//checkoutCart.verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(paymentInfo);
		checkoutCart.verifyIfReviewPageStepIsDisplayedAndPlaceOrder();
		checkoutCart.verifyIsConfirmationPageDisplayed();
	}
	
	
	

	  @After
	  public void tearDown() throws Exception {
//	    driver.quit();

	  }

}
