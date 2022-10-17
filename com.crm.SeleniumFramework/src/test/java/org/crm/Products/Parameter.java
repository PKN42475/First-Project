package org.crm.Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class Parameter {

	@Test
	public void browserTest() throws Throwable {
		WebDriver driver;
		String BROWSER = System.getProperty("browser");

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

		String URL = System.getProperty("url");
		String UN = System.getProperty("un");
		String PW = System.getProperty("pwd");

		driver.manage().window().maximize();
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PW);
	}
}
