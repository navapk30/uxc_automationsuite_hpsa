package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;





public class BillRetrievePage extends BaseDriver {
	
	@FindBy(how=How.ID,using="billId")
	public WebElement billIdElement;
	
	@FindBy(how=How.ID,using="lastName")
	public WebElement lastNameElement;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Retrieve Bill')]")
	public WebElement retireveBillButton;

	@FindBy(how=How.XPATH,using="//div[@class='alert alert-danger alert-dismissable']")
	public WebElement billPaymentErrorMessage;
	
	public BillRetrievePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void retrieveBill(String billId,String lastName){
		this.waitForPageToBeReady();
		this.typeText(billIdElement, billId);
		this.typeText(lastNameElement, lastName);
		this.clickElement(retireveBillButton);
	}
	
	public void verifyBillDetailPage(){
		this.waitForPageToBeReady();
		try{
			Assert.assertEquals("Pay My Bills | Public Sector Site", driver.getTitle());
		}catch(Error e){
			parseErrorMessageLog(e.toString());
		}
	}
	
	public void verifyErrorMessage(){
		String errorMessage=billPaymentErrorMessage.getText();
		try{
			Assert.assertTrue("We were unable to retrieve your bill.", errorMessage.contains("We were unable to retrieve your bill."));
		}catch(Error e){
			parseErrorMessageLog(e.toString());
		}
	}
}
