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
public class DisplayProductDetailPageMobile extends DisplayProductDetailPage {

	public DisplayProductDetailPageMobile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyPDPInformation(List<Map<String, String>> pdpData){
		this.waitForPageToBeReady();
		log.info("Verifying PDP....");
		try {
			Assert.assertEquals(pdpData.get(0).get("serviceRequestTitle"), serviceRequestTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("serviceRequestOnlineSection"), serviceRequestOnlineSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("emailPostSection"), byEmailOrPostSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("phoneSection"), phoneSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("relatedLinksSection"), relatedLinksSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("helpDeskSection"), helpDeskSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("sharePageSection"), shareThisPageSectionTitle.getText());
			Assert.assertEquals(pdpData.get(0).get("applynowButton1"), serviceRequestApplyNowButton1.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
}
