/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uxcautomation.utilities.LoadConfigProperties;

/**
 * @author tarundeepsharma
 *
 */
public class HomePageMobile extends HomePage {
	public static LoadConfigProperties loadConfig;
	public static String browser = System.getProperty("Browser");

	/**
	 * @param driver
	 */
	public HomePageMobile(WebDriver driver) {
		super(driver);
		loadConfig = LoadConfigProperties.getInstance();
		// TODO Auto-generated constructor stub
		// PageFactory.initElements(driver, HomePage.class);
	}

	/**
	 * To Handle Mobile site UI
	 *
	 */
	@FindBy(how = How.XPATH, xpath = "//button[contains(@class,'nav__row--btn-menu js-toggle-sm-navigation')]")
	public WebElement mainMobileMenu;

	@FindBy(how = How.CSS, using = "a.userSign")
	public WebElement mobileLoginLink;

	@FindBy(how = How.CSS, using = "span.glyphicon.glyphicon-remove")
	public WebElement mainMenuCloseButton;

	@FindBy(how = How.XPATH, xpath = "//button[@type='submit' and @class='btn btn-link btn-primary btn-search']")
	public WebElement searchButton;

	@FindBy(how = How.ID, using = "js-site-search-input")
	public WebElement searchField;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'glyphicon-chevron-down')]")
	public WebElement mobileMyAccountLink;

	public String mobileMyAccountOptionXpath = "//div[contains(@class,'myAccountLinksContainer')]/ul/li[@class='auto']/a[contains(text(),'%S')]";

	public LoginPage goToLoginPage() {
		// this.getWhenElementVisible(mainMobileMenu, 30);
		this.waitForPageToBeReady();

		this.getWhenElementVisible(mainMobileMenu, 160);
		this.clickElement(mainMobileMenu);
		this.getWhenElementVisible(mobileLoginLink, 60);
		this.clickElement(mobileLoginLink);

		return PageFactory.initElements(driver, LoginPageMobile.class);

	}

	/**
	 * @return Invoke User Registration
	 */
	public UserRegistrationPage userRegistration() {
		this.clickElement(mainMobileMenu);
		getWhenVisible(mobileLoginLink, 30);
		this.clickElement(mobileLoginLink);

		return PageFactory.initElements(driver, UserRegistrationMobilePage.class);
	}

	@Override
	public DisplayProductListPage goToProductListingPage(String categoryName) {
		System.out.println("Loading mobiles homepage:" + mainMobileMenu.isEnabled());
		// this.clickElement(mainMobileMenu);
		WebDriverWait w = new WebDriverWait(driver, 60);
		mainMobileMenu = w.until(ExpectedConditions.elementToBeClickable(mainMobileMenu));
		mainMobileMenu.click();

		String xpath = "//a[contains(@href,'%categoryName%')]";
		String revisedXpath = xpath.replace("%categoryName%", categoryName);
		String categoryUrl = loadConfig.getsiteUrl();

		if (browser.equals("AndriodPhone") && categoryName.equals("births-deaths-and-marriages")) {
			log.info("Andriod Check URL: "+categoryUrl + "en/Categories/c/" + categoryName);
			driver.navigate().to(categoryUrl + "en/Categories/c/" + categoryName);
		} else {
			WebElement element = FindElementBy(revisedXpath, "xpath");
			this.clickElement(element);
		}

		System.out
				.println("//a[contains(@href,'" + categoryName + "') and contains(text(),'See All Service Requests')]");

		// Code commented below because click category in menu opening the PLP
		/*
		 * WebElement seeAllServices = FindElementBy( "//a[contains(@href,'" +
		 * categoryName + "') and contains(text(),'See All Service Requests')]",
		 * "xpath");
		 * 
		 * try{ seeAllServices.click();; }catch(Exception e){
		 * System.out.println(this.loadConfig.getsiteUrl()+"c/"+categoryName);
		 * driver.navigate().to(this.loadConfig.getsiteUrl()+"c/"+categoryName);
		 * clickElement(mainMenuCloseButton);
		 * typeText(this.searchField,categoryName);
		 * clickElement(this.searchButton);
		 * 
		 * }
		 */

		return PageFactory.initElements(driver, DisplayProductListPage.class);
	}

	@Override
	public void clickOnMyAccountLink(String linkName) {
		// String replacedXpath=link_xpath.replace("%S", linkName);
		// WebElement element = FindElementBy(replacedXpath, "xpath");
		this.clickElement(mainMobileMenu);
		this.clickElement(mobileMyAccountLink);
	}

	@Override
	public void clickOnOptionUnderMyAccountLink(String myAccountOptionLinkName) {
		this.waitForPageToBeReady();
		String replacedXpath = mobileMyAccountOptionXpath.replace("%S", myAccountOptionLinkName);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		this.getWhenclickAble(element, 1000);
		this.clickElement(element);
	}
}
