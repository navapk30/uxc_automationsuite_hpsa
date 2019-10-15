package com.uxcautomation.selenium.pageobjects;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserRegistrationMobilePage extends UserRegistrationPage{

	@FindBy(how=How.CSS,using="a.userSign")
	public WebElement signoutLinkField;
	
	@FindBy(how=How.CSS,using="div.userName")
	public WebElement loggedinUserField;
	
	@FindBy(how=How.XPATH,xpath="//button[@type='button']")
	public WebElement mainMobileMenu;
	
	public UserRegistrationMobilePage(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyRegistrationIsSuccesfull() {

		
		try {
			Assert.assertEquals("Thank you for registering.",
					this.getStringErrorMessageFromErrorDiv(successMessageField));
		} catch (Error e) {

			parseErrorMessageLog(e.toString());
		}
		
		this.clickElement(mainMobileMenu);
		getWhenVisible(loggedinUserField, 30);
		try {
			Assert.assertEquals("Welcome " + fname, loggedinUserField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Sign Out", signoutLinkField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}


}
