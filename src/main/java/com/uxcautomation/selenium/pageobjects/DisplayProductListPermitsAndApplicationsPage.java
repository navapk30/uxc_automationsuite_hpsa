package com.uxcautomation.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;

public class DisplayProductListPermitsAndApplicationsPage extends DisplayProductListPage {

	@FindBy(how = How.LINK_TEXT, using = "SHOP BY COLLECTION")
	WebElement facetShopByCollectionLinkField;

	@FindBy(how = How.LINK_TEXT, using = "SHOP BY SIZE")
	WebElement facetShopBySizeLinkField;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Sort by:')]")
	WebElement sortByField;
	
	@FindBy(how=How.XPATH, using="//div[contains(text()[2],'Refine by Vehicle Type')]")
	WebElement facetRefineByVechileTypeField;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Apply for Learner Driver Licence')]")
	WebElement learnerDriverLicenceProductTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Apply-for-Learner-Driver-Licence')]")
	WebElement learnerDriverLicenceProductViewDetailButton;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@value,'apply-learner-driver-licence')]/following-sibling::button")
	WebElement learnerDriverLicenceProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Working with children check')]")
	WebElement workingWithChildrenProductTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Working-with-children-check')]")
	WebElement workingWithChildrenProductViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'working-with-children-check')]/following-sibling::button")
	WebElement workingWithChildrenProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Pool Building Permit')]")
	WebElement poolBuildingPermitProductTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Pool-Building-Permit')]")
	WebElement poolBuildingPermitProductViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'pool-building-permit')]/following-sibling::button")
	WebElement poolBuildingPermitProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Apply for disabled parking permit')]")
	WebElement disabledParkingPermitProductTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Apply-for-Disabled-Parking-Permit')]")
	WebElement disabledParkingPermitProductViewDetailButton;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@value,'apply-disabled-parking-permit')]/following-sibling::button")
	WebElement disabledParkingPermitProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Apply for Marriage Certificate')]")
	WebElement marriageCertificateProductTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Apply-for-Marriage-Certificate')]")
	WebElement marriageCertificateProductViewDetailButton;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@value,'apply-for-marriage-certificate')]/following-sibling::button")
	WebElement marriageCertificateProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Event permit application')]")
	WebElement eventPermitProductTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Apply-for-Event-Permit')]")
	WebElement eventPermitProductViewDetailButton;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@value,'event-permit-application')]/following-sibling::button")
	WebElement eventPermitProductApplyNowButton;

	public DisplayProductListPermitsAndApplicationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyPermitPLP() {
		// driver.findElement(By.linkText("PERMITS & APPLICATIONS")).click();

		try{
			assertEquals("Refine by Vehicle Type", facetRefineByVechileTypeField.getText());
		}catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			assertEquals("Apply for Learner Driver Licence", learnerDriverLicenceProductTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("VIEW DETAILS", learnerDriverLicenceProductViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
		try {
			assertEquals("APPLY NOW", learnerDriverLicenceProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("Working with children check", workingWithChildrenProductTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("VIEW DETAILS", workingWithChildrenProductViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("APPLY NOW", workingWithChildrenProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("Pool Building Permit", poolBuildingPermitProductTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("VIEW DETAILS", poolBuildingPermitProductViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("APPLY NOW", poolBuildingPermitProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("Apply for disabled parking permit", disabledParkingPermitProductTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("VIEW DETAILS", disabledParkingPermitProductViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
		try {
			assertEquals("APPLY NOW", disabledParkingPermitProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("Apply for Marriage Certificate", marriageCertificateProductTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("VIEW DETAILS", marriageCertificateProductViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
		try {
			assertEquals("APPLY NOW", marriageCertificateProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("Event permit application", eventPermitProductTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("VIEW DETAILS", eventPermitProductViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
		try {
			assertEquals("APPLY NOW", eventPermitProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

	}

}
