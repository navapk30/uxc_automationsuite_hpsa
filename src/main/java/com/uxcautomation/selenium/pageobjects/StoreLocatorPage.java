/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author tarundeepsharma
 *
 */
public class StoreLocatorPage extends BaseDriver{

	/**
	 * @param driver
	 */
	public StoreLocatorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String screenName = "StoreLocator";
	@FindBy(how=How.CSS,using="div.headline")
	private WebElement findStoreheadField;
	
	@FindBy(how=How.LINK_TEXT,using="STORE FINDER")
	private WebElement navStoreLinkField;
	
	@FindBy(how=How.ID,using="storelocator-query")
	private WebElement storeLocatorTextField;
	
	@FindBy(how=How.CSS,using="button.positive")
	private WebElement storeSearchSubmitField;
	
	@FindBy(how=How.ID,using="header1")
	private WebElement storeHeadField;
	
	@FindBy(how=How.ID,using="header2")
	private WebElement distanceHeadField;
	
	@FindBy(how=How.ID,using="header3")
	private WebElement addressHeadField;
	
	@FindBy(how=How.ID,using="header4")
	private WebElement openingHoursHeadField;
	
	public void verifyStoreLocatorDisplayed(){
		   log.info("Entering Store Locator");
		    try {
		      Assert.assertEquals("FIND A STORE", findStoreheadField.getText());
		    } catch (Error e) {
		      parseErrorMessageLog(e.toString());
		    }
		    try {
		      Assert.assertEquals("STORE FINDER", navStoreLinkField.getText());
		    } catch (Error e) {
		      parseErrorMessageLog(e.toString());
		    }
		    
	}
	
	public void verifyStoreSearchShowResult(){
		typeText(storeLocatorTextField,"1000");
	    clickElement(storeSearchSubmitField);
	    
	    try {
	      Assert.assertEquals("STORE", storeHeadField.getText());
	    } catch (Error e) {
	      parseErrorMessageLog(e.toString());
	    }
	  
	    try {
	      Assert.assertEquals("ADDRESS", addressHeadField.getText());
	    } catch (Error e) {
	      parseErrorMessageLog(e.toString());
	    }
	    try {
	      Assert.assertEquals("OPENING HOURS", openingHoursHeadField.getText());
	    } catch (Error e) {
	      parseErrorMessageLog(e.toString());
	    }
	    try {
	      Assert.assertEquals("DISTANCE", distanceHeadField.getText());
	    } catch (Error e) {
	      parseErrorMessageLog(e.toString());
	    }
	    this.getScreenshot(screenName);
	}
	
	
}
