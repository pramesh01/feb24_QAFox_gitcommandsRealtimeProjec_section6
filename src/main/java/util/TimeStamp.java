package util;

import java.util.Date;

public class TimeStamp {
	
	public static String getElementwithTimestamp() {
		Date d=new Date();
		return "pramesh"+d.toString().replace(" ","_").replace(":","_")+"@gmail.com";	
	 }
       }
