/**
 * 
 */
package com.uxcautomation.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author tarundeepsharma
 *
 */
public class GmailPage extends BaseDriver {

	@FindBy(how=How.ID,using="Email")
	private WebElement gmailEmailField;
	
	@FindBy(how=How.ID,using="next")
	private WebElement gmailNextField;
	
	@FindBy(how=How.ID,using="Passwd")
	private WebElement gmailPasswordField;
	
	@FindBy(how=How.ID,using="signIn")
	private WebElement gmailSignInField;
	
	private String baseUrl = "https://accounts.google.com/";
	/**
	 * @param driver
	 */
	public GmailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void logintoGmail(){
		log.info("Login to Gmail...");
			
		   driver.get(baseUrl + "/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		   
		   typeText(gmailEmailField, "tloytest@gmail.com");
		   clickElement(gmailNextField);
		   typeText(gmailPasswordField, "testtest123");
		   clickElement(gmailSignInField);
		   
		
	}

}
