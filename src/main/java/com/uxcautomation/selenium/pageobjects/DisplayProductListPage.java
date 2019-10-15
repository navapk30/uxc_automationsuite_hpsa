/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Assert;import org.openqa.selenium.Keys;
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
public class DisplayProductListPage extends BaseDriver {

	@FindBy(how = How.CSS, using = "button.addToCartButton")
	WebElement addToBagField;

	@FindBy(how = How.ID, using = "miniCartLayer")
	WebElement minicartLayerField;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Checkout')]")
	WebElement minicartCheckoutLinkField;

	@FindBy(how = How.XPATH, using = "//a[@class='minicart']")
	WebElement minicartLinkField;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Refine by Departments')]")
	WebElement facetRefineByDepartmentField;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Refine by Transaction Type')]")
	WebElement facetRefineByTransactionTypeField;

	@FindBy(how = How.XPATH, using = "//div[contains(text()[2],'Refine by Topic')]")
	WebElement facetRefineByTopicField;

	// @FindBy(how=How.XPATH, using="//div[contains(text()[2],'Refine by Vehicle
	// Type')]")
	// WebElement facetRefineByVechileTypeField;
	//
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Sort by:')]")
	WebElement sortByField;

	public static String TITLE_TEXT = "%categoryName% | Categories | Public Sector Site";

	// ERROR: Caught exception [ERROR: Unsupported command [mouseMove |
	// //a[@class='minicart'] | ]]

	/**
	 * @param driver
	 */
	public DisplayProductListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Verify Product Listing page components
	 */
	public void verifyProductListingIsDisplayed() {
		log.info("Verify Product Listing page components.. verifyProductListingIsDisplayed()");

		try {
			Assert.assertEquals("Refine by Departments", facetRefineByDepartmentField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Refine by Transaction Type", facetRefineByTransactionTypeField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals("Refine by Topic", facetRefineByTopicField.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		/*
		 * try{ Assert.assertEquals("Refine by Vehicle Type",
		 * facetRefineByVechileTypeField.getText()); }catch (Error e) {
		 * parseErrorMessageLog(e.toString()); }
		 */
		try {
			Assert.assertEquals("SORT BY:", sortByField.getText().toUpperCase());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
	}

	public DisplayProductListPage goToProductListingPage(String categoryName) {
		Actions action = new Actions(driver);
		String xpath = "//a[contains(text(),'%categoryName%')]";
		String revisedXpath = xpath.replace("%categoryName%", categoryName);
		WebElement element = FindElementBy(revisedXpath, "xpath");
		action.moveToElement(element).click().perform();
		// categoryLinkField.click();
		return PageFactory.initElements(driver, DisplayProductListPage.class);
	}

	/**
	 * @param map
	 *            To verify PLP Product data
	 */
	public void verifyProductInformation(Map<String, String> map) {

		// Produch name
		// div[@class='card-list']/div[@class='row']/div/div/div/div[contains(text()[2],'Report
		// Graffiti')]

		// Description
		// div[@class='card-list']/div[@class='row']/div/div/div/div[contains(text()[2],'Report
		// Pothole')]/following-sibling::div/following-sibling::div/div -->

		// View Details
		// div[@class='card-list']/div[@class='row']/div/div/div/div[contains(text()[2],'Report
		// Pothole')]/following-sibling::div/following-sibling::div/div/following-sibling::div/a

		// addtocart
		// input[@value="report-graffiti"]/following-sibling::button
		log.info("Verifying Product " + map.get("productName") + " and its information is displayed on PLP page");

		String xpath = "//div[@class='card-list']/div[@class='row']/div/div/div/h2[contains(text(),'%productName%')]";
		String revisedXpath = xpath.replace("%productName%", map.get("productName"));
		WebElement productName = null;
		boolean goToFirstPage = false;
		while (true) {
			try {
				productName = FindElementBy(revisedXpath, "xpath");
				break;
			} catch (Exception e) {
				log.info("Entered catch block...... ");
				WebElement nextButton = FindElementBy("(//*[contains(@class,'glyphicon glyphicon-chevron-right')])[1]",
						"xpath");
				clickElement(nextButton);
				goToFirstPage = true;
			}
		}

		try {
			Assert.assertTrue(isElementPresent(productName));
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		try {
			Assert.assertEquals(map.get("productName"), productName.getText().trim());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		WebElement shortDescriptionElement = FindElementBy(revisedXpath + "/parent::div/following-sibling::div",
				"xpath");

		try {
			Assert.assertEquals(map.get("productShortDescription"), shortDescriptionElement.getText().trim());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		WebElement departmentElement = FindElementBy(
				revisedXpath + "/parent::div/following-sibling::div/following-sibling::div/div", "xpath");

		try {
			Assert.assertEquals(map.get("department"), departmentElement.getText().trim());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		WebElement viewDetails = FindElementBy(
				revisedXpath
						+ "/parent::div/following-sibling::div/following-sibling::div/div/following-sibling::div/a",
				"xpath");

		try {
			Assert.assertEquals(map.get("viewDetailButton"), viewDetails.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}

		String addCart = "//input[@value='" + map.get("productID") + "']/following-sibling::button";

		WebElement addToCartButton = FindElementBy(addCart, "xpath");

		try {
			Assert.assertEquals(map.get("applyNowButton"), addToCartButton.getText());
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}
		
		if (goToFirstPage) {
			WebElement firstPageButton = FindElementBy("(//li[@class='pagination-prev']/following-sibling::li)[1]", "xpath");
			clickElement(firstPageButton);
		}

		log.info("Given Product " + map.get("productName") + " and its information is displayed");
	}

	public void verifyIsNavigatedToPLPPage(String categoryName) {

		String categoryTitle = TITLE_TEXT.replace("%categoryName%", categoryName);
		
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Assert.assertEquals(driver.getTitle().trim(), categoryTitle);
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		}*/

		/*
		 * if(!driver.getTitle().toLowerCase().trim().equals(categoryTitle.
		 * toLowerCase())){ log.info("Expected " + driver.getTitle()+" But got"
		 * +categoryTitle); Assert.fail(
		 * "Given Product listing page is not present"); }
		 */
	}

	/**
	 * @param productCode
	 * @return DisplayProductDetailPage
	 * @throws InterruptedException 
	 */
	public void addServiceToCartFromPLP(String productCode) throws InterruptedException {
		this.waitForPageToBeReady();
		String xpath = "//input[@type=\"hidden\"][@value=\"%productCode%\"]/following-sibling::button[@type=\"submit\"]";
		String replacedVersion = xpath.replace("%productCode%", productCode);
		WebElement addToCartElement = FindElementBy(replacedVersion, "xpath");
		System.out.println(addToCartElement.isEnabled());
		Thread.sleep(1000);
		this.clickElement(addToCartElement);
	}

	public void goToPDPFromPLP(String productCode) throws InterruptedException {
		this.waitForPageToBeReady();
		String xpath = "//a[contains(@aria-label,\"%productCode%\")]";
		String replacedVersion = xpath.replace("%productCode%", productCode);
		WebElement pdpElement = FindElementBy(replacedVersion, "xpath");
		System.out.println(pdpElement.isEnabled());
		this.clickElement(pdpElement);
	}
}
