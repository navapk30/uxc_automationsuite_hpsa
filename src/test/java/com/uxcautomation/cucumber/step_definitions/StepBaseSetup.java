/**
 * 
 */
package com.uxcautomation.cucumber.step_definitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.HomePageMobile;
import com.uxcautomation.utilities.LoadConfigProperties;
import com.uxcautomation.utilities.SauceApi;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author tarundeepsharma
 *
 */
public class StepBaseSetup {
	public static WebDriver driver;
	RemoteWebDriver remoteDriver;
	public static LoadConfigProperties loadConfig;
	protected static String baseUrl;
	public static HomePage homePage;
	public static HomePageMobile homePageMobile;
	// protected CsCockpitPage cscockpitPage;
	// protected DisplayProductListPage prodListPage;
	protected static SauceApi sauceApiObject;
	public static String browser = System.getProperty("Browser");

	/**
	 * 
	 */
	public StepBaseSetup() {
		loadConfig = LoadConfigProperties.getInstance();
		baseUrl = loadConfig.getsiteUrl();

	}

	
	@Before
	public void setDriver(Scenario scenario) throws MalformedURLException {
		DesiredCapabilities caps;
		// loadConfig = LoadConfigProperties.getInstance();
		String driverMode = loadConfig.getdriverMode();
		System.out.println(driverMode);
		System.out.println("Loading Browser :" + browser);
		CommonStepsDefs.scenario = scenario;
		
		switch (driverMode) {

		case "remote":
			/*
			 * DesiredCapabilities desiredCapabilities = new
			 * DesiredCapabilities();
			 * 
			 * desiredCapabilities.setBrowserName(System.getenv(loadConfig.
			 * getBrowser()));
			 * desiredCapabilities.setVersion(System.getenv(loadConfig.
			 * getBrowserVersion()));
			 * desiredCapabilities.setCapability(CapabilityType.PLATFORM,
			 * System.getenv(loadConfig.getPlatform())); driver = new
			 * RemoteWebDriver( new URL("http://"+loadConfig.getSauceUsername()+
			 * "@ondemand.saucelabs.com:80/wd/hub"), desiredCapabilities);
			 */

			System.out.println("Loading Browser :" + browser);
			String BambooBuildNumber = System.getProperty("BambooBuild");
			if (BambooBuildNumber == null) {
				BambooBuildNumber = "Local Job";
			}
			switch (browser) {
			case "LinuxFirefox":
				caps = DesiredCapabilities.firefox();
				caps.setCapability("platform", "Linux");
				caps.setCapability("version", "40.0");

				break;

			case "WindowFirefox":
				caps = DesiredCapabilities.firefox();
				caps.setCapability("platform", "Windows 10");
				caps.setCapability("version", "44.0");
				break;
			case "WindowChrome":
				caps = DesiredCapabilities.chrome();
				caps.setCapability("platform", "Windows 10");
				caps.setCapability("version", "55.0");
				caps.setCapability("screenResolution", "1280x1024");
				break;
			case "WindowIE":
				caps = DesiredCapabilities.internetExplorer();
				caps.setCapability("platform", "Windows 10");
				caps.setCapability("version", "11.0");
				break;
			case "MacFirefox":
				caps = DesiredCapabilities.firefox();
				caps.setCapability("platform", "OS X 10.10");
				caps.setCapability("version", "44.0");
				break;
			case "MacSafari":
				caps = DesiredCapabilities.safari();
				//caps.setCapability("platform", "OS X 10.9");
				//caps.setCapability("version", "7.0");
				
				caps.setCapability("platform", "OS X 10.10");
				caps.setCapability("version", "8.0");
				break;

			case "MacChrome":
				caps = DesiredCapabilities.chrome();
				caps.setCapability("platform", "OS X 10.11");
				caps.setCapability("version", "46.0");

				break;
			case "IPadAir":
				/*caps = DesiredCapabilities.iphone();
				caps.setCapability("platform", "OS X 10.10");
				caps.setCapability("version", "9.2");
				caps.setCapability("deviceName", "iPad Air");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("autoAcceptAlerts", true);
				caps.setCapability("sendKeyStrategy", "setValue");
				*/
				caps = DesiredCapabilities.iphone();
				caps.setCapability("appiumVersion", "1.5.3");
				caps.setCapability("deviceName","iPad Air Simulator");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("platformVersion","9.2");
				caps.setCapability("platformName", "iOS");
				caps.setCapability("browserName", "Safari");
				caps.setCapability("autoAcceptAlerts", true);

				
				break;
			case "Iphone6Plus":
				caps = DesiredCapabilities.iphone();
				
				/*caps.setCapability("platform", "OS X 10.10");
				caps.setCapability("version", "9.2");
				caps.setCapability("deviceName", "iPhone 6 Plus");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("autoAcceptAlerts", true);*/
				
				/*caps.setCapability("appiumVersion", "1.6.3");
				caps.setCapability("deviceName","iPhone Simulator");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("platformVersion","10.0");
				caps.setCapability("platformName", "iOS");
				caps.setCapability("browserName", "Safari");
				caps.setCapability("autoAcceptAlerts", true);
				*/
				caps = DesiredCapabilities.iphone();
				caps.setCapability("appiumVersion", "1.5.3");
				caps.setCapability("deviceName","iPhone Simulator");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("platformVersion","9.3");
				caps.setCapability("platformName", "iOS");
				caps.setCapability("browserName", "Safari");
				caps.setCapability("autoAcceptAlerts", true);
				break;
			case "AndriodTablet":
				caps = DesiredCapabilities.android();
				caps.setCapability("appiumVersion", "1.5.3");
				caps.setCapability("deviceName","Android GoogleAPI Emulator");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("browserName", "Browser");
				caps.setCapability("platformVersion", "5.0");
				caps.setCapability("platformName","Android");
				caps.setCapability("autoAcceptAlerts", true);
				caps.setCapability("autoDismissAlerts", true);
				break;
			case "AndriodPhone":
				/*caps = DesiredCapabilities.android();
				caps.setCapability("platform", "Linux");
				caps.setCapability("version", "4.3");
				caps.setCapability("deviceName", "Android Emulator");
				caps.setCapability("deviceType", "phone");
				caps.setCapability("deviceOrientation", "portrait");*/
				caps = DesiredCapabilities.android();
				caps.setCapability("appiumVersion", "1.5.3");
				caps.setCapability("deviceName","Android Emulator");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("browserName", "Browser");
				caps.setCapability("platformVersion", "5.1");
				caps.setCapability("platformName","Android");
				caps.setCapability("autoAcceptAlerts", true);
				caps.setCapability("autoDismissAlerts", true);
				/*caps = DesiredCapabilities.android();
				caps.setCapability("appiumVersion", "1.6.0");
				caps.setCapability("deviceName","Android Emulator");
				caps.setCapability("deviceOrientation", "portrait");
				caps.setCapability("browserName", "Browser");
				caps.setCapability("platformVersion", "5.1");
				caps.setCapability("platformName","Android");
				
*/
				break;
			case "MicrosoftEdge":
				caps = DesiredCapabilities.edge();
				caps.setCapability("platform", "Windows 10");
				caps.setCapability("version", "13.10586");	
				break;
			default:
				caps = DesiredCapabilities.firefox();
				caps.setCapability("platform", "Linux");
				caps.setCapability("version", "40.0");
				break;
			}
			caps.setCapability("name", BambooBuildNumber);
			caps.setCapability("build", BambooBuildNumber);
			caps.setCapability("passed", true);

			driver = new RemoteWebDriver(new URL("http://" + loadConfig.getSauceUsername() + ":"
					+ loadConfig.getSauceAccesskey() + "@ondemand.saucelabs.com:80/wd/hub"), caps);
			
			printSauceSessionId();

			break;

		case "local":
			browser = "MacFirefox";
			// System.setProperty("webdriver.gecko.driver",
			// "C:\\geckodriver\\wires.exe");
			// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			// capabilities.setCapability("marionette", true);
			// capabilities.setCapability("acceptSslCerts", true);

//			 System.setProperty("webdriver.chrome.driver",
//			 "C:\\Users\\bshah27\\Desktop\\HPSA\\chromedriver_win32\\chromedriver.exe");
			
			driver = new FirefoxDriver();
			// driver = new MarionetteDriver();
			 //driver = new ChromeDriver();
			break;

		default:
			System.out.println("default");
			break;

		}
		
		//driver.manage().window().setSize(new Dimension(320,800));
		//System.out.println("Mobile Device in base: "+isMobileUI());
		if(!isMobileUI()){
			System.out.println("I am not Mobile...");
		    driver.manage().window().maximize();
		}
		baseUrl = loadConfig.getsiteUrl();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(400, TimeUnit.SECONDS);
		
		
		
		if(isMobileUI()){
			homePage = PageFactory.initElements(driver, HomePageMobile.class); 
		} else {
			homePage = PageFactory.initElements(driver, HomePage.class); 
		}

	}
	
