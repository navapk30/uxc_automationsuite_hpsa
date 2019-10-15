package com.uxcautomation.selenium.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class DisplayProductListPagePOC extends BaseDriver {
	
	

	@FindBy(how = How.XPATH, using = "(//title")
	WebElement title;
	
	public static String  TITLE_TEXT = "%categoryName% | Categories | Public Sector Site";
	public DisplayProductListPagePOC(WebDriver driver) {
		super(driver);
	}

	public ArrayList<ArrayList<String>> getDataForCategory() {

		return getDataRowsFromExcelAsSeperatelist("automation_plp.xlsx");
	}

	public void verifyPLPPageForCategory(String categoryName) {

		ArrayList<ArrayList<String>> categoryProductInfoList = (ArrayList<ArrayList<String>>) getDataForCategory();

		ArrayList<ArrayList<String>> categoryProductsList = new ArrayList<ArrayList<String>>();
		
		for (ArrayList<String> category : categoryProductInfoList) {
			if (!category.isEmpty() && category.get(0).equals(categoryName)) {
				categoryProductsList.add(category);
			}
		}
		verifyCategoryInformation(categoryProductsList);

	}

	private void verifyCategoryInformation(ArrayList<ArrayList<String>> categoryProductsList) {

		goToProductListingPage(categoryProductsList.get(0).get(0));
        log.info("Verifying Category information for category "+categoryProductsList.get(0).get(0));
		for (ArrayList<String> categoryProduct : categoryProductsList) {
			log.info("Verifying product information for category "+categoryProduct.get(1));
			verifyProductInformation(categoryProduct);
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

	@SuppressWarnings("deprecation")
	public void verifyProductInformation(ArrayList<String> categoryProduct) {
		String xpath = "//span[@class='product-name' and contains(text(),'%productName%')]";
		String revisedXpath = xpath.replace("%productName%", categoryProduct.get(0));
		WebElement element = FindElementBy(revisedXpath, "xpath");

		if (!isElementPresent(element)) {
			Assert.fail("Given Product is not present");
		}
		WebElement productElement = element.findElement(By.xpath("./ancestor::div[contains(@class,'product-item')]"));

		WebElement shortDescriptionElement = productElement
				.findElement(By.xpath(".//div[contains(@class,'short-description')]"));

		
		if (!shortDescriptionElement.getText().trim().equals(categoryProduct.get(1))) {
			log.info("Expected " + shortDescriptionElement.getText()+" But got"+categoryProduct.get(1));
			Assert.fail("Given Product short description is not present");
			
		}

		WebElement department = productElement.findElement(By.xpath(".//div[contains(@class,'product-department')]"));

		if (!department.getText().equals(categoryProduct.get(2))) {
			log.info("Expected " + department.getText()+" But got"+categoryProduct.get(2));
			Assert.fail("Given Product department description is not present");
		}

		WebElement addToCartButton = productElement.findElement(By.xpath(".//button[@id='addToCartButton']"));

		if (!addToCartButton.getText().trim().equals(categoryProduct.get(3))) {
			log.info("Expected " + addToCartButton.getText()+" But got"+categoryProduct.get(3));
			
			Assert.fail("Given Product department description is not present");
		}
	  
		log.info("Given Product "+categoryProduct.get(1)+" and its information is displayed");
	}

	public void verifyIsNavigatedToPLPPage(String categoryName) {
		
		String categoryTitle = TITLE_TEXT.replace("%categoryName%", categoryName);
		if(!driver.getTitle().toLowerCase().trim().equals(categoryTitle.toLowerCase())){
			log.info("Expected " + driver.getTitle()+" But got"+categoryTitle);
			Assert.fail("Given Product listing page is not present");
		}
	}
	
	/**
	 * @param productCode
	 * @return DisplayProductDetailPage
	 */
	public void addServiceToCartFromPLP(String productCode) {
		String xpath = "//input[@type=\"hidden\"][@value=\"%productCode%\"]/following-sibling::button[@type=\"submit\"]";
		String replacedVersion = xpath.replace("%productCode%", productCode);
		WebElement addToCartElement = FindElementBy(replacedVersion, "xpath");
		this.clickElement(addToCartElement);
	}
}
