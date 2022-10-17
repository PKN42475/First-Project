package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestHotelMakeMyTrip {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
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

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@href=\"https://www.makemytrip.com/hotels/\"])[1]")).click();

		String place = "Bengaluru";
		driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys(place);
		driver.findElement(By.xpath("(//p[text()='Bengaluru'])[1]")).click();

		String month = "October";
		String date = "2";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+date+"']")).click();

		String montho = "October";
		String dateo = "20";
		driver.findElement(By.xpath("//div[text()='"+montho+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+dateo+"']")).click();

		String adult = "2";
		driver.findElement(By.xpath("(//li[text()='"+adult+"'])[1]")).click();
		String children = "3";
		driver.findElement(By.xpath("(//li[text()='"+children+"'])[2]")).click();

		WebElement list = driver.findElement(By.id("0"));
		Select s = new Select(list);
		s.selectByValue("4");

		WebElement list1 = driver.findElement(By.id("1"));
		Select s1 = new Select(list1);
		s1.selectByValue("6");

		WebElement list2 = driver.findElement(By.id("2"));
		Select s2 = new Select(list2);
		s2.selectByValue("2");

		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.findElement(By.id("hsw_search_button")).click();
	}
}
