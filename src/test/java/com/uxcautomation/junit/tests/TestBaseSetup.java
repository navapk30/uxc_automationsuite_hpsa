/**
 * 
 */
package com.uxcautomation.junit.tests;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestWatchman;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.utilities.LoadConfigProperties;
import com.uxcautomation.utilities.SauceApi;

/**
 * @author tarundeepsharma
 *
 */

public class TestBaseSetup {

	public static WebDriver driver;
	RemoteWebDriver remoteDriver;
	public static LoadConfigProperties loadConfig;
	protected static String baseUrl;
	protected HomePage homePage;
	//protected CsCockpitPage cscockpitPage;
	//protected DisplayProductListPage prodListPage;
	protected SauceApi sauceApiObject;
	
	@Rule
	  public TestRule watchman = new TestWatcher() {
	    @Override
	    public Statement apply(Statement base, Description description) {
	    	System.out.println("*****************RUNNING TEST**************************");
	    	System.out.println("********"+description.getMethodName()+"********");
	    	System.out.println("*******************************************************");
	    	updateSauceTestCaseNameMethod(description.getMethodName());
	      return super.apply(base, description);
	    }

	    @Override
	    protected void succeeded(Description description) {
	    	System.out.println("*****************SUCCESSFULL EXECUTED**************************");
	    	System.out.println("********"+description.getDisplayName() + "********");
	    	System.out.println("***************************************************************");
	    }

	    @Override
	    protected void failed(Throwable e, Description description) {
	    	System.out.println("*****************FAILED TEST**************************");
	    	System.out.println("**** "+description.getDisplayName() + " " + e.getClass().getSimpleName() + "****\n");
	    	System.out.println("******************************************************");
	    }

	    @Override
	    protected void skipped(AssumptionViolatedException e, Description description) {
	    	System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
	    }

	    @Override
	    protected void starting(Description description) {
	      super.starting(description);
	    }

	    @Override
	    protected void finished(Description description) {
	      super.finished(description);
	    }
	  };

	public TestBaseSetup() throws IOException{
		loadConfig = LoadConfigProperties.getInstance();
		baseUrl = loadConfig.getsiteUrl();				


	}

	/**
	 * @return the driver object
	 */
	public WebDriver getDriver(){

		return driver;

	}


	/**
	 * @throws IOException
	 */
	@BeforeClass
	public static void setDriver() throws IOException{
		loadConfig = LoadConfigProperties.getInstance();
		String driverMode = loadConfig.getdriverMode();
		System.out.println(driverMode);
		DesiredCapabilities caps;
		switch (driverMode){

		case "remote":
			/*DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

				desiredCapabilities.setBrowserName(System.getenv(loadConfig.getBrowser()));
				desiredCapabilities.setVersion(System.getenv(loadConfig.getBrowserVersion()));
				desiredCapabilities.setCapability(CapabilityType.PLATFORM, System.getenv(loadConfig.getPlatform()));
				driver = new RemoteWebDriver(
						new URL("http://"+loadConfig.getSauceUsername()+"@ondemand.saucelabs.com:80/wd/hub"),
						desiredCapabilities);*/
			String BambooBuildNumber = System.getProperty("BambooBuild");
			if(BambooBuildNumber == null){
				BambooBuildNumber = "Local Job";
			}
			
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "11.0");
			/*DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "45.0");*/

			caps.setCapability("name", BambooBuildNumber);
			caps.setCapability("build", BambooBuildNumber);
			caps.setCapability("passed", true);

			driver = new RemoteWebDriver(
					new URL("http://"+loadConfig.getSauceUsername()+":"+loadConfig.getSauceAccesskey()+"@ondemand.saucelabs.com:80/wd/hub"),
					caps);
			printSauceSessionId();
			break;

		case "local":
			driver = new FirefoxDriver();		
			break;

		default:
			System.out.println("default");
			break;


		}

		driver.manage().window().maximize();
		baseUrl = loadConfig.getsiteUrl();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}



	public static void printSauceSessionId(){
		String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",((RemoteWebDriver)driver).getSessionId().toString(),loadConfig.getBuildJobName());    
		System.out.println(message);
	}

	/**
	 * Updating Sauce TestName for Job
	 * @param testMethodName 
	 */
	public void updateSauceTestCaseNameMethod(String testMethodName){
		if(loadConfig.getdriverMode().equals("remote")){
			String sauceJobId = ((RemoteWebDriver)driver).getSessionId().toString();

			try {
				sauceApiObject = new SauceApi();
				sauceApiObject.updateSauceTestCaseName(sauceJobId, testMethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
