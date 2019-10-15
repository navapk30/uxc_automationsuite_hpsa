package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DisplayProductListReportAnIssuePage extends DisplayProductListPage {
	
	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Refine by Vehicle Type')]")
	WebElement facetRefineByVechileTypeField;
	
	@FindBy(how=How.XPATH,using="//div[contains(text()[2],'Report Graffiti')]")
	WebElement reportGraffitiTitle;
	
	@FindBy(how=How.XPATH,using="//a[contains(@href,'report-graffiti')]/parent::div")
	WebElement reportGraffitiViewDetailButton;
	
	@FindBy(how=How.XPATH,using="//input[contains(@value,'report-graffiti')]/following-sibling::button")
	WebElement reportGraffitiApplyNowButton;
	
	@FindBy(how=How.XPATH,using="//div[contains(text()[2],'Report Pothole')]")
	WebElement reportPotholeTitle;
	
	@FindBy(how=How.XPATH,using="//a[contains(@href,'report-pothole')]/parent::div")
	WebElement reportPotholeViewDetailButton;
	
	@FindBy(how=How.XPATH,using="//input[contains(@value,'report-pothole')]/following-sibling::button")
	WebElement reportPotholeApplyNowButton;
	

	public DisplayProductListReportAnIssuePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyReportAnIssuePLP(){
		
		try {
			Assert.assertEquals("Refine by Vehicle Type", facetRefineByVechileTypeField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("  Report Graffiti", reportGraffitiTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("VIEW DETAILS", reportGraffitiViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("REPORT GRAFFITI", reportGraffitiApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("  Report Pothole", reportPotholeTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("VIEW DETAILS", reportPotholeViewDetailButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
		try {
			Assert.assertEquals("REPORT A POTHOLE", reportPotholeApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}
		
	}
	
	/**
	 * @param productCode
	 * @return DisplayProductDetailPage
	 */
	public void addServiceToCartFromPLP(String productCode) {
		String xpath = "//input[@type=\"hidden\"][@value=\"%productCode%\"]/following-sibling::button[@type=\"submit\"]";
		String replacedVersion = xpath.replace("%productCode%", productCode);
		WebElement addToCartElement = FindElementBy(replacedVersion, "xpath");
		this.clickElement(addToCartElement);
	}


}
