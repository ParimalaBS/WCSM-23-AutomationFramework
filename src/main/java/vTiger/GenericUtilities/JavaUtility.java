package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	private static final String SystemDateFormat = null;

	/**
	 * This  method will retun the random number
	 * @return
	 */
		 public int getRandomNumber() {
			Random r=new Random();
			int value = r.nextInt(1000);
			return value;
		 }
		 
		 /**
		  * This method will provide System date
		  * @return
		  */
		 public String getSystemDate() {
			 Date d= new Date();
		    String date = d.toString();
		    return date;
	   }
		 
		 public String GetSystemDateFormat() {
			Date d= new Date();
			String[] dArry = d.toString().split(" ");
			String date = dArry [2];
			String month = dArry [1];
			String year = dArry[5];
			String time = dArry [3].replace(":", "-");
			String SystemDateFormat=date+" "+month+" "+year+" "+time;
			return SystemDateFormat;
			}
		

	}


