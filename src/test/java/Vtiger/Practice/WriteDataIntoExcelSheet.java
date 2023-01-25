package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step 1: load the file into fileInputStream
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
		
		//Step 2: Create Workbook
		Workbook wb =WorkbookFactory.create(fis);
		//Step 3: get into required sheet and row and create cell to pass value
		
		//Step 4: to write the data - mention the file to where data should store
		Sheet sh = wb.getSheet("Organization");
		Row rw = sh.getRow(1);
	     rw.createCell(5).setCellValue("Cognizent");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
		wb.write(fos);
		System.out.println("Data is Entered into xcel sheet");
		
		
	}
}
