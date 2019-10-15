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
public class OrderConfirmationPage extends BaseDriver {

	private String screenName = "OrderConfirmation";

	@FindBy(how = How.XPATH, xpath = "//a[contains(@href, '/yacceleratorstorefront/en/login')]")
	private WebElement loginLink;

	@FindBy(how = How.CSS, using = "div.orderHead > div")
	WebElement orderConfirmationMessageField;

	@FindBy(how = How.CSS, using = "div.headline")
	WebElement deliveryAddressHeadField;

	@FindBy(how = How.CSS, using = "div.orderBox.delivery > div.headline")
	WebElement deliveryMethodHeadField;

	@FindBy(how = How.CSS, using = "div.left > div.headline")
	WebElement paymentDetailsHeadField;

	@FindBy(how = How.CSS, using = "div.orderList > div.headline")
	WebElement deliveryItemsHeadField;

	@FindBy(how = How.ID, using = "header2")
	WebElement productDetailsHeadingField;

	@FindBy(how = How.ID, using = "header5")
	WebElement ItemPriceHeadingField;

	@FindBy(how = How.CSS, using = "thead > tr > td")
	WebElement orderTotalHeadingField;

	@FindBy(how = How.CSS, using = "tfoot > tr > td")
	WebElement orderTotalFootHeadingField;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Confirmation - Report Graffiti')]")
	WebElement confirmationPageTitle;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Number')]")
	WebElement refernceNumberFiled;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Thank you for submitting')]")
	WebElement thankyouTextFiled;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Summary')]")
	WebElement summaryTitle;

	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Type of damaged item :')]")
	WebElement damageItemTitle;

	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Comment or Description:')]")
	WebElement commentsTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='review-section-content'][2]/div")
	WebElement updateSectionField;

	@FindBy(how = How.XPATH, using = "//div[@class='review-section-content']/div[2]")
	WebElement damgeItemOption;

	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Location :')]")
	WebElement locationTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='review-section-content']/div[4]")
	WebElement addressLine1;

	@FindBy(how = How.XPATH, using = "//div[@class='review-section-content']/div[6]")
	WebElement city;

	@FindBy(how = How.XPATH, using = "//div[@class='review-section-content']/div[7]")
	WebElement postCode;

	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Attachment : ')]")
	WebElement attachmentTitle;

	public String keepUpdateCheck;

	//Generic
	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Shipping Address')]")
	WebElement shippingAddressTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Shipping Address')]/following-sibling::div")
	WebElement shippingaddressInfoSection;

	
	@FindBy(how=How.XPATH,using="//div[@class='card-section-h2' and contains(text(),'Shipping Method')]")
	WebElement shippingMethodTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Payment & Billing Address')]")
	WebElement paymentAndBillingAddressTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Application Summary')]")
	WebElement applictaionSummaryTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Application Totals')]")
	WebElement applictaionTotalsTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2']/h2[contains(text(),'Help Desk')]")
	WebElement helpDeskTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h1' and contains(text(),'Consent Declaration')]")
	WebElement consentDeclarationTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='card-section-content']/div[1]/p")
	WebElement referenceNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-content']/div[2]/p")
	WebElement thankYouMessage;
	

	/**
	 * @param driver
	 */
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyReportGraffitiConfirmationPage(List<Map<String, String>> dataToCompare) {

		log.info("Report Graffiti confirmation page review started...");
		String refernceNumberContent = refernceNumberFiled.getText();
		log.info("Data passed here :" + dataToCompare);

		try {
			Assert.assertEquals("Confirmation - Report Graffiti", confirmationPageTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertTrue("Reference Number", refernceNumberContent.contains("Reference Number"));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		if (dataToCompare.get(0).get("userEmail") != null) {
			try {
				Assert.assertEquals(
						"Thank you for submitting your service order! We have sent a confirmation email to "
								+ dataToCompare.get(0).get("userEmail") + "." + "\n" + "\n"
								+ "We will notify you of any updates to your service order via email. You can also check the progress of your service order under My Account in My Applications & Requests.",
						thankyouTextFiled.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		} else {
			try {
				Assert.assertEquals("Thank you for submitting your service order!", thankyouTextFiled.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
		try {
			Assert.assertEquals("Summary", summaryTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Type of damaged item :", damageItemTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals(dataToCompare.get(0).get("Type"), damgeItemOption.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Location :", locationTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals(dataToCompare.get(0).get("Address1"), addressLine1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals(dataToCompare.get(0).get("city"), city.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals(dataToCompare.get(0).get("postcode"), postCode.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		// try{
		// Assert.assertEquals("Location :"+dataToCompare.get(0).get("Address1")
		// +" "+dataToCompare.get(0).get("city")+""+", United Kingdom"+" "+
		// dataToCompare.get(0).get("postcode"),
		// driver.findElement(By.xpath("//div[@class='review-section-content']/div[4]")).getText().replace("\n",
		// " "));
		// }catch (Error e) {
		// parseErrorMessageLog(e.toString());
		// }

		try {
			Assert.assertEquals("Comment or Description:", commentsTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Attachment :", attachmentTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		keepUpdateCheck = dataToCompare.get(0).get("KeepUpdate");

		if (keepUpdateCheck.equalsIgnoreCase("true")) {

			try {
				Assert.assertEquals("Further updates about this incident will be communicated to "
						+ dataToCompare.get(1).get("name") + " by email on the following email address "
						+ dataToCompare.get(1).get("email"), updateSectionField.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}

		}
	}

	protected void verifyShippingAddress(Map<String, String> pageData) {
		try {
			Assert.assertEquals("Shipping Address", shippingAddressTitle.getText());
			Assert.assertEquals(
					pageData.get("Title") + " " + pageData.get("FirstName") + " " + pageData.get("LastName") + "\n"
							+ pageData.get("Address1") + "\n" + pageData.get("City") + "," + "  "
							+ pageData.get("PostalCode") + "\n" + pageData.get("Country")+"\n"+"\n"+pageData.get("PhoneNumber"),
					shippingaddressInfoSection.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	protected void verifyShippingMethod(Map<String,String> pageData) {
		try{
			Assert.assertEquals("Shipping Method", shippingMethodTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	protected void verifyPaymentMethod(Map<String,String> pageData) {
		try{
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
		}
		catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	
	
	
}
