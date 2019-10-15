package com.uxcautomation.junit.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uxcautomation.utilities.LoadConfigProperties;

@RunWith(Parameterized.class)
public class UserLoginTestParameterized {
	WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	public String emailAddress;
	public String password;
	 private static final Logger LOGGER = Logger.getAnonymousLogger();
	 LoadConfigProperties loadConfig;
	
	public UserLoginTestParameterized(String emailAddress, String password){
		this.emailAddress = emailAddress;
		this.password = password;
		
	}
	
	@Before
	public void setUp() throws Exception {
		loadConfig = LoadConfigProperties.getInstance();
		LOGGER.info("sdfsdfdsfdsf@@@@@@@@@@@@@@");
		System.err.println("fsfsdfdsfsdfdsffsfdssf");
		System.out.println("dhjkshjkhjks"+loadConfig.getBrowser());
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl = "http://project-pink.whitelabelled.com.au:9001/hiabstorefront/?site=citychic-au";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("dhjkshjkhjks"+loadConfig.getBrowser());
	}
	@Parameters
	public static  Collection<Object[]> data(){
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "tsharma@whitelabelled.com";
		data[0][1] = "Test1234";
		
		data[1][0] = "tsharma@whitelabelled.com";
		data[1][1] = "Test12345";
		
		return Arrays.asList(data);
		
	}
	
	@Test
	public void chkTest(){
		System.out.println("Checking Login"+this.emailAddress+"---"+this.password);
		LOGGER.info("Test Started ..");
		LOGGER.info("Checking with "+this.emailAddress+" and "+this.password);
	}

	@Ignore
	@Test
	public void checkUserLoginTest() throws Exception{
		System.out.println("Checking Login"+this.emailAddress+"---"+this.password);
		LOGGER.info("Test Started ..");
		LOGGER.info("Checking with "+this.emailAddress+" and "+this.password);
		 driver.get(baseUrl);
		    driver.findElement(By.linkText("Sign in")).click();
		    driver.findElement(By.id("j_username")).clear();
		    driver.findElement(By.id("j_username")).sendKeys(this.emailAddress);
		    driver.findElement(By.id("j_password")).clear();
		    driver.findElement(By.id("j_password")).sendKeys(this.password);
		    driver.findElement(By.cssSelector("button.btn-l")).click();
		    

		    
		    try {
		      assertTrue(isElementPresent(By.linkText("Account")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		      LOGGER.info("Login NOT Succesfull using credentials "+this.emailAddress+" and "+this.password);
		    	getScreenshot("LoginError");
			    try {
			        assertEquals("Your username or password was incorrect.", driver.findElement(By.cssSelector("div.alert.negative")).getText());
			        getScreenshot("InvalidLoginSuccess");
				     LOGGER.info("Login not successfull with Invalid Credentials "+this.emailAddress+" and "+this.password);
				      
			      } catch (Error ef) {
			        verificationErrors.append(ef.toString());
			      }
		    }
		    try {
		    	
		      assertEquals("Sign out", driver.findElement(By.id("fblogout")).getText());
		      getScreenshot("LoginSuccess");
		      LOGGER.info("Login Succesfull using credentials "+this.emailAddress+" and "+this.password);
		      
		    } catch (Error e) {
		    	
		      verificationErrors.append(e.toString());
		    }
		    driver.findElement(By.id("fblogout")).click();
	}
	
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
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
	  
    public void getScreenshot(String screenName) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("Screenshots/"+screenName+".png"));
           
    }

}
