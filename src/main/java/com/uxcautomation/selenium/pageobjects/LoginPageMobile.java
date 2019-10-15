/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author tarundeepsharma
 *
 */
public class LoginPageMobile extends LoginPage {

	@FindBy(how = How.XPATH, xpath = "//button[contains(@class,'nav__row--btn-menu js-toggle-sm-navigation')]")
	public WebElement mainMobileMenu;

	@FindBy(how = How.CSS, using = "a.userSign")
	public WebElement signoutLinkField;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'js-toggle-sm-navigation btn')]")
	public WebElement closeButton;

	@FindBy(how = How.ID, using = "j_username")
	private WebElement usernameField;

	@FindBy(how = How.ID, using = "j_password")
	private WebElement passwordField;

	/**
	 * 
	 */
	/**
	 * 
	 */
	@FindBy(how = How.XPATH, using = "//button[@type='submit' and contains(text(),'Login')]")
	private WebElement submitLogin;
	/**
	 * @param driver
	 */
	public LoginPageMobile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Verify the Login is successful
	@Override
	public void verifyIsLoginSuccessfullwithCorrectCredentials(String username, String password) throws Exception {
		log.info("Performing Login test with correct details for mobile..");
		doLogin(username, password);
		
		
		try {
			this.getWhenElementVisible(mainMobileMenu, 120);
			this.clickElement(mainMobileMenu);
			this.getWhenElementVisible(signoutLinkField, 60);
			System.out.println(signoutLinkField.getText()+"=="+signoutLinkField.isDisplayed());
			Assert.assertTrue(isElementPresent(signoutLinkField));
		} catch (Error e) {
			WebElement mainMenu = FindElementBy("//button[contains(@class,'nav__row--btn-menu js-toggle-sm-navigation')]", "xpath");
			this.getWhenElementVisible(mainMenu, 120);
			mainMenu.click();
			//driver.findElement(By.xpath("//button[@type='button' and @class='btn js-toggle-sm-navigation']")).click();
			//this.getScreenshot("LoginError");
			//parseErrorMessageLog(e.toString());

		} catch(Exception e){
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("SIGN OUT", signoutLinkField.getText());
		} catch (Error e) {
			// this.getScreenshot("LoginError");
			parseErrorMessageLog(e.toString());
		}
		this.closeButton.click();
	}
	
	// Perform login submit execution
	@Override
	public void doLogin(String username, String password) {

		this.typeText(usernameField, username);
		this.typeText(passwordField, password);
		this.clickElement(submitLogin);

	}

}
