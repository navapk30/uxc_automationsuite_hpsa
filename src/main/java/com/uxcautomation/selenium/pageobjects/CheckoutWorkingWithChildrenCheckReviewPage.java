package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * CheckoutWorkingWithChildrenCheckReviewPage page object
 * 
 * @author pkumar350
 */
public class CheckoutWorkingWithChildrenCheckReviewPage extends CheckoutFinalReviewPage {

	@FindBy(how = How.CSS, using = "div.card-section-h1")
	private WebElement summaryTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='bundle-info']")
	private WebElement summaryInfoField;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Application Details')]")
	private WebElement applicationDetailsTitle;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Child-related sector')]")
	private WebElement childRelatedSectorLabel;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Child development')]")
	private WebElement childRelatedSectorData;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Have you ever applied for a Working With Children Check before?')]")
	private WebElement appliedBeforeLabel;

	@FindBy(how = How.XPATH, using = "(//span[@class='xforms-selected'])[1]")
	private WebElement appliedBeforeData;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Do you know at which specific organisation you will be using your Working with Children Check?')]")
	private WebElement specificOrgLabel;

	@FindBy(how = How.XPATH, using = "(//span[@class='xforms-selected'])[2]")
	private WebElement specificOrgData;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Title')]/following-sibling::span[contains(@class,\"xforms-select1\")]")
	private WebElement title;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'First Name')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Last Name')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Your gender')]/following-sibling::span[contains(@class,\"xforms-control\")]/span")
	private WebElement gender;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Place of Birth')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement placeOfBirth;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Your Date of Birth')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement dateOfBirth;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Country')]/following-sibling::span[contains(@class,\"xforms-control\")]/span")
	private WebElement country;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Address Line 1')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement addressLine1;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Postcode')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement postcode;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Phone Number')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Email Address')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement emailAddress;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'City')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement city;

	@FindBy(how = How.XPATH, using = "(//*[contains(@class,\"consentDeclarations\")])[1]")
	private WebElement consentDeclarations1;

	@FindBy(how = How.XPATH, using = "(//*[contains(@class,\"consentDeclarations\")])[2]")
	private WebElement consentDeclarations2;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'card-section-h2') and contains(text(),'Application Totals')]")
	private WebElement applicationTotals;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'card-section-h2') and contains(text(),'Billing Address')]")
	private WebElement paymentAndBillingAddress;

	public CheckoutWorkingWithChildrenCheckReviewPage(WebDriver driver) {
		super(driver);
	}

	public void verifyReviewPage(List<Map<String, String>> pageData) {
		log.info("Verifying review page");
		try {
			Assert.assertEquals("Summary", summaryTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		String bundleOption = "";
		boolean isVolunteerRequest = pageData.get(0).get("bundleOption").contains("volunteer");
		bundleOption = isVolunteerRequest ? "Volunteer" : "Paid employee / self employed";
		log.info("Is checkout as a volunteer: " + isVolunteerRequest);
		try {
			Assert.assertEquals("Working with Children" + "\n\n" + "Purpose for check*" + "\n" + bundleOption,
					summaryInfoField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Application Details", applicationDetailsTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Child-related sector", childRelatedSectorLabel.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("sector"), childRelatedSectorData.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Have you ever applied for a Working With Children Check before?",
					appliedBeforeLabel.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("appliedBefore"), appliedBeforeData.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(
					"Do you know at which specific organisation you will be using your Working with Children Check?",
					specificOrgLabel.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("organizationDetailsAvailable"), specificOrgData.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals(pageData.get(1).get("PhoneNumber"), phoneNumber.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("title"), title.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("firstName"), firstName.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("lastName"), lastName.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("gender"), gender.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("placeOfBirth"), placeOfBirth.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		// Verifying the year
		String[] dateAsArray = pageData.get(2).get("DOB").split("-");
		try {
			if (dateAsArray.length != 0) {
				Assert.assertTrue(dateOfBirth.getText().contains(dateAsArray[0]));
			}
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("country"), country.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("addressLine1"), addressLine1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("postCode"), postcode.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("city"), city.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(2).get("emailAddress"), emailAddress.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		if (!isVolunteerRequest) {
			try {
				Assert.assertEquals("Application Totals", applicationTotals.getText().trim());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}

			try {
				Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddress.getText().trim());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
	}

	public void agreeAllConsentDeclaration() {
		log.info("Agreeing consent declaration");
		clickElement(consentDeclarations1);
		clickElement(consentDeclarations2);
	}

}
