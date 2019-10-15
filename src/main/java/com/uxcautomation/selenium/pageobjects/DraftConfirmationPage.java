package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DraftConfirmationPage extends BaseDriver {
	
	@FindBy(how=How.TAG_NAME,using="h3")
	WebElement draftConfirmationTitle;
	
	@FindBy(how=How.TAG_NAME,using="h4")
	WebElement draftText;
	
	@FindBy(how=How.XPATH,using="//span[@id='draftConfirmationRegistered']//a[contains(text(),'My Applications & Requests')]")
	WebElement myApplicationAndRequestLink;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Child Details')]")
	WebElement page2LastRestored;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Parent 1 Details')]")
	WebElement page3LastRestored;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Payment & Billing Address')]")
	WebElement nonYFormLastRestored;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Registration Options')]")
	WebElement bundledPageLastRestored;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Event Permit')]")
	WebElement eventPermitbundledPageLastRestored;
	
	public static String draftNumber;

	public DraftConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyDraftConfirmationPage(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Draft Confirmation | Public Sector Site", driver.getTitle());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void getDraftNumber(){
		String draftNumberText=draftText.getText();
		draftNumber=draftNumberText.replace("Draft Number ", "");
		System.out.println("String draftNumber"+ draftNumber);
	}
	

	public void clickOnMyApplicationLink(){
		log.info("Navigating to my application page...");
		this.clickElement(myApplicationAndRequestLink);
	}
	
	public void page2LastRestoredPage(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Child Details", page2LastRestored.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	public void page3LastRestoredPage(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Parent 1 Details", page3LastRestored.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	public void nonYFormPageLastRestored(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Payment & Billing Address", nonYFormLastRestored.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	public void bundledPageLastRestoredPage(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Registration Options", bundledPageLastRestored.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	public void eventPermitBundledPageLastRestoredPage(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Event Permit", eventPermitbundledPageLastRestored.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
}
