package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws IOException  {
		//Step 1: Load the file into fileInputStream-java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
		
		//Step: 2 create  workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: Navigate to required row
		Row rw = sh.getRow(1);
		
		//Step 5: Navigate to required cell 
		Cell cell = rw.getCell(1);
		
		//step 6:capture the data present inside the cell
	    String celldata = cell.getStringCellValue();
	    System.out.println(celldata);
	    System.out.println(rw.getCell(2).getStringCellValue());
	  }

}
