/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;


import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * @author tarundeepsharma
 *
 */
public class HomePage extends BaseDriver {

	
	@FindBy(how=How.XPATH,xpath="//a[contains(@href, '/yacceleratorstorefront/en/login')]")
	private WebElement loginLink;
	
	@FindBy(how=How.LINK_TEXT,using="Brands")
	WebElement brandLinkField;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'PERMITS & APPLICATIONS')]")
	WebElement categoryLinkField;
	
	@FindBy(how=How.LINK_TEXT,using="Find a Store")
	private WebElement findStoreLinkField;
	
	@FindBy(how=How.XPATH,using="//a[@title='ROADS & VEHICLES']")
	private WebElement roadAndVechilesLinkField;
	
	public String link_xpath="//a[contains(text(),'%S')]";
	public String myAccountOptionXpath="//div[@id='accNavComponentDesktopOne']/ul/li[@class='auto col-md-4']/a[contains(text(),'%S')]";
	
	@FindBy(how=How.XPATH,using="//a[@title='Retrieve Bill']")
	private WebElement billRetrieveLink;
	
	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Invoke Login for customer
	public LoginPage goToLoginPage(){
		this.clickElement(loginLink);
		this.waitForPageToBeReady();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Assert.assertEquals("Login | Public Sector Site", driver.getTitle());

		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	
		return PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	// Invoke Logout for logged in user
	public void logout(){
		
	}
	
	
	/**
	 * @return
	 * Invoke User Registration
	 */
	public UserRegistrationPage userRegistration(){
		this.clickElement(loginLink);
		try {
			Assert.assertEquals("SIGN IN / REGISTER", driver.findElement(By.cssSelector("li.active")).getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		return PageFactory.initElements(driver, UserRegistrationPage.class);
	}
	
	// Navigate to Help Page
	public StoreLocatorPage goStoreFinderPage(){
		clickElement(findStoreLinkField);
		
		return PageFactory.initElements(driver, StoreLocatorPage.class);

		
	}
		
	public DisplayProductListPage goToProductListingPage(String categoryName) {
		this.waitForPageToBeReady();
		Actions action = new Actions(driver);
		String xpath = "//a[contains(@href,'%categoryName%')]";
		String revisedXpath = xpath.replace("%categoryName%", categoryName);
		WebElement element = FindElementBy(revisedXpath, "xpath");
		this.getWhenclickAble(element, 120);
		try{
			action.moveToElement(element).click().perform();
		} catch (Exception e){
			this.clickElement(element);
		} catch(Error e){
			parseErrorMessageLog(e.toString());
		}
		// categoryLinkField.click();
		return PageFactory.initElements(driver, DisplayProductListPage.class);
	}
	
	public DisplayProductListPage goToProductListingPageold(){
		Actions action = new Actions(driver);
		action.moveToElement(categoryLinkField).click().perform();
		//categoryLinkField.click();
		return PageFactory.initElements(driver, DisplayProductListPage.class);
	}
	
	public void verifyIfOnHomePage(){
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Homepage | Public Sector Site", driver.getTitle());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}
	

	public void clickOnMyAccountLink(String linkName){
		String replacedXpath=link_xpath.replace("%S", linkName);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		this.clickElement(element);		
	}
	
	public void clickOnOptionUnderMyAccountLink(String myAccountOptionLinkName){
		String replacedXpath=myAccountOptionXpath.replace("%S", myAccountOptionLinkName);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		this.getWhenElementVisible(element, 1000);
		this.clickElement(element);		
	}
	
	public BillRetrievePage navigateToBillRetrievePage(){
		this.waitForPageToBeReady();
		this.clickElement(billRetrieveLink);
		return PageFactory.initElements(driver, BillRetrievePage.class);
		
	}
}
