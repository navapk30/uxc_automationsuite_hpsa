package com.uxcautomation.junit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.uxcautomation.selenium.pageobjects.CheckoutSignupLoginPage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListBirthDeathMarriagePage;
import com.uxcautomation.selenium.pageobjects.DisplayProductListReportAnIssuePage;
import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.CheckoutBirthDeathsAndMarriagesPage;
import com.uxcautomation.selenium.pageobjects.CheckoutFinalReviewPage;
import com.uxcautomation.selenium.pageobjects.CheckoutReportAnIssuePage;

public class ReportAnIssueCheckout extends TestBaseSetup {

	DisplayProductListReportAnIssuePage display;

	public ReportAnIssueCheckout() throws IOException {

	}

	@Before
	public void setup() throws Exception {

		driver = getDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void testReportGraffiti() throws Exception {

		driver.get(baseUrl);
		homePage.goToProductListingPage("report-an-issue");
		display = PageFactory.initElements(driver, DisplayProductListReportAnIssuePage.class);
		display.verifyReportAnIssuePLP();
		display.addServiceToCartFromPLP("report-graffiti");

		CheckoutReportAnIssuePage checkoutpage=PageFactory.initElements(driver, CheckoutReportAnIssuePage.class);
//		checkoutpage.reportGraffiti_FillYformPage();
	
	}

	@Test
	public void testReportPothole() throws Exception {

		driver.get(baseUrl);
		homePage.goToProductListingPage("report-an-issue");
		display = PageFactory.initElements(driver, DisplayProductListReportAnIssuePage.class);
		display.verifyProductListingIsDisplayed();
		display.verifyReportAnIssuePLP();
		display.addServiceToCartFromPLP("report-pothole");

		CheckoutReportAnIssuePage checkoutpage=PageFactory.initElements(driver, CheckoutReportAnIssuePage.class);
//		checkoutpage.reportPotholeFillYformPage();
	}

	@After
	public void tearDown() throws Exception {
//		 driver.quit();

	}

}