	public static Boolean isMobileUI() {
		
		if (browser.equals("IPadAir") || browser.equals("Iphone6Plus")  || browser.equals("AndriodTablet") || browser.equals("AndriodPhone"))
				 {
			return true;
		} else {
			return false;
		}
	}


	@After
	public void closeDriver() {
		driver.quit();
	}

	public static void printSauceSessionId() {
		String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
				((RemoteWebDriver) driver).getSessionId().toString(), loadConfig.getBuildJobName());
		System.out.println(message);
	}

	/**
	 * Updating Sauce TestName for Job
	 * 
	 * @param testMethodName
	 */
	public static void updateSauceTestCaseNameMethod(String testMethodName) {
		if (loadConfig.getdriverMode().equals("remote")) {
			String sauceJobId = ((RemoteWebDriver) driver).getSessionId().toString();

			try {
				sauceApiObject = new SauceApi();
				sauceApiObject.updateSauceTestCaseName(sauceJobId, testMethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getPageObjectForClass(Class<T> className) {

		try {
			System.out.println(className.getSimpleName());
			if (isMobileUI()) {
			
				String fullClassPath = "com.uxcautomation.selenium.pageobjects"+"." + className.getSimpleName() + "Mobile";
				System.out.println(fullClassPath);
				return (T) PageFactory.initElements(driver, Class.forName(fullClassPath));

			} else {
				System.out.println("Inside ELse");
				String fullClassPath = "com.uxcautomation.selenium.pageobjects" + "." + className.getSimpleName();
				System.out.println(fullClassPath);
				return (T) PageFactory.initElements(driver, Class.forName(fullClassPath));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Inside Catch");
			return (T) PageFactory.initElements(driver, className);
		}
	}
//	
//	public Dimension getDimensionForDevice(String device){
//		switch(device){
//		case "Tablet":
//			return new Dimension()
//		}
//	}
}
