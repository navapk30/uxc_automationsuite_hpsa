package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyBillsPage extends BaseDriver{
	
	@FindBy(how=How.ID,using = "show")
	WebElement seeAllBillsButton;
	
	@FindBy(how=How.ID,using = "partial_amount")
	WebElement partialAmountField;
	
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'equals or is less than')]")
	WebElement amountErrorMessage;
	
	@FindBy(how=How.XPATH,using = "//button[contains(text(),'Pay Now')]")
	WebElement payNowButton;
	
	public static String payThisBillButton= "//tr[@class='responsive-table-item']/td[contains(text(),'%S')]/..//td/button";

	public MyBillsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickOnPayThisBillButton(String billType){
		
		this.clickElement(seeAllBillsButton);
		String replacedXpath = payThisBillButton.replace("%S", billType);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		this.clickElement(element);
	}
	
	public void verifyIfPartialAmountFieldIsVisible(){
		
		if(this.isElementPresent(partialAmountField))
			System.out.println("Partial amount filed present");
		else
			System.out.println("Partial amount filed is not present");
	}
	
	public void enterAmountInPartialAmountField(String amount) throws InterruptedException{
		
		this.waitForPageToBeReady();
		this.typeText(partialAmountField, amount);
	}
	
	public void clickOnPayNowButton(){
		
		this.waitForPageToBeReady();
		Actions action=new Actions(driver);
		action.moveToElement(payNowButton).click().perform();
//		this.clickElement(payNowButton);
	}
	
	public void verifyErrorMessage(){
		
		try {
			Assert.assertEquals("Please enter an amount that equals or is less than the outstanding amount (example: 3456.50)", amountErrorMessage.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
	}

}
