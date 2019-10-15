package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PoolBuildingPermitOrderConfirmationPage extends OrderConfirmationPage {
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Confirmation - Pool Building Permit')]")
	WebElement pbpConfirmationPageTitle;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Where there are joint or several owners of the land, only one can apply')]")
	private WebElement applicationDetailsInfo;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Title')]/following-sibling::span[contains(@class,\"xforms-select1\")]")
	private WebElement title;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'First Name')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Last Name')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Your Date of Birth')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement dateOfBirth;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Address Line 1')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement addressLine1;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Post Code')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement postcode;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Phone Number')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Email Address')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement emailAddress;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Registered Owners')]")
	private WebElement registeredOwnersTitle;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Development Application Approval Number')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement devAppApprovalNum;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Complying Development Certificate Approval Number')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement complyDevCertNum;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Certifier Number')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement certifierNumber;

	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'Market Value of the Work')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement marketValueOfWork;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Do you understand')]/following-sibling::span[1]/span[@class='xforms-selected']")
	private WebElement offenceQuestion;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Has the contractor')]/following-sibling::span[1]/span[@class='xforms-selected']")
	private WebElement certOfInsuranceQuestion;
	
	@FindBy(how = How.XPATH, using = "//*[@class='xforms-label' and contains(text(),'City')]/following-sibling::span[contains(@class,\"xforms-field\")]")
	private WebElement city;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'card-section-h2') and contains(text(),'Application Totals')]")
	private WebElement applicationTotals;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'card-section-h2') and contains(text(),'Billing Address')]")
	private WebElement paymentAndBillingAddress;
	
	public PoolBuildingPermitOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public void verifyPoolBuildingPermitConfirmationPage(List<Map<String, String>> pageData) {
		log.info("Verifying confirmation page for Pool Building Permit");
		String refernceNumberContent = refernceNumberFiled.getText();
		try {
			Assert.assertEquals("Confirmation - Pool Building Permit", pbpConfirmationPageTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertTrue("Reference Number", refernceNumberContent.contains("Reference Number"));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("Summary", summaryTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertTrue(applicationDetailsInfo.getText().contains("Applicant Details") && applicationDetailsInfo
					.getText().contains("(Where there are joint or several owners of the land, only one can apply)"));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("title"), title.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("firstName"), firstName.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("lastName"), lastName.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		// Verifying the year
		String[] dateAsArray = pageData.get(0).get("DOB").split("-");
		try {
			if (dateAsArray.length != 0) {
				Assert.assertTrue(dateOfBirth.getText().contains(dateAsArray[0]));
			}
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("addressLine1"), addressLine1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("city"), city.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("postCode"), postcode.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("PhoneNumber"), phoneNumber.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(0).get("emailAddress"), emailAddress.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Registered Owners", registeredOwnersTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("devAppApprovalNum"), devAppApprovalNum.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("complyDevCertApprovalNum"), complyDevCertNum.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("certifierNum"), certifierNumber.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("marketValueOfTheWork"), marketValueOfWork.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(pageData.get(1).get("offenceQuestion"), offenceQuestion.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals(pageData.get(1).get("certOfInsuranceQuestion"), certOfInsuranceQuestion.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddress.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("Application Totals", applicationTotals.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
}
