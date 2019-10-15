/**
 * 
 */
package com.uxcautomation.junit.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.support.PageFactory;

import com.uxcautomation.selenium.pageobjects.HomePage;
import com.uxcautomation.selenium.pageobjects.LoginPage;
import com.uxcautomation.utilities.DataReaderExcel;

/**
 * @author tarundeepsharma
 *
 */
@RunWith(Parameterized.class)
public class UserLoginTest extends TestBaseSetup {

	private String username;
	private String password;
	/**
	 * @param username 
	 * @param password 
	 * @throws IOException
	 */
	public UserLoginTest(String username, String password) throws IOException {
		super();
		this.username = username;
        this.password = password;
       
		// TODO Auto-generated constructor stub
	}

	HomePage homePage;
	
	
	@Parameters
    public static Collection<Object> spreadsheetData() throws IOException {
		String fileName ="TestData/testUsers.xlsx";
    	DataReaderExcel dr = new DataReaderExcel(fileName);
    	ArrayList<Object> ls = new ArrayList<Object>(dr.returnData());
    	
    	return ls;
    }

 
	
	@Before
	public void setUp()  throws Exception{
		driver = getDriver();		
		baseUrl = loadConfig.getsiteUrl();				
		homePage =PageFactory.initElements(driver, HomePage.class);
				
	}
	
	@Test
	public void userCanDoLogin() throws Exception{
		driver.get(baseUrl);
		
		LoginPage login = homePage.goToLoginPage();
		//login.verifyIsLoginSuccessfullwithCorrectCredentials("dssd", "dsdsds");
	
		login.verifyIsLoginNotSuccessfulwithBadCredentials(username, password);
		
		
	}
	

	  @AfterClass
	  public static void tearDown() throws Exception {
	    driver.quit();


	  }
	
}
