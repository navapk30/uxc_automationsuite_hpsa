package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutReportAnIssuePage extends CheckoutCartPage{
	
	@FindBy(how=How.ID,using="placeOrderBtn")
	WebElement reportanIssuePlaceOrderButton;
	
	@FindBy(how=How.ID,using="cancelBtn")
	WebElement reportanIssueCancelButton;
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Name')]/following-sibling::input[contains(@id,'update-me')]")
	WebElement keepMeUpdateName;
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Email address')]/following-sibling::input")
	WebElement keepMeUpdateEmail;
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-primary' and contains(text(),'OK')]/parent::span")
	WebElement reportAnIssuePopUp;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'damaged')]/span[2]")
	WebElement damageItemErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'control-17-control')]/span[2]")
	WebElement damageItemReportPotholeErrorMessage;
		
	@FindBy(how=How.XPATH,using="//span[contains(@id,'address-line1')]/span[1]")
	WebElement address1ErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'city')]/span[1]")
	WebElement cityErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'post')]/span[1]")
	WebElement postErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'comment')]/span[1]")
	WebElement commenttErrorMessage;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Yes, please keep me updated')]/parent::label[@class='checkbox']")
	WebElement keepUpdateCheckBox;
	
	public String rootFolder = System.getProperty("user.dir");
	
	
	public String keepUpdateCheck;
	
	public CheckoutReportAnIssuePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
   //Fill Report Graffiti Form	
	
	public void reportAnIssueFillYformPage(List<Map<String, String>> yFormData) throws InterruptedException{
	
		this.waitForPageToBeReady();
		log.info("Filling report graffiti form ..");
		if(yFormData.get(0).get("ServiceRequestName").equals("Graffiti")){
			enterYFormData("Type of damaged item",yFormData.get(0).get("Type"),"select");
		} else{
			enterYFormData("Please select the type of damage",yFormData.get(0).get("Type"),"select");	
		}
		
		
		enterYFormData("Address Line 1",yFormData.get(0).get("Address1"), "text");
		enterYFormData("Address Line 2",yFormData.get(0).get("Address2"), "text");
		enterYFormData("City", yFormData.get(0).get("city"), "text");
		enterYFormData("Post Code", yFormData.get(0).get("postcode"), "text");
		enterYFormData("Comment or Description", yFormData.get(0).get("Comments"), "textarea");	
		enterYFormData("If you have a photo", "IdentificationProof.PNG", "file");
		//this.typeText(uploadFileField, rootFolder+"\\src\\main\\resources\\TestData\\Report Graffiti.PNG");
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		keepUpdateCheck = yFormData.get(0).get("KeepUpdate");
	
	}
	
	public void reportAnIssueFillYformPagePothole(List<Map<String, String>> yFormData) throws InterruptedException{
		
		this.waitForPageToBeReady();
		log.info("Filling report graffiti form ..");
		if(yFormData.get(0).get("ServiceRequestName").equals("Graffiti")){
			enterYFormData("Type of damaged item",yFormData.get(0).get("Type"),"select");
		} else{
			enterYFormData("Please select the type of damage",yFormData.get(0).get("Type"),"select");	
		}
		
		
		enterYFormData("Address Line 1",yFormData.get(0).get("Address1"), "text");
		enterYFormData("Address Line 2",yFormData.get(0).get("Address2"), "text");
		enterYFormData("City", yFormData.get(0).get("city"), "text");
		enterYFormData("Post Code", yFormData.get(0).get("postcode"), "text");
		enterYFormData("Comment or Description", yFormData.get(0).get("Comments"), "textarea");	
		enterYFormData("Attach an image", "IdentificationProof.PNG", "file");
		//this.typeText(uploadFileField, rootFolder+"\\src\\main\\resources\\TestData\\Report Graffiti.PNG");
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		keepUpdateCheck = yFormData.get(0).get("KeepUpdate");
	
	}
	
	public void reportAnIssueKeepUpdateCheckFalse(){
		if(keepUpdateCheck.equalsIgnoreCase("false")){
			try {
				Assert.assertFalse(isElementPresent(keepMeUpdateName));
				}	      
			     catch (Error e) {
			      parseErrorMessageLog(e.toString());
			    }
			try {
				Assert.assertFalse(isElementPresent(keepMeUpdateEmail));
				}	      
			     catch (Error e) {
			      parseErrorMessageLog(e.toString());
			    }
		} else
		{
			enterYFormData("Yes, please keep me updated on this issue", null, "checkbox");
			try {
				Assert.assertTrue(isElementPresent(keepMeUpdateName));
				}	      
			     catch (Error e) {
			      parseErrorMessageLog(e.toString());
			    }
			try {
				Assert.assertTrue(isElementPresent(keepMeUpdateEmail));
				}	      
			     catch (Error e) {
			      parseErrorMessageLog(e.toString());
			    }
		}
	}
	
	public void reportAnIssueKeepUpdateCheckTrue(List<Map<String, String>> updateFiled){
		
			enterYFormData("Name", updateFiled.get(0).get("name"), "text");
			enterYFormData("Email address", updateFiled.get(0).get("email"), "text");
		
	}
	
	public OrderConfirmationPage clickOnReportAnIssueCheckoutCartButton(){
		this.waitForPageToBeReady();
		this.clickElement(reportanIssuePlaceOrderButton);
		return PageFactory.initElements(driver, OrderConfirmationPage.class);
	}
	
    public void clickOnReportAnIssueCancelButton(){
		
		this.clickElement(reportanIssueCancelButton);
	}
    
    public void clickOnReportAnIsssuePopUp(){
    	
    	this.clickElement(reportAnIssuePopUp);
    }
	
	public void verifyReportAnIssueErrorMessage(String serviceProduct){
		
		if(serviceProduct.equalsIgnoreCase("report-graffiti")){
			try {
				Assert.assertEquals("Please select an option", damageItemErrorMessage.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
		else{
			try {
				Assert.assertEquals("Please select the type of damage", damageItemReportPotholeErrorMessage.getText());
			} catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
		}
		/*try {
			Assert.assertEquals("Please enter a town or city", cityErrorMessage.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Please enter a post code", postErrorMessage.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}*/
		try {
			Assert.assertEquals("Please enter a comment or description", commenttErrorMessage.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	 public void reportGraffitiPrefilling(){
		 this.clickElement(keepUpdateCheckBox);
		 this.waitForPageToBeReady();
		 try{
				Assert.assertEquals("230 Primary Street", addressLine1.getAttribute("value"));
				Assert.assertEquals("Rosebud", city.getAttribute("value"));
				Assert.assertEquals("1000", postCode.getAttribute("value"));
			 	Assert.assertEquals("Automation", keepMeUpdateName.getAttribute("value"));
				Assert.assertEquals("automationtestuser@stateofrosebud.com", keepMeUpdateEmail.getAttribute("value"));
			}catch (Error e) {
				parseErrorMessageLog(e.toString());
			}
	 }
}
