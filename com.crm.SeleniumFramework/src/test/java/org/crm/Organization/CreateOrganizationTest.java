package org.crm.Organization;

import org.testng.annotations.Test;
import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	@Test(groups = {"SmokeTest"})
	public void createOrganizationTest() throws Throwable {
		File_Utility fu = new File_Utility();
		String URL = fu.getPropertyKeyValue("url");
		String UN = fu.getPropertyKeyValue("un");
		String PW = fu.getPropertyKeyValue("pw");

		WebDriver_Utility wu = new WebDriver_Utility();
		wu.waitForPageLoad(driver);

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PW);

		Java_Utility ju = new Java_Utility();
		int RanNum = ju.getRandomNum(1000);

		Excel_Utility eu = new Excel_Utility();
		String data = eu.getDataFromExcel("sheet1", 1, 1)+RanNum;

		HomePage hm = new HomePage(driver);
		hm.clickOnOrganization();

		OrganizationPage org = new OrganizationPage(driver);
		org.orgCreateBtn();
		org.orgEnterNameTextBox(data);
		//SoftAssert soft = new SoftAssert();
		//soft.assertEquals(true, false, data);
		org.orgSaveBtn();
		org.titleVerification(data);
		//soft.assertAll();
	}
}

