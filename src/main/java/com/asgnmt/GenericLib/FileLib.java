package com.asgnmt.GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

		/**
		 * It is used to read data from commonData.properties file based on key
		 * @param key
		 * @return String value
		 * @throws Throwable
		 */

		public String getPropertyKeyValue(String key) throws Throwable {
			FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
			Properties pobj = new Properties();
			pobj.load(fis);
			String value = pobj.getProperty(key);
			return value;
		}
		
		/**
		 * It is used to read data from testScriptData.xlsx file based on arguments
		 * @param sheetName
		 * @param rowNum
		 * @param CellNum
		 * @return String data
		 * @throws Throwable
		 */
		String epath = "./src/test/resources/testScriptData.xlsx";

		public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
			FileInputStream fis = new FileInputStream(epath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			String data = row.getCell(cellNum).getStringCellValue();
			wb.close();
			return data;
		}
		
		public void setExcelData(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
			FileInputStream fis = new FileInputStream(epath);

			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(epath);

				wb.write(fos);
			wb.close();
			
		}
		

}
