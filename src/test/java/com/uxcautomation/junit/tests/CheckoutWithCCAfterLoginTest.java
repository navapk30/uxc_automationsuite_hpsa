/**
 * 
 */
package com.uxcautomation.junit.tests;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.CheckoutCartPage;
import com.uxcautomation.selenium.pageobjects.CheckoutDeliveryAddressPage;
import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutPaymentBillingAddressPage;
import com.uxcautomation.selenium.pageobjects.CheckoutShippingMethodPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListPage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.LoginPage;
import com.uxcautomation.selenium.pageobjects.OrderConfirmationPage;

/**
 * @author tarundeepsharma
 *
 */
public class CheckoutWithCCAfterLoginTest extends TestBaseSetup {

	/**
	 * @throws IOException
	 */
	public CheckoutWithCCAfterLoginTest() throws IOException {
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
		
		driver.get(baseUrl);
		
		LoginPage login = homePage.goToLoginPage();
		login.verifyIsLoginSuccessfullwithCorrectCredentials("test2@hybrisautomation.com", "Test1234");
		
		//DisplayProductListPage listPage =homePage.goToProductListingPage();
		//listPage.verifyProductListingIsDisplayed();
		//listPage.verifyAddToBagFromListPage();
		
		/*CheckoutCartPage chkCartPage = listPage.verifyMinicartLayerCheckout();
		chkCartPage.verifyCartDisplayedToUser();
		
		CheckoutDeliveryAddressPage chkDelAddPage = chkCartPage.goToDeliveryAddressPage();
		chkDelAddPage.verifyDeliveryPageDisplayed();
		
		CheckoutShippingMethodPage chkShpMthPage = chkDelAddPage.verifyUserCanProvideDeliveryAddress();
		
		chkShpMthPage.verifyChoosingShippingMethodDisplayed();
		
		CheckoutPaymentBillingAddressPage chkPayBillAddPage = chkShpMthPage.goToPaymentPage();
		chkPayBillAddPage.verifyPaymentPagedisplayed();
		
		CheckoutFinalReviewPage chkFinalRewPage = chkPayBillAddPage.verifyUserCanSubmitCreditcardInfo();
		chkFinalRewPage.verifyFinalReviewPageIsDisplayed();
		
		OrderConfirmationPage ordConfPage = chkFinalRewPage.verifyUserCanSubmitOrderAfterReview();
		ordConfPage.verifyOrderPlacedSuccessfully();
		*/
	    
	  }
	
	 @After
	  public void tearDown() throws Exception {
	    driver.quit();


	  }
	
}
