/**
 * 
 */
package com.uxcautomation.junit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.StoreLocatorPage;

/**
 * @author tarundeepsharma
 *
 */
public class StoreLocatorTest extends TestBaseSetup{

	/**
	 * @throws IOException
	 */
	public StoreLocatorTest() throws IOException {
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
		StoreLocatorPage slp = homePage.goStoreFinderPage();
		slp.verifyStoreLocatorDisplayed();
		slp.verifyStoreSearchShowResult();
		
	}
	

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();

	  }
	

}
