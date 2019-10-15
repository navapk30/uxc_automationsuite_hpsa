package com.uxcautomation.selenium.pageobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DisplayProductListRoadsAndVehiclesPage extends DisplayProductListPage {

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Refine by Vehicle Type')]")
	WebElement facetRefineByVechileTypeField;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Apply for Disabled Parking Permit')]")
	WebElement disabledParkingPermitTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Apply-for-Disabled-Parking-Permit')]")
	WebElement disabledParkingPermitViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'apply-disabled-parking-permit')]/following-sibling::button")
	WebElement disabledParkingPermitProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Report Pothole')]")
	WebElement reportPotholeTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Report-Pothole')]")
	WebElement reportPotholeViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'report-pothole')]/following-sibling::button")
	WebElement reportPotholeProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class='product-name' and contains(text(),'Apply for Learner Driver Licence')]")
	WebElement learnerDriverLicenceTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'Apply-for-Learner-Driver-Licence')]")
	WebElement learnerDriverLicenceViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'apply-learner-driver-licence')]/following-sibling::button")
	WebElement learnerDriverLicenceProductApplyNowButton;

	public DisplayProductListRoadsAndVehiclesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyRoadsAndVechilePLP() {

		try {
			Assert.assertEquals("Refine by Vehicle Type", facetRefineByVechileTypeField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply for Disabled Parking Permit", disabledParkingPermitTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("VIEW DETAILS", disabledParkingPermitViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("APPLY NOW", disabledParkingPermitProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Report Pothole", reportPotholeTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("VIEW DETAILS", reportPotholeViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("REPORT A POTHOLE", reportPotholeProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply for Learner Driver Licence", learnerDriverLicenceTitle.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("VIEW DETAILS", learnerDriverLicenceViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("APPLY NOW", learnerDriverLicenceProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

	}

	public DisplayProductDetailPage goToRoadsVechicleProductDetailPage() {

		this.clickElement(learnerDriverLicenceViewDetailButton);
		return PageFactory.initElements(driver, DisplayProductDetailPage.class);
		
	}
	
	public CheckoutCartPage goToRoadsVechicleCheckoutCart() {
		
		this.clickElement(learnerDriverLicenceProductApplyNowButton);
	    return PageFactory.initElements(driver, CheckoutCartPage.class);
			}
    
    public void addServiceToCartFromPLP(String productCode) {
		String xpath = "//input[@type=\"hidden\"][@value=\"%productCode%\"]/following-sibling::button[@type=\"submit\"]";
		String replacedVersion = xpath.replace("%productCode%", productCode);
		WebElement addToCartElement = FindElementBy(replacedVersion, "xpath");
		this.clickElement(addToCartElement);
	}

}

