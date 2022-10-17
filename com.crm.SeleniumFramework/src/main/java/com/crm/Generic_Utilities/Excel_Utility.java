package com.crm.Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/**
	 * This method is used to fetch the data from Excel Sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @throws Throwable
	 * @author PAVAN
	 * @return data
	 */
	public String getDataFromExcel(String sheetName, int rowName, int cellName) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowName);
		Cell cl = rw.getCell(cellName);
		String data = cl.getStringCellValue();
		return data;
	}
}
