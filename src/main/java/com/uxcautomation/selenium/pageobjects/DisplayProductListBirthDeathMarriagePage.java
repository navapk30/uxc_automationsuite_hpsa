package com.uxcautomation.selenium.pageobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DisplayProductListBirthDeathMarriagePage extends DisplayProductListPage {

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Apply for Marriage Certificate')]")
	WebElement applyMarriageCertificateTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'apply-for-marriage-certificate')]/parent::div")
	WebElement applyMarriageCertificateViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'apply-for-marriage-certificate')]/following-sibling::button")
	WebElement applyMarriageCertificateProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Apply for Death Certificate')]")
	WebElement applyDeathcertificateTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'apply-for-death-certificate')]/parent::div")
	WebElement applyDeathCertificateViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'apply-for-death-certificate')]/following-sibling::button")
	WebElement applyDeathCertificateProductApplyNowButton;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Register a Birth')]")
	WebElement registerABirthTitle;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'register-birth')]/parent::div")
	WebElement registerABirthProductViewDetailButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'register-birth')]/following-sibling::button")
	WebElement registerABirthProductApplyNowButton;

	public DisplayProductListBirthDeathMarriagePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyPLPForBirthDeathMarriage() {

		try {
			Assert.assertEquals("  Apply for Marriage Certificate", applyMarriageCertificateTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("VIEW DETAILS", applyMarriageCertificateViewDetailButton.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("APPLY NOW", applyMarriageCertificateProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("  Apply for Death Certificate", applyDeathcertificateTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("VIEW DETAILS", applyDeathCertificateViewDetailButton.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			assertEquals("APPLY NOW", applyDeathCertificateProductApplyNowButton.getText());
		} catch (Error e) {
			this.parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("  Register a Birth", registerABirthTitle.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("VIEW DETAILS", registerABirthProductViewDetailButton.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		try {
			Assert.assertEquals("REGISTER NOW", registerABirthProductApplyNowButton.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

	}

	public DisplayProductDetailPage goToProductDetailPage() {

		this.clickElement(registerABirthProductViewDetailButton);
		return PageFactory.initElements(driver, DisplayProductDetailPage.class);
	}

	/**
	 * @param productCode
	 * @return DisplayProductDetailPage
	 */
	public void addServiceToCartFromPLP(String productCode) {
		WebElement addToCartElement = findAddToCartButtonForProduct(productCode);
		this.clickElement(addToCartElement);
	}

	public void addServiceToCartFromPLP(WebElement addToCartElement) {
		this.clickElement(addToCartElement);
	}

	private WebElement findAddToCartButtonForProduct(String productCode) {
		log.info("Finding Add to cart button for " + productCode);
		String xpath = "//input[@type=\"hidden\"][@value=\"%productCode%\"]/following-sibling::button[@type=\"submit\"]";
		String replacedVersion = xpath.replace("%productCode%", productCode);
		WebElement addToCartElement = null;
		while (true) {
			try {
				addToCartElement = FindElementBy(replacedVersion, "xpath");
				System.out.println("Add to cart button found for: " + productCode);
				break;
			} catch (Exception e) {
				log.info("Entered catch block...... ");
				WebElement nextButton = FindElementBy("(//*[contains(@class,'glyphicon glyphicon-chevron-right')])[1]",
						"xpath");
				System.out.println("Element not found click next button");
				clickElement(nextButton);
			}
		}
		return addToCartElement;
	}

	public void verifyAddToCartTextAndAddServiceToCart(String productCode, String addToCartText) {
		System.out.println("verifyAddToCartTextAndAddServiceToCart");
		this.waitForPageToBeReady();

		WebElement addToCartElement = findAddToCartButtonForProduct(productCode);
		try {
			Assert.assertEquals(addToCartText, addToCartElement.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		this.getWhenclickAble(addToCartElement, 60);
		System.out.println("Clicking element :"+addToCartElement.getText());
		if((loadConfig.getdriverMode()).equals("remote")){
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		this.clickElement(addToCartElement);
		//clickElement(addToCartElement);
	}
}
