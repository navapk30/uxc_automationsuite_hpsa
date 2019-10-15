/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author tarundeepsharma
 *
 */
public class CheckoutShippingMethodPage extends BaseDriver {

	@FindBy(how = How.XPATH, using = "//select[@id='delivery_method']")
	WebElement deliveryMethodSelectField;
	/**
	 * @param driver
	 */
	public CheckoutShippingMethodPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyIfShippingMethodStepIsDisplayed() {
		log.info("verifying card detail form...");
		if (!checkoutHeadingField.isDisplayed() || (!checkoutHeadingField.getText().equals("Shipping Method"))) {
			Assert.fail();
		}
	}
	
	public void selectDeliveryMode(String deliveryCode){
	new Select(deliveryMethodSelectField).selectByValue(deliveryCode);
	}
}
