/**
 * 
 */
package com.uxcautomation.junit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutRoadsAndVehiclesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutSignupLoginPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductDetailPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListRoadsAndVehiclesPage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.LoginPage;



/**
 * @author tarundeepsharma
 *
 */
public class CheckoutTest extends TestBaseSetup {

	/**
	 * @throws IOException
	 */
	public CheckoutTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	
	@Before
	public void setup()  throws Exception{
		
		driver = getDriver();
		homePage =PageFactory.initElements(driver, HomePage.class);	
		
		
	}
	//@Ignore
	@Test
	public void testCheckoutafterLogin() throws Exception {
		
		driver.get(baseUrl+"/Categories/Roads-%26-Vehicles/c/roads-and-vehicles");
	/*
		LoginPage login = homePage.goToLoginPage();
		login.verifyIsLoginSuccessfullwithCorrectCredentials("hpsatesting@hpsa.com", "Test1234");*/
		
		DisplayProductListRoadsAndVehiclesPage listingPage =PageFactory.initElements(driver, DisplayProductListRoadsAndVehiclesPage.class);
		listingPage.verifyProductListingIsDisplayed();
		listingPage.verifyRoadsAndVechilePLP();
		
		DisplayProductDetailPage productPage=listingPage.goToRoadsVechicleProductDetailPage();
		productPage.verifyIfProductDisplayPageIsDisplayed();
		productPage.verifyApplyforDisabledParkingPermitPDP();
		
//    	CheckoutSignupLoginPage checkoutSignUp=listingPage.goToRoadsVechicleGuestCheckoutCart();
//		checkoutSignUp.doGuestLogin("test@test.com","test@test.com");
		
		
//		learnerDriverLicencePage.fillApplicationDetailsForm();
		
		
		
		
	 }
	
	 @After
	  public void tearDown() throws Exception {
	    driver.quit();



	  }
	
}
