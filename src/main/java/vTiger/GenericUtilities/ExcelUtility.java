package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method will read the data from xcel sheet and return the celldata
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelSheet(String sheetName, int rowNum,int colNum ) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String celldata = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		return celldata;
	  }
	/**
	 * This method will give row count in Excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
   public int getrowcount(String sheetName) throws EncryptedDocumentException, IOException {
	   
	   FileInputStream fisE= new FileInputStream(IConstantUtility.ExcelFilePath);
	   Workbook wb = WorkbookFactory.create(fisE);
	   int rowCount = wb.getSheet(sheetName).getLastRowNum();
	   return rowCount;
   }
   
   /**
    * This method will write data into excel sheet
    * @param Sheetname
    * @param rowNum
    * @param colNum
    * @param value
    * @throws EncryptedDocumentException
    * @throws IOException
    */
   public void writeDataIntoExcelsheet(String Sheetname,int rowNum,int colNum,String value) throws EncryptedDocumentException, IOException {
	   FileInputStream fisE= new FileInputStream(IConstantUtility.ExcelFilePath);
	   Workbook wb = WorkbookFactory.create(fisE);
	   wb.getSheet(Sheetname).getRow(rowNum).createCell(colNum).setCellValue(value);
	   
	   FileOutputStream fos = new FileOutputStream(IConstantUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
	}
   
   public Object[][]  readMultipledata(String Sheetname) throws EncryptedDocumentException, IOException {
	   
	   FileInputStream Sfis=new FileInputStream(IConstantUtility.ExcelPath);
	   Workbook wb=WorkbookFactory.create(Sfis);
	 Sheet sh= wb.getSheet(Sheetname);
	int lastRow = sh.getLastRowNum();  
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastCell];
	for(int i=0; i<lastRow;i++) {
		
		for(int j=0; j<lastCell;j++) {
			
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			
		  }
		}
	return data;
	
}
	
}
