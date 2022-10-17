package com.crm.Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	public WebDriver driver;
	public File_Utility fu = new File_Utility();
	public static WebDriver sDriver;
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void BS(){
		System.out.println("DataBase Connection");
	}

	@BeforeTest(groups = {"SmokeTest","RegressionTest"})
	public void BT(){
		System.out.println("Execute in Parallel mode");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	//public void BC(String BROWSER) throws Throwable{
	public void BC() throws Throwable{
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
		
		sDriver = driver;
		driver.manage().window().maximize();
		System.out.println("Launching the Browser");
	}

	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
	public void BM() throws Throwable{
		System.out.println("Login to application");
	}

	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void AM(){
		HomePage hm = new HomePage(driver);
		hm.signOut();
		System.out.println("Logout the application");
	}

	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void AC(){
		driver.close();
		System.out.println("Close the browser");
	}

	@AfterTest(groups = {"SmokeTest","RegressionTest"})
	public void AT(){
		System.out.println("Executed Succesfully");
	}

	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void AS(){
		System.out.println("DataBase CLose");
	}
}
