package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//Initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
	private WebElement createOrgBtn;

	@FindBy(name="accountname")
	private WebElement orgNametextBox;

	@FindBy(xpath="//input[@value=\"  Save  \"]")
	private WebElement saveButton;

	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement verifyTitle;

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	public WebElement getOrgNametextBox() {
		return orgNametextBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getVerifyTitle() {
		return verifyTitle;
	}

	//Business Logic
	public void orgCreateBtn() {
		createOrgBtn.click();
	}

	public void orgEnterNameTextBox(String data) {
		orgNametextBox.sendKeys(data);
	}

	public void orgSaveBtn() {
		saveButton.click();
	}

	public void titleVerification(String data) {
		String text = verifyTitle.getText();
		if(text.contains(data)) {
			System.out.println("Organization Created");
		}
		else {
			System.out.println("Organization Not Created");
		}
	}
}

