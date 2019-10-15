package com.uxcautomation.utilities;


public class CommonUtil {
	
	public static Double formatStringToDouble(String number) {
		
		Double d = 0.0d;
		number = number.replaceAll("[$,-]", "");
		
		 try  
		  {  
		    d = Double.parseDouble(number);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    d = 0.0d; 
		  }  
		
		 return d;
	}

}
