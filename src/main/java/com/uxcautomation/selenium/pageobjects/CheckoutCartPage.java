/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class CheckoutCartPage extends BaseDriver {

	private String screenName = "CheckoutCartPage";
	private static final String CHECKBOX_LABEL_ELEMENT = "//label[contains(@for,'%S')]";
	
	@FindBy(how = How.CSS, using = "div.card-section-h1")
	WebElement summaryTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='bundle-info']")
	WebElement summaryInfoField;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Shipping Address')]")
	WebElement shippingAddressTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Shipping Method')]")
	WebElement shippingMethodTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Shipping Address')]/following-sibling::div")
	WebElement shippingaddressInfoSection;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Payment & Billing Address')]")
	WebElement paymentAndBillingAddressTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Application Summary')]")
	WebElement applictaionSummaryTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2' and contains(text(),'Application Totals')]")
	WebElement applictaionTotalsTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h2']/h2[contains(text(),'Help Desk')]")
	WebElement helpDeskTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='card-section-h1' and contains(text(),'Consent Declaration')]")
	WebElement consentDeclarationTitle;
	
	@FindBy(how = How.CSS, using = "h1")
	WebElement summaryTitle1;

	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'checkout-next')])[1]")
	WebElement checkoutNextButton;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'First Name')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement firstName;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'Last Name')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement lastName;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'Address Line 1')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement addressLine1;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'Title')]/following-sibling::span[contains(@class,'xforms-select1')]/select")
	WebElement title;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'City')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement city;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'Post Code')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement postCode;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'Postcode')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement registerBirthPostCode;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'Phone Number')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement phoneNumber;
	
	@FindBy(how = How.XPATH,using= "//label[contains(text(),'Email Address')]/following-sibling::input[contains(@class,'xforms-input-input')]")
	WebElement emailAddress;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel')]")
	WebElement checkoutCancelButton;
	
	@FindBy(how = How.ID, using = "saveYformButton")
	WebElement checkoutSaveAndCloseButton;
	
	@FindBy(how = How.ID, using = "bundleQuestionSave")
	WebElement bundledSaveAndCloseButton;
	
	@FindBy(how = How.ID, using = "saveDraft_silentOrderPostForm")
	WebElement nonYformSaveAndCloseButton;
	
	/**
	 * @param driver
	 */
	public CheckoutCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.ID, using = "header3")
	WebElement itemPriceHeaderField;

	@FindBy(how = How.ID, using = "header4")
	WebElement quantityHeaderField;

	@FindBy(how = How.ID, using = "header5")
	WebElement shippingHeaderField;

	@FindBy(how = How.ID, using = "header6")
	WebElement totalHeaderField;

	@FindBy(how = How.CSS, using = "thead > tr > td")
	WebElement orderTotalHeaderField;

	@FindBy(how = How.ID, using = "checkoutButtonTop")
	WebElement checkoutButtonField;

	@FindBy(how = How.XPATH, using = "//select")
	WebElement titleDropDownField;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'first-name')]")
	WebElement firstNameField;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'last-name')]")
	WebElement lastNameField;

	@FindBy(how = How.XPATH, using = "//select[contains(@id,'gender')]")
	WebElement genderDropDownField;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'date-of-birth')]")
	WebElement dateOfBirthField;

	@FindBy(how = How.XPATH, using = "//select[contains(@id,'country')]")
	WebElement countryDropDownField;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'addressline1')]")
	WebElement addressLine1Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'addressline2')]")
	WebElement addressLine2Field;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'city')]")
	WebElement cityField;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'postcode')]")
	WebElement postalcodeField;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'phone-number')]")
	WebElement phoneNumberField;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'email')]")
	WebElement emailAddressField;

	@FindBy(how = How.XPATH, using = "//input[contains(@class,'xforms-upload-select')]")
	WebElement uploadFileField;

	// @FindBy(how = How.XPATH, using =
	// "//div[contains(@class,'consentDeclaration')]/label")
	@FindBy(how = How.CSS, using = ".checkbox.consentDeclaration")
	WebElement consentDeclaration;

	@FindBy(how = How.ID, using = "placeOrder")
	WebElement placeOrderBtn;

	@FindBy(how = How.ID, using = "continueBtn")
	WebElement continueBtn;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'alert-danger')]")
	WebElement errorMessage;

	private final static String ERROR_MESSAGE = "//span[contains(@class,'xforms-alert')][contains(text(),'%S')]";
	
	public CheckoutDeliveryAddressPage goToDeliveryAddressPage() {
		clickElement(checkoutButtonField);
		return PageFactory.initElements(driver, CheckoutDeliveryAddressPage.class);
	}

	public void selectBundleOption(String bundleProductCode) throws InterruptedException {
		this.waitForPageToBeReady();
		getCheckoutBundlePage().selectBundleOption(bundleProductCode);
		this.getWhenclickAble(checkoutNextButton, 1000);
		Actions actons = new Actions(driver);
		try{
		actons.moveToElement(checkoutNextButton).click().perform();
		} catch (Exception e) {
			this.clickElement(checkoutNextButton);
				
			}catch(Error e){
				parseErrorMessageLog(e.toString());
			}
	}

	/**
	 * @param deliveryAddress
	 * @throws InterruptedException 
	 */
	public void verifyIfShippingAddressStepIsDisplayedAndEnterAddress(List<Map<String, String>> deliveryAddress) throws InterruptedException {
		getCheckoutDeliveryAddressPage().verifyIfShippingAddressStepIsDisplayed();
		getCheckoutDeliveryAddressPage().enterShippingAddressInfo(deliveryAddress);
		Thread.sleep(1000);
		driver.findElement(By.id("addressSubmit")).click();
	}

	/**
	 * @param deliveryCode
	 */
	public void verifyIfShippingMethodStepIsDisplayedAndEnterShippingMethod(String deliveryCode) {
		getCheckoutDeliveryMethodPage().verifyIfShippingMethodStepIsDisplayed();
		getCheckoutDeliveryMethodPage().selectDeliveryMode(deliveryCode);
		clickNext();
	}

	/**
	 * @param paymentInfo
	 * @throws InterruptedException 
	 */
	public void verifyIfPaymentStepIsDisplayedAndEnterPaymentInfo(List<Map<String, String>> paymentInfo) throws InterruptedException {
		getCheckoutPaymentBillingAddressPage().verifyIfPaymentMethodStepIsDisplayed();
		getCheckoutPaymentBillingAddressPage().enterPaymentInfo(paymentInfo, false, false);
		clickNext();
	}
	
	public void verifyIfPaymentStepIsDisplayedAndUseSavedCard(){
		getCheckoutPaymentBillingAddressPage().verifyIfPaymentMethodStepIsDisplayed();
		getCheckoutPaymentBillingAddressPage().selectSavedCard();
	}

	/**
	 * 
	 */
	public void verifyIfReviewPageStepIsDisplayedAndPlaceOrder() {
		getCheckoutFinalReviewPage().verifyIfReviewPageStepIsDisplayed();
		getCheckoutFinalReviewPage().verifyIfUserCanPlaceOrder();
	}

	public void placeOrder() {
		getCheckoutFinalReviewPage().verifyIfUserCanPlaceOrder();
	}
	
	public void verifyErrorMessageForInvalidData(String errorMessage) {
		String replacedXpath = ERROR_MESSAGE.replace("%S", errorMessage);
		WebElement webElement = driver.findElement(By.xpath("//label[@class='xforms-label'][1]"));//You can use xpath, ID or name whatever you like
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement);
		actions.click();
		actions.sendKeys(Keys.TAB);
		actions.build().perform();
		waitTillYFormLoadingIconDisappears();
		WebElement element = FindElementBy(replacedXpath, "xpath");
		Assert.assertNotNull(element);
	}

	public void verifyIfErrorDialogMessageIsShown(String arg1) throws InterruptedException{
		this.waitForPageToBeReady();
		WebElement webElement = driver.findElement(By.xpath("//div[contains(@class,'xbl-fr-alert-dialog-message')]/span/label"));
     	Assert.assertEquals(arg1,webElement.getText());
	}
	
	public void verifyIsConfirmationPageDisplayed() {
		this.waitForPageToBeReady();
		this.getWhenElementVisible(summaryTitle1, 30);
		System.out.println(driver.getTitle());
		try{
		Assert.assertEquals("Application Confirmation | Public Sector Site",driver.getTitle());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyIfConsentDeclarationErrorMessageIsShown() {
		if (!errorMessage.getText().contains("Please accept consent declaration(s) before applying for service.")) {
			Assert.fail("Consent Declaration error message is not thrown");
		}
	}

	public void acceptConsentDeclaration() {
		this.waitForPageToBeReady();
		consentDeclaration.click();
	}
	
	

	public void checkOrUncheckBoxForLabel(String arg1) {
		log.info("Clicking on Checkbox :"+arg1);
		String replacedXpath = CHECKBOX_LABEL_ELEMENT.replace("%S", arg1);
		System.out.println(replacedXpath);
		WebElement element = FindElementBy(replacedXpath, "xpath") ;
		clickElement(element);
		//driver.findElement(By.xpath(replacedXpath)).click();

	}

	public void clickContinue() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("continueBtn")).click();
	}

	public CheckoutPaymentBillingAddressPage getCheckoutPaymentBillingAddressPage() {
		return PageFactory.initElements(driver, CheckoutPaymentBillingAddressPage.class);
	}

	public CheckoutDeliveryAddressPage getCheckoutDeliveryAddressPage() {
		return PageFactory.initElements(driver, CheckoutDeliveryAddressPage.class);
	}

	public CheckoutShippingMethodPage getCheckoutDeliveryMethodPage() {
		return PageFactory.initElements(driver, CheckoutShippingMethodPage.class);
	}

	public CheckoutFinalReviewPage getCheckoutFinalReviewPage() {
		return PageFactory.initElements(driver, CheckoutFinalReviewPage.class);
	}

	public CheckoutBundlePage getCheckoutBundlePage() {
		return PageFactory.initElements(driver, CheckoutBundlePage.class);
	}

	public void verifyIfAllInformationInReviewPageIsDisplayed(List<Map<String, String>> pageData) {
	
		verifyIfAllInformationInReviewPageIsDisplayed();
	}

	public void verifyIfAllInformationInReviewPageIsDisplayed() {
		try {
			Assert.assertEquals("Summary", summaryTitle.getText());
			Assert.assertEquals("Shipping Address", shippingAddressTitle.getText());
			Assert.assertEquals("Shipping Method", shippingMethodTitle.getText());
			Assert.assertEquals("Payment & Billing Address", paymentAndBillingAddressTitle.getText());
			Assert.assertEquals("Application Summary", applictaionSummaryTitle.getText());
			Assert.assertEquals("Help Desk", helpDeskTitle.getText());
			Assert.assertEquals("Consent Declaration", consentDeclarationTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void clickOnChekoutPageCancelButton(){
		this.waitForPageToBeReady();
		this.clickElement(checkoutCancelButton);
	}
	
	public void clickOnChekoutPageSaveAndCloseButton(){
		this.waitForPageToBeReady();
		this.getWhenclickAble(checkoutSaveAndCloseButton, 1000);
		this.clickElement(checkoutSaveAndCloseButton);
	}
	
	public void clickOnBundledPageSaveAndCloseButton(){
		this.waitForPageToBeReady();
		this.clickElement(bundledSaveAndCloseButton);
	}
	
	public void clickOnNonYformPageSaveAndCloseButton(){
		this.waitForPageToBeReady();
		this.clickElement(nonYformSaveAndCloseButton);
	}
}
