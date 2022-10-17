package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMakeMyTrip {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./mmt.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//label[@for=\"fromCity\"]")).click();

		FileInputStream fi = new FileInputStream("./mmt.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sheet = book.getSheet("location");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();

		driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]")).sendKeys(data);
		driver.findElement(By.xpath("//p[text()=\"Hyderabad, India\"]")).click();

		Row rowt = sheet.getRow(2);
		Cell cellt = rowt.getCell(1);
		String datat = cellt.getStringCellValue();

		driver.findElement(By.xpath("//span[text()=\"To\"]")).click();
		driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys(datat);
		driver.findElement(By.xpath("//p[text()=\"Mumbai, India\"]")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		Thread.sleep(10000);
		String month = "October 2022";
		String day = "2";
		driver.findElement(By.xpath("//div[text()=\'"+month+"']"
				+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();

		Thread.sleep(10000);
		String monthd = "October";
		String dayd = "20";
		driver.findElement(By.xpath("//div[text()='"+monthd+"']"
				+ "/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+dayd+"']")).click();

		driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
		String numa = "3";
		driver.findElement(By.xpath("//ul[@class=\"guestCounter font12 darkText gbCounter\"]/ancestor::div[@class=\"appendBottom20\"]/descendant::li[text()=\'"+numa+"'][1]")).click();
		String numc = "3";
		driver.findElement(By.xpath("//ul[@class=\"guestCounter font12 darkText gbCounter\"]/ancestor::div[@class=\"appendBottom20\"]/descendant::li[text()=\'"+numc+"'][2]")).click();
		String numi = "3";
		driver.findElement(By.xpath("//ul[@class=\"guestCounter font12 darkText gbCounter\"]/ancestor::div[@class=\"appendBottom20\"]/descendant::li[text()=\'"+numi+"'][3]")).click();
		driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();

		//driver.close();
	}
}
