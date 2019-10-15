/**
 * 
 */
package com.uxcautomation.junit.tests;

import java.io.IOException;

/**
 * @author tarundeepsharma
 *
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.UserRegistrationPage;

/**
 * @author tarundeepsharma
 *
 */
public class UserRegistrationTest extends TestBaseSetup{

	/**
	 * @throws IOException
	 */
	public UserRegistrationTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	WebDriver driver;
	HomePage homePage;
	
	@Before
	public void setUp()  throws Exception{
		driver = getDriver();
		baseUrl = loadConfig.getsiteUrl();
		//login = PageFactory.initElements(driver, LoginPage.class);
		homePage =PageFactory.initElements(driver, HomePage.class);
			
		
	}

	
	@Test
	public void userCanDoRegistration() throws IOException{
		driver.get(baseUrl);
		
		UserRegistrationPage up = homePage.userRegistration();
		
		//up.checkFormValidationsWorking();
		up.verifyRegistrationIsSuccesfull();
		
		
	}
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();


	  }
	
}
