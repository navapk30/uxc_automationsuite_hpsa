package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.uxcautomation.utilities.LoadConfigProperties;

public class MyAccountPageMobile extends MyAccountPage {
	public LoadConfigProperties loadConfig;
	

	@FindBy(how = How.XPATH, using = "//div[@class='account-section-header']//a[contains(text(),'Add Address')]")
	WebElement addAddressButton;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'View Expired Documents')])[2]")
	WebElement expiredDocuments;


	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'See All Drafts')])[2]")
	WebElement seeAllDraftLinks;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'See All History')])[2]")
	WebElement seeAllHistoryLinks;
	
	public MyAccountPageMobile(WebDriver driver) {
		super(driver);
		loadConfig = LoadConfigProperties.getInstance();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void verifyMyApplicationRequestPage() {
		try {
			Assert.assertEquals("Applications & Requests", myApplicationRequestTitle.getText());
			Assert.assertEquals("History", historyTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	@Override
	public void verifyMyapplicationRequestForDraft() {
		try {
			Assert.assertEquals("Drafts", draftsTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	@Override
	public void clickOnAddAddressbutton() {
		this.getWhenclickAble(addAddressButton, 1000);
		this.clickElement(addAddressButton);
	}
	
	@Override
	public void verifyMyDocumentPage() {
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Documents", pageTitle.getText());
			Assert.assertEquals("Current Documents", currentDocumentsTitle.getText().trim());
			Assert.assertEquals("View Expired Documents", expiredDocuments.getText().trim());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	@Override
	public void clickOnViewExpiredDraftButton() {
		this.getWhenclickAble(expiredDocuments, 1000);
		this.clickElement(expiredDocuments);
	}
	
	@Override
	public void clickOnSubmittedServiceRequest() {
		if (this.isElementPresent(seeAllHistoryLinks)) {
			this.clickElement(seeAllHistoryLinks);
		}
		this.getWhenclickAble(submittedServiceRequest, 1000);
		this.clickElement(submittedServiceRequest);
	}

	@Override
	public void clickToRestoreDraft() {
		log.info("Restoring draft.......");
		this.waitForPageToBeReady();
		
		String siteUrl = loadConfig.getsiteUrl();
		log.info("Mobile naviting to all drafts page....");
		driver.navigate().to(siteUrl + "en/my-account/drafts/");

		String replacedXpath = restoreDraftLink.replace("%S", DraftConfirmationPage.draftNumber);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		System.out.println("restoreDraftLink" + element);
		this.getWhenclickAble(element, 1000);
		this.clickElement(element);
	}

}
