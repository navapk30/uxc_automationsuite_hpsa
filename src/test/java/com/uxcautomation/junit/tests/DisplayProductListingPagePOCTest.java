package com.uxcautomation.junit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.DisplayProductListPagePOC;
import com.uxcautomation.selenium.pageobjects.HomePage;

public class DisplayProductListingPagePOCTest extends TestBaseSetup {

	private DisplayProductListPagePOC display;

	public DisplayProductListingPagePOCTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Before
	public void setup() throws Exception {

		driver = getDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
	}
	@Test
	public void verifyProductListingPLP() throws Exception {

		driver.get(baseUrl);
		display = PageFactory.initElements(driver, DisplayProductListPagePOC.class);

		display.verifyPLPPageForCategory("BIRTHS, DEATHS & MARRIAGES");
		
	    
	}

	@After
	public void tearDown() throws Exception {
//		 driver.quit();

	}
}
