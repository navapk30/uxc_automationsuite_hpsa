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

/**
 * @author tarundeepsharma
 *
 */
public class CheckoutPaymentBillingAddressPage extends BaseDriver {

	/**
	 * @param driver
	 */
	public CheckoutPaymentBillingAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.LINK_TEXT, using = "Payment & Billing Address")
	WebElement paymentHeadingField;

	@FindBy(how = How.CSS, using = "div.headline")
	WebElement cardHeadingField;

	@FindBy(how = How.ID, using = "card_cardType")
	WebElement cardTypeField;

	@FindBy(how = How.ID, using = "card_nameOnCard")
	WebElement nameOnCardField;

	@FindBy(how = How.ID, using = "card_accountNumber")
	WebElement cardNumberField;

	@FindBy(how = How.ID, using = "card_cvNumber")
	WebElement cardCvvField;

	@FindBy(how = How.ID, using = "ExpiryMonth")
	WebElement ExpiryMonthField;

	@FindBy(how = How.ID, using = "ExpiryYear")
	WebElement ExpiryYearField;

	@FindBy(how = How.ID, using = "savePaymentInfo1")
	WebElement savePaymentInfoField;

	@FindBy(how = How.XPATH, using = "//input[@id='useDeliveryAddress' and @type='checkbox']")
	WebElement useDeliveryAddressField;

	@FindBy(how = How.XPATH, using = "//input[@id='usePrimaryAddress' and @type='checkbox']")
	WebElement usePrimaryAddressField;

	@FindBy(how = How.XPATH, using = "//form[@id='silentOrderPostForm']/div[10]/button")
	WebElement silentOrderSubmitField;

	@FindBy(how = How.ID, using = "address.country")
	WebElement addressCountryDropDownField;

	@FindBy(how = How.ID, using = "address.title")
	WebElement addressTitleFiled;

	@FindBy(how = How.ID, using = "address.firstName")
	WebElement addressFirstNameFiled;

	@FindBy(how = How.ID, using = "address.surname")
	WebElement addressLastNameFiled;

	@FindBy(how = How.ID, using = "address.line1")
	WebElement addressLine1Filed;

	@FindBy(how = How.ID, using = "address.townCity")
	WebElement addressCityFiled;

	@FindBy(how = How.ID, using = "address.postcode")
	WebElement addressPostalCodeFiled;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Next')]")
	WebElement paymentAndAddressNextButtonFiled;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'saved-payments')]")
	WebElement useSavedCardButtonFiled;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Use these payment details')]")
	WebElement usePaymentDetailsButtonField;

	public void verifyPaymentPagedisplayed() {
		try {
			Assert.assertEquals("Payment & Billing Address", paymentHeadingField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("CARD DETAILS", cardHeadingField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	/**
	 * 
	 * @param paymentInfo
	 * @param unCheckUseDeliveryAddress
	 * @param checkUsePrimaryAddress
	 * @throws InterruptedException 
	 */
	public void enterPaymentInfo(List<Map<String, String>> paymentInfo, boolean unCheckUseDeliveryAddress,
			boolean checkUsePrimaryAddress) throws InterruptedException {

		log.info("Entering card detail form...");
		this.selectDropdownValue(cardTypeField, paymentInfo.get(0).get("CardType"));
		// this.typeText(nameOnCardField, paymentInfo[1]);
		this.typeText(cardNumberField, paymentInfo.get(0).get("CardNumber"));
		this.selectDropdownValue(ExpiryMonthField, paymentInfo.get(0).get("ExpMonth"));
		this.selectDropdownValue(ExpiryYearField, paymentInfo.get(0).get("ExpYear"));
		this.typeText(cardCvvField, paymentInfo.get(0).get("Cvv"));

		if (unCheckUseDeliveryAddress) {
			this.clickElement(useDeliveryAddressField);
		}
		if (checkUsePrimaryAddress) {
			this.clickElement(usePrimaryAddressField);
		}
		if (paymentInfo.get(0).get("Country") != null) {
			this.selectDropdownValue(addressCountryDropDownField, paymentInfo.get(0).get("Country"));
			Thread.sleep(3000);
			this.selectDropdownValue(addressTitleFiled, paymentInfo.get(0).get("Title"));
			this.typeText(addressFirstNameFiled, paymentInfo.get(0).get("FirstName"));
			this.typeText(addressLastNameFiled, paymentInfo.get(0).get("LastName"));
			this.typeText(addressLine1Filed, paymentInfo.get(0).get("Address1"));
			this.typeText(addressCityFiled, paymentInfo.get(0).get("City"));
			this.typeText(addressPostalCodeFiled, paymentInfo.get(0).get("PostalCode"));
		}
		//this.clickElement(paymentAndAddressNextButtonFiled);
	}

	public void verifyIfPaymentMethodStepIsDisplayed() {
		log.info("verifying card detail form...");
		if (!checkoutHeadingField.isDisplayed()) {
			Assert.fail();
		}
	}
	
	public void selectSavedCard(){
		
		this.clickElement(useSavedCardButtonFiled);
		this.clickElement(usePaymentDetailsButtonField);
	}
}
