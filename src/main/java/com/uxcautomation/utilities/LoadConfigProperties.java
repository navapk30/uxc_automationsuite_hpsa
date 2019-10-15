package com.uxcautomation.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigProperties {

	protected  Properties configProperties;
	
	private  Properties elementsProperties = new Properties();

	public static final String GLOBAL_CONFIG_PROPERTY_FILE = "config.properties";
	public static final String TEST_CONFIG_LOCATION="testSuiteConfig";
	public static final String FILE_SEPARATOR="/";
    
	private static LoadConfigProperties instance;
	private static boolean loadBrand = false;

	/**
	 * Constructor is made private and object can be accessible only by calling this static method
	 * 
	 * @return LoadConfigProperties singleton instance.
	 */
	public static LoadConfigProperties getInstance() {
		if(instance == null){
			instance = new LoadConfigProperties();
		}
		return instance;
	}

	/**
	 *  Loading properties files into Properties object
	 */
	private LoadConfigProperties() {
		configProperties = new Properties();
		InputStream inputStream = null;
		try {
			
			//Global Config
			  inputStream = getClass().getClassLoader().getResourceAsStream(
					TEST_CONFIG_LOCATION+FILE_SEPARATOR+GLOBAL_CONFIG_PROPERTY_FILE);

			if (inputStream != null) {
				configProperties.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '"
						+ GLOBAL_CONFIG_PROPERTY_FILE + "' not found in the classpath");
			}
			if(LoadConfigProperties.loadBrand)
			loadPageElementProperties();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public String getsiteUrl() {
		return configProperties.getProperty("siteUrl");
	}

	public String getBrowser() {
		return configProperties.getProperty("browser");
	}

	public String getSauceUsername() {
		return configProperties.getProperty("sauceUsername");

	}

	public String getSauceAccesskey() {
		return configProperties.getProperty("sauceAccessKey");

	}

	public String getBrowserVersion() {
		return configProperties.getProperty("browserVersion");
	}

	public String getPlatform() {
		return configProperties.getProperty("platform");
	}

	public String getBuildJobName() {
		return configProperties.getProperty("buildJobName");
	}

	public String getdriverMode() {
		return configProperties.getProperty("driverMode");
	}

	public String getBrandSpecificPropertyFile() {
		return configProperties.getProperty("brandProperties");
	}
	
	/**
	 *  Loads the site specific element property to element properties object
	 */
	public void loadPageElementProperties(){
		InputStream inputStream = null;
		try {
			
			inputStream = getClass().getClassLoader().getResourceAsStream(
					TEST_CONFIG_LOCATION+FILE_SEPARATOR + getBrandSpecificPropertyFile());

			if (inputStream != null) {
				elementsProperties.load(inputStream);
			} else {
				throw new FileNotFoundException("site specific property file '"
						+ getBrandSpecificPropertyFile() + "' not found in the classpath");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * returns element locator based on the property 
	 * 
	 * @param propertyKey
	 * @return
	 */
	public String readElementLocatorFromProperties(String propertyKey) {

		System.out.println(elementsProperties.getProperty(propertyKey));
		return elementsProperties.getProperty(propertyKey);
	}


	public static void main(String args[]) throws IOException {

		LoadConfigProperties cc = LoadConfigProperties.getInstance();

		cc.readElementLocatorFromProperties("categoryLink");
	}
}
