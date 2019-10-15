/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.uxcautomation.utilities.DataReaderExcel;

//import junit.framework.Assert;
import org.junit.Assert;

/**
 * @author tarundeepsharma
 *
 */
public class UserRegistrationPage extends BaseDriver {

	@FindBy(how = How.ID, using = "register.title")
	private WebElement titleField;

	@FindBy(how = How.ID, using = "register.firstName")
	private WebElement firstNameField;

	@FindBy(how = How.ID, using = "register.lastName")
	private WebElement lastNameField;

	@FindBy(how = How.ID, using = "register.email")
	private WebElement emailField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.ID, using = "register.checkPwd")
	private WebElement checkPwdField;

	@FindBy(how = How.XPATH, using = "//button[@type='submit' and contains(text(),'Create Account')]")
	private WebElement registerButtonField;

	// @FindBy(how = How.CSS, using = "button.positive")
	// private WebElement registerButtonField;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-info alert-dismissable']")
	public WebElement successMessageField;

	// @FindBy(how = How.CSS, using = "div.alert.positive")
	// public WebElement successMessageField;

	@FindBy(how = How.CSS, using = ".logged_in.js-logged_in")
	public WebElement loggedinUserField;

	@FindBy(how = How.LINK_TEXT, using = "SIGN OUT")
	public WebElement signoutLinkField;

	@FindBy(how = How.XPATH, using = "(//span[@id='email.errors'])")
	public WebElement emailExistErrorField;

	@FindBy(how = How.CSS, using = "div.headline")
	private WebElement registrationHeader;

	private String fileName;
	private DataReaderExcel dataReader;
	private String title;
	public String fname;
	private String lname;
	private String email;
	private String fpassword;
	private String fvpassword;

	/**
	 * @param driver
	 * @throws IOException
	 */
	public UserRegistrationPage(WebDriver driver) throws IOException {
		super(driver);
		
	}

	public void verifyRegistrationFormDisplayed() {
		try {
			Assert.assertEquals("SIGN IN - RETURNING CITIZEN", this.registrationHeader.getText().toUpperCase());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertTrue(this.firstNameField.isDisplayed());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}

	public void getDataFromExcel(String fileName) throws IOException {
		fileName = "TestData/"+fileName;
		dataReader = new DataReaderExcel(fileName);
		ArrayList<String> values = dataReader.getDataRowsFromExcel();
		System.out.println(values);
		
		
		title = values.get(1);
		fname = values.get(2);
		lname = values.get(3);
		email = values.get(4);
		fpassword = values.get(5);
		fvpassword = values.get(6);

		System.out.println(title + "" + fname + "" + lname + "" + email + "" + fpassword);
	}

	/**
	 * Check Registration form validation working
	 */

	public void checkFormValidationsWorking() {
		log.info("Form Validation Started for Registration in checkFormValidationsWorking");
		this.clickElement(registerButtonField);
		try {
			Assert.assertEquals("Please correct the errors below.",
					driver.findElement(By.cssSelector("div.alert.negative")).getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void submitRegistration() {
		log.info("Submitting the Registration test Started...");
		selectDropdownValue(titleField, title);
		typeText(firstNameField, fname);
		typeText(lastNameField, lname);
		typeText(emailField, email);
		System.out.println(emailField.getText().toString());
		typeText(passwordField, fpassword);
		typeText(checkPwdField, fvpassword);
		clickElement(registerButtonField);

	}

	public void verfyUserAccountAlreadyExists() {
		log.info("Verifying the user already exist...");
		// submitRegistration();
		try {
			Assert.assertEquals("An account already exists for this email address.", emailExistErrorField.getText());

			Assert.fail("Account exist with :" + emailField.getAttribute("value"));
		} catch (Error e) {
			this.parseSuccessMessageLog("Test Pass User exists with email :" + emailField.getAttribute("value"));
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyRegistrationIsSubmitted() throws IOException {
		getDataFromExcel("userRegistration.xlsx");
		submitRegistration();
		if (isElementPresent(emailExistErrorField)) {
			verfyUserAccountAlreadyExists();
		}
		
	}
	
	public void verifyRegistrationIsSuccesfull() {

		try {
			Assert.assertEquals("Thank you for registering.",
					this.getStringErrorMessageFromErrorDiv(successMessageField));
		} catch (Error e) {

			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals(("Welcome " + fname).toUpperCase(), loggedinUserField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("SIGN OUT", signoutLinkField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

}
