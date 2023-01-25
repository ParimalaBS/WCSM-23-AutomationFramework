package Vtiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class JavaUtilitiesPractice {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtil=new JavaUtility();
		
		int value = jUtil.getRandomNumber();
		System.out.println(value);
		
		String Systemdate = jUtil.getSystemDate();
		System.out.println(Systemdate);
		
		String dateInFormat = jUtil.GetSystemDateFormat();
		System.out.println(dateInFormat);
		
		PropertyFileUtility Putil=new PropertyFileUtility();
		String Pvalue = Putil.readDataFromPropertyFile("browser");
		System.out.println(Pvalue);
		
		ExcelUtility eUtil=new ExcelUtility();
		String Evalue = eUtil.readDataFromExcelSheet("Contact", 1, 2);
		System.out.println(Evalue);
		
		int rowcount = eUtil.getrowcount("Contact");
		System.out.println(rowcount);
		
		eUtil.writeDataIntoExcelsheet("Contact", 1, 5, "Bangalore");
		System.out.println("data added");	
		}
		
		
	}

