/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author tarundeepsharma
 *
 */
public class CheckoutSignupLoginPage extends BaseDriver {
	
	@FindBy(how = How.XPATH, using = "//input[@id='guest.email']")
	private WebElement guestEmailField;

	@FindBy(how = How.ID, using = "guest.confirm.email")
	private WebElement guestConfirmEmailField;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit' and contains(text(),'Continue as a Guest')]")
	private WebElement submitGuestLogin;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Refine by Vehicle Type')]")
	WebElement facetRefineByVechileTypeField;


	/**
	 * @param driver
	 */
	public CheckoutSignupLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void doGuestLogin(String guestEmail, String guestConfirmEmail) {
		
		this.waitForPageToBeReady();
		this.getWhenElementVisible(guestEmailField, 80);
		this.typeText(guestEmailField, guestEmail);
		this.typeText(guestConfirmEmailField, guestConfirmEmail);
		this.clickElement(submitGuestLogin);
		

	}

}
