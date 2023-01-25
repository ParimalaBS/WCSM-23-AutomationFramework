package Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void addProduct(String phone, int Price,String model) {
		
		System.out.println(phone +" "+Price+" "+ model);
		
		}
	
    @DataProvider()
    public Object[][] getData(){
    	
    	Object[][] data=new Object [2][3];
    	
    	data[0][0]="samsung";
    	data[0][1]=12000;
    	data[0][2]	="A56"
    			;
    	data[1][0]="Iphone";
    	data[1][1]=19000;
    	data[1][2]	="s13";
    	return data;
    	
    	     }
    
public Object[][] watchesData(){
    	
    	Object[][] data=new Object [2][3];
    	
    	data[0][0]="boat";
    	data[0][1]=1200;
    	data[0][2]	="A3"
    			;
    	data[1][0]="noise";
    	data[1][1]=1000;
    	data[1][2]	="ss1";
    	return data;
    }
}
	
