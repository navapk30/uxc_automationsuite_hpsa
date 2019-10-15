/**
 * 
 */
package com.uxcautomation.utilities;
import com.saucelabs.saucerest.*;
import com.uxcautomation.utilities.LoadConfigProperties;

import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tarundeepsharma
 *
 */
public class SauceApi {
	
	public String sauceUsername;
	public String sauceAccessKey;
	public LoadConfigProperties loadConfig;
	/**
	 * 
	 */
	public SauceApi() {
		super();
		
			loadConfig = LoadConfigProperties.getInstance();
	
		this.sauceUsername = loadConfig.getSauceUsername();
		this.sauceAccessKey = loadConfig.getSauceAccesskey();
	}

	   public  void updateSauceTestResult(String sauceJobId,String error) throws IOException {
		   System.out.println("@@@@@API Running updateSauceTestResult--->"+sauceJobId);
	        SauceREST client = new SauceREST(this.sauceUsername,this.sauceAccessKey);

	        Map<String, Object> updates = new HashMap<String, Object>();
	        updates.put("passed", false);
	        JSONArray tags = new JSONArray();
	        tags.add(error);
	        updates.put("tags", tags);
	        client.updateJobInfo(sauceJobId, updates);
	        System.out.println(client.getJobInfo(sauceJobId));
	    }
	   
	   public  void updateSauceTestCaseName(String sauceJobId,String testMethodName) throws IOException {
		   System.out.println("@@@@@API Running updateSauceTestCaseName--->"+sauceJobId+""+testMethodName);
	        SauceREST client = new SauceREST(this.sauceUsername,this.sauceAccessKey);

	        Map<String, Object> updates = new HashMap<String, Object>();
	        updates.put("name", testMethodName);
	        //JSONArray tags = new JSONArray();
	        //tags.add("testingblah");
	        //updates.put("tags", tags);
	        client.updateJobInfo(sauceJobId, updates);
	        System.out.println(client.getJobInfo(sauceJobId));
	    }

}
