package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestXl {

	public static void main(String[] args) throws IOException {
		String key = "webdriver.chrome.driver";
		String value = "./driver/chromedriver.exe";
		System.setProperty(key, value);

		FileInputStream fis = new FileInputStream("./pavan.xlsx");
		Workbook book = WorkbookFactory.create(fis);

		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue();

		System.out.println(data);

	}

}
