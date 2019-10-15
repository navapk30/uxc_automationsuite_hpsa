/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.junit.Assert;

/**
 * @author tarundeepsharma
 *
 */
public class LoginPage extends BaseDriver {

	/**
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);

		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.ID, using = "j_username")
	private WebElement usernameField;

	@FindBy(how = How.ID, using = "j_password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//button[@type='submit' and contains(text(),'Login')]")
	private WebElement submitLogin;

	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/yacceleratorstorefront/en/logout')]")
	public WebElement signoutLinkField;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger alert-dismissable']")
	public WebElement loginErrorField2;

	@FindBy(how = How.CSS, using = "div.alert.negative")
	public WebElement loginErrorField;
	
	@FindBy(how = How.CSS, using = "div.login-section >div.headline> h2")
	WebElement loginSignInTitle;

	@FindBy(how = How.CSS, using = "div.register-section >div.headline> h2")
	WebElement loginRegsiterTitle;
	
	// Verify Login page displayed

	public void verifyLoginPageDisplayed() {
		/*try {
			Assert.assertEquals("Sign in / Register", driver.findElement(By.cssSelector("li.active")).getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}*/
		this.getWhenElementVisible(loginSignInTitle, 30);
		try {
			Assert.assertEquals("Login | Public Sector Site", driver.getTitle());

		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Sign In - Returning Citizen",
					loginSignInTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		/*try {
			Assert.assertEquals("Returning Customer",
					driver.findElement(By.cssSelector("div.login-section > div.headline")).getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}*/
	}

	// Perform login submit execution
	public void doLogin(String username, String password) {

		this.typeText(usernameField, username);
		this.typeText(passwordField, password);
		this.clickElement(submitLogin);

	}

	// Verify the Login is successful
	public void verifyIsLoginSuccessfullwithCorrectCredentials(String username, String password) throws Exception {
		log.info("Performing Login test with correct details for desktop..");
		doLogin(username, password);
		this.waitForPageToBeReady();
		this.getWhenElementVisible(signoutLinkField, 60);

		try {
			Assert.assertEquals("SIGN OUT", signoutLinkField.getText().toUpperCase().trim());
		} catch (Error e) {
			// this.getScreenshot("LoginError");
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyIsLoginNotSuccessfulwithBadCredentials(String username, String password) throws Exception {
		log.info("Performing Login test with wrong details..");
		doLogin(username, password);
		try {
			Assert.assertEquals("Your email address or password was incorrect.",
					getStringErrorMessageFromErrorDiv(loginErrorField2));
		} catch (Error e) {
			this.getScreenshot("LoginErrorIncorrectDetails");
			parseErrorMessageLog(e.toString());

		}
		/*
		 * try { Assert.assertEquals("Your username or password was incorrect."
		 * ,loginErrorField.getText()); } catch (Error e) {
		 * this.getScreenshot("LoginErrorIncorrectDetails");
		 * parseErrorMessageLog(e.toString()); }
		 */

	}

}
