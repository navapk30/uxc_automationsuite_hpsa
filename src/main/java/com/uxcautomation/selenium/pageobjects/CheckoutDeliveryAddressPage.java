/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author tarundeepsharma
 *
 */
public class CheckoutDeliveryAddressPage extends BaseDriver {
	
	@FindBy(how=How.LINK_TEXT,using="Shipment/Pick Up Location")
	WebElement shippingLinkField;
	
	@FindBy(how=How.CSS,using="button.addToCartButton.")
	WebElement addToBagField;

	@FindBy(how=How.ID,using="address.country")
	WebElement countryField;
	
	@FindBy(how=How.XPATH,using="//select[@id='address.title' and @name='titleCode']")
	WebElement titleField;
	
	@FindBy(how=How.ID,using="address.firstName")
	WebElement firstnameField;
	
	@FindBy(how=How.ID,using="address.surname")
	WebElement surnameField;
	
	@FindBy(how=How.ID,using="address.line1")
	WebElement addressLine1Field;
	
	@FindBy(how=How.ID,using="address.townCity")
	WebElement townField;
	
	@FindBy(how=How.ID,using="address.region")
	WebElement regionField;
	
	@FindBy(how=How.ID,using="address.postcode")
	WebElement postcodeField;
	
	@FindBy(how=How.ID,using="saveAddressInMyAddressBook")
	WebElement saveAddressField;
	
	@FindBy(how=How.ID,using="addressSubmit")
	WebElement submitField;
	
	@FindBy(how = How.XPATH, using = "//select[@id='address.country']")
	WebElement addressCountryField;

	/**
	 * @param driver
	 */
	public CheckoutDeliveryAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyDeliveryPageDisplayed(){
		try {
		      Assert.assertEquals("Shipment/Pick Up Location", shippingLinkField.getText());
		    } catch (Error e) {
		    	parseErrorMessageLog(e.toString());
		    }
		
	}
	
	public CheckoutShippingMethodPage verifyUserCanProvideDeliveryAddress(){
		 selectDropdownValue(countryField, "Canada");
		 selectDropdownValue(titleField, "Mr.");
		 typeText(firstnameField, "Testing");
		 typeText(surnameField, "Lastname");
		 typeText(addressLine1Field, "333 Fun Street");
		 typeText(townField, "Sydney");
		 selectDropdownValue(regionField, "Ontario");
		 typeText(postcodeField, "2345");
		 clickElement(saveAddressField);
		 clickElement(submitField);
		 
		 return PageFactory.initElements(driver, CheckoutShippingMethodPage.class);
	}
	
	public void verifyIfShippingAddressStepIsDisplayed() {
		log.info("verifying shipping detail form...");
		 if (!checkoutHeadingField.isDisplayed()){
		 Assert.fail();
		 }
	}

	public void enterShippingAddressInfo(List<Map<String, String>> deliveryAddress){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.selectDropdownValue(addressCountryField, deliveryAddress.get(0).get("Country"));
//		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='address.title']")));
//
		this.selectDropdownValue(titleField, deliveryAddress.get(0).get("Title"));
		this.typeText(firstnameField, deliveryAddress.get(0).get("FirstName"));
		this.typeText(surnameField, deliveryAddress.get(0).get("LastName"));
		this.typeText(addressLine1Field, deliveryAddress.get(0).get("Address1"));
		this.typeText(townField, deliveryAddress.get(0).get("City"));
		this.typeText(postcodeField, deliveryAddress.get(0).get("PostalCode"));
	}
	
	
}
