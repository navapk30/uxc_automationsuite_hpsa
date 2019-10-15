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

/**
 * @author tarundeepsharma
 *
 */
public class CheckoutFinalReviewPage extends BaseDriver {

	private String screenName = "CheckoutFinalReviewPage";

	/**
	 * @param driver
	 */
	public CheckoutFinalReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.CSS, using = "li.step.active > a")
	WebElement finalReviewLinkField;

	@FindBy(how = How.CSS, using = "div.headline")
	WebElement finalReviewHeadField;

	@FindBy(how = How.CSS, using = "div.column.append-1 > strong")
	WebElement deliveryOpitonsHeadField;

	@FindBy(how = How.CSS, using = "div.summaryPayment.clearfix > div.column.append-1 > strong")
	WebElement summaryPaymentHeadField;

	@FindBy(how = How.CSS, using = "li > strong")
	WebElement billingAddressHeadField;

	@FindBy(how = How.CSS, using = "strong")
	WebElement deliveryAddressHeadField;

	@FindBy(how = How.CSS, using = "div.terms > label")
	WebElement termsConditionField;

	@FindBy(how = How.ID, using = "Terms1")
	WebElement termsConditionCheckboxField;

	@FindBy(how = How.XPATH, using = "//button[@type='submit' and contains(text(),'Place Order')]")
	WebElement submitFinalOrderField;

	@FindBy(how = How.ID, using = "placeOrder")
	WebElement placeOrderBtn;

	@FindBy(how = How.XPATH, using = ".//div[contains(@class,'alert-danger alert-dismissable')]")
	WebElement alertMessage;

	public void verifyFinalReviewPageIsDisplayed() {
		log.info("Verifying the final review page under verifyFinalReviewPageIsDisplayed");
		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (isElementPresent(finalReviewLinkField))
					break;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Assert.assertEquals("Final Review", finalReviewLinkField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("FINAL REVIEW", finalReviewHeadField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Delivery Options", deliveryOpitonsHeadField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Payment Details", summaryPaymentHeadField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Billing Address:", billingAddressHeadField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Delivery Address", deliveryAddressHeadField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals(
					"By placing the order, I am confirming that I have read and agree with the Terms & Conditions",
					termsConditionField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		this.getScreenshot(screenName);
	}

	public OrderConfirmationPage verifyUserCanSubmitOrderAfterReview() {
		clickElement(termsConditionCheckboxField);
		clickElement(submitFinalOrderField);
		return PageFactory.initElements(driver, OrderConfirmationPage.class);

	}

	public void verifyIfReviewPageStepIsDisplayed() {
		if (!checkoutHeadingField.isDisplayed()) {
			Assert.fail();
		}
	}

	public void verifyIfUserCanPlaceOrder() {
		clickElement(placeOrderBtn);
	}

	public void verifyPaymentInfoErrorIsDisplayed() {
		try {
			Assert.assertTrue(alertMessage.getText()
					.contains("Please check your payment details are correct or provide a different payment method."));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyConsentDeclarationErrorIsDisplayed() {
		try {
			Assert.assertTrue(alertMessage.getText()
					.contains("Please accept consent declaration(s) before applying for service."));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
}
