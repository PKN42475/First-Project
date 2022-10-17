package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class assignment_1 {
	
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int count = sh.getLastRowNum();
		
		for(int i=0; i<=count; i++) {
			Row row = sh.getRow(i);
			String col1 = row.getCell(0).getStringCellValue();
			String col2 = row.getCell(1).getStringCellValue();
			System.out.println(col1 + "\t" + col2);
		}
	}
}
