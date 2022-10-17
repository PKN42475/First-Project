package practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCretaeOrganizationWithCustomer {
	static{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./CommonProperties.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String UN = pro.getProperty("un");
		String PW = pro.getProperty("pw");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		Random ran = new Random();
		int RanNum = ran.nextInt(1000);

		FileInputStream fisa = new FileInputStream("./Data.xlsx");
		Workbook book = WorkbookFactory.create(fisa);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue()+RanNum;
		String fin = book.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
		String lan = book.getSheet("sheet1").getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("(//input[@class=\"detailedViewTextBox\"])[1]")).sendKeys(data);
		driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();

		Set<String> alWh = driver.getWindowHandles();
		Iterator<String> it1=alWh.iterator();
		while(it1.hasNext()){
			String wid = it1.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Accounts&action")){
				break;
			}
		}
		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(data);
		driver.findElement(By.xpath("//input[@type=\"button\"]")).click();
		driver.findElement(By.xpath("(//a[@href=\"javascript:window.close();\"])")).click();

		Set<String> alWh1 = driver.getWindowHandles();
		Iterator<String> it2=alWh1.iterator();
		while(it2.hasNext()){
			String wid = it2.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Contacts&action")){
				break;
			}
		}

		WebElement fn = driver.findElement(By.xpath("//select[@name=\"salutationtype\"]"));
		Select s = new Select(fn);
		s.selectByValue("Mr.");
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys(fin);
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lan);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		driver.findElement(By.xpath("(//img[@style=\"padding: 0px;padding-left:5px\"])[1]")).click();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		driver.close();	
	}
}
