/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



/**
 * @author tarundeepsharma
 *
 */
public class MyAccountPage extends BaseDriver {

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Applications & Requests')]")
	WebElement myApplicationRequestTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'History')]")
	WebElement historyTitle;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Service Request')]")
	WebElement serviceRequestTitle;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Status')]")
	WebElement statusTitle;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Total')]")
	WebElement totalTitle;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Delivery Mode')]")
	WebElement deliveryModeTitle;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Date')]")
	WebElement dateTitle;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Drafts')]")
	WebElement draftsTitle;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Last Saved')]")
	WebElement lastSavedTitle;

	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Options')]")
	WebElement optionsTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@data-product-name,'Pool')]")
	WebElement deleteIcon;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Cancel')]")
	WebElement cancelButton;

	@FindBy(how = How.ID, using = "delete-draft-submit")
	WebElement deleteDraftButton;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'testOrder22')]")
	WebElement submittedServiceRequest;

	@FindBy(how = How.TAG_NAME, using = "h1")
	WebElement pageTitle;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'order-History-Detail-Summary')]//p)[1]")
	WebElement statusSection;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'order-History-Detail-Summary')]//p)[3]")
	WebElement downloadSection;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'order-History-Detail-Summary')]//p)[4]")
	WebElement dateSection;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Payment & Billing Address')]")
	WebElement paymentBillingTitleSection;

	@FindBy(how = How.XPATH, using = "//label[@for='profile.title']")
	WebElement titleSection;

	@FindBy(how = How.XPATH, using = "//label[@for='profile.firstName']")
	WebElement firstNameSection;

	@FindBy(how = How.XPATH, using = "//label[@for='profile.lastName']")
	WebElement lastNameSection;

	@FindBy(how = How.ID, using = "profile.title")
	WebElement titleDropDown;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-primary')]")
	WebElement updateButton;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Your profile has')]")
	WebElement updateText;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'btn-default')]")
	WebElement updatePageCancelButton;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Current Password')]")
	WebElement confirmPassword;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'New Password')]")
	WebElement newPassword;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Confirm New Password')]")
	WebElement confirmNewPassword;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pull-right')]/a")
	WebElement addAddressButton;

	@FindBy(how = How.ID, using = "address.firstName")
	WebElement addressFirstName;

	@FindBy(how = How.ID, using = "address.country")
	WebElement addressCountry;

	@FindBy(how = How.XPATH, using = "//select[@id='address.title' and @name='titleCode']")
	WebElement addressTitle;

	@FindBy(how = How.ID, using = "address.surname")
	WebElement addressLastName;

	@FindBy(how = How.ID, using = "address.line1")
	WebElement addressAddressLine1;

	@FindBy(how = How.ID, using = "address.townCity")
	WebElement addressCity;

	@FindBy(how = How.ID, using = "address.postcode")
	WebElement addressPostcode;

	@FindBy(how = How.XPATH, using = "(//span[@class='glyphicon glyphicon-pencil'])[2]")
	WebElement editIcon;

	@FindBy(how = How.XPATH, using = "(//a[contains(@class,'removeAddressFromBookButton')]/span[2])[2]")
	WebElement addressDeleteIcon;

	@FindBy(how = How.CSS, using = "css=#cboxLoadedContent >div.account-address-removal-popup > div.addressItem > div.modal-actions>div:nth-of-type(2) a")
	WebElement addressCancelButton;

	@FindBy(how = How.CSS, using = "css=#cboxLoadedContent >div.account-address-removal-popup > div.addressItem > div.modal-actions>div:nth-of-type(1) a")
	WebElement addressDeleteOverlayButton;
	// @FindBy(how=How.XPATH,using="(//a[contains(text(),'Cancel')])[2]")
	// WebElement addressCancelButton;

	// @FindBy(how=How.XPATH,using="(//a[contains(text(),'Delete')])[2]")
	// WebElement addressDeleteOverlayButton;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-info alert-dismissable']")
	WebElement addressDeleteSuccessMessage;

	@FindBy(how = How.TAG_NAME, using = "h2")
	WebElement currentDocumentsTitle;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'View Expired Documents')])[1]")
	WebElement expiredDocuments;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'See All Drafts')])")
	WebElement seeAllDraftLinks;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'See All History')])[1]")
	WebElement seeAllHistoryLinks;

	public String restoreDraftLink = "//a[contains(@class,'retrieveLink')]//text()[contains(.,'%S')]/..";

	

	/**
	 * @param driver
	 */
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyMyApplicationRequestPage() {
		try {
			Assert.assertEquals("Applications & Requests", myApplicationRequestTitle.getText());
			Assert.assertEquals("History", historyTitle.getText());
			Assert.assertEquals("Service Request", serviceRequestTitle.getText());
			Assert.assertEquals("Status", statusTitle.getText());
			Assert.assertEquals("Total", totalTitle.getText());
			Assert.assertEquals("Delivery Mode", deliveryModeTitle.getText());
			Assert.assertEquals("Date", dateTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyMyapplicationRequestForDraft() {
		try {
			Assert.assertEquals("Drafts", draftsTitle.getText());
			Assert.assertEquals("Service Request", serviceRequestTitle.getText());
			Assert.assertEquals("Last Saved", lastSavedTitle.getText());
			Assert.assertEquals("Options", optionsTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void clickOnDeleteIcon() {
		this.getWhenclickAble(deleteIcon, 1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.clickElement(deleteIcon);
	}

	public void clickOnCancelButton() {
		this.getWhenclickAble(cancelButton, 1000);
		this.clickElement(cancelButton);
	}

	public void clickOnDeleteDraftButton() {
		this.getWhenclickAble(deleteDraftButton, 1000);
		this.clickElement(deleteDraftButton);
	}

	public void clickOnViewExpiredDraftButton() {
		this.getWhenclickAble(expiredDocuments, 1000);
		this.clickElement(expiredDocuments);
	}
	
	public void clickOnSubmittedServiceRequest() {
		if (this.isElementPresent(seeAllHistoryLinks)) {
			this.clickElement(seeAllHistoryLinks);
		}
		this.getWhenclickAble(submittedServiceRequest, 1000);
		this.clickElement(submittedServiceRequest);
	}

	public void verifySubmittedServiceRequest() {
		try {
			Assert.assertEquals("History - Register a Birth Reference Number testOrder22", pageTitle.getText());
			Assert.assertEquals("Status  In Process", statusSection.getText());
			Assert.assertEquals("Download in Documents", downloadSection.getText());
			Assert.assertEquals("May 31, 2016", dateSection.getText());
			// Assert.assertEquals("Payment & Billing Address",
			// paymentBillingTitleSection.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyPersonalDetailsPage() {
		this.waitForPageToBeReady();
		System.out.println("pageTitle" + pageTitle.getText());
		try {
			Assert.assertTrue("Update Personal Details", driver.getTitle().contains("Update Personal Details"));
			Assert.assertEquals("Title", titleSection.getText());
			Assert.assertEquals("First Name", firstNameSection.getText());
			Assert.assertEquals("Last Name", lastNameSection.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void updateTitleAndClickConfirm() {
		this.selectDropdownValue(titleDropDown, "Dr.");
		this.getWhenclickAble(updateButton, 1000);
		this.clickElement(updateButton);
	}

	public void verifyupdateSuccessMessage() {
		String updateSuccessMessage = updateText.getText();
		try {
			Assert.assertTrue("Your profile has been updated",
					updateSuccessMessage.contains("Your profile has been updated"));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void updateTitleAndClickCancel() {
		this.selectDropdownValue(titleDropDown, "Mr.");
		this.getWhenclickAble(updatePageCancelButton, 1000);
		this.clickElement(updatePageCancelButton);
	}

	public void verifyChangePasswordPage() {
		try {
			Assert.assertEquals("Update Password", pageTitle.getText());
			Assert.assertEquals("Current Password", confirmPassword.getText().trim());
			Assert.assertEquals("New Password", newPassword.getText().trim());
			Assert.assertEquals("Confirm New Password", confirmNewPassword.getText().trim());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void clickOnPasswordPageCancelButton() {
		this.getWhenclickAble(updatePageCancelButton, 1000);
		this.clickElement(updatePageCancelButton);
	}

	public void clickOnAddAddressbutton() {
		this.getWhenclickAble(addAddressButton, 1000);
		this.clickElement(addAddressButton);
	}

	public void enterUserAddress(List<Map<String, String>> userAddress) {
		this.selectDropdownValue(addressCountry, userAddress.get(0).get("Country"));
		this.selectDropdownValue(addressTitle, userAddress.get(0).get("Title"));
		this.typeText(addressFirstName, userAddress.get(0).get("FirstName"));
		this.typeText(addressLastName, userAddress.get(0).get("LastName"));
		this.typeText(addressAddressLine1, userAddress.get(0).get("Address1"));
		this.typeText(addressCity, userAddress.get(0).get("City"));
		this.typeText(addressPostcode, userAddress.get(0).get("PostalCode"));
	}

	public void clickOnAddressSavebutton() {
		this.getWhenclickAble(updateButton, 1000);
		this.clickElement(updateButton);
	}

	public void updateAddressAndClickSave() {
		this.selectDropdownValue(addressTitle, "Dr.");
		this.getWhenclickAble(updateButton, 1000);
		Actions action = new Actions(driver);
		action.moveToElement(updateButton).click().perform();
		// this.clickElement(updateButton);
	}

	public void clickOnEditIcon() {
		this.getWhenclickAble(editIcon, 1000);
		this.clickElement(editIcon);
	}

	public void clickOnAddressPageDeleteIcon() {
		this.getWhenclickAble(addressDeleteIcon, 1000);
		this.clickElement(addressDeleteIcon);
	}

	public void clickOnAddressCancelButton() {
		this.waitForPageToBeReady();
		this.getWhenclickAble(addressCancelButton, 1000);
		this.clickElement(addressCancelButton);
	}

	public void verifyAddressBookPage() {
		try {
			Assert.assertEquals("Address Book | Public Sector Site", driver.getTitle());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void clickOnAddressDeleteOverlayButton() {
		this.waitForPageToBeReady();
		this.getWhenclickAble(addressDeleteOverlayButton, 1000);
		Actions action = new Actions(driver);
		action.moveToElement(addressDeleteOverlayButton).click().perform();
		// this.clickElement(addressDeleteOverlayButton);
	}

	public void verifyDeleteAddressSuccessMessage() {
		String successMessage = addressDeleteSuccessMessage.getText();
		try {
			Assert.assertTrue("Address removed successfully", successMessage.contains("Address removed successfully"));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyMyDocumentPage() {
		this.waitForPageToBeReady();
		try {
			Assert.assertEquals("Documents", pageTitle.getText());
			Assert.assertEquals("Current Documents", currentDocumentsTitle.getText().trim());
			Assert.assertEquals("View Expired Documents", expiredDocuments.getText().trim());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void verifyExpiredDocumentsPage() {
		try {
			Assert.assertEquals("Expired Documents", pageTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public void clickToRestoreDraft() {
		log.info("Restoring draft.......");
		this.waitForPageToBeReady();

	

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		if (this.isElementPresent(seeAllDraftLinks)) {
			this.clickElement(seeAllDraftLinks);
		}

		String replacedXpath = restoreDraftLink.replace("%S", DraftConfirmationPage.draftNumber);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		System.out.println("restoreDraftLink" + element);
		this.getWhenclickAble(element, 1000);
		this.clickElement(element);
	}

}
