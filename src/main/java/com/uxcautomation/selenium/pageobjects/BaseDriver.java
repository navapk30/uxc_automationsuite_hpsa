/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.piccolo.xml.ElementDefinition;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.uxcautomation.utilities.DataReaderExcel;
import com.uxcautomation.utilities.LoadConfigProperties;
import com.uxcautomation.utilities.SauceApi;

/**
 * @author tarundeepsharma
 *
 */
/**
 * @author tarundeepsharma
 *
 */
/**
 * @author mkuppuchamy
 *
 */
/**
 * @author sharmat
 *
 */
public class BaseDriver {

	private static final String TEST_DATA_FOLDER = "TestData";
	private static final String FILE_PATH_SEPARATOR = "/";
	protected WebDriver driver;
	protected StringBuffer verificationErrors = new StringBuffer();
	protected Logger log = Logger.getLogger(BaseDriver.class.toString());
	public SauceApi sauceApi;
	public LoadConfigProperties loadConfig;
	public String browser = System.getProperty("Browser");

	public static String INPUT_TEXT_YFORM_FIELD = "//label[contains(text(),'%S')]/following-sibling::input[contains(@class,\"xforms-input-input\")]";
	public static String INPUT_SELECT_YFORM_FIELD = "//label[contains(text(),'%S')]/following-sibling::span[contains(@class,\"xforms-select1\")]/select";
	public static String INPUT_CHECKBOX_YFORM_FIELD = "//span[contains(text(),\"%S\")]/parent::label[@class='checkbox']";
	public static String INPUT_RADIO_YFORM_FIELD = "//span[contains(text(),\"%S\")]/parent::label[@class='radio']";
	public static String INPUT_TEXT_YFORM_FIELD_WITH_POSITION = "(//label[contains(text(),'%S')])[%D]/following-sibling::input[contains(@class,\"xforms-input-input\")]";
	public static String INPUT_SELECT_YFORM_WITH_POSITION = "(//label[contains(text(),'%S')])[%D]/following-sibling::span[contains(@class,\"xforms-select1\")]/select";
	public static String INPUT_CHECKBOX_YFORM_WITH_POSITION = "(//span[contains(text(),\"%S\")])[%D]/parent::label[@class='checkbox']";
	public static String INPUT_RADIO_YFORM_WITH_POSITION = "(//span[contains(text(),\"%S\")])[%D]/parent::label[@class='radio']";
	public static String TEXT_AREA_YFORM_FIELD = "//label[contains(text(),'%S')]/following-sibling::textarea";
	public static String INPUT_FILE_YFORM_FIELD = "//label[contains(text(),\"%S\")]/following-sibling::span[1]/input";
	public static String UPLOADED_FILE_ELEMENT = "//span[contains(@class,\"xforms-upload-filename\")]";
	@FindBy(how = How.CSS, using = "a.js-checkout-step.active .title")
	WebElement checkoutHeadingField;

	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'checkout-next')])[1]")
	WebElement nextbuttonField;

	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'btn-primary')])[1]")
	WebElement nextCheckoutbuttonField;

	// Constructor
	public BaseDriver(WebDriver driver) {
		this.driver = driver;
	}

	// Type text in Text fields

	public void typeText(WebElement element, String text) {
		try {
			// Assert.assertTrue(element.toString() + " is not present",
			// isElementPresent(element));
			Assert.assertTrue(isElementPresent(element));
			try {
				element.clear();
			} catch (Exception e) {
				element.sendKeys(Keys.DELETE);
			}
			element.sendKeys(text);
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		} catch (Exception e) {
			log.info(element.toString() + " is not present");
			parseErrorMessageLog(e.toString());
		}
	}

	// Click on the element
	public void clickElement(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(isElementPresent(element));
			element.click();
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		} catch (Exception e) {
			parseErrorMessageLog(e.toString());
		}
	}

	/**
	 * Select value from drop down
	 */

	public void selectDropdownValue(WebElement element, String value) {
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(value);
	}

	/**
	 * returns options for select dropdown
	 * 
	 * @param selectLink
	 * @return
	 */
	public List<WebElement> getOptionsForDropDown(WebElement selectLink) {
		List<WebElement> selectOptions = null;
		try {
			Assert.assertTrue(isElementPresent(selectLink));
			Select select = new Select(selectLink);
			selectOptions = select.getOptions();
		} catch (Error e) {
			parseErrorMessageLog(e.toString());
		} catch (Exception e) {
			parseErrorMessageLog(e.toString());
		}
		return selectOptions;
	}

	/**
	 * Clicking element by mouse
	 * 
	 * @param element
	 */
	public void actionMouseClick(WebElement element) {
		log.info("Action click :" + element.getText());
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	/**
	 * Logging all errors on the Console
	 */
	public void parseErrorMessageLog(String err) {

		err = err.replaceAll("[\\[\\]]", "");

		verificationErrors.append(err);
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			log.info(err);
			updateSauceResultForTestFailure(err);
			fail(verificationErrorString);
		}

		// System.out.println(verificationErrors);
		// return verificationErrors;
	}

	/**
	 * Logging all errors on the Console
	 */
	public void parseSuccessMessageLog(String success) {
		log.info(success);

	}

	/**
	 * Call to SauceAPI Method Update Test Result
	 */
	public void updateSauceResultForTestFailure(String error) {

		loadConfig = LoadConfigProperties.getInstance();

		if (loadConfig.getdriverMode().equals("remote")) {
			sauceApi = new SauceApi();
			String sauceJobId = ((RemoteWebDriver) driver).getSessionId().toString();
			try {
				sauceApi.updateSauceTestResult(sauceJobId, error);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			log.info("########Suite is Running Locally...########");
		}

	}

	/**
	 * Taking Screenshots for the pages
	 */
	public void getScreenshot(String screenName) {
		log.info("Preparing to take Screen shot..");
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// The below method will save the screen shot in d drive with name
			// "screenshot.png"
			FileUtils.copyFile(scrFile, new File("Screenshots/" + screenName + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param ele
	 * @return Message from div Alert
	 */
	public String getStringErrorMessageFromErrorDiv(WebElement ele) {
		String[] srt = ele.getText().split("\\n");
		return srt[1];
	}

	public Boolean isMobileUI() {
		if (browser == "Iphone6Plus" || browser == "AndriodTablet" || browser == "AndriodPhone"
				|| browser == "IpadAir") {
			return true;
		} else {
			return false;
		}
	}

	public WebElement FindElementBy(String element, String how) {

		loadConfig = LoadConfigProperties.getInstance();

		WebElement elementForPage = null;
		String locator = element;
		System.out.println("Test->" + locator);
		try {
			switch (how) {

			case "link_text":
				elementForPage = driver.findElement(By.linkText(locator));
				break;

			case "css":
				elementForPage = driver.findElement(By.cssSelector(locator));
				break;
			case "xpath":
				elementForPage = getWhenVisible(By.xpath(locator), 120);// driver.findElement(By.xpath(locator));
				break;
			case "id":
				elementForPage = driver.findElement(By.id(locator));
				break;
			}
		} catch (Exception e) {
			parseErrorMessageLog(e.toString());
		}

		return elementForPage;
	}

	//
	public void logout() {

	}

	/**
	 * @return a LinkedList containing String arrays representing the browser
	 *         combinations the test should be run against. The values in the
	 *         String array are used as part of the invocation of the test
	 *         constructor
	 */
	public static LinkedList<String[]> browsersStrings() {
		LinkedList<String[]> browsers = new LinkedList<String[]>();
		browsers.add(new String[] { "Windows 8.1", "11", "internet explorer" });
		browsers.add(new String[] { "OSX 10.8", "6", "safari" });
		return browsers;
	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.getTagName();
			// driver.findElement((By) element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * @return true if any Alert detected
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/**
	 * @return the Alert Text
	 */
	public String getAlertAndItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();

			return alertText;
		} catch (NoAlertPresentException e) {
			return e.getMessage();
		}

	}

	public WebElement getCustomLinkElement(String linkText) {
		return driver.findElement(By.linkText(linkText));

	}

	public WebElement getCustomXpathElement(String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression));

	}

	public WebElement getWhenElementVisible(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log.info(element.toString() + " is not present");
			parseErrorMessageLog(e.toString());
		}
		return element;
	}

	public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	public WebElement getWhenVisible(WebElement element, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public WebElement getWhenclickAble(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			log.info(element.toString() + " is not present");
			parseErrorMessageLog(e.toString());
		}
		return element;
	}

	/**
	 * Checking if Page is in ready State or Not
	 */
	public void waitForPageToBeReady() {
		log.info("Checking ready state of the Page...");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// This loop will rotate for 100 times to check If page Is ready after
		// every 1 second.
		// You can replace your if you wants to Increase or decrease wait time.
		for (int i = 0; i < 400; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.

			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				log.info("Page ready state is complete...");
				break;
			}
		}
	}

	/**
	 * returns data from excel
	 * 
	 * @param excelName
	 * @return
	 */
	public ArrayList<String> getDataRowsFromExcel(String excelName) {
		try {
			log.info("Reading Information from Excel...");
			String fileName = TEST_DATA_FOLDER + FILE_PATH_SEPARATOR + excelName;
			DataReaderExcel dataReader = new DataReaderExcel(fileName);
			return dataReader.getDataRowsFromExcel();
		} catch (IOException ioException) {
			log.info(" not able to read test data");
			parseErrorMessageLog("not able to read test data " + ioException.toString());
			return null;
		}
	}

	/**
	 * returns data from excel
	 * 
	 * @param excelName
	 * @return
	 */
	public ArrayList<ArrayList<String>> getDataRowsFromExcelAsSeperatelist(String excelName) {
		try {
			log.info("Reading Information from Excel...");
			String fileName = TEST_DATA_FOLDER + FILE_PATH_SEPARATOR + excelName;
			DataReaderExcel dataReader = new DataReaderExcel(fileName);
			return dataReader.getDataRowsFromExcelAsSeperateList();
		} catch (IOException ioException) {
			log.info(" not able to read test data");
			parseErrorMessageLog("not able to read test data " + ioException.toString());
			return null;
		}
	}

	/**
	 * insert/select value for yform field
	 * 
	 * TODO Update case for file upload
	 * 
	 * @param label
	 * @param value
	 * @param type
	 */
	public void enterYFormData(String label, String value, String type) {

		switch (type) {
		case "text":
			enterTextInYFormField(label, value);
			break;
		case "select":
			chooseOptionInYFormField(label, value);
			break;
		case "checkbox":
			selectCheckboxInYFormData(label);
			break;
		case "radio":
			selectRadioButtonInYFormData(label);
			break;
		case "textarea":
			enterCommentInYformPage(label, value);
			break;
		case "file":
			uploadFileInYformPage(label, value);
			break;
		default:
			enterTextInYFormField(label, value);
			break;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	/**
	 * insert/select value for yform multiple field with same name
	 *
	 * TODO Update case for file upload
	 * 
	 * @param label
	 * @param value
	 * @param type
	 * @param positionIndex
	 */
	public void enterYFormDataForMultipleFieldWithSameName(String label, String value, String type,
			String positionIndex) {
		switch (type) {
		case "text":
			enterTextInYFormField(label, value, positionIndex);
			break;
		case "select":
			chooseOptionInYFormField(label, value, positionIndex);
			break;
		case "checkbox":
			selectCheckboxInYFormData(label, positionIndex);
			break;
		case "radio":
			selectRadioButtonInYFormData(label, positionIndex);
			break;

		default:
			enterTextInYFormField(label, value, positionIndex);
			break;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void waitTillYFormLoadingIconDisappears() {

		// FluentWait<WebDriver> wait = new WebDriverWait(driver,
		// 60).pollingEvery(20, TimeUnit.SECONDS);

		FluentWait<WebDriver> wait = new WebDriverWait(driver, 120).pollingEvery(10, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		try {

			wait.until(ExpectedConditions
					.invisibilityOfElementLocated((By.xpath("(//*[contains(@class,'yui-overlay-hidden')])[1]"))));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated((By.xpath("(//*[contains(@id,'orbeon-spinner_mask')])"))));
		} catch (Exception e) {
			log.info("Error in waitTillYFormLoadingIconDisappears");
			parseErrorMessageLog(e.toString());
		}

	}

	public void waitTillYFormLoadingIconDisappears(int timeout, int pollingTimeout) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, timeout).pollingEvery(pollingTimeout,

				TimeUnit.SECONDS);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated((By.xpath("(//*[contains(@class,'yui-overlay-hidden')])[1]"))));
	}

	public void clickNext() {
		this.waitForPageToBeReady();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element = FindElementBy("(//*[contains(@class,'checkout-next')])[1]", "xpath");
		clickElement(element);
		System.out.println("Click done");
	}

	private void selectRadioButtonInYFormData(String label) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String inputPath = INPUT_RADIO_YFORM_FIELD.replace("%S", label);
		FindElementBy(inputPath, "xpath").click();
	}

	private void selectCheckboxInYFormData(String label) {
		String inputPath = INPUT_CHECKBOX_YFORM_FIELD.replace("%S", label);
		FindElementBy(inputPath, "xpath").click();
	}

	private void selectRadioButtonInYFormData(String label, String positionIndex) {
		String inputPath = INPUT_RADIO_YFORM_WITH_POSITION.replace("%S", label);
		String replacedNumberPath = inputPath.replace("%D", positionIndex);
		WebElement element = FindElementBy(replacedNumberPath, "xpath");
		this.clickElement(element);
		log.info("Radio button value : "+element.getText());
		

		// Actions action = new Actions(driver);
		// action.moveToElement(FindElementBy(replacedNumberPath,
		// "xpath")).click().perform();
	}

	private void selectCheckboxInYFormData(String label, String positionIndex) {
		String inputPath = INPUT_CHECKBOX_YFORM_WITH_POSITION.replace("%S", label);
		String replacedNumberPath = inputPath.replace("%D", positionIndex);
		FindElementBy(replacedNumberPath, "xpath").click();
	}

	private void chooseOptionInYFormField(String label, String value, String positionIndex) {
		String replacedXpath = INPUT_SELECT_YFORM_WITH_POSITION.replace("%S", label);
		String replacedNumberPath = replacedXpath.replace("%D", positionIndex);
		WebElement element = FindElementBy(replacedNumberPath, "xpath");
		new Select(element).selectByVisibleText(value);
	}

	private void enterTextInYFormField(String label, String value, String positionIndex) {
		String replacedXpath = INPUT_TEXT_YFORM_FIELD_WITH_POSITION.replace("%S", label);
		String replacedNumberPath = replacedXpath.replace("%D", positionIndex);
		WebElement element = FindElementBy(replacedNumberPath, "xpath");
		this.typeText(element, value);
	}

	private void chooseOptionInYFormField(String label, String value) {
		String replacedXpath = INPUT_SELECT_YFORM_FIELD.replace("%S", label);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		new Select(element).selectByVisibleText(value);
	}

	private void enterTextInYFormField(String label, String value) {
		this.waitForPageToBeReady();
		String replacedXpath = INPUT_TEXT_YFORM_FIELD.replace("%S", label);
		WebElement element = FindElementBy(replacedXpath, "xpath");

		this.typeText(element, value);

	}

	private void enterCommentInYformPage(String label, String value) {
		String replacedXpath = TEXT_AREA_YFORM_FIELD.replace("%S", label);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		this.typeText(element, value);
	}

	private void uploadFileInYformPage(String label, String value) {
		enterFilePathForUploadField(label, value);

		String replacedXpathForFileUpload = UPLOADED_FILE_ELEMENT.replace("%S", label);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(By.xpath(replacedXpathForFileUpload), value));
	}

	private void enterFilePathForUploadField(String label, String value) {
		String driverMode = LoadConfigProperties.getInstance().getdriverMode();

		if (StringUtils.containsIgnoreCase(driverMode, "remote")) {
			if (driver instanceof RemoteWebDriver) {
				RemoteWebDriver localDriver = (RemoteWebDriver) driver;
				localDriver.setFileDetector(new LocalFileDetector());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				log.info("Driver ready for local file detection on remote server");
			}
		}
		log.info("OS Version :" + System.getProperty("os.name"));
		String replacedXpath = INPUT_FILE_YFORM_FIELD.replace("%S", label);
		WebElement element = FindElementBy(replacedXpath, "xpath");
		String relativeFilePath = StringUtils.EMPTY;
		if (StringUtils.containsIgnoreCase(System.getProperty("os.name"), "window")) {
			relativeFilePath = System.getProperty("user.dir") + "\\target\\classes\\TestData\\" + value;
		} else {
			relativeFilePath = System.getProperty("user.dir") + "/target/classes/TestData/" + value;
		}

		log.info("File Location: " + relativeFilePath);
		log.info("File exists at location :" + new File(relativeFilePath).exists());

		this.typeText(element, relativeFilePath);
	}

	public void uploadInvalidFileInYForm(String fileName, String fieldName) {
		enterFilePathForUploadField(fieldName, fileName);

	}

	public boolean hasIndex(int index, String[] list) {
		if (index < list.length)
			return true;
		return false;
	}

}
