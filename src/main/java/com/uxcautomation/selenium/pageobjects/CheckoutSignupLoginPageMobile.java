/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author mkuppuchamy
 *
 */
public class CheckoutSignupLoginPageMobile extends  CheckoutSignupLoginPage {
	
	@FindBy(how = How.XPATH, using = "(//input[@id='guest.email'])[2]")
	private WebElement guestEmailField;

	@FindBy(how = How.XPATH, using = "(//input[@id='guest.confirm.email'])[2]")
	private WebElement guestConfirmEmailField;
	
	@FindBy(how = How.XPATH, using = "(//button[@type='submit' and contains(text(),'Continue as a Guest')])[2]")
	private WebElement submitGuestLogin;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Refine by Vehicle Type')]")
	WebElement facetRefineByVechileTypeField;


	/**
	 * @param driver
	 */
	public CheckoutSignupLoginPageMobile(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void doGuestLogin(String guestEmail, String guestConfirmEmail) {
		this.waitForPageToBeReady();
		//this.getWhenElementVisible(guestEmailField, 60);
		this.typeText(guestEmailField, guestEmail);
		this.typeText(guestConfirmEmailField, guestConfirmEmail);
		this.clickElement(submitGuestLogin);
	}

}
