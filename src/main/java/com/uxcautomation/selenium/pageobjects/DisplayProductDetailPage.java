/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author tarundeepsharma
 *
 */
public class DisplayProductDetailPage extends BaseDriver {

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'By email or post')]")
	WebElement byEmailOrPostSectionTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'By Phone')]")
	WebElement phoneSectionTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Key Facts')]")
	WebElement keyFactsSectionTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Related Links')]")
	WebElement relatedLinksSectionTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Help Desk')]")
	WebElement helpDeskSectionTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Share this page')]")
	WebElement shareThisPageSectionTitle;

	@FindBy(how = How.CSS, using = "h1")
	WebElement serviceRequestTitle;
	
	@FindBy(how = How.CSS, using = "div.pdp-section-h2")
	WebElement serviceRequestOnlineSectionTitle;

	@FindBy(how = How.XPATH, using = "(//form[@id='command']/button)[1]")
	WebElement serviceRequestApplyNowButton1;

	@FindBy(how = How.XPATH, using = "(//form[@id='command']/button)[2]")
	WebElement serviceRequestApplyNowButton2;
	
	public static WebDriver driver;
	public Map<String, String> classIdentifier = new HashMap<String, String>() {
		{
			put("report-pothole", "value1");
			put("key2", "value2");
		}
	};

	public void goToCartPage(){
		System.out.println(this.classIdentifier.get("key2"));
		this.clickElement(serviceRequestApplyNowButton2);
		PageFactory.initElements(driver, DisplayProductDetailPage.class);
	}
	/**
	 * @param driver
	 */
	public DisplayProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

	}
	

	public void verifyIfProductDisplayPageIsDisplayed() {

		try {
			Assert.assertEquals("By email or post", byEmailOrPostSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("By Phone", phoneSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Key Facts", keyFactsSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Related Links", relatedLinksSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Help Desk", helpDeskSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Share this page", shareThisPageSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	/**
	 *  Verify Report Pothole PDP page
	 */
	public void verifyReportPotholePDP() {

		try {
			Assert.assertEquals("Report Pothole", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Report Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Report Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Reporting Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	/**
	 *  Verify Report Graffiti PDP page
	 */
	public void verifyReportGraffitiPDP() {

		try {
			Assert.assertEquals("Report Graffiti", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Report Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Report Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Reporting Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	/**
	 *  Verify WCC PDP page
	 */
	public void verifyWorkingWithChildrenCheckPDP() {

		try {
			Assert.assertEquals("Working with children check", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	/**
	 *  Verify Register A Birth PDP page
	 */
	public void verifyRegisterABirthPDP() {

		try {
			Assert.assertEquals("Register a Birth", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Register Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Register Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Registering Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	/**
	 *  Verify Apply For Driver License PDP page
	 */
	public void verifyApplyForDriverLicensePDP() {

		try {
			Assert.assertEquals("Apply for Learner Driver Licence", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	/**
	 *  Verify Apply for Disabled Parking Permit PDP page
	 */
	public void verifyApplyforDisabledParkingPermitPDP() {

		try {
			Assert.assertEquals("Apply for Disabled Parking Permit", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	/**
	 *  Verify Pool Building Permit PDP page
	 */
	public void verifyPoolBuildingPermitPDP() {

		try {
			Assert.assertEquals("Pool Building Permit", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	/**
	 *  Verify Apply for Marriage Certificate PDP page
	 */
	public void verifyApplyforMarriageCertificatePDP() {

		try {
			Assert.assertEquals("Apply for Marriage Certificate", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}

	
	/**
	 *  Verify Apply for Death Certificate PDP page
	 */
	public void verifyApplyforDeathCertificatePDP() {

		try {
			Assert.assertEquals("Apply for Death Certificate", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}	
	
	/**
	 *  Verify Apply for Event Permit PDP page
	 */
	public void verifyApplyforEventPermitPDP() {

		try {
			Assert.assertEquals("Apply for Event Permit", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	public void verifyTouristVisaPDP() {

		try {
			Assert.assertEquals("Apply for Tourist Visa", serviceRequestTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Apply Now", serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("Applying Online", serviceRequestOnlineSectionTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}
	
	public void verifyPDPInformation(List<Map<String, String>> pdpData){
		this.waitForPageToBeReady();
		log.info("Verifying PDP....");
		try {
			Assert.assertEquals(pdpData.get(0).get("serviceRequestTitle"), serviceRequestTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("serviceRequestOnlineSection"), serviceRequestOnlineSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("emailPostSection"), byEmailOrPostSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("phoneSection"), phoneSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("keyFactsSection"), keyFactsSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("relatedLinksSection"), relatedLinksSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("helpDeskSection"), helpDeskSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("sharePageSection"), shareThisPageSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("applynowButton1"), serviceRequestApplyNowButton1.getText());
			Assert.assertEquals(pdpData.get(0).get("applynowButton2"), serviceRequestApplyNowButton2.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	
	public CheckoutSignupLoginPage goToCheckoutSignupLoginPage(){
		
		this.clickElement(serviceRequestApplyNowButton2);
		return PageFactory.initElements(driver, CheckoutSignupLoginPage.class);	
	}
	
	public static void main(String [] args){
		DisplayProductDetailPage ob = new DisplayProductDetailPage(driver);
		ob.goToCartPage();
	}
}
