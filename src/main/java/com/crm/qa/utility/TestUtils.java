package com.crm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.Base;

public class TestUtils extends Base {

	public static int PAGELOAD=20;
	public static int IMPLICITWAIT=30;
	
	public static String TestDataSheetPath ="C:\\Users\\Admin\\eclipse-workspace\\E2E_CRMProject"
			+ "\\src\\main\\java\\com\\crm\\qa\\testdata\\testcrmdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getCRMSheetTestData(String sheetName){
		FileInputStream file = null;
		try {
				file = new FileInputStream(TestDataSheetPath);
				book = WorkbookFactory.create(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i < sheet.getLastRowNum(); i++) {
			
			for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}	
		}
		
		return data;
   }

	// Generic code of taking screenshots and this will be use in WebEventListner and "falied" method have to call in
	// WebEventListner Class in exception method.
	
	public static void failed() throws IOException {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String currentDir = System.getProperty("C:/Users/Admin");
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	

	
	
	
}
