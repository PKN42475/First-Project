package org.crm.Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleteProduct {

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

		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PW);

		HomePage hp = new HomePage(driver);
		hp.clickOnProduct();

		Java_Utility ju = new Java_Utility();
		int RanNum = ju.getRandomNum(1000);

		Excel_Utility eu = new Excel_Utility();
		String data = eu.getDataFromExcel("sheet1", 1, 1)+RanNum;

		ProductPage pp = new ProductPage(driver);
		pp.productCreation();
		pp.productName(data);
		pp.clickSaveButton();
		pp.titleVerification(data);
		pp.deleteProduct();
		wu.acceptAlert(driver);
		hp.signOut();
		driver.close();
	}
}
