package com.uxcautomation.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mkuppuchamy
 *
 */
public class CheckoutBundlePage extends BaseDriver {

	public CheckoutBundlePage(WebDriver driver) {
		super(driver);
	}

	public static String XPATH_TO_CHOOSE_BUNDLE_OPTION = "//input[@type=\"radio\"][@value=\"%bundleOption%\"]/parent::label";
	
	public void selectBundleOption(String bundleOption) {
		log.info("Selecting Bundle option..");
		this.waitForPageToBeReady();
		String revisedPath = XPATH_TO_CHOOSE_BUNDLE_OPTION.replace("%bundleOption%", bundleOption);
		WebElement element = FindElementBy(revisedPath, "xpath");
		clickElement(element);
	}
}
