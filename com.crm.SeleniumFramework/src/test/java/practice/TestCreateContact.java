package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCreateContact {
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		File_Utility fu = new File_Utility();
		String URL = fu.getPropertyKeyValue("url");
		String UN = fu.getPropertyKeyValue("un");
		String PW = fu.getPropertyKeyValue("pw");
		String BROWSER = fu.getPropertyKeyValue("browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();

		WebDriver_Utility wu = new WebDriver_Utility();
		wu.waitForPageLoad(driver);

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
	}

}
