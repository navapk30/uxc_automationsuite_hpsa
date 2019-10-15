package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterABirthOrderConfirmationPage extends OrderConfirmationPage {

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Confirmation - Register a Birth')]")
	WebElement confirmationPageTitle;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Number')]")
	WebElement refernceNumberFiled;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Summary')]")
	WebElement summaryTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='bundle-info']")
	WebElement summaryInfoField;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Application Totals')]")
	WebElement appliactionTotalsTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h1' and contains(text(),'Child Details')]")
	WebElement childDetailsTitle;

	@FindBy(how = How.CSS, using = "div.card-450.col-xs-12.col-sm-12.col-md-12")
	WebElement childDeatilsInfoSection;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Birth Details')]")
	WebElement birthDetailsTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Birth Details')]/following-sibling::div")
	WebElement birthDetailsInfoSection;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Birth Address')]")
	WebElement birthAddressTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Birth Address')]/following-sibling::div")
	WebElement birthAddressInfoSection;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h1' and contains(text(),'Parent Details')]")
	WebElement parentDetailsTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Parent 1 Details')]")
	WebElement parentDetails1Title;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Parent 1 Details')]/following-sibling::div")
	WebElement parentDetails1InfoSection;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Parent 2 Details')]")
	WebElement parentDetails2Title;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Parent 2 Details')]/following-sibling::div")
	WebElement parentDetails2InfoSection;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h3' and contains(text(),'Contact Details')]")
	WebElement contactDetailsTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h3' and contains(text(),'Contact Details')]/following-sibling::div")
	WebElement contactDetailsInfoSection;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h3' and contains(text(),'Email Address')]")
	WebElement emailAddressTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h3' and contains(text(),'Email Address')]/following-sibling::div")
	WebElement emailAddressInfoSection;

	@FindBy(how = How.XPATH, using = "(//div[@class='card-section-h3' and contains(text(),'Contact Details')])[2]/following-sibling::div[1]")
	WebElement parent2ContactDetails;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Parent 2 is unknown')]")
	WebElement parent2UnknownText;

	public RegisterABirthOrderConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void registerABirthConfirmationPage(List<Map<String, String>> pageData) {

		log.info("Register a Birth Confirmation page");
		String refernceNumberContent = refernceNumberFiled.getText();
		String registrationOption = summaryInfoField.getText();
		try {
			Assert.assertEquals("Confirmation - Register a Birth", confirmationPageTitle.getText());

			Assert.assertTrue("Reference Number", refernceNumberContent.contains("Reference Number"));

			Assert.assertEquals("Summary", summaryTitle.getText());

			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());

			Assert.assertEquals("Application Totals", appliactionTotalsTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		verifyBundleInformationForRegisterBirth(registrationOption);
		verifyYFormVMTemplateInfoForRegisterBirth(pageData);
		if (pageData.get(3).get("FillBillingAddress") == "Yes") {

			verifyShippingAddress(pageData.get(3));
			verifyShippingMethod(pageData.get(3));
		}
		verifyPaymentMethod(pageData.get(3));
	}

	protected void verifyBundleInformationForRegisterBirth(String registrationOption) {
		if (registrationOption.contains("2 printed certificate")) {
			try {
				Assert.assertEquals("Registration Options" + "\n"
						+ "How many printed birth certificates would you like to order with this registration?*" + "\n"
						+ "2 printed certificates", summaryInfoField.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		} else {
			try {
				Assert.assertEquals("Registration Options" + "\n"
						+ "How many printed birth certificates would you like to order with this registration?*" + "\n"
						+ "None", summaryInfoField.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
	}

	protected void verifyYFormVMTemplateInfoForRegisterBirth(List<Map<String, String>> pageData) {
		try {
			Assert.assertEquals("Child Details", childDetailsTitle.getText());

			Assert.assertEquals(
					"Child Details" + "\n" + pageData.get(0).get("FirstName") + " " + pageData.get(0).get("LastName")
							+ "\n"
							+ "I understand that as parents, we have the right to choose the given names and surname or family name of our child. However, the Registrar-General may refuse to register a name which is obscene, offensive, too long or is contrary to public interest.",
					childDeatilsInfoSection.getText());

			Assert.assertEquals("Birth Details", birthDetailsTitle.getText());

			Assert.assertEquals(pageData.get(0).get("DOB") + "\n" + pageData.get(0).get("BirthWeight") + " grams\n"
					+ pageData.get(0).get("Gender"), birthDetailsInfoSection.getText());

			Assert.assertEquals("Birth Address", birthAddressTitle.getText());

			Assert.assertEquals(
					pageData.get(0).get("Country") + "\n" + pageData.get(0).get("Address1") + "\n"
							+ pageData.get(0).get("PostalCode") + "," + " " + pageData.get(0).get("City"),
					birthAddressInfoSection.getText());

			Assert.assertEquals("Parent Details", parentDetailsTitle.getText());
			Assert.assertEquals("Parent 1 Details", parentDetails1Title.getText());

			Assert.assertEquals(
					pageData.get(1).get("Title") + " " + pageData.get(1).get("FirstName") + " "
							+ pageData.get(1).get("LastName") + "\n" + pageData.get(1).get("Gender") + "\n"
							+ pageData.get(1).get("DOB") + "\n" + pageData.get(1).get("PlaceOfBirth") + "\n" + "Father",
					parentDetails1InfoSection.getText());

			Assert.assertEquals("Contact Details", contactDetailsTitle.getText());

			Assert.assertEquals(pageData.get(1).get("Title") + " " + pageData.get(1).get("FirstName") + " "
					+ pageData.get(1).get("LastName") + "\n" + pageData.get(1).get("Address1") + "\n"
					+ pageData.get(1).get("Country") + "\n" + pageData.get(1).get("PostalCode") + "," + " "
					+ pageData.get(1).get("City")+ "\n" + pageData.get(1).get("PhoneNumber"), contactDetailsInfoSection.getText());

			Assert.assertEquals("Email Address", emailAddressTitle.getText());

			Assert.assertEquals(pageData.get(1).get("EmailAddress"), emailAddressInfoSection.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		if (pageData.get(2).get("Parent2IsUnknown").equalsIgnoreCase("False")) {

			try {
				Assert.assertEquals(pageData.get(2).get("Title") + " " + pageData.get(2).get("FirstName") + " "
						+ pageData.get(2).get("LastName") + "\n" + pageData.get(2).get("Gender") + "\n"
						+ pageData.get(2).get("DOB") + "\n" + pageData.get(2).get("PlaceOfBirth") + "\n" + "Mother",
						parentDetails2InfoSection.getText());

				Assert.assertEquals("Contact Details", contactDetailsTitle.getText());

				Assert.assertEquals(pageData.get(2).get("Title") + " " + pageData.get(2).get("FirstName") + " "
						+ pageData.get(2).get("LastName") + "\n" + pageData.get(2).get("Address1") + "\n"
						+ pageData.get(2).get("Country") + "\n" + pageData.get(2).get("PostalCode") + "," + " "
						+ pageData.get(2).get("City"), parent2ContactDetails.getText());
				Assert.assertEquals("Email Address", emailAddressTitle.getText());

				Assert.assertEquals(pageData.get(2).get("EmailAddress"), emailAddressInfoSection.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		} else {
			try {
				Assert.assertEquals("Parent 2 is unknown", parent2UnknownText.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
	}

}
